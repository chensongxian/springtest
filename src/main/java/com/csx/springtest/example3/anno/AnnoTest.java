package com.csx.springtest.example3.anno;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-02-04
 */
public class AnnoTest {
    @Test
    public void testOrder(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com.csx.springtest.example3.anno/beans.xml");

        MyComponent myComponent=context.getBean("myComponent",MyComponent.class);

        Assertions.assertNotNull(myComponent.getPlugins());
    }
}
