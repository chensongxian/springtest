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
@Order(1)
public class Order2 {
    public Order2() {
        System.out.println("order 2");
    }
}
