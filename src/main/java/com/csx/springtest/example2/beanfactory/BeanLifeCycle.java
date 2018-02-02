package com.csx.springtest.example2.beanfactory;

import com.csx.springtest.example2.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/01
 */
public class BeanLifeCycle {
    @Test
    public void LifeCycleInBeanFactory(){


        //1.下面两句装载配置文件并启动容器
        Resource res = new ClassPathResource("com/csx/springtest/example2/beans.xml");

        BeanFactory bf= new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((DefaultListableBeanFactory)bf);
        reader.loadBeanDefinitions(res);

        /*
         * ConfigurableBeanFactory正如其名可配置的BeanFactory
         * 该BeanFactory可以添加一些后处理器
         */

        //2.向容器中注册MyBeanPostProcessor后处理器
        ((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyBeanPostProcessor());

        //3.向容器中注册MyInstantiationAwareBeanPostProcessor后处理器
        ((ConfigurableBeanFactory)bf).addBeanPostProcessor(
                new MyInstantiationAwareBeanPostProcessor());
        //4.第一次从容器中获取car，将触发容器实例化该Bean，这将引发Bean生命周期方法的调用。
        Car car1 = (Car)bf.getBean("car");
        car1.introduce();
        car1.setColor("红色");

        //5.第二次从容器中获取car，直接从缓存池中获取
        System.out.println("------------");
        Car car2 = (Car)bf.getBean("car");

        /*
         * 6.查看car1和car2是否指向同一引用
         *
         * spring中容器创建JavaBean默认是singleton单例
         */
        System.out.println("car1==car2:"+(car1==car2));
        //7.关闭容器
        ((DefaultListableBeanFactory)bf).destroySingletons();

    }
}
