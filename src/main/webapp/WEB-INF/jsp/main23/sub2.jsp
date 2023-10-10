<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-10-10
  Time: 오전 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="">
    고객 이름 검색:
    <input type="text" name="k">
    <button>검색</button>
</form>
<table>
    <tr>
        <th>고객명</th>
    </tr>
    <c:forEach items="${names}" var="name">
        <tr>
            <td>${name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
