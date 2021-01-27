import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


/**
 * @author nio -- chengyan
 * @date 2021/1/27 14:38
 **/
public class HttpClientDemo {

    private static final String SERVER_ADDRESS = "https://weixin.qq.com/";

    private static void doGet(CloseableHttpClient httpClient, RequestConfig config, String url) {

        HttpGet httpGet = new HttpGet(url);

        httpGet.setConfig(config);

        try (CloseableHttpResponse httpResponse = httpClient.execute(httpGet)) {

            System.out.printf("status:%s\ncontent:%s%n",
                    httpResponse.getStatusLine(),
                    EntityUtils.toString(httpResponse.getEntity()));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args){

        RequestConfig requestConfig = RequestConfig.DEFAULT;

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {

            doGet(httpClient, requestConfig, SERVER_ADDRESS);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
