package com.csx.springtest.example4.beanprop;

import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/08
 */
public class SysConfig {
    private int sessionTimeout;
    private int maxTabPageNum;

    private DataSource dataSource;

    public void initFromDB(){
        //从数据库中获取属性配置值
        this.sessionTimeout = 30;
        this.maxTabPageNum = 10;
    }

    public int getSessionTimeout() {
        return sessionTimeout;
    }

    public int getMaxTabPageNum() {
        return maxTabPageNum;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
