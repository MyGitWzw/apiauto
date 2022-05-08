package httpclientdemo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * @Author: Wzw
 * @Date: 2021/7/27 20:32
 */
public class RegisterCase_v3 {
    /**V3 版本，String filePath = "src\\test\\resources\\testdata\\cases_v1.xlsx";
     * 优点：使用POI 实现了从Excel中读取数据的功能
     *
     * 缺点：不能够读取非连续行或者列的数据 （只能读取行区间、列区间）
     *
     * 解决思路: 将要读取的行和列分别存入数组
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
        String filePath = "src\\test\\resources\\testdata\\cases_v1.xlsx";
        Object[][] data = ExcelUtil.datas(filePath,"用例",2,6,6,7);

        return  data;
    }
}
