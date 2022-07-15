package org.springmvc;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//实现了tomcat的功能
//接收浏览器发过来的数据, 调用SpringMVC, 把结果返回给浏览器
public class WebServer  {
    public static void main(String[] args) throws Throwable{
        //服务器监听端口号
        ServerSocket serverSocket = new ServerSocket(9090);
        System.out.println("服务器启动成功");
        while (true){
            //接收浏览器发过来的请求
            //socket代表的是与浏览器的连接
            Socket socket = serverSocket.accept();
            //来一个用户启动一个线程
            HttpThread httpThread = new HttpThread(socket);
            httpThread.start();
        }


    }
    static class HttpThread extends Thread{
        Socket socket;

        public HttpThread(Socket socket) {
            this.socket = socket;
        }

        /**
         * If this thread was constructed using a separate
         * <code>Runnable</code> run object, then that
         * <code>Runnable</code> object's <code>run</code> method is called;
         * otherwise, this method does nothing and returns.
         * <p>
         * Subclasses of <code>Thread</code> should override this method.
         *
         * @see #start()
         * @see #stop()
         */
        @Override
        public void run() {
            System.out.println("有请求过来了");
            try{
                //调用springMVC框架
                InputStream inputStream = socket.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String requestLine = bufferedReader.readLine();
                System.out.println("浏览器发过来的请求行" + requestLine);

                //返回数据给浏览器
            }catch(Exception e){
                e.printStackTrace();

            }
            //调用springmvc框架
            //返回数据给浏览器
        }
    }
}
