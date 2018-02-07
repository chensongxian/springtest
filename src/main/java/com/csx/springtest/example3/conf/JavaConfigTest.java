package com.csx.springtest.example3.conf;

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
 * @Date: 2018/02/07
 */
public class JavaConfigTest {

    /**
     * 通过构造函数加载配置类
     */
    @Test
    public void testLoadContextByConstructor(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConf.class);
        LogonService logonService = ctx.getBean("logonService", LogonService.class);
        logonService.printHelllo();
    }

    /**
     * 通过注册加载配置类
     */
    @Test
    public void testLoadContextByRegister(){
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
        ctx.register(DaoConfig.class);
        ctx.register(ServiceConfig.class);
        ctx.refresh();

        LogonService logonService = ctx.getBean("logonService", LogonService.class);

        logonService.printHelllo();
    }

    /**
     * 通过XML组装@Configuration配置类所提供的配置信息
     */
    @Test
    public void testLoadContextByXml(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com.csx.springtest.example3.conf/beans2.xml");

        LogonService logonService = ctx.getBean("logonService", LogonService.class);

        logonService.printHelllo();
    }

    /**
     * @Configuration的配置类相互引用
     */
    @Test
    public void testJavaConfigRefOther(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoConfig.class,ServiceConfig.class);
        LogonService logonService = ctx.getBean(LogonService.class);
        Assertions.assertNotNull(logonService.getLogDao());
        logonService.printHelllo();
    }

    /**
     * 测试基于java类的配置引用xml中的配置
     */
    @Test
    public void testJavaCOnfigRefXml(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(LogonAppConfig.class);

        LogonService logonService = ctx.getBean(LogonService.class);
        Assertions.assertNotNull(logonService.getLogDao());
        logonService.printHelllo();
    }

}
