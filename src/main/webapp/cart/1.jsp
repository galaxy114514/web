<%--
  Created by IntelliJ IDEA.
  User: 45292
  Date: 2018/8/2
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <script src="/web/js/jquery-3.3.1.js"></script>
    <title>1</title>
</head>
<body>

<h4>Step1:选择要购买的图书 </h4>
<form method="post" action="2.jsp">
    <table>
        <tr>
            <td>书名</td>
            <td>购买</td>
        </tr>
        <tr>
            <td>java</td>
            <td><input type="checkbox" name="book" value="java"></td>
        </tr>
        <tr>
            <td>html</td>
            <td><input type="checkbox" name="book" value="html"></td>
        </tr>
        <tr>
            <td>html</td>
            <td><input type="checkbox" name="book" value="javascsript"></td>
        </tr>
    </table>
    <br>
    <button type="submit">提交</button>
</form>
</body>
</html>
