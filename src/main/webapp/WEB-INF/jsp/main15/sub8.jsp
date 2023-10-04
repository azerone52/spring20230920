<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-27
  Time: 오전 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>좋아하는 음식은
<c:forEach items="${favoriteFoods}" var="food">
    ${food}
</c:forEach> 입니다.
</h1>
<a href="/main15/sub9">다음 페이지로 이동하기</a>
</body>
</html>
