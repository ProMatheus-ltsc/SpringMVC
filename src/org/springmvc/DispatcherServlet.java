package org.springmvc;

import com.fasterxml.jackson.databind.ObjectMapper;

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
        //TODO 此处有空指针异常;
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
        //判断调用的方法返回的是不是实体类
        if(controllerEntity.isReturnIsObject() == true){
            Object entity = method.invoke(controllerObject);
            //调用jackson把实体类转为json字符串
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(entity);
            response = new Response();
            response.setResponseBody(json);

        }else{
            //相当于controllerObject.method()
            response = (Response) method.invoke(controllerObject);

        }
        //返回response给webServer
        return response;

    }
}
