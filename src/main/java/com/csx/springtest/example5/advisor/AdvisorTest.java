package com.csx.springtest.example5.advisor;

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
public class AdvisorTest {
    /**
     * 静态普通方法匹配切面
     * GreetingAdvisor静态方法匹配器，匹配了greetTo方法同时又必须是waiter类
     */
    @Test
    public void testAdvisor(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com.csx.springtest.example5.advisor/beans.xml");

        Waiter waiter = context.getBean("waiter", Waiter.class);
        Seller seller = context.getBean("seller", Seller.class);

        waiter.greetTo("waiter");

        System.out.println("----------");
        seller.greetTo("seller");
    }

    /**
     * 静态正则表达式方法匹配切面
     */
    @Test
    public void testRegexpAdvisor(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com.csx.springtest.example5.advisor/beans.xml");

        Waiter waiter = context.getBean("waiter1", Waiter.class);

        waiter.greetTo("waiter1");
    }

    /**
     * 如果静态方法匹配是匹配的，将不会进行动态检查
     *
     * 值得注意的是如果不进行静态检查只进行动态检查，每次匹配都进行动态检查将耗费很大的性能
     *
     * 所以很有必要在进行动态检查时必须覆盖静态检查的两个方法，以过滤掉在静态检查阶段就不匹配的方法
     */
    @Test
    public void testDynamicPointcut(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com.csx.springtest.example5.advisor/beans.xml");

        Waiter waiter=context.getBean("waiter2",Waiter.class);

        waiter.greetTo("waiter2");
    }

    /**
     * 流程切面
     * 流程切面就是通过某个方法直接或间接调用的方法
     *
     * 流程切面本质上和动态切面是一种切面，都是动态判断切面
     */
    @Test
    public void testControlFlowPointcut(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com.csx.springtest.example5.advisor/beans.xml");

        Waiter waiter=context.getBean("waiter3",Waiter.class);

        WaiterDelegate waiterDelegate=new WaiterDelegate();

        waiterDelegate.setWaiter(waiter);

        waiter.greetTo("waiter3");

        waiterDelegate.service("waiter3");
    }
}
