package com.csx.springtest.example3.tagdepend;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/07
 */
public class SysInit {
    public SysInit(){
        System.out.println("SysInit");
        //模拟从数据库中加载系统设置信息
        SystemSettings.REFRESH_CYCLE = 100;
        SystemSettings.SESSION_TIMEOUT = 10;
    }
}
