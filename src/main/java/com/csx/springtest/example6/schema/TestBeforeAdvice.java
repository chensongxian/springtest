package com.csx.springtest.example6.schema;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/09
 */
public class TestBeforeAdvice implements MethodBeforeAdvice{
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("------TestBeforeAdvice------");
        System.out.println("clientName:"+args[0]);
        System.out.println("------TestBeforeAdvice------");
    }
}
