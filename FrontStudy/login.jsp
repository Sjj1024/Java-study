<%--
  Created by IntelliJ IDEA.
  User: sWX829949
  Date: 2020/4/20
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <script>
        window.onload = function (ev) {
            var checkcode = document.getElementById("change");
            var code = document.getElementById("code");
            checkcode.onclick = function (ev1) {
                var number = Math.random();
                code.src = "/cao/Servlet7?num=" + number;
            }
        }
    </script>
</head>
<body>
<form action="/cao/ServletCodeLogin" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密 码:</td>
            <td><input type="text" name="password"></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td><input type="text" name="checkcode"></td>
        </tr>
        <tr>
            <td>
            <div id="change">
                <img id="code" src="/cao/Servlet7" alt="验证码">
                <a href="javascript:void(0)">点击切换</a>
            </div>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="登陆"></td>
        </tr>
    </table>
</form>

<div id="error" style="color: red;">
    <%
        String error = (String)request.getSession().getAttribute("error");
        if (error != null) {
            out.print(error);
        }
    %>
</div>
</body>
</html>
