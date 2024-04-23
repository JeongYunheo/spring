<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty message}">
    <div style="padding: 20px; background-color: rosybrown">${message}</div>
</c:if>

<h3> 직원 정보 수정</h3>
<form action="">
    번호
    <input type="number" name="id">
    <button>조회</button>
</form>
<hr>
<form action="/main30/sub2/update2" method="post">
    <div>
        <input hidden type="number" name="id" value="${employee.id}">
        <h3>${employee.id}번 직원</h3>
    </div>

    <div>
        이름
        <input type="text" name="lastName" value="${employee.lastName}">
    </div>
    <div>
        성
        <input type="text" name="firstName" value="${employee.firstName}">
    </div>
    <div>
        생일
        <input type="date" name="birth" value="${employee.birth}">
    </div>
    <div>
        사진
        <input type="text" name="photo" value="${employee.photo}">
    </div>
    <div>
        참고
        <textarea name="note" id="" cols="30" rows="10">${employee.note}</textarea>
    </div>
    <%--    name은 컨트롤러에 적용한 이름과 같아야함--%>
    <div>
        수정
        <input type="submit">
    </div>
</form>
</body>
</html>
