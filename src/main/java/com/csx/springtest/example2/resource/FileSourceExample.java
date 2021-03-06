package com.csx.springtest.example2.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 资源访问
 * @Author: csx
 * @Date: 2018/02/01
 */
public class FileSourceExample {
    public static void main(String[] args) throws IOException {
        String filePath="F:\\idea\\springtest\\src\\main\\resources\\com.csx.springtest.example2.conf\\file1.txt";

        // 1. 使用系统文件路径方式加载文件
        WritableResource wr=new PathResource(filePath);

        // 2. 使用类路径方式加载文件
        Resource re=new ClassPathResource("com/csx/springtest/example2/conf/file1.txt");

        // 3. 使用WritableResource接口写资源文件
        OutputStream outputStream = wr.getOutputStream();

        outputStream.write("测试写入".getBytes());

        outputStream.close();

        // 4. 使用Resource接口读资源文件
        InputStream wrInputStream = wr.getInputStream();

        InputStream reInputStream = re.getInputStream();

        ByteArrayOutputStream bos=new ByteArrayOutputStream();

        int i;
        while ((i=wrInputStream.read())!=-1){
            bos.write(i);
        }

        System.out.println(bos.toString());

        System.out.println("wr: "+wr.getFilename());

        System.out.println("res: "+re.getFilename());
    }
}
