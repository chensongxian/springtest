package com.csx.springtest.example3.impt;

import com.csx.springtest.example3.fb.Car;
import org.junit.jupiter.api.Assertions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/07
 */
public class Test {
    /**
     * 整合多个配置文件
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("com/csx/springtest/example3/impt/beans2.xml");

        Car car1 = context.getBean("car1", Car.class);

        Assertions.assertNotNull(car1);
    }
}
