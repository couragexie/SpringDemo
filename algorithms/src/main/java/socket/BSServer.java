package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class BSServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while(true) {//网页加载图片会另开线程请求数据，一直开启服务器以加载图片
            Socket socket = serverSocket.accept();
            new Thread(new Runnable() {//多线程提高效率，每收到一个客户端就开启一个线程，允许多个客户端同时上传
                @Override
                public void run() {
                    try{ //Runnable接口中父类方法run没有申明throws异常，故而重写的子方法不能throws任何异常，只能用try
                        InputStream is = socket.getInputStream();
                        OutputStream os = socket.getOutputStream();
                        int len = 0;
                        byte[] bytes = new byte[1024];
                        while ((len = is.read(bytes)) != -1) {
                            //System.out.println(new String(bytes,0,len));
                            System.out.println(new String(bytes,"utf-8"));
                        }
                        /*BufferedReader br = new BufferedReader(new InputStreamReader(is));
                        String line = br.readLine();
                        String[]arr=line.split(" ");
                        String path=arr[1].substring(1);
                        System.out.println(path);
                        FileInputStream fis = new FileInputStream(path);
                        os.write("HTTP/1.1 200 OK\r\n".getBytes());
                        os.write("Content-Tybe:text/html\r\n".getBytes());
                        os.write("\r\n".getBytes());
                        while ((len = fis.read(bytes)) != -1) {
                            os.write(bytes, 0, len);
                        }
                        os.close();
                        socket.shutdownOutput();//为"上传成功"打印”流读取到末尾的标记“
                        //socket.close();//关闭客户端，关闭前会执行shutdownOutput()，则"上传成功"后面会再写入结尾标记
                        //serverSocket.close();*/
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
    }).start();
}
    }}