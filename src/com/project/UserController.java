package com.project;

import org.springmvc.Controller;
import org.springmvc.RequestMapping;

import javax.http.Request;
import javax.http.Response;

@Controller
public class UserController {
    @RequestMapping("/login")
    public Response login(){
        Response response = new Response();
        response.setResponseBody("login success");
        return response;
    }
    @RequestMapping("/register")
    public Response register(){
        Response response = new Response();
        response.setResponseBody("register success");
        return  response;
    }
}
