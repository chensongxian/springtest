package com.csx.springtest.example5.advisor;

import org.springframework.aop.support.DynamicMethodMatcher;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * 使用动态检查会耗费性能，应该同时覆盖静态检查和getClassFilter过滤掉大部分方法
 * @Author: csx
 * @Date: 2018/02/08
 */
public class GreetingDynamicPointcut extends DynamicMethodMatcherPointcut{
    private static List<String> specialClientList = new ArrayList<String>();
    static {
        specialClientList.add("John");
        specialClientList.add("Tom");
    }
    //	public ClassFilter getClassFilter() {
//		return new ClassFilter() {
//			public boolean matches(Class clazz) {
//				System.out.println("调用getClassFilter()对"+clazz.getName()+"做静态检查.");
//				return Waiter.class.isAssignableFrom(clazz);
//			}
//		};
//	}
//	public boolean matches(Method method, Class clazz) {
//		System.out.println("调用matches(method,clazz)对"+clazz.getName()+"."+method.getName()+"做静态检查.");
//		return "greetTo".equals(method.getName());
//	}

    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        System.out.println("调用matches(method,clazz)对"+targetClass.getName()+"."+method.getName()+"做动态检查.");
        String clientName = (String) args[0];
        return specialClientList.contains(clientName);
    }
}
