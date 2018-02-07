package com.csx.springtest.example3.injectfun;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/07
 */
public class InjectFunTest {

    /**
     * 测试lookup方法注入
     * 通过lookup-method可以为MagicBoss的getCar方法提供动态实现
     *
     * 适用范围:
     * lookup一般适用于一个singleton Bean希望获取一个prototype bean时使用
     * 如果一个singleton Bean获取一个singleton Bean将没有意义，直接使用属性注入即可
     */
    @Test
    public void testLookUpMethod(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com.csx.springtest.example3.injectfun/beans.xml");


        /*
         * 实现BeanFactoryWare方法
         */
        MagicBossImpl1 magicBossImpl1=context.getBean("magicBossImpl1",MagicBossImpl1.class);
        System.out.println(magicBossImpl1.getCar().toString());
        System.out.println(magicBossImpl1.getCar().toString());

        /*
         * 实现ApplicationContextAware方法
         */
        MagicBossImpl2 magicBossImpl2=context.getBean("magicBossImpl2",MagicBossImpl2.class);
        System.out.println(magicBossImpl2.getCar().toString());
        System.out.println(magicBossImpl2.getCar().toString());
        /*
         * 使用lookup-method实现
         */
        System.out.println("------------------");
        MagicBoss magicBoss3=context.getBean("magicBoss",MagicBoss.class);
        //每次使用getCar方法都是返回新的对象
        System.out.println(magicBoss3.getCar().toString());
        System.out.println(magicBoss3.getCar().toString());

    }

    /**
     * 方法替换
     */
    @Test
    public void testReplacer(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com.csx.springtest.example3.injectfun/beans.xml");

        Boss1 boss1 = context.getBean("boss1", Boss1.class);

        Car car=boss1.getCar();

        System.out.println(car.getBrand());
    }
}
