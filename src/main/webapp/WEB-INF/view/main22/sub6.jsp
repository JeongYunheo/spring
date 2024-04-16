<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${param.type eq 'fail'}">
    <div style="padding: 50px; background-color: darkseagreen">
        아이디와 패스워드를 다시 확인해주세요
    </div>
</c:if>
<form action="/main22/sub7" method="post">
    <div>
        id
        <input type="text" name="id">
    </div>
    <div>
        pw
        <input type="text" name="password">
    </div>
    <div>
        <input type="submit" value="login">
    </div>

</form>
</body>
</html>
