package com.csx.springtest.example5.advisor;

import com.csx.springtest.example5.introduce.Monitorable;
import org.springframework.aop.support.IntroductionInfoSupport;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/09
 */
public class MyIntroduceInfo extends IntroductionInfoSupport{
    public MyIntroduceInfo(){
        super();
        super.publishedInterfaces.add(Monitorable.class);
    }
}
