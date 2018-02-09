package com.csx.springtest.example6.aspectj.example;

import com.csx.springtest.example6.NaiveWaiter;
import com.csx.springtest.example6.Waiter;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/09
 */
public class AspectJProxyTest {
    /**
     * 编码式织入切面
     */
    @Test
    public void testAspectJProxy(){
        AspectJProxyFactory proxyFactory=new AspectJProxyFactory();

        Waiter waiter=new NaiveWaiter();
        proxyFactory.setTarget(waiter);

        proxyFactory.addAspect(PreGreetingAspect.class);

        Waiter proxy = proxyFactory.getProxy();

        proxy.greetTo("xx");
    }

    /**
     * 通过xml织入切面
     */
    @Test
    public void testAspectJByXml(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com/csx/springtest/example6/aspectj/example/beans.xml");

        Waiter waiter = context.getBean("waiter", Waiter.class);

        waiter.greetTo("xx");
    }
}
