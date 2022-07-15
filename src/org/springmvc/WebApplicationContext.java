package org.springmvc;

import java.lang.reflect.Method;
import java.util.HashMap;

public class WebApplicationContext {
    public static HashMap<String,ControllerEntity> urlMapping = new HashMap<>();

    public void init() throws Throwable{
        //扫描所有的controller
        String[] controllerNames = {"com.project.UserController"};
        //遍历所有的controller
        for(String controllerName : controllerNames){
            //根据类名创建类对象clazz
            Class clazz = Class.forName(controllerName);
            //创建controller的对象
            Object controllerObject = clazz.newInstance();
            //得到controller的所有方法
            Method[] methods = clazz.getDeclaredMethods();
            //遍历所有的方法
            for(Method method : methods){
                //判断方法有没有加@requestMapping注解
                RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
                if(requestMapping != null){
                    //取出url
                    String url = requestMapping.value();
                    //得到方法名
                    String methodName = method.getName();
                    //创建controllerEntity
                    ControllerEntity controllerEntity = new ControllerEntity();
                    controllerEntity.setControllerName(controllerName);
                    controllerEntity.setMethodName(methodName);
                    //把url,controllerEntity放到urlMapping中
                    urlMapping.put(url,controllerEntity);
                }


            }

        }




    }
}
