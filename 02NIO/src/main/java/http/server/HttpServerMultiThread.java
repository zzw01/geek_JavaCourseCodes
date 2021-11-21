package http.server;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName HttpServerMultiThread
 * @Description TODO
 * @Date 2021/11/13 20:09
 * @Author kevin
 **/
public class HttpServerMultiThread {

    public static void main(String[] args) {
        try {
            System.out.println("Binding to server port...");
            ServerSocket server = new ServerSocket(8081);
            System.out.println("Server started.");
            while (true) {
                Socket socket = server.accept();
                new Thread(() -> {
                    try {
                        HttpServerHandler.service(socket, "<h1>Hello!</h1>\n<body>I am a multi-thread http server!</body>");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }, "httpThread-" + System.currentTimeMillis()).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
