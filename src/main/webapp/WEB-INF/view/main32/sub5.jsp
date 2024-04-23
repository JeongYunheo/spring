<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="padding: 20px; background-color: antiquewhite">
    ${message}
</div>
<h3>직원 정보 입력</h3>
<form action="">
    <div>
        last name
        <input type="text" name="lastName">
    </div>
    <div>
        first name
        <input type="text" name="firstName">
    </div>
    <div>
        birth
        <input type="date" name="birth">
    </div>
    <div>
        photo
        <input type="text" name="photo">
    </div>
    <div>
        note
        <textarea name="note" id="" cols="30" rows="10"></textarea>
    </div>
    <button>등록</button>
</form>
</body>
</html>
