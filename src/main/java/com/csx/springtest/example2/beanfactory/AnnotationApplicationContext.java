package com.csx.springtest.example2.beanfactory;

import com.csx.springtest.example2.Car;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 使用注解加载一个Bean
 * @Author: csx
 * @Date: 2018/02/01
 */
public class AnnotationApplicationContext {
    @Test
    public void getBean(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(Beans.class);

        Car car= applicationContext.getBean("car",Car.class);

        Assertions.assertNotNull(car);
    }
}
