package com.csx.springtest.example12.basic.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/23
 */
public class TimerRunner {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new SimpleTimerTask();
        timer.schedule(task,1000L,1000L);
    }
}
