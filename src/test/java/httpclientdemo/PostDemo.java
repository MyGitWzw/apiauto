package httpclientdemo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @Author: Wzw
 * @Date: 2021/7/11 16:51
 */
public class PostDemo {
    public static void main(String[] args) throws Exception {
        //接口地址
        String url = "http://119.23.241.154:8080/futureloan/mvc/api/member/register";
        //指定接口请求方式：POST
        HttpPost httpPost = new HttpPost(url);
        //准备post测试数据 & 准备请求头数据（if any）
        String mobilephone = "18868811111";
        String pwd = "123456";

        List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
        parameters.add(new BasicNameValuePair("mobilephone",mobilephone));
        parameters.add(new BasicNameValuePair("pwd",pwd));

        httpPost.setEntity(new UrlEncodedFormEntity(parameters,"utf-8"));
        //发起请求,获取接口响应信息
        HttpClient client = HttpClients.createDefault();
        HttpResponse httpResponse = client.execute(httpPost);

        //状态码
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        //响应报文
//        HttpEntity entity = httpResponse.getEntity();
        String responseText = EntityUtils.toString(httpResponse.getEntity());
    }


}
