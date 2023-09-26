<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-25
  Time: 오전 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>el에서 사용할 수 있는 연산자</h3>
<h4>산술 연산자</h4>
<h4>+, -, *, /, %</h4>
<hr>
<h5>+ : 더하기</h5>
<p>${a} + ${b} = ${a + b}</p>
<p>${c} + ${d} = ${c + d}</p>

<h5>- : 빼기</h5>
<p>${a} - ${b} = ${a - b}</p>
<p>${c} - ${d} = ${c - d}</p>

<h5>* : 곱하기</h5>
<p>${a} * ${b} = ${a * b}</p>
<p>${c} * ${d} = ${c * d}</p>

<h5>/ (div) : 나누기</h5>
<p>${a} / ${b} = ${a / b}</p>
<p>${c} / ${d} = ${c / d}</p>
<p>${a} / ${b} = ${a div b}</p>
<p>${c} / ${d} = ${c div d}</p>

<h5>% (mod) : 나머지 연산 (modulo, remainder)</h5>
<p>${b} % ${a} = ${b % a}</p>
<p>${d} % ${a} = ${d % a}</p>
<p>${b} % ${a} = ${b mod a}</p>
<p>${d} % ${a} = ${d mod a}</p>

<h5>() : 우선순위 높음</h5>
<p>a * b - c = ${a * b - c}</p>
<p>a * (b - c) = ${a * (b - c)}</p>
<p>(a * b) - c = ${(a * b) - c}</p>
<hr>
<h5>구구단 2단</h5>
<c:forEach begin="1" end="9" var="i">
    <p> 2 * ${i} = ${2 * i}</p>
</c:forEach>

<hr>
<h5>구구단 2단~9단</h5>
<c:forEach begin="2" end="9" var="i">
    <h5>${i}단</h5>
    <c:forEach begin="1" end="9" var="j">
        <p>${i} * ${j} = ${i * j}</p>
    </c:forEach>
    <hr>
</c:forEach>

<h5>구구단 9단~2단 1</h5>
<c:forEach items="${gu}" var="i">
    <h5>${i}단</h5>
    <c:forEach begin="1" end="9" var="j">
        <p>${i} * ${j} = ${i * j}</p>
    </c:forEach>
    <hr>
</c:forEach>

<h5>구구단 9단~2단 2</h5>
<c:forEach begin="0" end="7" var="i">
    <h5>${9-i}단</h5>
    <c:forEach begin="1" end="9" var="j">
        <p>${9-i} * ${j} = ${(9-i) * j}</p>
    </c:forEach>
    <hr>
</c:forEach>

</body>
</html>
