package com.csx.springtest.example4.event;

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
public class ApplicationEventTest {

    /**
     * 容器事件测试
     */
    @Test
    public void  testApplicationEvent(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com.csx.springtest.example4.event/beans.xml");

        MailSender mailSender = context.getBean("mailSender", MailSender.class);

        mailSender.sendMail("11@qq.com");
    }
}
