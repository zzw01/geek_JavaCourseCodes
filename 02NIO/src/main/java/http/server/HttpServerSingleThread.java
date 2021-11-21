package http.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName HttpServerSingleThread
 * @Description TODO
 * @Date 2021/11/13 19:58
 * @Author kevin
 **/
public class HttpServerSingleThread {

    public static void main(String[] args) {
        try {
            System.out.println("Binding to server port...");
            ServerSocket server = new ServerSocket(8081);
            System.out.println("Server started.");
            while (true) {
                Socket socket = server.accept();
                HttpServerHandler.service(socket, "<h1>Hello!</h1>\n<body>I am a single-thread http server!</body>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
