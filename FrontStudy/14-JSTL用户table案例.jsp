<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.User" %><%--
  Created by IntelliJ IDEA.
  User: sWX829949
  Date: 2020/4/21
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL标签库案例</title>
</head>
<body>
<%--
创建一个list集合存储用户列表，然后存储多个用户，最后通过JSTL遍历出来
--%>
<%
    List userList = new ArrayList();
    userList.add(new User("王思松", 23, "北京"));
    userList.add(new User("王健林", 43, "上海"));
    userList.add(new User("马云", 53, "杭州"));
    userList.add(new User("郑凯", 25, "深圳"));
    userList.add(new User("王宝强", 35, "三亚"));
    userList.add(new User("赵本山", 45, "东北"));
    userList.add(new User("古力娜扎", 27, "内蒙"));
    request.setAttribute("userList", userList);
%></
>

<%--
将数据展示出来
--%>

<table border="2px" align="center">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>老家</th>
    </tr>
    <c:forEach items="${userList}" var="user" varStatus="i">
        <c:if test="${i.count % 2 == 0}">
            <tr bgcolor="#add8e6">
                <td>${i.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.home}</td>
            </tr>
        </c:if>
        <c:if test="${i.count % 2 == 1}">
            <tr bgcolor="#ffc0cb">
                <td>${i.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.home}</td>
            </tr>
        </c:if>
    </c:forEach>
</table>

</body>
</html>
