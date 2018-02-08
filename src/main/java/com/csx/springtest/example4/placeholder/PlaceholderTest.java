package com.csx.springtest.example4.placeholder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/08
 */
public class PlaceholderTest {

    @Test
    public void testEncryptPlaceholder(){
        String resourceFile = "com.csx.springtest.example4.placeholder/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(resourceFile);

        MyDataSource dataSource=ctx.getBean("myDataSource",MyDataSource.class);

        Assertions.assertNotNull(dataSource);
    }
}
