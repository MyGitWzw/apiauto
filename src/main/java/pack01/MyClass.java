package pack01;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MyClass {

    public  String saveMapListToCSV(String filename, List<LinkedHashMap<String,Object>> mapList,String delimiter) throws Exception {
        String csvfilePath  = null;
        csvfilePath = System.getProperty("user.dir")+"\\testdata\\" +filename + "_New.csv";

        FileWriter fileWriter = null;
        BufferedWriter bw = null;

        try{
            createFile(csvfilePath);
            fileWriter = new FileWriter(csvfilePath);
            bw = new BufferedWriter(fileWriter);

            //combine delimiter and records
            StringBuffer bf = new StringBuffer();
            String content = "";
            //将 mapList.get(0).keySet() 作为csv文件头
            // mapList的每一个元素均是 Map类型，所以mapList.get(0) 有第一行数据的key & value
            // 既然先拿文件头，当然只需要把 key作为csv文件头就可以啦
            Set<String> keySet = mapList.get(0).keySet();
            int dataIndex = 0;
            List<String> contentList = new ArrayList<String>();
            for (String key : keySet){
                content += "\"" + key + "\"";
                if(dataIndex != keySet.size() -1){
                    content += ",";
                }
                dataIndex++;
            }
            contentList.add(content);
            bw.write(content);
            bw.newLine();
            bw.flush();

            //get text
            for (Map<String,Object> map : mapList) {
//                map = mapList.get(i);
                Collection<Object> values = map.values();
                String valueContent =null;
                int valueIndex = 0;
                for (Object value:values) {
                    valueContent += "\"" + value + "\"";
                    if(valueIndex != values.size()-1){
                        valueContent += ",";
                    }
                    valueIndex++;
                    contentList.add(valueContent);
                    bw.write(valueContent);
                    bw.newLine();
                    bw.flush();
                }
            }
        //捕获异常
        }catch (IOException e){e.printStackTrace();}
        catch (Exception e){e.printStackTrace();}
        finally {
            try{
                fileWriter.close();
                bw.close();
            }catch (IOException e) {e.printStackTrace();}
        }

        return csvfilePath;
    }

    public void createFile(String filePath) throws Exception{

        String current = new File(".").getCanonicalPath();
        String newFilePath = null;
        newFilePath = new File(filePath).isAbsolute()?filePath:current + filePath;

        File file = new File(newFilePath);
        boolean success = true;
        if(!file.exists()){
            System.out.println("The File need to be create" + filePath);
            success = file.createNewFile();
        }



    }





    public static void main(String[] args) {
        System.out.println("111111111111");
    }
}
