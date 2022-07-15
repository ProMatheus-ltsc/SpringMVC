package org.springmvc;
//实体类
public class ControllerEntity {
    String controllerName;
    String methodName;
    boolean returnIsObject;

    public String getControllerName() {
        return controllerName;
    }

    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public boolean isReturnIsObject() {
        return returnIsObject;
    }

    public void setReturnIsObject(boolean returnIsObject) {
        this.returnIsObject = returnIsObject;
    }
}
