<%--
  Created by IntelliJ IDEA.
  User: 45292
  Date: 2018/8/2
  Time: 1:05
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
    session1.setAttribute("username",request.getParameter("username"));
%>
    创建时间<%=session1.getCreationTime() %>
<br>
上次修改时间<%= session1.getLastAccessedTime()%>
<br>
是否是新的<%= session1.isNew()%>
<br>
SessionId<%= session1.getId()%>
<br>
Hello<%= session1.getAttribute("username")%>
<br>
<a href="login.jsp">重新登录</a>
<br>
<a href="logout.jsp">注销</a>
</body>
</html>
