package com.csx.springtest.example7.spel;

import com.csx.springtest.example7.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: csx
 * @Date: 2018-02-14
 */
public class MethodExprSample {
    public static void main(String[] args) {
        User user = new User();
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);

        /*
         * 调用string方法
         */
        String substring = parser.parseExpression("'Spring SpEL'.substring(7)").getValue(String.class);
        Integer index = parser.parseExpression("'Spring SpEL'.indexOf('SpEL')").getValue(Integer.class);

        //调用实例方法
        boolean isCorrect = parser.parseExpression("validatePassword('123456')").getValue(context, Boolean.class);
        //调用私有方法，报错
        isCorrect = parser.parseExpression("validatePassword2('123456')").getValue(context, Boolean.class);
        //调用静态方法
        isCorrect = parser.parseExpression("validatePassword3('123456')").getValue(context, Boolean.class);
        parser.parseExpression("addInterests('Js','C')").getValue(context, Boolean.class);
    }
}
