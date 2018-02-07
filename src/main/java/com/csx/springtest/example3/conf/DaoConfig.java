package com.csx.springtest.example3.conf;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/07
 */
@Configuration
public class DaoConfig {
    @Bean(name = "userDao")
    public UserDao userDao(){
        return new UserDao();
    }

    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    @Bean(name = "logDao")
    public LogDao logDao(){
        return new LogDao();
    }
}
