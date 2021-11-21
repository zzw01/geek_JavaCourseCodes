package work01.client;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName OkHttpClientMain
 * @Description TODO
 * @Date 2021/11/13 21:38
 * @Author kevin
 **/
public class OkHttpClientMain {

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .callTimeout(120, TimeUnit.SECONDS)
                .pingInterval(5, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();

        String url = "http://localhost:8808/nio";
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            System.out.println("请求"+url+"的响应结果：");
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
