package com.csx.springtest.example6;

import com.csx.springtest.example6.anno.NeedTest;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/09
 */
public class NaughtyWaiter implements Waiter{

    @NeedTest
    @Override
    public void greetTo(String clientName) {
        System.out.println("NaughtyWaiter:greet to "+clientName+"...");
    }
    @Override
    public void serveTo(String clientName){
        System.out.println("NaughtyWaiter:serving "+clientName+"...");
    }
    public void joke(String clientName,int times){
        System.out.println("NaughtyWaiter:play "+times+" jokes to "+clientName+"...");
    }
}
