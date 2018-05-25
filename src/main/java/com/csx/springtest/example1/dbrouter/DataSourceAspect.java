package com.csx.springtest.example1.dbrouter;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * @author csx
 * @Package com.csx.springtest.example1.dbrouter
 * @Description: TODO
 * @date 2018/5/24 0024
 */
public class DataSourceAspect implements MethodBeforeAdvice,AfterReturningAdvice,ThrowsAdvice {

    private final String QUERY_START_LIST = "list";
    private final String QUERY_START_SELECT = "select";
    private final String QUERY_START_GET = "get";
    private final String QUERY_START_COUNT = "count";
    private final String QUERY_START_LIST_BATCH = "batchList";
    private final String QUERY_CONTAIN_FROM_MASTER = "FromMaster";

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public DataSourceAspect() {
    }

    @Override
    public void before(Method m, Object[] args, Object target) throws Throwable {
        try {
            if(m != null) {
                logger.debug("数据源切换,执行SQL的目标方法: {}", target.getClass().toString());

                boolean isQuery = ((m.getName().startsWith(QUERY_START_LIST) ||
                        m.getName().startsWith(QUERY_START_SELECT) ||
                        m.getName().startsWith(QUERY_START_GET) ||
                        m.getName().startsWith(QUERY_START_COUNT)) ||
                        m.getName().startsWith(QUERY_START_LIST_BATCH) &&
                                !m.getName().contains(QUERY_CONTAIN_FROM_MASTER));
                if(isQuery) {
                    DBContextHolder.setDbType(true);
                } else {
                    DBContextHolder.setDbType(false);
                }
            }
        } catch (Exception e) {
            logger.error("动态切换数据源失败，切面获取异常:" + e.getMessage(), e);
            throw new Exception("动态切换数据源失败，切面获取异常:" + e.getMessage());
        }

    }

    public void after(JoinPoint point) {
        logger.debug("数据库操作成功，当前数据源：{},当前线程id：{}", new Object[]{DBContextHolder.getDbType()},
                new Object[]{Long.valueOf(Thread.currentThread().getId())});
        DBContextHolder.clearDBType();
    }

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        logger.debug("数据库操作成功，当前数据源：{},当前线程id：{}", new Object[]{DBContextHolder.getDbType()},
                new Object[]{Long.valueOf(Thread.currentThread().getId())});
        DBContextHolder.clearDBType();
    }

    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) throws Throwable {
        logger.error("数据库操作异常，当前数据源为：{},当前线程id：{}" + ex.toString(), new Object[]{DBContextHolder.getDbType()},
                new Object[]{Long.valueOf(Thread.currentThread().getId())});
        DBContextHolder.clearDBType();
        throw new Exception("");

    }
}
