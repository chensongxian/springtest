package com.csx.springtest.example5.advice;

import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/08
 */
public class AdivceTest {

    /**
     * 前置增强测试
     */
    @Test
    public void testBefore(){
        Waiter target=new NaiveWaiter();

        ProxyFactory proxyFactory=new ProxyFactory();

        /*
         * 指定针对接口进行代理
         */
        proxyFactory.setInterfaces(Waiter.class);

        /*
         * 启用优化，针对接口代理时也会使用cglib
         */
        proxyFactory.setOptimize(true);

        proxyFactory.setTarget(target);

        proxyFactory.addAdvice(new GreetingBeforeAdvice());

        Waiter waiter= (Waiter) proxyFactory.getProxy();

        waiter.greetTo("test");
    }

    /**
     * 测试通过xml配置后置增强
     */
    @Test
    public void testAfter(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com/csx/springtest/example5/advice/beans.xml");

        Waiter waiter=context.getBean("waiterOfBefore",Waiter.class);

        waiter.greetTo("test");
    }

    @Test
    public void testThrowAdivce(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com/csx/springtest/example5/advice/beans.xml");

        ForumService forumService = context.getBean("forumService", ForumService.class);

        forumService.removeForum(1);
    }
}
