package http.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName HttpServerThreadPool
 * @Description TODO
 * @Date 2021/11/13 20:28
 * @Author kevin
 **/
public class HttpServerThreadPool {

    public static void main(String[] args) {
        try {
            System.out.println("Binding to server port...");
            ServerSocket server = new ServerSocket(8081);
            ExecutorService executorService = Executors.newFixedThreadPool(8,
                    r -> new Thread(r, "httpThread-" + System.currentTimeMillis()));
            System.out.println("Server started.");
            while (true) {
                Socket socket = server.accept();
                executorService.execute(() -> {
                    try {
                        HttpServerHandler.service(socket, "<h1>Hello!</h1>\n<body>I am an http server with thread-pool!</body>");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
