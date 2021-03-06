package com.csx.springtest.example3.anno;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: @Lazy延迟加载
 * @Author: csx
 * @Date: 2018-02-04
 */
@Lazy
@Repository
public class LogDao implements InitializingBean{

    public LogDao() {
        System.out.println("create LogDao");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("LogDao....");
    }

    public void saveLog(){}
}
