package com.csx.springtest.example6.aspectj.advanced;

import org.aspectj.lang.annotation.Pointcut;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/09
 */
public class TestNamePointcut {
    @Pointcut("within(com.csx.springtest.example6.*)")
    private void inPackage(){}
    //
	@Pointcut("execution(* greetTo(..)))")
    protected void greetTo(){}

    @Pointcut("inPackage() && greetTo()")
    public void inPkgGreetTo(){}
}
