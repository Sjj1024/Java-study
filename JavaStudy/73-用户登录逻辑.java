package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceimpl;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/login")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("接收到了登录请求");
        // 获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 调用service通过用户名和密码查找用户
        UserService userService = new UserServiceimpl();
        boolean login = userService.login(username, password);
        ResultInfo resultinfo = new ResultInfo();
        if (login) {
            System.out.println("登录成功");
            resultinfo.setFlag(true);
        } else {
            System.out.println("登录失败");
            resultinfo.setFlag(false);
        }
        // 将结果返回
        String res = JSONObject.toJSONString(resultinfo);
        // 需要设置相应类型为json，不然前端接收到的数据类型不知道是啥
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(res);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
