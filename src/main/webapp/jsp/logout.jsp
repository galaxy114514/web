<%--
  Created by IntelliJ IDEA.
  User: 45292
  Date: 2018/8/2
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <script src="/web/js/jquery-3.3.1.js"></script>
    <title>Title</title>
</head>
<body>
<%
    HttpSession session1 = request.getSession(true);
    session1.invalidate();
%>

<a href="login.jsp">重新登录</a>

</body>
</html>
