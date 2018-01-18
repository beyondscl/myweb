<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/18
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="/user/login" method="get" enctype="multipart/form-data">
    <input id="name" name="name" value="" type="text">
    <input id="password" name="password" value="" type="password">
    <input type="submit" value="提交"/>
</form>
</body>
</html>
