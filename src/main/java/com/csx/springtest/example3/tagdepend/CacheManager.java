package com.csx.springtest.example3.tagdepend;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/07
 */
public class CacheManager {
    public CacheManager(){
        Timer timer = new Timer();
        TimerTask cacheTask = new CacheTask();

        System.out.println("REFRESH_CYCLE:"+SystemSettings.REFRESH_CYCLE);

        timer.schedule(cacheTask,0,SystemSettings.REFRESH_CYCLE*1000);
    }
}
