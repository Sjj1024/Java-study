<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: sWX829949
  Date: 2020/4/21
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL是jsp标签库</title>
</head>
<body>
<%--
jstl是：java server tage libaray
导入方式：<%@ taglib jstl标签库%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

--%>
<%
    String res = "";
    request.setAttribute("num", 6);
    List<String> lista = new ArrayList<>();
    lista.add("a");
    lista.add("b");
    lista.add("c");
    lista.add("d");
    request.setAttribute("list", lista);
%>
<%--
使用jstl标签的if表达式
<c:if test="真假表达式，一般会和EL表达式一起使用">
--%>
<c:if test="true">
    表达式内容为真
    <h1>真的为真！</h1>
</c:if>
<c:if test="${not empty res}">
    res 结果内容为空
</c:if>

<%--
choose方法相当于java中的switch
when相当于case
otherwise相当于default
--%>
<hr>
<c:choose>
    <c:when test="${num == 1}">今天是星期一</c:when>
    <c:when test="${num == 2}">今天是星期二</c:when>
    <c:when test="${num == 3}">今天是星期三</c:when>
    <c:when test="${num == 4}">今天是星期四</c:when>
    <c:when test="${num == 5}">今天是星期五</c:when>
    <c:when test="${num == 6}">今天是星期六</c:when>
    <c:when test="${num == 7}">今天是星期天</c:when>
    <c:otherwise>数字输入有误，请重新输入！</c:otherwise>
</c:choose>
<%--
foreach标签:遍历循环标签，bggin是开始标签，end是结束标签，step是步长，var是变量名称，varStatus是状态属性
s.index 是索引，从0开始，count是遍历次数，从1开始
<c:forEach begin="0" end="10" step="1" var="i" varStatus="s">

第二种：直接遍历列表中你的元素
items相当于集合对象，var相当于其中的一个项，varstatus是遍历状态属性
<c:forEach items="${list}" var="item" varStatus="i">
--%>
<c:forEach begin="0" end="10" step="3" var="i" varStatus="s">
    <h3>${i}</h3>---${s.index}---${s.count}
</c:forEach>
<hr>
<%--
items相当于集合对象，var相当于其中的一个项，varstatus是遍历状态属性
--%>
<c:forEach items="${list}" var="item" varStatus="i">
    ${i.index}--${i.count}--${item}<br>
</c:forEach>

<hr>

</body>
</html>
