<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-22
  Time: 오후 3:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            border-collapse: collapse;
            border: 1px solid black;
            width: 100%;
        }
        td{
            padding: 5px;
        }
    </style>
</head>
<body>
<table>
    <c:forEach items="${moving}" var="move">
        <tr>
            <td>${move.id}</td>
            <td>${move.firstName}</td>
            <td>${move.lastName}</td>
            <td>${move.className}</td>
            <td>${move.phoneNumber}</td>
        </tr>
    </c:forEach>
</table>
<hr>
</body>
</html>
