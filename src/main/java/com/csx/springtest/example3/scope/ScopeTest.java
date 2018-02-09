package com.csx.springtest.example3.scope;

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
public class ScopeTest {
    /**
     * 测试单例scope
     */
    @Test
    public void testSingletonScope(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com/csx/springtest/example3/scope/beans.xml");

        Car car1=context.getBean("singletonCar",Car.class);
        Car car2=context.getBean("singletonCar",Car.class);
        /*
         * 因为car1和car2都是同一个对象实例，所以输出true
         */
        System.out.println("car1==car2: "+(car1==car2));

        Boss boss1=context.getBean("boss1",Boss.class);
        Boss boss2=context.getBean("boss1",Boss.class);
        Boss boss3=context.getBean("boss1",Boss.class);

        System.out.println("car1==boss1: "+(car1==(boss1.getCar())));
        System.out.println("boss1==boss2: "+((boss1.getCar()==boss2.getCar())));

        System.out.println("------------------------");

    }

    /**
     * 测试多例scope
     */
    @Test
    public void testPrototypeScope(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com/csx/springtest/example3/scope/beans.xml");

        Car car1=context.getBean("prototypeCar",Car.class);
        Car car2=context.getBean("prototypeCar",Car.class);
        /*
         * prototype多例scope每次从容器中取bean都是重新创建，所以输出false
         */
        System.out.println(car1==car2);

        System.out.println("------------------------");
    }

    /**
     * lazy-init测试
     * 设置lazy-init为true之后在容器初始化并不会加载
     * 但是当被其他对象引用时将会忽略此设置
     */
    @Test
    public void testLazyInit(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com/csx/springtest/example3/scope/beans.xml");

        Boss boss1=context.getBean("boss1",Boss.class);


        System.out.println("------------------------");
    }
}
