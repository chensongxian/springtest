package com.csx.springtest.example2.resource;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: spring资源加载器
 * @Author: csx
 * @Date: 2018/02/01
 */
public class PatternResolverTest {
    public static void main(String[] args) throws IOException {
        ResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();

        /*
         *  ?: 匹配文件名中的一个字符
         *  *: 匹配文件名中的任意字符
         *  **: 匹配多层路径
         */
        Resource[] resources = resolver.getResources("classpath*:*.xml");

        for(Resource resource:resources){
            System.out.println(resource.getDescription());
        }
    }
}
