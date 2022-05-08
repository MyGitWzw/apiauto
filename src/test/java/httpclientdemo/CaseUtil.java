package httpclientdemo;

import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2021/7/31 22:35
 */
public class CaseUtil {
    /**
     * 保存所有用例对象(共享数据)
     * */
    public static List<Case> cases = new ArrayList<Case>();

    static{
        /**
         * 将所有数据解析封装到 cases成员变量
         * */
        ExcelUtil.load("src\\test\\resources\\testdata\\cases_v4.xlsx","用例",Case.class);
    }


    /**
     * 在调用 getCaseDataByApiId ()这个方法之前，所有的数据就应该已经存放在 cases 中，所有在此之前要用静态代码块进行初始化
     * 根据接口编号拿对应接口的测试数据
     * @param apiId
     * @param colNames 要获取的数据对应的列名
     * */
    public static Object[][] getCaseDataByApiId(String apiId, String[] colNames){

        Class<Case> clazz = Case.class;

        //每个 apiId 对应的case其数量是不知道的，所以需要先遍历cases来确定2维数据的行和列 Object[][]
        //遍历cases,找出指定接口编号apiId的用例数据,并将其保存在 csList
        ArrayList<Case> csList = new ArrayList<Case>();
        for (Case cs:cases) {
            if(cs.getApiId().equals(apiId)){
                csList.add(cs);
            }
        }

        Object [][] datas = new Object[csList.size()][colNames.length];
        try {
            for (int i = 0;i<csList.size();i++) {
                Case aCase = csList.get(i);
                for (int j = 0; j <colNames.length ; j++) {
                    String colName = colNames[j];
                    String methodName = "get"+colName;
//                    System.out.println("---------------"+ methodName);
                    Method method = clazz.getMethod(methodName);
//                    Method method = clazz.getDeclaredMethod(methodName);
                    String value = (String)method.invoke(aCase);

                    datas[i][j] = value;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return datas;
    }


    public static void main(String[] args) {
        String [] colNames = {"ApiId","Params"};
        Object[][] testData = getCaseDataByApiId("1", colNames);
        for (Object[] objects:testData) {
            for (Object object:objects) {
                System.out.print(object+",");
            }
            System.out.println();
        }
    }

}
