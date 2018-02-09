package com.csx.springtest.example6.aspectj.fun;

import com.csx.springtest.example6.Seller;
import com.csx.springtest.example6.SmartSeller;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 引介增强
 * @Author: csx
 * @Date: 2018/02/09
 */
@Aspect
public class EnableSellerAspect implements Ordered{
    @DeclareParents(value = "com.csx.springtest.example6.NaiveWaiter", defaultImpl = SmartSeller.class)
    public static Seller seller;
    @Override
    public int getOrder() {
        return 2;
    }
}
