package com.csx.springtest.example6.aspectj.advanced;

import com.csx.springtest.example6.Monitorable;
import com.csx.springtest.example6.Waiter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/09
 */
@Aspect
public class TestAspect {
    //-------------复合运算----------
	@Before("!target(com.csx.springtest.example6.NaiveWaiter) && execution(* serveTo(..)))")
	public void notServeInNaiveWaiter() {
		System.out.println("--notServeInNaiveWaiter() executed!--");
	}

	@After("within(com.csx.springtest.example6.*) "
			+ " && execution(* greetTo(..)))")
	public void greeToFun() {
		System.out.println("--greeToFun() executed!--");
	}

	@AfterReturning("target(com.csx.springtest.example6.Waiter) || "+
			        " target(com.csx.springtest.example6.Seller)")
	public void waiterOrSeller(){
		System.out.println("--waiterOrSeller() executed!--");
	}

    //	//------------引用命名切点----------//
	@Before("TestNamePointcut.inPkgGreetTo()")
	public void pkgGreetTo(){
		System.out.println("--pkgGreetTo() executed!--");
	}

	@Before("!target(com.csx.springtest.example6.NaiveWaiter) && "
			+"TestNamePointcut.inPkgGreetTo()")
	public void pkgGreetToNotNaiveWaiter(){
		System.out.println("--pkgGreetToNotNaiveWaiter() executed!--");
	}


    /**
     * ------------访问连接点对象----------
     * @param pjp
     * @throws Throwable
     */
    @Around("execution(* greetTo(..)) && target(com.csx.springtest.example6.NaiveWaiter)")
    public void joinPointAccess(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("------joinPointAccess-------");
        System.out.println("args[0]:"+pjp.getArgs()[0]);
        System.out.println("signature:"+pjp.getTarget().getClass());
        pjp.proceed();
        System.out.println("-------joinPointAccess-------");
    }

  //------------绑定连接点参数----------//
	@Before("target(com.csx.springtest.example6.NaiveWaiter) && args(name,num,..)")
	public void bindJoinPointParams(int num,String name){
	   System.out.println("----bindJoinPointParams()----");
	   System.out.println("name:"+name);
	   System.out.println("num:"+num);
	   System.out.println("----bindJoinPointParams()----");
	}

    //------------绑定代理对象----------//
	@Before("execution(* greetTo(..)) && this(waiter)")
//	@Before("this(waiter)")
	public void bindProxyObj(Waiter waiter){
	   System.out.println("----bindProxyObj()----");
	   System.out.println(waiter.getClass().getName());
	   System.out.println("----bindProxyObj()----");
	}

    //------------绑定类标注对象----------//
	@Before("@within(m)")
	public void bindTypeAnnoObject(Monitorable m){
	   System.out.println("----bindTypeAnnoObject()----");
	   System.out.println(m.getClass().getName());
	   System.out.println("----bindTypeAnnoObject()----");
	}
    //------------绑定抛出的异常----------//
	@AfterReturning(value="target(com.csx.springtest.example6.SmartSeller)",returning="retVal")
	public void bingReturnValue(int retVal){
	   System.out.println("----bingReturnValue()----");
	   System.out.println("returnValue:"+retVal);
	   System.out.println("----bingReturnValue()----");
	}

//    //------------绑定抛出的异常----------//
	@AfterThrowing(value="target(com.csx.springtest.example6.SmartSeller)",throwing="iae")
	public void bindException(IllegalArgumentException iae){
	   System.out.println("----bindException()----");
	   System.out.println("exception:"+iae.getMessage());
	   System.out.println("----bindException()----");
	}
}
