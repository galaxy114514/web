<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 45292
  Date: 2018/8/2
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <script src="/web/js/jquery-3.3.1.js"></script>
    <title>books</title>
</head>
<body>
<h4>books page</h4>
    <a href="book.jsp?book=javaweb">Java Web</a><br>
    <a href="book.jsp?book=orangle">orangle</a><br>
    <a href="book.jsp?book=java">java</a><br>
    <a href="book.jsp?book=php">php</a><br>
    <a href="book.jsp?book=python">python</a><br>
    <a href="book.jsp?book=javascript">javascript</a><br>
    <a href="book.jsp?book=html">html</a><br>
    <a href="book.jsp?book=css">css</a>
    <br>
<%
    Cookie[] cookie=request.getCookies();
    List<String> books=new ArrayList<>();
    for (Cookie cookie1 : cookie) {
        if (cookie1.getName().startsWith("aiguigu_")){
            books.add(cookie1.getValue());
        }
    }
%>
<%=books%>
</body>
</html>
