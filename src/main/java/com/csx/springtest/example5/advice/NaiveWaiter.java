package com.csx.springtest.example5.advice;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/08
 */
public class NaiveWaiter implements Waiter{
    @Override
    public void greetTo(String name) {
        System.out.println("greet to "+name+"...");
    }

    @Override
    public void serveTo(String name){
        System.out.println("serving "+name+"...");
    }
}
