package com.csx.springtest.example6.aspectj.basic;

import com.csx.springtest.example6.Seller;
import com.csx.springtest.example6.Waiter;
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
public class EnableSellerAspectTest {

    @Test
    public void testEnableSellerAspect(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com/csx/springtest/example6/aspectj/basic/beans.xml");

        Waiter waiter=context.getBean("waiter", Waiter.class);

        waiter.greetTo("xxx");

        Seller seller= (Seller) waiter;

        seller.sell("goods","name");
    }
}
