package com.csx.springtest.example3.anno;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: spring注解测试
 * @Author: csx
 * @Date: 2018-02-04
 */
public class AnnoTest{
    /**
     * 测试@Order注解，可以用于在list或者数组中注入时进行排序
     */
    @Test
    public void testOrder(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com/csx/springtest/example3/anno/beans.xml");

        MyComponent myComponent=context.getBean("myComponent",MyComponent.class);

        Assertions.assertNotNull(myComponent.getPlugins());

        myComponent.say();
    }

    /**
     * 测试@Lazy注解
     * 必须同时在属性及目标bean上同时加注解
     *
     * 通过测试可以发现在加载LogonService和获取LogDao时并没有开始加载LogDao
     * 而是在调用saveLog方法才开始加载，@Lazy发挥了作用
     */
    @Test
    public void testLazy(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com/csx/springtest/example3/anno/beans.xml");

        LogonService logonService=context.getBean("logonService",LogonService.class);

        Assertions.assertNotNull(logonService);

        LogDao logDao = logonService.getLogDao();

        Assertions.assertNotNull(logDao);
        System.out.println("-------------");
        logDao.saveLog();

    }

    /**
     * 测试生命周期注解@PostConstruct和@PreDestroy
     * 上述两个方法相当于xml配置中的init-method和destory-method
     */
    @Test
    public void testBeanLifeMethod(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com/csx/springtest/example3/anno/beans.xml");

        Boss boss=context.getBean("boss",Boss.class);

        Assertions.assertNotNull(boss);

        ((ClassPathXmlApplicationContext)context).destroy();
    }
}
