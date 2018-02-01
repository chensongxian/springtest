package com.csx.springtest.example2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/01
 */
public class Car implements BeanFactoryAware,BeanNameAware,InitializingBean,DisposableBean {
    private String brand;
    private String color;
    private int maxSpeed;
    private String name;
    private BeanFactory beanFactory;
    private String beanName;

    public Car() {
        System.out.println("调用Car()构造函数。");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println("调用setBrand()设置属性。");
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void introduce(){
        System.out.println("introduce:"+this.toString());
    }


    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    /**
     * BeanFactoryAware的接口方法
     * 在属性设置完之后执行，位于BeanNameAware的setBeanName之后
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryAware.setBeanFactory()。");
        this.beanFactory = beanFactory;
    }


    /**
     * BeanNameAware接口方法
     * 在属性设置完之后执行
     * @param name
     */
    @Override
    public void setBeanName(String name) {
        System.out.println("调用BeanNameAware.setBeanName()。");
        this.beanName = beanName;
    }

    /**
     * InitializingBean接口方法
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitializingBean.afterPropertiesSet()。");
    }

    /**
     * DisposableBean接口
     * 容器销毁之后执行
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("调用DisposableBean.destory()。");
    }

    /**
     * InitializingBean.afterPropertiesSet()之后执行
     */
    public void myInit() {
        System.out.println("调用myInit()，将maxSpeed设置为240。");
        this.maxSpeed = 240;
    }

    /**
     * DisposableBean.destory()之后执行
     */
    public void myDestory() {
        System.out.println("调用myDestroy()。");
    }
}
