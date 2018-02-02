package com.csx.springtest.example2.beanfactory;

import com.csx.springtest.example2.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/01
 */
public class GroovyApplicationContext {
    @Test
    public void getBean(){
        ApplicationContext applicationContext=new GenericGroovyApplicationContext("classpath:com/csx/springtest/example2/groovy-beans.groovy");

        Car car=applicationContext.getBean("car",Car.class);

        Assertions.assertNotNull(car);
    }
}
