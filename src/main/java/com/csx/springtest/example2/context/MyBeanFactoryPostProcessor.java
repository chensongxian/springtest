package com.csx.springtest.example2.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * BeanFactoryPostProcessor处理器，对工厂定义消息进行处理
 * 发送在调用getBean方法之前
 * @Author: csx
 * @Date: 2018/02/01
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor{
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition bd = beanFactory.getBeanDefinition("car");
        bd.getPropertyValues().addPropertyValue("brand", "奇瑞QQ");
        System.out.println("调用MyBeanFactoryPostProcessor.postProcessBeanFactory()！");
    }
}
