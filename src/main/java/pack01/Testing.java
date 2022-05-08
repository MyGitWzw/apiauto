package pack01;

import java.util.*;

public class Testing {

    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        System.out.println(userDir);
        System.out.println("--------------------");
        String dataFileType = "xlsx";
        int i = dataFileType.hashCode();
        System.out.println("dataFileType.hashCode() is: "+ i);

        ArrayList<String> testHeaderinfo = new ArrayList<String>();
        testHeaderinfo.add("name");
        testHeaderinfo.add("id");
        testHeaderinfo.add("address");


        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        LinkedHashMap<String, String> linkedHashMap2 = new LinkedHashMap<String, String>();
//        LinkedHashMap<String, String> linkedHashMap3 = new LinkedHashMap<String, String>();
        List<LinkedHashMap<String, String>> testDataBody = new ArrayList<LinkedHashMap<String, String>>();

        linkedHashMap.put("name","LiSi"); linkedHashMap.put("id","123");linkedHashMap.put("address","CN");
        linkedHashMap2.put("name","Zhangsan");linkedHashMap2.put("id","456");linkedHashMap2.put("address","CA");
//        linkedHashMap3.put("name","Wangwu");linkedHashMap3.put("id","555");

        testDataBody.add(linkedHashMap);
        testDataBody.add(linkedHashMap2);
//        testDataBody.add(linkedHashMap3);

        Object[][] obj = new Object[testDataBody.size()][2];

        for (int j = 0; j < testDataBody.size(); j++) {
            obj[j][0] = testHeaderinfo;
            System.out.println("-----------obj[j][0]--------");

            for (int k = 0; k < testHeaderinfo.size(); k++) {
                System.out.println("Headerinfor :" + testHeaderinfo.get(k));
            }

            LinkedHashMap<String, String> bodyj = testDataBody.get(j);
            obj[j][1] = testDataBody.get(j);

            Iterator<Map.Entry<String, String>> it = bodyj.entrySet().iterator();
            System.out.println("-----------obj[j][1]--------");
            while(it.hasNext()) {
                Map.Entry<String, String> entry = it.next();
                System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
            }


        }



    }
}
