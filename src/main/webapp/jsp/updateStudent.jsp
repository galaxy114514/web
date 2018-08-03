<%--
  Created by IntelliJ IDEA.
  User: 45292
  Date: 2018/8/1
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <script src="/web/js/jquery-3.3.1.js"></script>
    <title>update</title>
</head>
<body>
<form method="post" action="/web/updateStudent.do">
    name~<input type="text" name="name" value="${student.name}"><br>
    address<input type="text" name="address" value="${student.address}"><br>
    phone<input type="text" name="phone" value="${student.phone}"><br>
    <button type="submit" id="button1">确认</button>
    <a href="/web/index.jsp">返回</a>
</form>
<div>${message}</div>
</body>
</html>
