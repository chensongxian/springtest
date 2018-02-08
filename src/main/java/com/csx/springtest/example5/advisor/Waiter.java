package com.csx.springtest.example5.advisor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/08
 */
public class Waiter {
    public void serveTo(String name){
        System.out.println("waiter serving "+name+"...");
        //waiter.greetTo(name);
    }

    public void greetTo(String name) {
        System.out.println("waiter greet to "+name+"...");
    }
}
