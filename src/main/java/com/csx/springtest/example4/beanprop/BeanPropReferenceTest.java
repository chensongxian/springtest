package com.csx.springtest.example4.beanprop;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.jupiter.api.Assertions;
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
public class BeanPropReferenceTest {
    public static void main(String[] args) throws Throwable {
        String resourceFile = "com.csx.springtest.example4.beanprop/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(resourceFile);
        DataSource ds = ctx.getBean("dataSource",BasicDataSource.class);
        Connection conn = ds.getConnection();
        Assertions.assertNotNull(conn);

    }
}
