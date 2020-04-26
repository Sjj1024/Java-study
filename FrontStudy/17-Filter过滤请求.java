package it.cast.showuser.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/*
* dispatcherTypes = DispatcherType.REQUEST是分发请求类型，总共有5种，
* 默认的类型就是DispatcherType.REQUEST，表示正常的网络浏览器请求
* DispatcherType.FORWARD ：表示转发过来的请求
* */

// @WebFilter(value = "/login.jsp", dispatcherTypes = DispatcherType.REQUEST)
// @WebFilter(value = "/login.jsp", dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})  // 分发类型可以是多个，所以可以是数组
public class FilterMethod implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器被执行了");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("过滤后的请求放行了");
    }

    @Override
    public void destroy() {

    }
}
