<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/20 0020
  Time: 下午 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true" %>
<%
%>
<html>
<head>
    <title>亲，你访问的页面去火星了?!</title>
</head>
<body>
<h>
    错误码：<%=request.getAttribute("javax.servlet.error.status_code")%> <br>
    信息： <%=request.getAttribute("javax.servlet.error.message")%> <br>
    异常类型： <%=request.getAttribute("javax.servlet.error.exception_type")%> <br>
</h>
</body>
</html>
