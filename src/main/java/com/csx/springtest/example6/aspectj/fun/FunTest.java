package com.csx.springtest.example6.aspectj.fun;

import com.csx.springtest.example6.NaiveWaiter;
import com.csx.springtest.example6.NaughtyWaiter;
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
public class FunTest {
    /**
     * 增强到标识@NeedTest注解的所有方法
     */
    @Test
    public void testAnnotation(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com/csx/springtest/example6/aspectj/fun/beans.xml");

        Waiter waiter = context.getBean("waiter", Waiter.class);

        waiter.greetTo("greetTo");

        System.out.println("-----------");
        waiter.serveTo("serveTo");
    }

    @Test
    public void testThis(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com/csx/springtest/example6/aspectj/fun/beans.xml");

        Waiter naiveWaiter=context.getBean("naiveWaiter", Waiter.class);

        Seller seller= (Seller) naiveWaiter;

        naiveWaiter.greetTo("xx");

        System.out.println("----------------------");

        (seller).sell("goods","sell");
    }
}
