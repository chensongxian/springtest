package com.csx.springtest.example6.aspectj.execution;

import com.csx.springtest.example6.NaughtyWaiter;
import com.csx.springtest.example6.Seller;
import com.csx.springtest.example6.Waiter;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 测试execution定义切点
 * @Author: csx
 * @Date: 2018/02/09
 */
public class ExecutionTest {
    /**
     * execution匹配所有目标类的public方法
     *
     *  @Before("execution(public * * (..))")
     *
     *  如下所示:showGoods是protect方法,所有并没有得到增强
     */
    @Test
    public void testExecutionPublic(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com/csx/springtest/example6/aspectj/execution/beans.xml");

        Seller seller = context.getBean("seller", Seller.class);

        TestSeller testSeller= (TestSeller) seller;
        testSeller.sell("1","1");
        System.out.println("-----------------");
        testSeller.showGoods();
    }

    /**
     * execution匹配所有目标类以To结尾的方法
     *
     * @Before("execution(* *To(..))")
     *
     * 如下所示:只有sellTo方法得到了增强
     */
    @Test
    public void testExecutionToSuffix(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com/csx/springtest/example6/aspectj/execution/beans.xml");

        Seller seller = context.getBean("seller", Seller.class);

        TestSeller testSeller= (TestSeller) seller;
        testSeller.sell("1","1");
        System.out.println("-----------------");
        testSeller.sellTo();
    }

    /**
     * execution匹配所有Waiter接口的方法
     *
     * @Before("execution(* com.csx.springtest.example6.Waiter.*(..))")
     *
     * 如下所示:joke方法没有得到增强
     */
    @Test
    public void testExecutionWaiterMethod(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com/csx/springtest/example6/aspectj/execution/beans.xml");

        Waiter waiter=context.getBean("waiter",Waiter.class);

        NaughtyWaiter naughtyWaiter= (NaughtyWaiter) waiter;

        naughtyWaiter.greetTo("greetTo");

        System.out.println("-----------");
        naughtyWaiter.joke("1",2);
    }


    /**
     * execution匹配Waiter接口及其实现类的方法
     *
     * @Before("execution(* com.csx.springtest.example6.Waiter+.*(..))")
     *
     * 如下所示:joke方法也得带了增强
     */
    @Test
    public void testExecutionWaiterAllMethod(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com/csx/springtest/example6/aspectj/execution/beans.xml");

        Waiter waiter=context.getBean("waiter",Waiter.class);

        NaughtyWaiter naughtyWaiter= (NaughtyWaiter) waiter;

        naughtyWaiter.greetTo("greetTo");

        System.out.println("-----------");
        naughtyWaiter.joke("joke",2);
    }

    /**
     * execution匹配example6包下的所有方法，不包含子包（注意，其继承类的实现方法也包括在内）
     *
     * @Before("execution(* com.csx.springtest.example6.*.*(..))")
     *
     * 如下所示:只有showGoods方法没有增强
     */
    @Test
    public void testExecutionMethodInPackage(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com/csx/springtest/example6/aspectj/execution/beans.xml");

        Waiter waiter=context.getBean("waiter",Waiter.class);

        Seller seller = context.getBean("seller", Seller.class);

        waiter.serveTo("waiter");
        System.out.println("------------------");

        TestSeller testSeller= (TestSeller) seller;
        testSeller.sell("goods","testSeller");
        System.out.println("--------------------");
        testSeller.showGoods();
    }

    /**
     * execution匹配example6包下的所有方法，包括子包
     *
     * @Before("execution(* com.csx.springtest.example6..*.*(..))")
     *
     * 如下所示:所有方法都得到了增强
     */
    @Test
    public void testExecutionAllMethodInPackage(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com/csx/springtest/example6/aspectj/execution/beans.xml");

        Waiter waiter=context.getBean("waiter",Waiter.class);

        Seller seller = context.getBean("seller", Seller.class);

        waiter.serveTo("waiter");
        System.out.println("-----------------");

        TestSeller testSeller= (TestSeller) seller;

        testSeller.showGoods();
    }

    /**
     * 匹配example6包下的所有以Seller为后缀的类下以sell为前缀的方法，包括子包
     *
     * @Before("execution(* com.csx.springtest.example6..*.*Seller.sell*(..))")
     */
    @Test
    public void testPrefixMethodInPackage(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com/csx/springtest/example6/aspectj/execution/beans.xml");

        Waiter waiter=context.getBean("waiter",Waiter.class);


        Seller seller = context.getBean("seller", Seller.class);

        TestSeller testSeller= (TestSeller) seller;

        waiter.serveTo("waiter");
        System.out.println("---------------");
        testSeller.sell("goods","seller");
        System.out.println("--------------");
        testSeller.sellTo();
        System.out.println("--------------");
        testSeller.showGoods();
    }

    @Test
    public void testMethodByParam1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com/csx/springtest/example6/aspectj/execution/beans.xml");

        Waiter waiter=context.getBean("waiter",Waiter.class);

        Seller seller = context.getBean("seller", Seller.class);

        TestSeller testSeller= (TestSeller) seller;

        waiter.serveTo("waiter");
        System.out.println("-----------------");

        testSeller.sellTo();
    }
}
