package com.csx.springtest.example7.js;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 脚本实现动态函数
 * @author: csx
 * @Date: 2018-02-12
 */
public class ScriptSample {
    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        ScriptEngineManager manager=new ScriptEngineManager();
        ScriptEngine engine=manager.getEngineByName("JavaScript");
        String scriptText="function sum(a,b) { return a+b; }";
        engine.eval(scriptText);
        Invocable invocable= (Invocable) engine;
        Object result=invocable.invokeFunction("sum",100,200);
        System.out.println(result);
    }
}
