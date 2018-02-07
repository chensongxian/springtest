package com.csx.springtest.example3.injectfun;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/07
 */
public class MagicBossImpl1 implements BeanFactoryAware,MagicBoss{
    private BeanFactory beanFactory;
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory=beanFactory;
    }

    @Override
    public Car getCar() {
        return (Car) beanFactory.getBean("car");
    }
}
