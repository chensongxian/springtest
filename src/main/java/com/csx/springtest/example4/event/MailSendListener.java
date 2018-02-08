package com.csx.springtest.example4.event;

import org.springframework.context.ApplicationListener;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/08
 */
public class MailSendListener implements ApplicationListener<MailSendEvent>{
    @Override
    public void onApplicationEvent(MailSendEvent event) {
        MailSendEvent mse = (MailSendEvent) event;
        System.out.println("MailSendListener:向" + mse.getTo() + "发送完一封邮件");
    }
}
