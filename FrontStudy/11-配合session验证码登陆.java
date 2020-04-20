package LoginDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ServletCodeLogin")
public class ServletCodeLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        // 获取传递的参数map集和
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkcode = request.getParameter("checkcode");
        System.out.println(username + "--------" + password + "---------" + checkcode);
        // 获取session中真实验证码，然后做比对
        HttpSession session = request.getSession();
        // 强制转换成字符串类型
        String sessionCode = (String) session.getAttribute("SESSIONID");
        String upcode = checkcode.toUpperCase();
        // 移除sessionid验证码，防止出现验证码重复使用的问题
        session.removeAttribute("SESSIONID");
        if (sessionCode != null & sessionCode.equals(upcode)) {
            System.out.println("验证码校验成功，开始校验用户名和密码");
            // response.getWriter().write("欢迎回来，我想死你了！");
            session.setAttribute("user", username);
            response.sendRedirect("/cao/success.jsp");
        } else {
            System.out.println("验证码校验失败，会刷新当前页面，并重新获取验证码");
            session.setAttribute("error", "验证码错误");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
