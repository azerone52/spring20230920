<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-27
  Time: 오후 5:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <a href="/main17/list">목록 보기</a>
</div>
<p>${message}</p>
<h1>글 보기</h1>
<form method="post">
    <div>
        <label for="titleInput">제목</label>
        <input type="text" id="titleInput" name="title" readonly value="${post.title}">
    </div>
    <div>
        <textarea name="body" id="" cols="30" rows="10" readonly>${post.body}</textarea>
    </div>
</form>
</body>
</html>
