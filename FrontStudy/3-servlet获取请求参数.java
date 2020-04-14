import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/ServletDemo4")
public class ServletDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 解决中文乱码问题，需要设置一行代码
        request.setCharacterEncoding("utf-8");
        // 使用通用获取参数的方法获取参数值
        System.out.println("post方法");
        System.out.println("------------------------------");
        String name = request.getParameter("name");
        System.out.println(name);
        // getParameterValues获取参数所有值得数组
        System.out.println("------------------------------");
        String[] hobbies = request.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }
        // 获取所有传递过来的键名称
        System.out.println("------------------------------");
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String s = parameterNames.nextElement();
            System.out.println(s);
        }

        // getParameterMap获取参数中所有键值对map，键是字符串，值是字符串集合
        System.out.println("111111111111111111111111111111111111111");
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> strings = parameterMap.keySet();
        for (String str : strings) {
            System.out.println("------------------------------");
            String[] strings1 = parameterMap.get(str);
            for (String s : strings1) {
                System.out.println(s);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 使用通用获取参数的方法获取参数值，中文乱码问题在get方式中已经不存在了，但是在post中还是存在的
        System.out.println("get方法");
        System.out.println("------------------------------");
        String name = request.getParameter("name");
        System.out.println(name);
        // getParameterValues获取参数所有值得数组
        System.out.println("------------------------------");
        String[] hobbies = request.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }
        // 获取所有传递过来的键名称
        System.out.println("------------------------------");
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String s = parameterNames.nextElement();
            System.out.println(s);
        }

        // getParameterMap获取参数中所有键值对map，键是字符串，值是字符串集合
        System.out.println("111111111111111111111111111111111111111");
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> strings = parameterMap.keySet();
        for (String str : strings) {
            System.out.println("------------------------------");
            String[] strings1 = parameterMap.get(str);
            for (String s : strings1) {
                System.out.println(s);
            }
        }
    }
}
