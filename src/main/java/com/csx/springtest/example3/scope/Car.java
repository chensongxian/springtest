package com.csx.springtest.example3.scope;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/02
 */
public class Car {
    private String color;
    private String brand;
    private double price;

    public Car() {
        System.out.println("init car");
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "brand:" + brand + "/price:" + price + "/color:" + color;
    }
}
