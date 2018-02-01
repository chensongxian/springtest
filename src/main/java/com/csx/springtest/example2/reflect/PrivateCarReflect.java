package com.csx.springtest.example2.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/01
 */
public class PrivateCarReflect {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        ClassLoader classLoader=Thread.currentThread().getContextClassLoader();

        Class<?> clazz = classLoader.loadClass("com.csx.springtest.example2.reflect.PrivateCar");

        PrivateCar privateCar = (PrivateCar) clazz.newInstance();

        Field color = clazz.getDeclaredField("color");

        color.setAccessible(true);

        color.set(privateCar,"红色");


        Method drive = clazz.getDeclaredMethod("drive",(Class[])null);

        drive.setAccessible(true);

        drive.invoke(privateCar,(Object[])null);

    }
}
