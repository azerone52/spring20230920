<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-25
  Time: 오후 2:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- /main11/sub7?show=true --%>
<%-- table 형식의 데이터 출력 --%>
<c:if test="${param.show}" var="isShow">
    <table>
        <c:forEach items="${moving}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.firstName}</td>
                <td>${item.lastName}</td>
                <td>${item.className}</td>
                <td>${item.phoneNumber}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<%-- /main11/sub7 --%>
<%-- 데이터가 없습니다. --%>
<c:if test="${! isShow}">
    <p>데이터가 없습니다.</p>
</c:if>
</body>
</html>
