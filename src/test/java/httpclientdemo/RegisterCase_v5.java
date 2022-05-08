package httpclientdemo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * V5 版本， String filePath = "src\\test\\resources\\testdata\\cases_v3.xlsx";
 * 优点：创建"接口信息"sheet,使之可以实现数据冗余问题
 *
 * 缺点：
 * 1. 会造成重复读文件，需要分别读取 "接口信息"和"用例"的信息
 * 2. 读取的rows 和 columns 是写死在代码中的，耦合性较高
 *
 * 解决思路:
 * 1. 只读取一次来实现拿到所有数据（利用静态代码块一次性把数据读出来，后面要用的话直接从内存中取）
 * 2. （用例的传参设计）利用反射拿到需要读取的列
 *
 * @Author: Wzw
 * @Date: 2021/7/31 14:32
 */
public class RegisterCase_v5 {
    // mobilephone:"18868811111",pwd:""
    // mobilephone:"",pwd:"12345"
    // mobilephone:"18868811111",pwd:"1234"
    // mobilephone:"18868811111",pwd:"123456"
    // mobilephone:"18868811111",pwd:"123456"
    @Test(dataProvider = "datas")
    public void test1(String apiIdFromCase,String parameters) {
        //1. 读取json 数据，并将params 转换成 HashMap
        Gson gson = new Gson();
        HashMap<String, String> params = gson.fromJson(parameters,new TypeToken<HashMap<String,String>>() {}.getType());

        //2. 利用接口编号获取接口地址
//        String url = "http://119.23.241.154:8080/futureloan/mvc/api/member/register";
        int [] rows = {1,2};
        int [] cols = {1,3,4};

        Object[][] dataFromAPIInfo = ExcelUtil.datas("src\\test\\resources\\testdata\\cases_v3.xlsx", "接口信息", rows, cols);
        String requestType = "";
        String url = "";

        String reponse = "";
        for (Object [] objects:dataFromAPIInfo) {
            String apiIdFromInfro = objects[0].toString();

            if(apiIdFromInfro.equalsIgnoreCase(apiIdFromCase)){
                requestType = objects[1].toString();
                url = objects[2].toString();
                break;
            }
        }

        reponse = HttpUtil.doService(url, requestType, params);

//        params.put("mobilephone",mobilephone);
//        params.put("pwd",pwd);
//        String reponse = HttpUtil.doPost(url, params);
        System.out.println(reponse);
    }


    @DataProvider
    public Object[][] datas() {
        String filePath = "src\\test\\resources\\testdata\\cases_v2.xlsx";
        int[] rows = {2, 3, 4, 5, 6};
        int[] cols = {3,4};//拿到接口编号和参数两列数据
        Object[][] data = ExcelUtil.datas(filePath,"用例", rows, cols);
        return data;
    }

    public String getApiIdFromInfoSheet(){
        String apiId = "";


        return apiId;
    }

    public void formatOutputParameters(Map<String,String> hashMap){
        Set<String> keys = hashMap.keySet();
        int size = keys.size();
        for (String key:keys) {
            if(size>1){
                System.out.print(key + "=" + hashMap.get(key)+",");
            }else{
                System.out.print(key + "=" + hashMap.get(key)+"\n");
            }
            size--;
        }
    }

}
