package com.csx.springtest.example5.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/08
 */
public class PerformaceHandler implements InvocationHandler{
    private Object target;

    public PerformaceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonitor.begin(target.getClass().getName()+"."+method.getName());
        Object obj = method.invoke(target, args);
        PerformanceMonitor.end();
        return obj;
    }
}
