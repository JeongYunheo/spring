<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <c:if test="${not empty message}">
        <div style="padding: 30px; background-color: pink">
                ${message}
        </div>
    </c:if>
</div>
<h3>새 직원 추가</h3>
<form action="" method="post">
    <div>
        <div>
            이름
            <input type="text" name="lastName">
        </div>
        <div>
            성
            <input type="text" name="firstName">
        </div>
        <div>
            출생
            <input type="date" name="birth">
        </div>
        <div>
            사진
            <input type="text" name="photo">
        </div>
        <div>
            참고
            <input type="text" name="note">
        </div>
        <div>
            <button>등록</button>
        </div>
    </div>
</form>
</body>
</html>
