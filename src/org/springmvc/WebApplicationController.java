package org.springmvc;

import java.util.HashMap;

public class WebApplicationController {
    public static HashMap<String,ControllerEntity> urlMapping = new HashMap<>();

    public void init(){
        //扫描所有的controller
    }
}
