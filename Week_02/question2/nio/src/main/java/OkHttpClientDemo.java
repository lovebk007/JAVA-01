import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;


/**
 * @author nio -- chengyan
 * @date 2021/1/27 10:39
 **/
public class OkHttpClientDemo {

    public static String getSyncRequest(String url) {

        String responseResult = "";

        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
               .url(url)
               .build();

        try (Response response = okHttpClient.newCall(request).execute()) {

           responseResult = response.body().string();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseResult;
    }

    public static void main(String[] args) {

        String url = "https://www.baidu.com";

        String text = OkHttpClientDemo.getSyncRequest(url);

        System.out.println("url: " + url + "\nresponse: " + text);

    }
}
