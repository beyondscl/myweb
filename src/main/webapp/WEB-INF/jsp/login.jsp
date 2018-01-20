<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/18
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<html>
<head>
    <title>奇鸟安全，登录</title>
</head>
<body>
<form action="/user/login" method="post"
      enctype="application/x-www-form-urlencoded">
    <input id="name" name="name" value="" type="text">
    <input id="password" name="password" value="" type="password">
    <input id="token" name="token" value="" type="hidden">
    <input type="submit" value="提交"/>
</form>
</body>
</html>
