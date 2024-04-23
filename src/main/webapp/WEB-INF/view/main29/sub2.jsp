<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty message}">
    <div style="background-color: burlywood; padding: 50px">
            ${message}
    </div>
</c:if>
<h3>직원 조회</h3>
<form>
    직원 번호
    <input type="number" name="id">
    <button>조회</button>
</form>
<hr>
<c:if test="${empty employee}">
    조회된 고객이 없습니다
</c:if>
<c:if test="${not empty employee}">
    <div>
        번호
        <input type="text" readonly value="${employee.id}">
    </div>
    <div>
        이름
        <input type="text" readonly value="${employee.lastName}">
    </div>
    <div>
        성
        <input type="text" readonly value="${employee.firstName}">
    </div>
    <div>
        생일
        <input type="date" readonly value="${employee.birth}">
    </div>
    <div>
        사진
        <input type="text" readonly value="${employee.photo}">
    </div>
    <div>
        참고
        <textarea name="note" readonly id="" cols="30" rows="10"> ${employee.note}</textarea>
    </div>

    <form action="/main29/sub2/delete" method="post" onsubmit="return confirm('삭제하시겠습니까?')">
        <input hidden type="number" name="id" value="${employee.id}">
        <div>
            <button style="background-color: cadetblue">삭제</button>
        </div>
    </form>
</c:if>

</body>
</html>
