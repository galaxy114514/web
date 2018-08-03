<%--
  Created by IntelliJ IDEA.
  User: 45292
  Date: 2018/8/1
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType = "text/html;charset=UTF-8" language = "java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <script src = "/web/js/jquery-3.3.1.js"></script>
    <title>Login</title>
</head>
<body>
<form action = "/web/login.login" method = "post">
    username:<input type = "text" name = "username" value = "${user.username==null?null:user.username}"><br>
    password:<input type = "password" name = "password" value = "${user.password}"><br>
    <button type = "submit">登录</button>
    <a href = "/web/jsp/registerUser.jsp">注册</a>
</form>
<div><h5>${message}</h5></div>
</body>
</html>
