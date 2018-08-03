<%--
  Created by IntelliJ IDEA.
  User: 45292
  Date: 2018/8/2
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <script src="/web/js/jquery-3.3.1.js"></script>
    <title>2</title>
</head>
<body>
<h3>Step2:请选择购物地址及信用卡信息</h3>
<%
    String[] books = request.getParameterValues("book");
    HttpSession session1 = request.getSession(true);
    session1.setAttribute("books", books);
%>
<form action="3.jsp" method="post">
    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <td>姓名</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>地址</td>
            <td><input type="text" name="address"></td>
        </tr>
        <tr>
            <td>信用卡</td>
            <td>Visa:<input type="radio" name="cardType" value="Visa">
                <br>
                Master:<input type="radio" name="cardType" value="Master">
            </td>
        </tr>
        <tr>
            <td>卡号</td>
            <td><input type="text" name="cardNumber"></td>
        </tr>
    </table>
    <br>
    <button type="submit">Submit</button>
</form>
</body>
</html>
