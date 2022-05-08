package pack01;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class TestURLConnection {
    public static void main(String[] args) throws Exception {
//        URL url = new URL("https://www.baidu.com");
//        Object content = url.getContent();
//        String s = content.toString();
//
//        System.out.println("url.getAuthority()= "+url.getAuthority());
//        System.out.println("url.getFile()= "+url.getFile());
//        System.out.println("url.getContent()" + s);

        String csdnURL = "https://passport.csdn.net/login?code=public";
        String username = "15968810094";
        String pwd = "wang20102010";
        URL url = new URL(csdnURL);
        HttpURLConnection connection = null;
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoInput(true);
        connection.setDoOutput(true);

        connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
        String payload = "";
        String payloadPath = ".\\Payload_text.txt";
        StringBuffer sb = readFile(payloadPath);
        String sbToString = sb.toString();
//        System.out.println(sbToString);

        String srcPath = "C:\\Users\\wzw\\IdeaProjects\\TestA\\src\\main\\java\\pack01\\uTools.png";
        String destPath = "C:\\Users\\wzw\\IdeaProjects\\TestA\\src\\main\\java\\pack01\\uTools1.png";
        copyFile(srcPath,destPath);
        System.out.println("copy file completed");


    }


    public static StringBuffer readFile(String filePath) throws Exception {
        File file = null;
        try {
            file = new File(filePath);
        } catch (Exception e) {
            System.out.println("文件不存在");
            e.printStackTrace();
        }

        FileReader fr = null;
        StringBuffer sb = null;
        try {
            fr = new FileReader(file);
            char[] buffer = new char[10];

            int readCounts = fr.read(buffer);
            sb = new StringBuffer();
            while (readCounts != -1) {
//                sb.append(buffer);//错误写法，最后一次读入时readCounts < 1024, 1024-readCounts 数据不会被覆盖，还会写入到文件
                sb.append(buffer,0,readCounts);//每次读取 readCounts 个字符
                readCounts = fr.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return sb;
    }


    public static void copyFile(String srcPath,String destPath){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1. 打开文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            //2. 造数据流
            //2.1 造数据输入流 和 输出流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);

            //2.2 造缓冲流，目的是为了提高读写速度
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //其实在造数据流的时候，可以写成如下链式形式
//        BufferedInputStream bis2 = new BufferedInputStream(new FileInputStream(new File(srcPath)));
//        BufferedOutputStream bos2 = new BufferedOutputStream(new FileOutputStream(new File(destPath)));

            //3. 写数据
            byte[] buf = new byte[10];
            int len;
            while ((len = bis.read(buf))!= -1){
                bos.write(buf,0,len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            // 4. 关闭流
            //当bos,bis 流关闭的是时候，fis和fos也会自动关上的，所以关闭fis和fos的步骤可以省略
            if(bos != null)
                try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(bis != null)
                try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
