package com.csx.springtest.example2.beanfactory;

import com.csx.springtest.example2.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * 继承自BeanPostProcessor,在设置完属性之后对bean进行后续操作
 * AOP和动态代理都通过BeanPostProcessors实现
 * @Author: csx
 * @Date: 2018/02/01
 */
public class MyBeanPostProcessor implements BeanPostProcessor{

    /**
     * 在设置完属性之后执行，在执行一系列init方法之前执行
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("car")){
            Car car = (Car)bean;
            if(car.getColor() == null){
                System.out.println("调用MyBeanPostProcessor.postProcessBeforeInitialization()，color为空，设置为默认黑色。");
                car.setColor("黑色");
            }
        }
        return bean;
    }

    /**
     * 在执行一系列init方法之后执行
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("car")){
            Car car = (Car)bean;
            if(car.getMaxSpeed() >= 200){
                System.out.println("调用MyBeanPostProcessor.postProcessAfterInitialization()，将maxSpeed调整为200。");
                car.setMaxSpeed(200);
            }
        }
        return bean;
    }
}
