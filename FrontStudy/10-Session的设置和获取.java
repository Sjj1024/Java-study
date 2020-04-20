# 设置session
package SessionDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ServletSetSession")
public class ServletSetSession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建一个session对象，从request对象中获取
        HttpSession session = request.getSession();

        // 设置
        session.setAttribute("SESSIONID", "44asdf564687a6dfafa");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}



# 获取session
package SessionDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ServletGetSession")
public class ServletGetSession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // session作用是在一次会话中共享数据的,不同的请求之间可以获取相同的session
        // session是依赖cookie存在的，原理是：session的id是保存在cookie中用于传输，被服务器是别
        HttpSession session = request.getSession();

        Object sessionid = session.getAttribute("SESSIONID");

        System.out.println(sessionid);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}


