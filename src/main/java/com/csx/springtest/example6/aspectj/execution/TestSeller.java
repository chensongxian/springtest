package com.csx.springtest.example6.aspectj.execution;

import com.csx.springtest.example6.Seller;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/09
 */
public class TestSeller implements Seller{
    @Override
    public int sell(String goods, String clientName) {
        System.out.println("TestSeller: sell " + goods + " to " + clientName + "...");
        return 100;
    }

    public void sellTo(){
        System.out.println("sellTo method");
    }

    protected void showGoods(){
        System.out.println("show goods");
    }
}
