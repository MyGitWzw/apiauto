package httpclientdemo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * @Author: Wzw
 * @Date: 2021/7/27 20:32
 */
public class RegisterCase_v2 {
    /**V2 这个版本
     * 优点：使用了@DataProvider 注解，DataProvider 有5组数据，test1()方法就会执行5次，实现了批量测试、减少了代码量
     *
     * 缺点：datas 这个DataProvider 中的测试数据是硬编码写在代码中的，不宜与后期维护
     *
     * 解决思路：把测试数据放在excel中，编写一个读取excel 的方法实现读取测试数据
     *
     * */
    // mobilephone:"18868811111",pwd:""
    // mobilephone:"",pwd:"12345"
    // mobilephone:"18868811111",pwd:"1234"
    // mobilephone:"18868811111",pwd:"123456"
    // mobilephone:"18868811111",pwd:"123456"

    @Test(dataProvider = "datas")
    public void test1(String mobilephone,String pwd){
        String url = "http://119.23.241.154:8080/futureloan/mvc/api/member/register";
        HashMap<String, String> params = new HashMap<String, String>();

        params.put("mobilephone",mobilephone);
        params.put("pwd",pwd);
        String reponse = HttpUtil.doPost(url, params);
        System.out.println(reponse);
    }

    @DataProvider
    public Object[][] datas(){
        Object[][] datas = {
                {"18868811111",""},
                {"","12345"},
                {"18868811111","1234"},
                {"18868811111","123456"},
                {"18868811111","123456"}
        };

        return  null;
    }

}
