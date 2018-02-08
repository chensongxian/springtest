package com.csx.springtest.example5.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/08
 */
public class CglibProxy implements MethodInterceptor{
    private Enhancer enhancer=new Enhancer();

    public Object getProxy(Class clazz) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        PerformanceMonitor.begin(object.getClass().getName()+"."+method.getName());
        Object result=methodProxy.invokeSuper(object,args);
        PerformanceMonitor.end();
        return result;
    }
}
