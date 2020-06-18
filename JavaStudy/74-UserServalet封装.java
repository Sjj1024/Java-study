package cn.itcast.travel.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServalte extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 重写父类中的分发方法，定义自己的方法分发工作
        System.out.println("方法分发被执行了");

        // 提取出来请求路径中的方法名称
        String requestURI = req.getRequestURI(); // user/login
        String substring = requestURI.substring(requestURI.lastIndexOf("/") + 1);
        // 通过方法的名字，执行集体对象的方法:这里的this表示具体的子类对象，谁调用我，我就代表谁
        System.out.println(this);
        // 有了this对象，就可以使用
        try {
            // 获取本类对应的字节码文件对象，然后获取方法，需要传递相应的参数，
            Method method = this.getClass().getMethod(substring, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
