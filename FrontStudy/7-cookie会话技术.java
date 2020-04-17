package CookieDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/ServletRemLogTime")
public class ServletRemLogTime extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 判断是否有一个cookie名字为last_time的cookie,不存在就设置cookie，存在就获取
        // 设置一下内容编码方式为utf-8
        response.setHeader("content-type", "text/html; charset=utf-8");
        Cookie[] cookies = request.getCookies();
        String last_time = null;
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            if (name.equals("last_name") & value != null) {
                String decode = URLDecoder.decode(value, "utf-8");
                last_time = decode;
                System.out.println("有last_time的cookie存在");
                response.getWriter().write("你上次登录时间是：" + decode);
                Date time = new Date();
                SimpleDateFormat simple = new SimpleDateFormat("yyyy年MM月dd号 HH时mm分ss秒");
                String format = simple.format(time);
                String encode = URLEncoder.encode(format, "utf-8");
                cookie.setValue(encode);
                response.addCookie(cookie);
                break;
            }
        }
        // 遍历完之后看是否有登陆过，如果没有，就显示首次登陆
        if (last_time == null) {
            System.out.println("没有last_time的cookie存在");
            Date time = new Date();
            SimpleDateFormat simple = new SimpleDateFormat("yyyy年MM月dd号 HH时mm分ss秒");
            String format = simple.format(time);
            String encode = URLEncoder.encode(format, "utf-8");
            Cookie cs = new Cookie("last_name", encode);
            cs.setMaxAge(300);
            response.addCookie(cs);
            response.getWriter().write("欢迎您首次登陆我们网站");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
