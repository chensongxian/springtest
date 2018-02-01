package com.csx.springtest.example2.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/01/31
 */
public class ReflectTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
        Class clazz=classLoader.loadClass("com.csx.springtest.example2.reflect.Car");

        Constructor constructor = clazz.getConstructor((Class[]) null);
        Car car = (Car) constructor.newInstance();

        Method setBrand = clazz.getMethod("setBrand", String.class);
        setBrand.invoke(car,"红旗");

        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car,"红色");

        Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car,1);

        car.introduce();
    }
}
