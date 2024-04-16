<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty message}">
    <div style="background-color: darkseagreen; padding: 50px">
            ${message}
    </div>
</c:if>
<form action="/main22/sub17" method="post">
    <div>
        login
        <input type="text" name="login">
    </div>
    <div>
        pw
        <input type="text" name="pw">
    </div>
    <div>
        <input type="submit" value="로그인">
    </div>
</form>
</body>
</html>
