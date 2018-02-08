package com.csx.springtest.example5.proxy;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/08
 */
public class ProxyTest {

    /**
     * 测试简单代理
     */
    @Test
    public void testSimpleProxy(){
        ForumService forumService=new ForumServiceImpl();
        forumService.removeForum(1);
    }

    /**
     * 通过JdK的动态代理实现AOP
     * JDK的动态代理只能为接口创建代理实例,存在局限性
     */
    @Test
    public void testJdkProxy(){
        ForumService target=new ForumServiceImpl();

        PerformaceHandler handler=new PerformaceHandler(target);

        ForumService proxyInstance = (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader()
                , target.getClass().getInterfaces()
                , handler);

        proxyInstance.removeForum(1);
    }

    /**
     * 通过cglib动态代理实现AOP
     * 可以不通过接口创建代理实例，cglib会为代理实例创建一个之类
     */
    @Test
    public void testCglibProxy(){
        CglibProxy proxy=new CglibProxy();

        ForumServiceImpl forumService = (ForumServiceImpl) proxy.getProxy(ForumServiceImpl.class);

        forumService.removeForum(1);
    }
}
