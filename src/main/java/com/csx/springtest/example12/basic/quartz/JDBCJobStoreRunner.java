package com.csx.springtest.example12.basic.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/23
 */
public class JDBCJobStoreRunner {
    public static void main(String args[]) {
        try {
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            //获取调度器中所有触发器组
            String[] triggerGroups = scheduler.getTriggerGroupNames();
            for (int i = 0; i < triggerGroups.length; i++) {
                //获取所有触发器名
                String[] triggers = scheduler.getTriggerNames(triggerGroups[i]);
                for (int j = 0; j < triggers.length; j++) {
                    //获取所有触发器
                    Trigger tg = scheduler.getTrigger(triggers[j],
                            triggerGroups[i]);
                    if (tg instanceof SimpleTrigger
                            && tg.getFullName().equals("tgroup1.trigger1_1")) {
//						((SimpleTrigger) tg).setRepeatCount(100);
                        scheduler.rescheduleJob(triggers[j], triggerGroups[i],tg);
                    }
                }
            }
            scheduler.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
