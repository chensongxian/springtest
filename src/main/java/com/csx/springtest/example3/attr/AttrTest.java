package com.csx.springtest.example3.attr;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/02
 */
public class AttrTest {
    /**
     * 设置转义字符属性
     */
    @Test
    public void testEscapeString(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com.csx.springtest.example3.attr/beans.xml");

        Car car=context.getBean("car",Car.class);

        System.out.println(car.getBrand());
    }

    /**
     * 父子容器
     * 子容器引用父容器
     */
    @Test
    public void testParentContext(){
        ClassPathXmlApplicationContext parentContext = new ClassPathXmlApplicationContext("com.csx.springtest.example3.attr/beans1.xml");

        ApplicationContext context=new ClassPathXmlApplicationContext(new String[]{"com.csx.springtest.example3.attr/beans2.xml"},parentContext);

        Boss boss=context.getBean("boss",Boss.class);

        Car car=boss.getCar();

        System.out.println(car.toString());
    }

}
