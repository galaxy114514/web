<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.LinkedList" %><%--
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
    <title>book</title>
</head>
<body>
<h4>book detail page</h4>
<%= request.getParameter("book") %>
<a href="books.jsp">返回</a>
<%
    Cookie[] cookies= request.getCookies();
    LinkedList<String> books=new LinkedList<>();
    if (cookies!=null&&cookies.length>0){
        for (Cookie cookie : cookies) {
           if (cookie.getName().startsWith("aiguigu_")){
               System.out.println(cookie.getName());
               books.add(cookie.getName().replaceAll("aiguigu_","").trim());
           }
        }
    }
    System.out.println("form brower"+books);
    String book = request.getParameter("book");
    if (books.size()<5){
        books.add(book);
    }else {
        if (books.contains(book)){
            books.remove(book);
            books.addLast(book);
        }else {
            books.removeFirst();
            books.addLast(book);
        }
    }
    System.out.println("after processing"+books);
    for (Cookie cookie : cookies) {
        cookie.setMaxAge(-1);
        response.addCookie(cookie);
    }
    for (String s : books) {
        Cookie cookie=new Cookie("aiguigu_"+s,s);
        response.addCookie(cookie);
    }


%>
</body>
</html>
