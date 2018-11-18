package com.csx.springtest.example2.inject;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 三种方式注入例子
 * @author: csx
 * @Date: 2018-11-18
 */
public class Director {
    /**
     *
     * 构造函数注入
     */
    public void director_1() {
        // 1. 指定角色的饰演者
        GeLi geLi = new LiuDeHua();

        // 2. 注入具体的饰演者到剧本中
        MoAttack moAttack = new MoAttack(geLi);

        moAttack.cityGateAsk();
    }

    /**
     *
     * 属性注入
     */
    public void director_2() {
        MoAttack moAttack = new MoAttack();

        // 1. 调用属性setter方法注入
        GeLi geLi = new LiuDeHua();
        moAttack.setGeLi(geLi);
        moAttack.cityGateAsk();
    }

    /**
     * 接口注入
     *
     * 接口注入需要额外声明一个接口，增加类的数目，而且与属性注入并无本质区别
     * 因此不提倡采用这种注入方式
     */
    public void director_3() {
        MoAttack moAttack = new MoAttack();
        GeLi geLi = new LiuDeHua();
        moAttack.injectGeli(geLi);
        moAttack.cityGateAsk();
    }
}
