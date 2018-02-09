package com.csx.springtest.example6.aspectj.basic;

import com.csx.springtest.example6.NaiveWaiter;
import com.csx.springtest.example6.Seller;
import com.csx.springtest.example6.SmartSeller;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/09
 */
@Aspect
public class EnableSellerAspect {
    @DeclareParents(value = "com.csx.springtest.example6.NaiveWaiter",
                    defaultImpl = SmartSeller.class)
    public Seller seller;
}
