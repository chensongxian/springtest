package com.csx.springtest.example5.aop;

import org.springframework.core.Ordered;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/09
 */
public interface SystemBootAddon extends Ordered{
    /**
     * 在系统就绪后调用的方法
     */
    void onReady();
}
