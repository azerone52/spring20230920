<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-10-06
  Time: 오전 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>공급자 조회</h3>
<table>
  <tr>
    <th>ID</th>
    <th>NAME</th>
  </tr>
  <c:forEach items="${suppliers}" var="supplier">
    <tr>
      <td>${supplier.id}</td>
      <td>${supplier.name}</td>
    </tr>
  </c:forEach>
</table>
<c:forEach begin="1" end="${cnt}" var="num">
  <a href="/main22/sub2?p=${num}">${num} | </a>
</c:forEach>

</body>
</html>
