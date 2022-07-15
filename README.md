# SpringMVC

## 分析


![](img.png)

具体的内容[参考](https://github.com/ProMatheus-ltsc/SpringMVC/blob/master/kaitao-springMVC.pdf)

## 伪代码

[参见](https://github.com/ProMatheus-ltsc/SpringMVC/blob/master/%E6%89%8B%E5%86%99sprigmvc.pdf)

## 实现
0. 增加RestController注解
1. controllerEntity增加returnIsObject
2. WebApplicationContext.init
3. controllerNames = {增加orderController}, controllerEntity.returnIsObject = true
4. DispatcherServelet调用方法时, 判断controllerEntity.returnIsObject == true,
调用jackson把对象转成json字符串.



