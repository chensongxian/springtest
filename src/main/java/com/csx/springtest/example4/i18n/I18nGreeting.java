package com.csx.springtest.example4.i18n;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/08
 */
public class I18nGreeting {
//    @Test
    public static void rsrBdlMessageResource(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com.csx.springtest.example4.i18n/beans.xml");

        MessageSource ms = (MessageSource)ctx.getBean("myResource1");
        Object[] params = {"John", new GregorianCalendar().getTime()};

        String str1 = ms.getMessage("greeting.common",params,Locale.US);
        String str2 = ms.getMessage("greeting.morning",params, Locale.CHINA);
        String str3 = ms.getMessage("greeting.afternoon",params,Locale.CHINA);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
    }

    public static void main(String[] args) {
        rsrBdlMessageResource();
    }
}
