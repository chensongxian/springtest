package com.csx.springtest.example2.inject;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: csx
 * @Date: 2018-11-18
 */
public class MoAttack implements ActorArrangable {
    private GeLi geLi;

    public MoAttack() {
    }

    /**
     *
     * 注入革离得具体饰演者
     * 构造函数注入
     * @param geLi
     */
    public MoAttack(GeLi geLi) {
        this.geLi = geLi;
    }

    /**
     * 属性注入
     * @param geLi
     */
    public void setGeLi(GeLi geLi) {
        this.geLi = geLi;
    }

    public void cityGateAsk() {
        geLi.responseAsk("墨者革离！");
    }

    /**
     * 接口注入
     * @param geLi
     */
    @Override
    public void injectGeli(GeLi geLi) {
        this.geLi = geLi;
    }
}
