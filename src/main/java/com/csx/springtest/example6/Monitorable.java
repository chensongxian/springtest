package com.csx.springtest.example6;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/09
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Monitorable {
}
