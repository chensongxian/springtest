package com.csx.springtest.example5.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/08
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice{
    @Override
    public void before(Method method, Object[] args, Object o) throws Throwable {
        String clientName = (String)args[0];
        System.out.println("How are you！Mr."+clientName+".");
    }
}
