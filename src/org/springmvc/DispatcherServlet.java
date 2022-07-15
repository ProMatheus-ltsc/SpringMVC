package org.springmvc;

import javax.http.Request;
import javax.http.Response;
import java.lang.reflect.Method;

public class DispatcherServlet {
    WebApplicationContext webApplicationContext = new WebApplicationContext();
    public DispatcherServlet() throws Throwable{
        //调用webApplicationContext
        webApplicationContext.init();

    }
    public Response doDispatch(Request request) throws Throwable{
        //得到url
        String url = request.getUrl();
        //从webApplicationContext.urlMapping中取到controllerEntity
        ControllerEntity controllerEntity = WebApplicationContext.urlMapping.get(url);

        //得到controllerName
        String controllerName = controllerEntity.getControllerName();
        //得到方法名
        String methodName = controllerEntity.getMethodName();

        //根据controllerName创建clazz内对象
        Class clazz = Class.forName(controllerName);

        //创建controller对象
        Object controllerObject = clazz.newInstance();

        //根据方法名创建method对象
        Method method = clazz.getDeclaredMethod(methodName);
        //用反射调用方法 method.invoke(controller对象)
        Response response = null;
        //相当于controllerObject.method()
        response = (Response) method.invoke(controllerObject);
        //返回response给webServer
        return response;
    }
}
