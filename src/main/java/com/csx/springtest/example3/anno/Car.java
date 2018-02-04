package com.csx.springtest.example3.anno;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-02-04
 */
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Component
public class Car {
    private int maxSpeed;
    public String brand;
    private double price;


    public static  String  HONG_QI = "红旗";
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "brand:"+brand+"/maxSpeed:"+maxSpeed+"/price:"+price;
    }
}
