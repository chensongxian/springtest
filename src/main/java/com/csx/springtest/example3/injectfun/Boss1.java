package com.csx.springtest.example3.injectfun;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/07
 */
public class Boss1 implements MagicBoss{
    @Override
    public Car getCar() {
        Car car = new Car();
        car.setBrand("宝马Z4");
        return car;
    }
}
