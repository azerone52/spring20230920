<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-10-10
  Time: 오후 2:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>공급자 입력</h3>
<form action="" method="post">
    <div>
        Supplier Name:
        <input type="text" name="supplierName">
    </div>
    <div>
        Contact Name:
        <input type="text" name="contactName">
    </div>
    <div>
        Address:
        <input type="text" name="address">
    </div>
    <div>
        City:
        <input type="text" name="city">
    </div>
    <div>
        Post Code:
        <input type="text" name="postalCode">
    </div>
    <div>
        Country:
        <input type="text" name="country">
    </div>
    <div>
        Phone:
        <input type="text" name="phone">
    </div>
    <button>등록</button>
</form>
</body>
</html>
