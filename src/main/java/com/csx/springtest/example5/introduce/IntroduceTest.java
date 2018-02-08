package com.csx.springtest.example5.introduce;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/08
 */
public class IntroduceTest {

    @Test
    public void testIntroduce(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com.csx.springtest.example5.introduce/beans.xml");

        ForumService forumService = context.getBean("forumService", ForumService.class);

        /*
         * 未开启性能监视
         */
        forumService.removeForum(1);

        System.out.println("-----------");
        /*
         * 开启性能监视
         */
        Monitorable monitorable= (Monitorable) forumService;
        monitorable.setMonitorActive(true);

        forumService.removeForum(1);
    }
}
