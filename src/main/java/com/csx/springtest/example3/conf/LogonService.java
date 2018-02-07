package com.csx.springtest.example3.conf;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/07
 */
public class LogonService {
    private LogDao logDao;
    private UserDao userDao;
    public LogDao getLogDao() {
        return logDao;
    }
    public void setLogDao(LogDao logDao) {
        this.logDao = logDao;
    }
    public UserDao getUserDao() {
        return userDao;
    }
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void printHelllo(){
        System.out.println("hello!");
    }
}
