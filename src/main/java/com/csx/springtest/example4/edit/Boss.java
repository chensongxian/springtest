package com.csx.springtest.example4.edit;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/08
 */
public class Boss {
    private String name;
    private Car car = new Car();

    @Override
    public String toString(){
        String temp ="name:"+name+"\n";
        temp += "car:"+car;
        return temp;
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
}
