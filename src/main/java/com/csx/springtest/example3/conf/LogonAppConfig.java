package com.csx.springtest.example3.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/07
 */
@Configuration
@ImportResource("classpath:com/csx/springtest/example3/conf/beans3.xml")
public class LogonAppConfig {
    @Bean
    @Autowired
    public LogonService logonService(UserDao userDao,LogDao logDao){
        LogonService logonService = new LogonService();
        logonService.setUserDao(userDao);
        logonService.setLogDao(logDao);
        return logonService;
    }
}
