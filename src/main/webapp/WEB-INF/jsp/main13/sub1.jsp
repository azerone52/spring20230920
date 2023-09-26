<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-26
  Time: 오전 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>input 요소들</h3>
<form action="/main13/sub2">
<%--    (div*10>input[name=param$])^button{전송}--%>
    <div>
        <input type="text" name="param1">
    </div>
    <div>
        <input type="password" name="param2">
    </div>
    <div>
        <input type="date" name="param3">
    </div>
    <div>
        <input type="button" name="param4" value="어떤 버튼">
    </div>
    <div>
        <input type="number" name="param5">
    </div>
    <div>
        <input type="submit" name="param6" value="회원가입">
    </div>
    <div>
        <input type="radio" name="param7">
        <input type="radio" name="param7">
    </div>
    <div>
        <input type="checkbox" name="param8">
        <input type="checkbox" name="param8">
    </div>
    <div>
        <input type="hidden" name="param9" value="some value">
    </div>
    <button>전송</button>
</form>

<form action="/main13/sub2">
    <div>
        <input type="text" name="param1" value="son">
    </div>
    <div>
        <input type="text" name="param2" placeholder="이름을 입력해주세요">
    </div>
    <div>
        <input type="text" maxlength="5">
    </div>
    <div>
<%--        필수입력--%>
        <input type="text" required>
    </div>
    <div>
<%--        읽기만 가능--%>
        <input type="text" name="param3" readonly value="son">
    </div>
    <div>
        <input type="text" name="param4" value="son" disabled>
    </div>
    <div>
<%--        정규표현식을 넣어서 입력한 값이 패턴에 맞을 때만 전송--%>
        <input type="text" pattern="\d{3}" name="param5">
    </div>
<%--    div*2>input:c--%>
    <div>
        <input type="checkbox" name="param6" checked id="">
    </div>
    <div>
        <input type="checkbox" name="param6" id="">
    </div>
<%--    div*2>input:r--%>
    <div>
        <input type="radio" name="param7" id="">
    </div>
    <div>
        <input type="radio" name="param7" checked id="">
    </div>
    <div>
<%--        둘 이상의 값 입력 가능--%>
        <input type="file" multiple>
    </div>
    <button>전송</button>
</form>

<form action="/main13/sub2">
    <label for="input1">
        주소
    </label>
    <input id="input1" type="text">
    <br>
<%--    div>div*3>label[for=check$]>lorem1^input:c#check$--%>
    <div>
        <div>
            <label for="check1">Lorem.</label>
            <input type="checkbox" name="" id="check1">
        </div>
        <div>
            <label for="check2">Fugiat!</label>
            <input type="checkbox" name="" id="check2">
        </div>
        <div>
            <label for="check3">Ab.</label>
            <input type="checkbox" name="" id="check3">
        </div>
    </div>
    <input type="submit">
<%--    input과 button의 차이점은 콘텐츠의 유무 차이--%>
</form>
</body>
</html>
