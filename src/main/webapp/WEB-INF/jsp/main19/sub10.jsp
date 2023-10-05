<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-10-05
  Time: 오전 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>고객 조회</h4>
<form action="/main19/sub11">
    고객번호
    <input type="text" name="cid">
    <button>조회</button>
</form>
<form action="/main19/sub12">
    고객국가
    <select name="country" id="">
        <c:forEach items="${countryList}" var="country">
            <option value="${country}">${country}</option>
        </c:forEach>
    </select>
    <button>조회</button>
</form>
</body>
</html>
