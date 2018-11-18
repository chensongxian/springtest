package com.csx.springtest.example2.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 反射机制，控制类
 * @Author: csx
 * @Date: 2018/01/31
 */
public class ReflectTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 1. 通过类加载器获取Car类对象
        ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
        Class clazz=classLoader.loadClass("com.csx.springtest.example2.reflect.Car");

        // 2. 获取类的默认构造器对象并通过它实例化Car
        Constructor constructor = clazz.getConstructor((Class[]) null);
        Car car = (Car) constructor.newInstance();

        // 3. 通过反射方法设置属性
        Method setBrand = clazz.getMethod("setBrand", String.class);
        setBrand.invoke(car,"红旗");

        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car,"红色");

        Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car,1);

        car.introduce();
    }
}
