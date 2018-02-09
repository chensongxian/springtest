package com.csx.springtest.example5.aop;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/08
 */
public class Waiter implements BeanSelfProxyAware{
    private Waiter waiter;
    public void serveTo(String name){
        System.out.println("waiter serving "+name+"...");
        waiter.greetTo(name);
    }

    public void greetTo(String name) {
        System.out.println("waiter greet to "+name+"...");
    }

    @Override
    public void setSelfProxy(Object object) {
        waiter= (Waiter) object;
    }
}
