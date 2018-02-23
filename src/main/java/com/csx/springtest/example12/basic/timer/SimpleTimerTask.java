package com.csx.springtest.example12.basic.timer;

import java.util.Date;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/23
 */
public class SimpleTimerTask extends TimerTask{
    private int count = 0;
    public void run() {
        System.out.println("execute task.");
        Date exeTime = (new Date(scheduledExecutionTime()));
        System.out.println("本次任务安排执行时间点为："+exeTime);
        if(++count > 5){cancel();}
    }
}
