package httpclientdemo;

import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * @Author: Wzw
 * @Date: 2021/7/27 20:32
 */
public class RegisterCase_v1 {
    /**test data
     * 初始版本使用Testng @Test注解来分别执行下面5组测试用例
     *
     * 缺点：每组用例都要写一个 test方法，每个test方法都大同小异，重复代码过多，需要优化一下
     *
     * 解决思路：使用DataProvider实现批量读取数据，减少重复代码
     * */
    // mobilephone:"18868811111",pwd:""
    // mobilephone:"",pwd:"12345"
    // mobilephone:"18868811111",pwd:"1234"
    // mobilephone:"18868811111",pwd:"123456"
    // mobilephone:"18868811111",pwd:"123456"

    @Test
    public void test1(){
        String url = "http://119.23.241.154:8080/futureloan/mvc/api/member/register";
        HashMap<String, String> params = new HashMap<String, String>();

        params.put("mobilephone","18868811111");
        params.put("pwd","");
        String reponse = HttpUtil.doPost(url, params);
        System.out.println(reponse);
    }

    @Test
    public void test2(){
        String url = "http://119.23.241.154:8080/futureloan/mvc/api/member/register";
        HashMap<String, String> params = new HashMap<String, String>();

        params.put("mobilephone","");
        params.put("pwd","12345");
        String reponse = HttpUtil.doPost(url, params);
        System.out.println(reponse);
    }


    @Test
    public void test3(){
        String url = "http://119.23.241.154:8080/futureloan/mvc/api/member/register";
        HashMap<String, String> params = new HashMap<String, String>();

        params.put("mobilephone","18868811111");
        params.put("pwd","12345");
        String reponse = HttpUtil.doPost(url, params);
        System.out.println(reponse);
    }

    @Test
    public void test4(){
        String url = "http://119.23.241.154:8080/futureloan/mvc/api/member/register";
        HashMap<String, String> params = new HashMap<String, String>();

        params.put("mobilephone","18868811111");
        params.put("pwd","123456");
        String reponse = HttpUtil.doPost(url, params);
        System.out.println(reponse);
    }

    @Test
    public void test5(){
        String url = "http://119.23.241.154:8080/futureloan/mvc/api/member/register";
        HashMap<String, String> params = new HashMap<String, String>();

        params.put("mobilephone","18868811111");
        params.put("pwd","123456");
        String reponse = HttpUtil.doPost(url, params);
        System.out.println(reponse);
    }


}
