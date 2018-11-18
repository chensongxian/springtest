package com.csx.springtest.example7.spel;

import com.csx.springtest.example7.PlaceOfBirth;
import com.csx.springtest.example7.User;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: csx
 * @Date: 2018-02-14
 */
public class PropertyExprSample {
    public static void main(String[] args) {
        User user=new User();
        user.setUserName("tom");
        user.setCredits(100);
        user.setLastVisit(new Date());
        user.setPlaceOfBirth(new PlaceOfBirth("中国","厦门"));

        ExpressionParser parser=new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext(user);
        String userName=parser.parseExpression("userName").getValue(context,String.class);

        String city = (String)parser.parseExpression("placeOfBirth.city").getValue(context);
        int credits = (Integer) parser.parseExpression("credits + 10").getValue(context);
        System.out.println("username = "+userName);
        System.out.println("city = "+city);
        System.out.println("credits = "+credits);

    }
}
