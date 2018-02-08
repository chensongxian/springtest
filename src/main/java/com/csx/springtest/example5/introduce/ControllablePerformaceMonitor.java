package com.csx.springtest.example5.introduce;

import com.csx.springtest.example5.proxy.PerformanceMonitor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.platform.commons.annotation.Testable;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/08
 */
public class ControllablePerformaceMonitor extends DelegatingIntroductionInterceptor implements Monitorable, com.csx.springtest.example5.introduce.Testable {
    private ThreadLocal<Boolean> MonitorStatusMap = new ThreadLocal<Boolean>();

    @Override
    public void setMonitorActive(boolean active) {
        MonitorStatusMap.set(active);
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object obj = null;
        if (MonitorStatusMap.get() != null && MonitorStatusMap.get()) {
            PerformanceMonitor.begin(mi.getClass().getName() + "."
                    + mi.getMethod().getName());
            obj = super.invoke(mi);
            PerformanceMonitor.end();
        } else {
            obj = super.invoke(mi);
        }
        return obj;
    }

    @Override
    public void test() {
        System.out.println("dd");
    }
}
