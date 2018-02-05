package com.csx.springtest.example3.anno;

import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-02-04
 */
@Component
@Order(value = 1)
public class TwoPlugin implements Plugin{
    public TwoPlugin() {
        System.out.println("second plugin");
    }
}
