<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="padding: 20px">${message}</div>
<h3>직원 조회 및 조회</h3>
<form action="">
    <input type="number" name="id">
    <button>조회</button>
</form>
<hr>
<c:if test="${empty employee}">
    조회된 직원이 없습니다
</c:if>
<c:if test="${not empty employee}">
    <h3>${employee.id}번 직원</h3>
    <form action="/main32/sub6/update" method="post">
        <div>
            last name
            <input type="text" value="${employee.lastName}" name="lastName">
        </div>
        <div>
            first name
            <input type="text" value="${employee.firstName}" name="firstName">
        </div>
        <div>
            birth
            <input type="date" value="${employee.birth}" name="birth">
        </div>
        <div>
            <input type="text" value="${employee.photo}" name="photo">
        </div>
        <div>
            notes
            <textarea name="note" id="" cols="30" rows="10">${employee.note}</textarea>
        </div>
        <div style="display: none">
            <input type="text" name="id" value="${employee.id}">
        </div>
        <div>
            <input type="submit" value="전송">
        </div>
    </form>
</c:if>

</body>
</html>
