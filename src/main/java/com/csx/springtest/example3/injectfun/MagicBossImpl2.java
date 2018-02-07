package com.csx.springtest.example3.injectfun;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/07
 */
public class MagicBossImpl2 implements MagicBoss,ApplicationContextAware{
    private ApplicationContext context;
    @Override
    public Car getCar() {
        return null;
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context=context;
    }
}
