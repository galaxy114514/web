<%--
  Created by IntelliJ IDEA.
  User: 45292
  Date: 2018/8/1
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <script src="/web/js/jquery-3.3.1.js"></script>
    <title>Register</title>
</head>
<body>
<form action="/web/register.login" method="post">
    name:<input type="text" name="username" value="${user.username}">
    password:<input type="password" name="password" value=" ${user.password}">
    <button type="submit">注册</button>
    <div><h3>${message}</h3></div>
</form>
</body>
</html>
