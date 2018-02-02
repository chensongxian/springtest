package com.csx.springtest.example2.context;

import com.csx.springtest.example2.Car;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/01
 */
public class ApplicationContextLifeCycle {
    @Test
    public void LifeCycleInApplication(){
        /*
         * 貌似ApplicationContext并没有开发代码显示注册后处理器的方法
         * 需要用xml进行配置
         */
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("com/csx/springtest/example2/beans-context.xml");

        Car car1 = (Car)applicationContext.getBean("car");
        car1.introduce();
        car1.setColor("红色");

        //第二次从容器中获取car，直接从缓存池中获取
        System.out.println("------------");
        Car car2 = (Car)applicationContext.getBean("car");

        /*
         * 查看car1和car2是否指向同一引用
         *
         * spring中容器创建JavaBean默认是singleton单例
         */
        System.out.println("car1==car2:"+(car1==car2));

        ((ConfigurableApplicationContext) applicationContext).close();
    }
}
