package com.csx.springtest.example3.scope;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/02
 */
public class Boss {
    private String name ;
    private Car car;
    public Boss(){
        System.out.println("init boss");
    }
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "name:"+name+"\n car:"+car;
    }
}
