package httpclientdemo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

/**
 * @Author: Wzw
 * @Date: 2021/7/26 21:30
 */
public class GetDemo {
    public static void main(String[] args) throws IOException {
        // 提供接口地址,并准备测试数据
        String url = "http://119.23.241.154:8080/futureloan/mvc/api/member/register";
        String mobilephone = "18868811111";
        String pwd = "123456";
        url += ("?mobilephone" + mobilephone + "&pwd" + pwd);

        //指定接口的提交方式
        HttpGet get = new HttpGet(url);

        //发送请求，拿到响应数据
        HttpClient httpClient = HttpClients.createDefault();
        HttpResponse httpResponse = httpClient.execute(get);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        String result = EntityUtils.toString(httpResponse.getEntity());
        System.out.println(result);
    }



}
