package com.csx.springtest.example11.hazelcast;


import com.csx.springtest.example11.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserMain {
    public static void main(String... args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-hazelcast.xml");
        UserService userService = (UserService) context.getBean("hazelcastUserServcie");

        User user1 = new User("2", "w2", 34);
        User userFetch1 = userService.getUser(user1);
        System.out.println(userFetch1);
        User userFetch2 = userService.getUser(user1);
        System.out.println(userFetch2);

        User user2 = new User("1", "w1",37);
        User userFetch3 = userService.getUser(user2);
        System.out.println(userFetch3);
        User userFetch4 = userService.getUser(user2);
        System.out.println(userFetch4);
    }
}
