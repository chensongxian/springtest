package com.csx.springtest.example2.inject;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: csx
 * @Date: 2018-11-18
 */
public class LiuDeHua implements GeLi{
    @Override
    public void responseAsk(String content) {
        System.out.println(content);
    }
}
