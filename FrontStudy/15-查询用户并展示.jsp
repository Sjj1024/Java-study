<%--
  Created by IntelliJ IDEA.
  User: sWX829949
  Date: 2020/4/22
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
    <title>用户信息展示界面</title>
</head>
<body>
    <div align="center">
        <div align="center"><h3>用户列表</h3></div>
        <br>
        <div align="center">
            <table  class="table table-bordered">
                <tr>
                    <th>编号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>年龄</th>
                    <th>籍贯</th>
                    <th>QQ</th>
                    <th>邮箱</th>
                    <th>操作</th>
                </tr>
                <%--使用EL表达式和JSTL库遍历成员，并输出到页面上--%>
                <c:forEach var="people" items="${peoples}" varStatus="index">
                    <tr>
                        <td>${index.count}</td>
                        <td>${people.name}</td>
                        <td>${people.gender}</td>
                        <td>${people.age}</td>
                        <td>${people.home}</td>
                        <td>${people.qq}</td>
                        <td>${people.email}</td>
                        <td><a href="javascript:void(0)">修改</a>&nbsp<a href="javascript:void(0)">删除</a></td>
                    </tr>
                </c:forEach>
                <tr>
                    <a href="${pageContext.request.contextPath}/addpeople.jsp">添加联系人</a>
                </tr>
            </table>
        </div>
    </div>
</body>
</html>
