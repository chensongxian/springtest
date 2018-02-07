package com.csx.springtest.example3.tagdepend;

import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/07
 */
public class CacheTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("doing clean cache");
    }
}
