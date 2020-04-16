import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletDemo6")
public class ServletDemo6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // response是设置相应消息的,这个例子实现重定向操作
        // response.sendRedirect("/cao/ServletDemo5");
        response.sendRedirect("https://github.com/");
        // 重定向的特点：会改地址栏变化，301是永久重定向，302是临时重定向，
        // 发生了两次请求，
        // 可以重定向到别的网站上
    }
}
