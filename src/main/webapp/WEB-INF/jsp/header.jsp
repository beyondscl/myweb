<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/19 0019
  Time: 下午 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
    request.setAttribute("basePath", basePath);
%>
<html>
<head>
    <title>奇鸟安全</title>
    <base href="${basePath}">
    <link rel="stylesheet" href="/assets/css/theme.css">
    <script type="text/javascript"
            src="/assets/js/jquery-3.2.1.min.js"></script>
</head>
</html>
