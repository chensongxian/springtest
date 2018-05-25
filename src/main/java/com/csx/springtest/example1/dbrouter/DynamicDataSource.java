package com.csx.springtest.example1.dbrouter;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.gson.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.jdbc.datasource.lookup.DataSourceLookup;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author csx
 * @Package com.csx.springtest.example1.dbrouter
 * @Description: TODO
 * @date 2018/5/24 0024
 */
public class DynamicDataSource extends AbstractRoutingDataSource implements ApplicationContextAware {

    private static final Logger LOGGER=LoggerFactory.getLogger(DynamicDataSource.class);
    private Resource addressConfig;
    private ApplicationContext ac;

    public void setAddressConfig(Resource addressConfig) {
        this.addressConfig = addressConfig;
    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        ac=ctx;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DBContextHolder.getDbType();
    }

    @Override
    public void setTargetDataSources(Map targetDataSources) {
        super.setTargetDataSources(targetDataSources);
    }

    @Override
    public void setDefaultTargetDataSource(Object defaultTargetDataSource) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
    }

    @Override
    public void setDataSourceLookup(DataSourceLookup dataSourceLookup) {
        super.setDataSourceLookup(dataSourceLookup);
    }

    @Override
    public void afterPropertiesSet() {
        LOGGER.info("");
        initDynamicDataSource();
        super.afterPropertiesSet();
        LOGGER.info("");
    }

    private void initDynamicDataSource(){
        try {
            //创建JSON解析器
            JsonParser parser = new JsonParser();
            //创建JsonObject对象
            JsonObject object = (JsonObject) parser.parse(new FileReader(addressConfig.getFile()));
            //得到为json的数组pagoda_customer_db
            JsonArray array = object.get("pagoda_customer_db").getAsJsonArray();

            //创建数据库连接
            DruidDataSource ds = null;

            DefaultListableBeanFactory acf = (DefaultListableBeanFactory)ac.getAutowireCapableBeanFactory();
            Map<Object,DruidDataSource> datasources;
            datasources = new HashMap<>(16);
            for (int i = 0; i < array.size(); i++) {
                JsonObject subObject = array.get(i).getAsJsonObject();
                ds = new DruidDataSource();
                String id = subObject.get("key").getAsString();

                JsonObject config = subObject.get("config").getAsJsonObject();

                String username = config.get("user").getAsString();
                String url = config.get("url").getAsString();
                String pwd = config.get("password").getAsString();
                ds.setUsername(username);
                ds.setUrl(url);
                ds.setPassword(pwd);
                ds.setInitialSize(config.get("initialSize").getAsInt());
                ds.setMaxActive(config.get("maxActive").getAsInt());
                ds.setMinIdle(config.get("minIdle").getAsInt());
                ds.setMaxWait(config.get("maxWait").getAsInt());
                ds.setTimeBetweenEvictionRunsMillis(config.get("timeBetweenEvictionRunsMillis").getAsLong());
                ds.setMinEvictableIdleTimeMillis(config.get("minEvictableIdleTimeMillis").getAsLong());
                ds.setValidationQuery(config.get("validationQuery").getAsString());
                ds.setTestWhileIdle(config.get("testWhileIdle").getAsBoolean());
                ds.setTestOnBorrow(config.get("testOnBorrow").getAsBoolean());
                ds.setTestOnReturn(config.get("testOnReturn").getAsBoolean());
                ds.setValidationQueryTimeout(config.get("validationQueryTimeout").getAsInt());
                acf.registerSingleton(id, ds);
                datasources.put(id, ds);
            }
            setTargetDataSources(datasources);
            //设置默认数据源
            setDefaultTargetDataSource(datasources.get("v2_pagoda_customer1"));

            //初始化數據庫分庫信息
            DBContextHolder.initDBInfo(object);

        } catch (JsonIOException e) {
            logger.error("加载json文件，json文件读取异常！" + e.toString());
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            logger.error("加载json文件，json文件解析异常！" + e.toString());
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            logger.error("加载json文件，json文件不存在！" + e.toString());
            e.printStackTrace();
        } catch (IOException e) {
            logger.error("加载json文件，json文件读取异常！" + e.toString());
            e.printStackTrace();
        }
    }
}
