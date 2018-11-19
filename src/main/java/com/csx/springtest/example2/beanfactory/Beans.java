package com.csx.springtest.example2.beanfactory;

import com.csx.springtest.example2.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 注解方式注册一个Bean
 * @Author: csx
 * @Date: 2018/02/01
 */
@Configuration
public class Beans {

    /**
     * 定义一个bean
     * @return
     */
    @Bean(name = "car")
    public Car buildCar(){
        Car car=new Car();
        car.setBrand("红旗");
        car.setColor("黑色");
        car.setMaxSpeed(200);

        return car;
    }
}
