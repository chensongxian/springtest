package com.csx.springtest.example2.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * 通过查看源码可以发现InstantiationAwareBeanPostProcessorAdapter最终的父类是BeanPostProcessor
 * 可以通过继承该类在JavaBean实例化前后进行一些操作
 * @Author: csx
 * @Date: 2018/02/01
 */
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    /**
     * 实例化之前运行
     *
     * 通过实测发现当bean的scope被设置成prototype时，只会在第一次实例化调用该方法，第二次并不会执行
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if("car".equals(beanName)){
            System.out.println("MyInstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation:实例化之前");
        }
        return null;
    }

    /**
     * 实例化之后运行
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if("car".equals(beanName)){
            System.out.println("InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation:实例化之后");
        }
        return true;
    }

    /**
     * 在设置属性之前执行
     * @param pvs 属性名称和值
     * @param pds 属性描述，比如set和get方法
     * @param bean 没有设置属性的bean对象
     * @param beanName bean名称
     * @return
     * @throws BeansException
     */
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        MutablePropertyValues values=null;
        if("car".equals(beanName)){
            PropertyValue[] propertyValues = pvs.getPropertyValues();
            values=new MutablePropertyValues();
            for (PropertyValue propertyValue:propertyValues){
                String name=propertyValue.getName();
                if(name.equals("color")){
                    //PropertyValue内部的value和name都是final,setAttribute并不生效
                    //propertyValue.setAttribute(name,"红色");

                    propertyValue=new PropertyValue(name,"红色");
                }
                values.addPropertyValue(propertyValue);
            }
            System.out.println("InstantiationAwareBeanPostProcessor.postProcessPropertyValues:设置属性之前");
        }
        return values==null?pvs:values;
    }

    /**
     * 通过源码可以发现InstantiationAwareBeanPostProcessorAdapter最终的父类是BeanPostProcessor
     * postProcessBeforeInitialization和postProcessAfterInitialization都是继承自BeanPostProcessor
     * 执行的顺序也基本一致
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
