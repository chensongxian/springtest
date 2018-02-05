package com.csx.springtest.example3.anno;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-02-04
 */
@Component
public class Boss {
    private Car car;

    public Boss(){
        System.out.println("construct...");
    }

//	@Autowired
//	private void setCar(Car car){
//		System.out.println("execute in setCar");
//		this.car = car;
//	}

    @Resource
    private void setCar(Car car){
        System.out.println("execute in setCar");
        this.car = car;
    }

    /**
     * @PostConstruct相当于init-method方法
     */
    @PostConstruct
    private void init1(){
        System.out.println("execute in init1");
    }

    @PostConstruct
    private void init2(){
        System.out.println("execute in init1");
    }

    /**
     * @PreDestroy相当于destory-method方法
     */
    @PreDestroy
    private void destory1(){
        System.out.println("execute in destory1");
    }

    @PreDestroy
    private void destory2(){
        System.out.println("execute in destory2");
    }

}
