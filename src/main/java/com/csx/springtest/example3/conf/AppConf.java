package com.csx.springtest.example3.conf;

import com.csx.springtest.example1.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/07
 */
@Configuration
public class AppConf {
    @Bean
    public UserDao userDao(){
        return new UserDao();
    }

    @Bean
    public LogDao logDao(){
        return new LogDao();
    }

    @Bean
    public LogonService logonService(){
        LogonService logonService=new LogonService();
        logonService.setLogDao(logDao());
        logonService.setUserDao(userDao());
        return logonService;
    }
}
