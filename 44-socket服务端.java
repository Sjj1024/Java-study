package Demo1;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocServer {
    public static void main(String[] args) throws IOException {
        System.out.println("我是socket服务端");
        // 创建一个服务器socket对象,使用的是ServerSocket
        ServerSocket ss = new ServerSocket(8888);

        // 使用服务器对象获取到请求的客户端对象socket
        Socket accept = ss.accept();

        // 使用socket对象的getinputstream获取一个输入流对象
        InputStream inputStream = accept.getInputStream();

        // 使用输入流对象的read方法，接收客户端发送来的请求
        byte[] content = new byte[1024];
        int read = inputStream.read(content);
        while (read != -1) {
            System.out.println("客户端发送来的数据是:");
            System.out.println(new String(content));
            read = inputStream.read(content);
        }

        // 接收到客户端请求后，给客户端回显数据
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("谢谢，已经收到消息".getBytes());

        // 释放资源
        inputStream.close();
        outputStream.close();
        ss.close();
        accept.close();
    }
}
