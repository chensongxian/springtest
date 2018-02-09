package com.csx.springtest.example6.aspectj.fun;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/09
 */
@Aspect
public class TestAspect implements Ordered{
//    @AfterReturning("@annotation(com.csx.springtest.example6.anno.NeedTest)")
//    public void needTestFun(){
//        System.out.println("needTestFun execute");
//    }

    @AfterReturning("this(com.csx.springtest.example6.Seller)")
    public void thisTest(){
        System.out.println("thisTest() executed!");
    }
    @Override
    public int getOrder() {
        return 1;
    }
}
