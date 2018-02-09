package com.csx.springtest.example6;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/09
 */
public class NaiveWaiter implements Waiter{
    @Override
    public void greetTo(String clientName) {
        System.out.println("NaiveWaiter:greet to "+clientName+"...");
    }
    @Override
    public void serveTo(String clientName){
        System.out.println("NaiveWaiter:serving "+clientName+"...");
    }
    public void smile(String clientName,int times){
        System.out.println("NaiveWaiter:smile to  "+clientName+ times+"times...");
    }
}
