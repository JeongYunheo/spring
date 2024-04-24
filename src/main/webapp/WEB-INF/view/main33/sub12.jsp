<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table, tr, th, td {
            border-collapse: collapse;
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h3>table 입력</h3>
<form action="" method="post">
    <div>
        제목
        <input type="text" name="title" value="이것이다">
    </div>
    <div>
        이름
        <input type="text" name="name" value="이강인">
    </div>
    <div>
        나이
        <input type="number" name="age" value="23">
    </div>
    <div>
        가격
        <input type="text" name="price" value="3214.10">
    </div>
    <div>
        출판일
        <input type="date" name="published" value="1888-11-11">
    </div>
    <div>
        입력
        <input type="datetime-local" name="inserted" value="1999-12-12T12:12:12">
    </div>
    <button>입력</button>
</form>
<hr>
<h3>my_table10 레코드 조회</h3>
<table>
    <thead>
    <tr>
        <th>제목</th>
        <th>이름</th>
        <th>나이</th>
        <th>가격</th>
        <th>출판</th>
        <th>입력</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${datas}" var="data">
        <tr>
            <td>${data.title}</td>
            <td>${data.name}</td>
            <td>${data.age}</td>
            <td>${data.price}</td>
            <td>${data.published}</td>
            <td>${data.inserted}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
