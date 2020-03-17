服务端代码:
package Demo1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class FileUpServer {
    public static void main(String[] args) throws IOException {
        System.out.println("文件上传服务端");
        // 创建网络套接字对象
        ServerSocket server = new ServerSocket(8888);
        while (true) {
            // 使用套接字对象获取网络字节输入流，读取客户端发送来的二进制数据
            Socket accept = server.accept(); // 需要使用accept方法先获取请求套接字
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 其实文件上传和下载就是文件的复制，一读一写就是文件的复制
                        // 使用当前毫秒值实现文件名字随机生成
                        String name = "D:\\tools\\" + String.valueOf(System.currentTimeMillis() + new Random().nextInt(88888888)) + ".zip";
                        // 创建本地的字节输出流对象，用于将接收到的二进制数据存储到服务器中
                        FileOutputStream fos = new FileOutputStream(name);
                        // 创建缓冲输出流对象，提高输出效率
                        BufferedOutputStream buffout = new BufferedOutputStream(fos);
                        byte[] content = new byte[10240];
                        InputStream inputStream = accept.getInputStream();
                        // 将读取到的二进制数据写入到本地硬盘中
                        byte[] request = new byte[10240];
                        int read = inputStream.read(request);
                        while (read != -1) {
                            buffout.write(request);
                            buffout.flush();
                            read = inputStream.read(request);
                        }

                        // 使用服务器套接字创建网络字节输出流，返回给客户端数据
                        OutputStream outputStream = accept.getOutputStream();
                        outputStream.write("接收到了".getBytes());

                        // 释放资源
                        inputStream.close();
                        outputStream.close();
                        buffout.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }
}


客户端代码:
package Demo1;

import java.io.*;
import java.net.Socket;
import java.util.Random;

public class FileUpClien {
    public static void main(String[] args) throws IOException {
        System.out.println("文件上传客户端");
        // 创建一个本地字节输入流，读取硬盘中要上传的数据内容
        FileInputStream fis = new FileInputStream("D:\\图片\\Something.zip");
        BufferedInputStream buffinput = new BufferedInputStream(fis);
        byte[] content = new byte[10240];
        int leng = buffinput.read(content);
        // 创建客户端socket对象，
        Socket client = new Socket("127.0.0.1", 8888);
        // 使用socket对象获取网络字节输出流，传输数据到服务端
        OutputStream outputStream = client.getOutputStream();
        while (leng != -1) {
            outputStream.write(content);
            leng = buffinput.read(content);
        }
        // 关闭输出网络套接字对象，表示输出完成
        client.shutdownOutput();

        // 创建网络字节输入流，接收服务端返回的数据
        InputStream inputStream = client.getInputStream();
        byte[] response = new byte[1024];
        int read = inputStream.read(response);
        while (read != -1) {
            System.out.println("客户端收到服务端的相应内容：");
            System.out.println(new String(response));
            read = inputStream.read(content);
        }

        // 释放资源
        buffinput.close();
        inputStream.close();
        client.close();
    }
}
