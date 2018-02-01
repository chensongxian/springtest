package com.csx.springtest.example2.resource;

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
public class PatternResolverTest {
    public static void main(String[] args) throws IOException {
        ResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();

        Resource[] resources = resolver.getResources("classpath*:*.xml");

        for(Resource resource:resources){
            System.out.println(resource.getDescription());
        }
    }
}
