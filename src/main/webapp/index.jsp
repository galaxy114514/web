<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 45292
  Date: 2018/7/30
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Index</title>
    <script src="/web/js/jquery-3.3.1.js"></script>
    <script>
        $(function () {
            $(".delete").click(function () {
                var flag=confirm("确定删除吗");
                return flag;
            })
        })
    </script>

</head>
<body>
<div><h3>welcome:${user.username}</h3></div>
<div id="top"></div>
<form action="/web/student?method=query" method="post">
    name~<input type="text" name="name" value="${info.name}"/><br>
    address<input type="text" name="address" value="${info.address}"><br>
    phone<input type="text" name="phone" value="${info.phone}"><br>
    <button type="submit" id="button1">查询</button>
    <a href="/web/jsp/addStudent.jsp">添加</a>

</form>

<c:if dao.test="${students!=null}">
    <table border="1" cellpadding="10" cellspacing="0">
        <thead>
        <td>id</td>
        <td>name</td>
        <td>address</td>
        <td>phone</td>
        <td>编辑</td>
        <td>删除</td>
        </thead>
        <c:forEach var="student" items="${students}">
            <tbody>
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.address}</td>
                <td>${student.phone}</td>
                <td><a href="/web/updateStudent.do?id=${student.id}">编辑</a></td>
                <td><a href="/web/deleteStudent.do?id=${student.id}" class="delete">删除</a></td>
            </tr>
            </tbody>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
