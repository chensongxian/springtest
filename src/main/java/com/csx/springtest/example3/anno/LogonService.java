package com.csx.springtest.example3.anno;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-02-04
 */
@Service
public class LogonService implements BeanNameAware {
    /**@Lazy注解必须同时标注在属性及目标Bean上*/
    @Lazy
    @Autowired(required=false)
    private LogDao logDao;


    /**@Qualifier指定注入bean的名称*/
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    public void saveLog(){
        logDao.saveLog();
    }



   /* @Autowired
    @Qualifier("userDao")
    public void setUserDao(UserDao userDao) {
        System.out.println("auto inject");
        this.userDao = userDao;
    }



    @Autowired
    public void setLogDao(LogDao logDao) {
        this.logDao = logDao;
    }*/

    /*
        @Autowired
        public void init(@Qualifier("userDao")UserDao userDao,LogDao logDao){
            System.out.println("multi param inject");
            this.userDao = userDao;
            this.logDao =logDao;
        }*/
    public LogDao getLogDao() {
        return logDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("beanName:" + beanName);
    }

    public void initMethod1() {
        System.out.println("initMethod1");
    }

    public void initMethod2() {
        System.out.println("initMethod2");
    }
}
