package pack01;


import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 处理流：转换流的使用
 * 1.转换流 (Reader/Writer) 归属哪个流，应该看后缀
 *  InputStreamReader [将一个字节输入流 转换为 字符的输入流]     类似于解码
 *  OutputStreamWriter [将一个字符的输出流 转换为 字节的输出流]   类似于编码
 *  2. 作用：提供字节流与字符流之间的转换
 *
 * 3. 解码: 字节、字节数组（一个个字节看不懂） ---> 字符数组、字符串（但是一个个字符却可以看得懂）
 *
 * 4.字符集
 *
 *
 * @Author: Wzw
 * @Date: 2021/5/3 14:47
 */
public class InputStreamReaderTest {
    @Test
    public void client() throws Exception{
        Socket socket = null;
        OutputStream os = null;
        try {
            //1. get ip address
            InetAddress inet = InetAddress.getByName("127.0.0.1");

            //2. create a socket object and bind to 8899 port
            socket = new Socket(inet,8899);

            //3. getOutputStream and write data to sever
            os = socket.getOutputStream();
            os.write("你是，你收到了来自客户端的消息".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Test
    public void server() {

        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.create sever socket
            ss = new ServerSocket(8899);

            //2. accept client request and return a socket object
            socket = ss.accept();

            //3. getInputStream and read the data of input stream
            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] buff = new byte[10];
            int len;
            while((len = is.read(buff)) != -1){
                baos.write(buff,0,len);
            }
            System.out.println(baos.toString());
            System.out.println("收到了来自于：" + socket.getInetAddress().getHostAddress());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(baos != null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ss != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }




    }
}
