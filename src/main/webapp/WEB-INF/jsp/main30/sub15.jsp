<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-10-19
  Time: 오전 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>${message}</h4>
<h3>조회할 고객 번호 입력</h3>
<form action="/main30/sub15">
<input type="number" name="id">
<button>조회</button>
</form>
<hr>
<h3>고객 정보 수정</h3>
<form action="/main30/sub15" method="post">
    고객번호:
    <input type="text" name = "customerId" value="${customer.customerId}" readonly><br>
    고객이름:
    <input type="text" name = "customerName" value="${customer.customerName}"><br>
    담당자 명:
    <input type="text" name = "contactName" value="${customer.contactName}"><br>
    주소:
    <input type="text" name = "address" value="${customer.address}"><br>
    도시:
    <input type="text" name = "city" value="${customer.city}"><br>
    우편번호:
    <input type="text" name = "postalCode" value="${customer.postalCode}"><br>
    국가:
    <input type="text" name = "country" value="${customer.country}"><br>

    <button>수정</button>
</form>
</body>
</html>
