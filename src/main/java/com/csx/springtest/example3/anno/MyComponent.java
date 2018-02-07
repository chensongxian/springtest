package com.csx.springtest.example3.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-02-04
 */
@Component(value = "myComponent")
public class MyComponent {
    @Autowired(required=false)
    private List<Plugin> plugins;

    @Autowired
    private Plugin[] pluginArr;

    @Autowired
    private Map<String,Plugin> pluginMaps;

    public List<Plugin> getPlugins() {
        return plugins;
    }

    public void say(){
        for(Plugin plugin:plugins){
            System.out.println("list: "+plugin.getClass().getName());
        }

        System.out.println("--------------");

        for(Plugin plugin:pluginArr){
            System.out.println("array: "+plugin.getClass().getName());
        }
    }
}
