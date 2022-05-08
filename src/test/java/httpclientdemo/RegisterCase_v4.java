package httpclientdemo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

/**V4 版本，String filePath = "src\\test\\resources\\testdata\\cases_v1.xlsx";
 * 优点：引入将要读取的行和列分别存入数组，使用数组从excel 读取指定行和列的数据
 *
 *缺点：测试数据还有冗余，比如可以将传入的参数统一用json格式，不用访问多列
 *
 * 解决思路: POM中引入读取json格式的jar包
 *
 *
 * @Author: Wzw
 * @Date: 2021/7/27 20:32
 */
public class RegisterCase_v4 {
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
        int [] rows = {2,3,4,5,6};
        int [] cols = {6,7};
        Object[][] data = ExcelUtil.datas(filePath,"用例",rows,cols);
        return  data;
    }
}
