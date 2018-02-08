package com.csx.springtest.example5.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/08
 */
public class GreetingInterceptor implements MethodInterceptor{


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object[] args = invocation.getArguments();
        String clientName = (String)args[0];
        System.out.println("How are you！Mr."+clientName+".");

        Object obj = invocation.proceed();

        System.out.println("Please enjoy yourself!");

        return obj;
    }
}
