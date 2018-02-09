package com.csx.springtest.example5.aop;

import com.csx.springtest.example5.advisor.Seller;
import com.csx.springtest.example5.advisor.Waiter;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/09
 */
public class AopTest {

    /**
     * 根据bean名进行自动代理
     */
    @Test
    public void testBeanNameAutoProxyCreator(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com/csx/springtest/example5/autoproxy/beans.xml");

        Waiter waiter = context.getBean("waiter", Waiter.class);

        Seller seller = context.getBean("seller", Seller.class);

        waiter.greetTo("xx");

        seller.greetTo("xxx");
    }

    /**
     * 根据切面进行自动代理
     */
    @Test
    public void testDefaultAdvisorAutoProxyCreator(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com/csx/springtest/example5/autoproxy/beans.xml");

        Waiter waiter = context.getBean("waiter", Waiter.class);

        Seller seller = context.getBean("seller", Seller.class);

        waiter.greetTo("xx");
        System.out.println("-------------");
        seller.greetTo("xxx");
    }

    /**
     * 测试同一个类一个方法调用另一个方法不会发生代理的情况
     * 由waiter类中的serveTo方法调用greetTo方法
     */
    @Test
    public void testNoProxy(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com/csx/springtest/example5/autoproxy/beans-aware.xml");

        com.csx.springtest.example5.aop.Waiter waiter = context.getBean("waiter", com.csx.springtest.example5.aop.Waiter.class);

        waiter.serveTo("xx");
    }
}
