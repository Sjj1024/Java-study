<%--
  Created by IntelliJ IDEA.
  User: sWX829949
  Date: 2020/4/14
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Tomcat测试</title>
  </head>
  <body>
  <h1>JSP是java server page</h1>
  是一种java服务端页面，为了简化书写的。
  jsp原理其实就是将jsp文件转换成.java文件，但是这个java文件是Servelet,其中还是将jsp中的标签全部转换成
  response.writer到页面上的。

  jsp中的java脚本：
  <% System.out.println("1111111111"); %>  这种脚本是servelet中可以写啥，这里就可以写啥
  <%= 111 %>  这种脚本是servelet中可以写啥，这里就可以写啥

  <hr>
  jsp的内置对象：
  request, response, out
  out对象的print方法，可以将参数输出到页面上
  但是和response对象的write方法不同的是，无论如何，网页都会先加载response对象的write方法的内容，再输出out对象的内容
  <%
      response.getWriter().write("11111111111111111111");
      String realPath = request.getServletContext().getRealPath("");
      out.print(realPath);
      response.getWriter().write("222222222222222222222222");
  %>

  </body>
</html>
