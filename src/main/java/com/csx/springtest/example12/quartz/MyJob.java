package com.csx.springtest.example12.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;
import org.springframework.context.ApplicationContext;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/23
 */
public class MyJob implements StatefulJob{

    @Override
    public void execute(JobExecutionContext jctx) throws JobExecutionException {
        Map dataMap = jctx.getTrigger().getJobDataMap();
        String size =(String)dataMap.get("size");
        ApplicationContext ctx = (ApplicationContext)dataMap.get("applicationContext");
        System.out.println("size:"+size);
        dataMap.put("size",size+"0");

        String count =(String)dataMap.get("count");
        System.out.println("count:"+count);
    }
}
