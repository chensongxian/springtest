package com.csx.springtest.example2.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 编码资源读取器
 * @Author: csx
 * @Date: 2018/02/01
 */
public class EncodedResourceExample {
    public static void main(String[] args) throws IOException {
        Resource resource = new ClassPathResource("com/csx/springtest/example2/conf/file1.txt");

        EncodedResource encodedResource=new EncodedResource(resource,"UTF-8");

        String content=FileCopyUtils.copyToString(encodedResource.getReader());
        System.out.println(content);
    }
}
