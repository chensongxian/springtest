package com.csx.springtest.example4.beanprop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/08
 */
public class AnnoBeanPropReferenceTest {
    public static void main(String[] args) throws Throwable {
        String resourceFile = "com.csx.springtest.example4.beanprop/beans1.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(resourceFile);
        ApplicationManager applicationManager = ctx.getBean("applicationManager",ApplicationManager.class);
        System.out.println(applicationManager);
    }
}
