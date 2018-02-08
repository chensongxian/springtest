package com.csx.springtest.example5.advisor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/08
 */
public class WaiterDelegate {
    private Waiter waiter;
    public void service(String clientName) {
        waiter.greetTo(clientName);
        waiter.serveTo(clientName);
    }
    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }
}
