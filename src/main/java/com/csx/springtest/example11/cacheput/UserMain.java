package com.csx.springtest.example11.cacheput;

import com.csx.springtest.example11.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserMain {
    public static void main(String... args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/csx/springtest/example11/applicationContext.xml");
        UserService userService = (UserService) context.getBean("cachePutUserServcie");

        User userFetch1 = userService.getUser(1);
        System.out.println(userFetch1);
        User userFetch2 = userService.getUser(1);
        System.out.println(userFetch2);
    }
}
