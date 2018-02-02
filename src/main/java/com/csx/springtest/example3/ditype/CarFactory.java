package com.csx.springtest.example3.ditype;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/02
 */
public class CarFactory {
    public Car createHongQiCar(){
        Car car = new Car();
        car.setBrand("红旗CA72");
        return car;
    }

    public static Car createCar(){
        Car car = new Car();
        return car;
    }
}
