package com.csx.springtest.example12.basic.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/23
 */
public class SimpleTriggerRunner {
    public static void main(String[] args) {
        try {
            JobDetail jobDetail=new JobDetail("job1_1","jgroup1",SimpleJob.class);

            SimpleTrigger trigger=new SimpleTrigger("trigger1_1","jgroup1");
            trigger.setStartTime(new Date());
            trigger.setRepeatInterval(2000);
            trigger.setRepeatCount(100);

            SchedulerFactory schedulerFactory=new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.scheduleJob(jobDetail,trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
