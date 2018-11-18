package com.csx.springtest.example7.spel;

import com.csx.springtest.example7.User;
import org.junit.jupiter.api.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: csx
 * @Date: 2018-02-13
 */
public class CompilerSample {


    public static void main(String[] args) {
        User user=new User();

        //创建解析配置
        SpelParserConfiguration configuration=new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE
                ,CompilerSample.class.getClassLoader());

        //创建取值上下文
        EvaluationContext context = new StandardEvaluationContext(user);

        //创建解析器
        SpelExpressionParser parser=new SpelExpressionParser(configuration);


        //创建解析式
        String expression = "isVipMember('tom') && isVipMember('jony')";

        //解析表达式
        SpelExpression spelExpression = parser.parseRaw(expression);

        //通过表达式求职
        System.out.println(spelExpression.getValue(context));
        System.out.println(spelExpression.getValue(context));
    }
}
