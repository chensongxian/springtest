package com.csx.springtest.example6.aspectj.execution;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/09
 */
@Aspect
public class ExecutionAspect {

    /**
     * 通过方法签名定义切点
     *
     * 匹配所有目标类的public方法
     */
    //@Before("execution(public * * (..))")
    public void executionPublic(){
        System.out.println("execution public");
    }

    /**
     * 通过方法签名定义切点
     *
     * 匹配所有目标类以To结尾的方法
     */
    //@Before("execution(* *To(..))")
    public void executionToSuffix(){
        System.out.println("execution to suffix");
    }

    /**
     * 通过类定义切点
     *
     * 匹配Waiter接口的所有方法
     */
//    @Before("execution(* com.csx.springtest.example6.Waiter.*(..))")
    public void executionWaiterMethod(){
        System.out.println("execution method of waiter");
    }

    /**
     * 通过类定义切点
     *
     * 匹配Waiter接口及其实现类的所有方法
     */
//    @Before("execution(* com.csx.springtest.example6.Waiter+.*(..))")
    public void executionWaiterAllMethod(){
        System.out.println("execution all method of waiter");
    }

    /**
     * 通过类包定义切点
     *
     * 匹配example6包下的所有类的方法,不包括其子包
     */
//    @Before("execution(* com.csx.springtest.example6.*.*(..))")
    public void executionPackageofExample6(){
        System.out.println("execution method in example6 package ");
    }

    /**
     * 通过类包定义切点
     *
     * 匹配example6包下的所有类的方法，包括子包
     */
    //@Before("execution(* com.csx.springtest.example6..*.*(..))")
    public void executionAllMethodInPackage(){
        System.out.println("execution all method in example6 package");
    }

    /**
     * 通过类包定义切点
     *
     * 匹配example6包下的所有以Seller为后缀的类下以sell为前缀的方法，包括子包
     */
//    @Before("execution(* com.csx.springtest.example6..*.*Seller.sell*(..))")
    public void executionPrefixMethodInPackage(){
        System.out.println("execution all method in example6 package");
    }

    /**
     * 通过方法入参定义切点
     *
     * 匹配所有以To为后缀的方法同时参数又是String的方法
     */
    @Before("execution(* *To(String))")
    public void executionMethodParam1(){
        System.out.println("execution method by param");
    }
}
