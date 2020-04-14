import javax.print.attribute.standard.MediaSize;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/ServletDemo1")
public class ServletDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 演示获取请求头信息，返回的是一个枚举类型的数据
        System.out.println("请求1被访问到了");
        Object msg = request.getAttribute("msg");
        System.out.println("共享的到的数据是：" + msg);
        Enumeration<String> headerNames = request.getHeaderNames();
        System.out.println("收到Get请求消息了！");
        // 循环遍历出枚举中的元素
        while (headerNames.hasMoreElements()) {
            // 通过获取请求头的名字，可以再使用request的getHeader获取请求头的值
            String name = headerNames.nextElement();
            // 使用这个获取头的值比较多，想获取哪个头的值，就写上头名称
            String value = request.getHeader(name);
            System.out.println(name + ":" + value);
        }
    }
}
