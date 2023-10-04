<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-27
  Time: 오전 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>model</h3>
<ul>
  <c:forEach items="${items}" var="item">
    <li>${item}</li>
  </c:forEach>
</ul>
<h3>session</h3>
<ul>
  <c:forEach items="${sessionScope.items}" var="item">
    <li>${item}</li>
  </c:forEach>
</ul>
</body>
</html>
