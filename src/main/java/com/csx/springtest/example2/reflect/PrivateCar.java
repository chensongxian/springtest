package com.csx.springtest.example2.reflect;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/01/31
 */
public class PrivateCar {
    private String color;
    protected void drive(){
        System.out.println("drive private car! the color is:"+color);
    }
}
