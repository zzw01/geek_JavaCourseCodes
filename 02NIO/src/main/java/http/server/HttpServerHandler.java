package http.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @ClassName HttpServerHandler
 * @Description TODO
 * @Date 2021/11/13 20:00
 * @Author kevin
 **/
public class HttpServerHandler {

    public static void service(Socket socket, String body) {
        try (PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true)) {
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            printWriter.println("Content-Length:" + body.getBytes().length);
            printWriter.println();
            printWriter.write(body);
            printWriter.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
