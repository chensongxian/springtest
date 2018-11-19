package com.csx.springtest.example2.beanfactory;

import com.csx.springtest.example2.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/01
 */
public class BeanFactoryTest {

    @Test
    public void getBean() throws IOException {
        ResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
        // 1. 获取资源
        Resource resource = resolver.getResource("classpath:com/csx/springtest/example2/beans.xml");

        System.out.println(resource.getURL());

        // 2. 获取BeanFactory
        DefaultListableBeanFactory listableBeanFactory=new DefaultListableBeanFactory();

        // 3. 根据新建的 BeanFactory 创建一个 BeanDefinitionReader 对象，该 Reader 对象为资源的解析器
        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(listableBeanFactory);
        XmlBeanDefinitionReader reader2=new XmlBeanDefinitionReader(listableBeanFactory);

        // 4. 装载资源
        reader.loadBeanDefinitions(resource);

        System.out.println(" init bean");

        Car car= (Car) listableBeanFactory.getBean("car");

        System.out.println("car bean is ready for use");

        car.introduce();

    }








}
