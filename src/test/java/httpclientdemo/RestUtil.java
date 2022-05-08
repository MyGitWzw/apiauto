package httpclientdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2021/8/1 15:40
 */
public class RestUtil {

    public static List<Rest> rests = new ArrayList<Rest>();

    static{
        ExcelUtil.load("src\\test\\resources\\testdata\\cases_v4.xlsx","接口信息",Rest.class);
    }


    public static String  getUrlByApiId(String apiId){

        String url = "";
        for (Rest rest:rests) {
            if(rest.getApiId().equals(apiId)) {
                url = rest.getUrl();
            }
        }
       return url;

    }

    public static String getTypeByApiId(String apiId){
        String type = "";
        for (Rest rest:rests) {
            if(rest.getApiId().equals(apiId)) {
                type = rest.getType();
            }
        }
        return type;
    }
}
