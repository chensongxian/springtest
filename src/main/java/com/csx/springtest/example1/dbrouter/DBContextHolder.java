package com.csx.springtest.example1.dbrouter;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author csx
 * @Package com.csx.springtest.example1.dbrouter
 * @Description: TODO
 * @date 2018/5/24 0024
 */
public class DBContextHolder {
    private static final Logger LOGGER=LoggerFactory.getLogger(DBContextHolder.class);

    private static final Integer NUMER_1000000=1000000;

    private static ThreadLocal<String> contextHold=new ThreadLocal<>();

    private static AtomicInteger counter=new AtomicInteger();

    private static ThreadLocal<Long> customerID=new ThreadLocal<>();

    private static int masterSize=0;

    private static int slaveSize=0;

    /**
     * 读写分离标志
     */
    private static boolean wrConfig = true;

    /**
     * 主库索引
     */
    private static String[] writerKey;

    /**
     * 从库索引
     */
    private static String[][] readerKey;

    /**
     * 分库算法，按照customerID范围分
     */
    private static HashMap<String,Integer>[] range;

    public DBContextHolder() {
    }

    public static void setCustomerID(Long id) {
        customerID.set(id);
    }

    public static String getDbType(){
        String dbType = contextHold.get();
        return dbType;
    }
    public static void setDbType(boolean isSlave){
        if(isSlave){
            contextHold.set(getSlaveContext());
        }else{
            contextHold.set(getMasterContext());
        }
    }
    public static void initDBInfo(JsonObject jsonObject){
        masterSize=jsonObject.get("maxDB").getAsInt();
        slaveSize=jsonObject.get("maxSlave").getAsInt();
        wrConfig=jsonObject.get("wrConfig").getAsBoolean();

        JsonArray writerKeyArray = jsonObject.get("writerKey").getAsJsonArray();
        writerKey=new String[writerKeyArray.size()];
        for(int i=0;i<writerKeyArray.size();i++){
            writerKey[i]=writerKeyArray.get(i).getAsString();
        }

        JsonArray readerKeyArray = jsonObject.get("readerKey").getAsJsonArray();
        readerKey=new String[readerKeyArray.size()][];
        for(int i=0;i<readerKeyArray.size();i++){
            JsonArray subArray = readerKeyArray.get(i).getAsJsonArray();
            readerKey[i]=new String[subArray.size()];
            for(int j=0;j<subArray.size();j++){
                readerKey[i][j]=subArray.get(i).getAsString();
            }
        }

        JsonArray rangeArray = jsonObject.get("range").getAsJsonArray();
        range=new HashMap[rangeArray.size()];
        for(int i=0;i<rangeArray.size();i++){
            JsonObject rangMap = rangeArray.get(i).getAsJsonObject();
            range[i]=new HashMap<String, Integer>(16);
            range[i].put("beginValue",rangMap.get("beginValue").getAsInt());
            range[i].put("endValue",rangMap.get("endValue").getAsInt());
        }

    }


    public static void clearDBType(){
        contextHold.remove();
    }

    private static String getMasterContext(){
        int masterIndex=getDBIndex();
        return writerKey[masterIndex];
    }

    private static String getSlaveContext(){
        int masterIndex=getDBIndex();
        if(wrConfig){
            int count=counter.getAndIncrement();
            if(count>NUMER_1000000){
                counter.set(0);
            }
            int slaveIndex=count%masterSize;
            return readerKey[masterIndex][slaveIndex];
        }else{
            return writerKey[masterIndex];
        }
    }

    private static int getDBIndex(){
        int beginValue,endValue;
        for(int i=0;i<range.length;i++){
            beginValue=range[i].get("beginValue");
            endValue=range[i].get("endValue");
            System.out.println(customerID.get());
            if(customerID.get()>=beginValue&&customerID.get()<=endValue){
                return (i%masterSize);
            }
        }
        return 0;

    }
}
