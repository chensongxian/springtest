package com.csx.springtest.example6;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/09
 */
public class SmartSeller implements Seller {
    @Override
    public int sell(String goods, String clientName) {
        System.out.println("SmartSeller: sell " + goods + " to " + clientName + "...");
        return 100;
    }

    public void checkBill(int billId) {
        if (billId == 1) {
            throw new IllegalArgumentException("iae Exception");
        } else {
            throw new RuntimeException("re Exception");
        }
    }
}
