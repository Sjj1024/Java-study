package it.cast.showuser.fillter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

// 过滤器的使用：servlet、filter、监听器被称为web的三大组件,WebFilter注解作用是要过滤哪些请求，/*表示所有请求
// 使用webxml配置过滤器文件，需要在WEB-INF下创建web.xml文件，就会自动识别并加载
// @WebFilter("/*")
public class Fileremo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器被执行了");
        // 过滤器放行，不然请求会被拦截下来
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
