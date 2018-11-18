package com.csx.springtest.example7.spel;

import com.csx.springtest.example7.User;
import org.junit.jupiter.api.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: csx
 * @Date: 2018-02-13
 */
public class SpelHello {
    @Test
    public void test1() {
        ExpressionParser parser=new SpelExpressionParser();
        Expression expression = parser.parseExpression("'Hello'+' World'");
        String value = (String) expression.getValue();
        System.out.println(value);
    }

    @Test
    public void test2(){
        ExpressionParser parser=new SpelExpressionParser();
        Expression expression=parser.parseExpression("'Helloworld'.concat('!')");
        String messeage= (String) expression.getValue();
        System.out.println(messeage);
    }

    @Test
    public void test3(){
        ExpressionParser parser=new SpelExpressionParser();
        Expression expression=parser.parseExpression("'Helloworld'.concat('!')");
        String messeage=expression.getValue(String.class);
        System.out.println(messeage);
    }

    @Test
    public void test4(){
        User user=new User();
        user.setUserName("tom");
        user.setCredits(100);

        ExpressionParser parser=new SpelExpressionParser();
        EvaluationContext context=new StandardEvaluationContext(user);
        String userName= (String) parser.parseExpression("userName").getValue(context);
        System.out.println(userName);
    }
}
