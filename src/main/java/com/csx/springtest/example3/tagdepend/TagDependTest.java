package com.csx.springtest.example3.tagdepend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/07
 */
public class TagDependTest {
    /**
     * 父子bean配置
     * 利用父子bean可以消除一下重复配置
     */
    @Test
    public void testExtend(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com/csx/springtest/example3/tagdepend/beans.xml");

        Car car=context.getBean("subCar1",Car.class);

        Assertions.assertNotNull(car);

        System.out.println(car.toString());
    }

    /**
     * 测试depends-on
     * depends-on用来确保depends-on的对象优先于自身先实例化
     * depends-on使用于依赖关系不是很明显的情况
     * 比如在本次示例中CacheManager并不明显依赖于sysInit，当需要SysInit先于CacheManager实例化加载配置信息
     * 总结:
     * 当一个对象并不需要持有另一个对象的引用，但需要另一个对象优先于本对象实例化时，适用depends-on
     * 比如spring官方文档中的例子database driver的注册
     *
     * depends-on是指指定Bean初始化及销毁时的顺序，使用depends-on属性指定的Bean要先初始化完毕后才初始化当前Bean
     * ,由于只有"singleton"Bean才能被Spring管理销毁，所以当指定的Bean都是"singleton"时
     * ，使用depends-on属性指定的Bean要在指定的Bean之后销毁
     */
    @Test
    public void testDependOn(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com/csx/springtest/example3/tagdepend/beans.xml");

        CacheManager cacheManager=context.getBean("cacheManager",CacheManager.class);

        Assertions.assertNotNull(cacheManager);
    }

    /**
     * 使用<idref/>会在容器启动初期检查引用是否正确
     */
    @Test
    public void testIdref(){
        ApplicationContext context=new ClassPathXmlApplicationContext("com/csx/springtest/example3/tagdepend/beans.xml");

        Boss boss=context.getBean("boss",Boss.class);

        Assertions.assertNotNull(boss);

        System.out.println(boss.toString());
    }
}
