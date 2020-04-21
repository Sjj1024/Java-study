<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.User" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: sWX829949
  Date: 2020/4/20
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" errorPage="500.jsp" language="java" %>
<html>
<head>
    <title>常见的指令注释和内置独享</title>
</head>
<body>
<%--
JSP指令：
    作用：用于配置jsp页面，导入资源等
    格式：<%@ 指令名称 属性名=属性值 属性名=属性值 %>
    分类：page :配置jsp页面的，contentType：等同于respnse.setContentType()
                                           设置响应体的mime类型以及字符集，设置当前jsp页面的编码
                              import：导包，例如导入list包，ArrayList包等，和java中的导包类似
                              errorPage: 当前页面发生错误后，会自动跳转到指定的错误页面
                              isErrorPage:标识当前页是否是错误页面，也就是说是不是404页面，是的话，就可以使用内置的exception对象
                              将错误信息输出到页面上

        include: 页面包含的，导入页面的资源文件，将别的jsp文件导入进来
        taglib:导入标签库，必须使用taglib将标签引入进来,被包含的文件可以是JSP文件、HTML文件或文本文件。
        包含的文件就好像是该JSP文件的一部分，会被同时编译执行。
        <%@ taglib uri="uri" prefix="prefixOfTag" %>

    内置对象：在jsp页面中不需要创建，就可以直接使用的对象一共有9个：
            变量名                  真实类型                作用
            pageContext             PageContext             当前页面共享数据，可以获取其他八个内置对象
            request                 HttpServletRequest      一次请求访问的多个资源，转发工作
            session                 HttpSession             一次会话的多个请求间
            application             ServletContext          所有用户间共享数据
            response                HttpServletResponse     响应对象
            page                    Object                  当前页面对象，this
            out                     Jspwriter               输出对象，数据输出到页面上
            config                  ServletConfig           Servlet的配置对象
            exception               Throwable               异常对象

    MVC开发模式：
            如果在jsp中有html和java代码。会变得很难阅读
            MVC：
                model：模型，用于和数据库进行交互，javabean
                view：jsp用来充当，展示数据
                control：控制器，servlet充当

   EL表达式：Expression Language 表达式语言
       比较操作：${}

       获取值：${域.属性}


--%>
<%
    // 在域中存储数据，然后使用EL表达式获取属性中的值
    session.setAttribute("name", "songjiang");

    // 设置一个user对象，存储到域中，然后在EL表达式中使用属性获取对象的属性
    User wang = new User("王思聪", 23, "北京");
    request.setAttribute("user", wang);

    // 存储在list和map中的数据，获取方式有一点区别
    List lista = new ArrayList<String>();
    lista.add("aaaaaaaa");
    lista.add("bbbbbbbbb");
    lista.add(wang);

    Map<Object, Object> map = new HashMap<>();
    map.put("animal", "猪");
    map.put("user", wang);

    request.setAttribute("list", lista);
    request.setAttribute("map", map);

    // 让empty表达式判断是否为空或者null或者0
    String teststr = "1544";
    Integer testnumber = 0;
    List<String> testlist = null;
%>
<%--
获取字符串类型的值
如果属性名称没有相同的时候，可以不用写域对象，直接写上数据名称
--%>
获取域中的数据：
${sessionScope.name}
${name}
<hr>
${ 4 > 5}

<%--
获取对象的属性：属性是set和get方法去掉set和get后的名称小写，一般属性和成员变量相同，但是
set和get方法也有逻辑视图，逻辑视图是自己定义的，例如 public String getStrDate()
并且属性值全都需要使用对象的属性获取，例如获取了date对象，继而还需要使用date.属性获取值
--%>
<br>
${user}
<br>
${user.name}
<br>
${user.age}
<br>
${user.home}
<br>
${user.strDate}
<hr>
<h3>获取list和map中的值：</h3>
${list}<br>
${list[0]}<br>
${list[1]}<br>
${list[2].name}<br>
<hr>
<h3>获取map中的值,有两种方式：map.属性值，或者map["属性值"]</h3>
${map}<br>
${map.animal}<br>
${map["animal"]}
<hr>
<h3>使用empty判断值是否为空或者null或者0</h3>
${empty teststr}<br>
${empty testnumber}<br>
${empty testlist}<br>
<hr>
<h3>EL中有一个隐式对象pageContext，可以获取其他8个内置对象，并获取其中的数据</h3>
特别常用的是request对象的虚拟目录：
${pageContext.request}<br>
${pageContext.request.contextPath}
<div>
    这是一个jsp文件测试类！
</div>
</body>
</html>
