package com.csx.springtest.example4.edit;

import org.junit.jupiter.api.Assertions;
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
public class EditTest {

    /**
     * 测试自定义属性
     */
    @Test
    public void testEdit(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com/csx/springtest/example4/edit/beans.xml");

        Boss boss = context.getBean("boss", Boss.class);

        Assertions.assertNotNull(boss);

        System.out.println(boss.getCar().toString());
    }
}
