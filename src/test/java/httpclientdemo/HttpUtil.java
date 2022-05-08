package httpclientdemo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Set;

/**
 * @Author: Wzw
 * @Date: 2021/7/14 8:50
 */
public class HttpUtil {

    /**
     * 实现简单的post请求
     * */
    public static String doPost(String url, HashMap<String, String> param) {
        //指定接口请求方式：POST
        HttpPost httpPost = new HttpPost(url);
        //准备post测试数据 & 准备请求头数据（if any）
        List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
        //通过循环将参数保存到list
        Set<String> keys = param.keySet();
        for (String key : keys) {
            parameters.add(new BasicNameValuePair(key, param.get(key)));
        }

        String responseText = null;
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(parameters, "utf-8"));
            //发起请求,获取接口响应信息
            HttpClient client = HttpClients.createDefault();
            HttpResponse httpResponse = client.execute(httpPost);

            //状态码
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            //响应报文
        HttpEntity entity = httpResponse.getEntity();
        responseText = EntityUtils.toString(entity);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return responseText;
    }

    /**
     * 实现简单的post请求
     * */
    public static  String doGet(String url,HashMap<String,String> param){
        // get 方法要先把测试数据和 url拼接在一起，组成新的url
        Set<String> keys = param.keySet();
        int count = 1;
        for (String key:keys) {
            if(count ==1){
                url += ("?" + key + param.get(key));
            }else{
                url += ("&" + key + param.get(key));
            }
            count++;
        }
        // 接口提交方式
        HttpGet get = new HttpGet(url);
        // 提交数据，拿到请求数据
        String result = "";
        try {
            HttpClient client = HttpClients.createDefault();
            HttpResponse httpResponse = client.execute(get);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            HttpEntity entity = httpResponse.getEntity();
             result = EntityUtils.toString(entity);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  result;
    }

    public static String doService(String url,String type, HashMap<String,String> params){
        String result = "";
        if("post".equalsIgnoreCase(type)){
            result = HttpUtil.doPost(url, params);
        }else if("get".equalsIgnoreCase(type)){
            result = HttpUtil.doGet(url, params);
        }

        return  result;
    }


}
