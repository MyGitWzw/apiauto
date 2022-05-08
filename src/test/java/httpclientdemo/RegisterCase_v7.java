package httpclientdemo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * V7 版本， String filePath = "src\\test\\resources\\testdata\\cases_v3.xlsx";
 * 优点：
 *
 * 缺点：
 *
 * 解决思路:
 *
 * @Author: Wzw
 * @Date: 2021/7/31 14:32
 */
public class RegisterCase_v7 {
    // mobilephone:"18868811111",pwd:""
    // mobilephone:"",pwd:"12345"
    // mobilephone:"18868811111",pwd:"1234"
    // mobilephone:"18868811111",pwd:"123456"
    // mobilephone:"18868811111",pwd:"123456"
    @Test(dataProvider = "datas")
    public void test1(String apiId,String parameters) {
        //1. 获取 URL
        String url  = RestUtil.getUrlByApiId(apiId);
        //2. 获取type
        String type = RestUtil.getTypeByApiId(apiId);

        //2. 读取json 数据，将parameters 转换成 HashMap
        Gson gson = new Gson();
        HashMap<String, String> params = gson.fromJson(parameters,new TypeToken<HashMap<String,String>>() {}.getType());

        String response = HttpUtil.doService(url, type, params);
        System.out.println("The http response is : " + response);
    }


    @DataProvider
    public Object[][] datas() {
        String [] colName = {"ApiId","Params"};
        Object[][] data = CaseUtil.getCaseDataByApiId("1",colName);
        return data;
    }

    public static void main(String[] args) {
        String [] colName = {"ApiId","Params"};
        Object[][] data = CaseUtil.getCaseDataByApiId("1",colName);
        for (Object[] objects:data) {
            for (Object object :objects) {
                System.out.print(object+",");
            }
            System.out.println();
        }

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
