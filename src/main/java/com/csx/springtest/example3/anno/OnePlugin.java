package com.csx.springtest.example3.anno;

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
@Order(value = 2)
public class OnePlugin implements Plugin{
    public OnePlugin() {
        System.out.println("first plugin");
    }
}
