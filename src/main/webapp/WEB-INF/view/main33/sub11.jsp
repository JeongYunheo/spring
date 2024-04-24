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
<h3>새 데이터 입력</h3>
<form action="" method="post">
    <div>
        <input type="text" name="stringCol" value="기본문자열">
    </div>
    <div>
        <input type="text" name="intCol" value="100">
    </div>
    <div>
        <input type="number" name="decCol" value="3.14" step="0.01">
    </div>
    <div>
        <input type="date" name="dateCol" value="2024-03-03">
    </div>
    <div>
        <input type="datetime-local" name="dateTimeCol" value="2024-03-03T12:12:24">
    </div>
    <div>
        <input type="submit" value="저장">
    </div>
</form>
<hr>
<h3>table9 자료들</h3>
<table>
    <thead>
    <tr>
        <th>문자열</th>
        <th>정수</th>
        <th>실수</th>
        <th>날짜</th>
        <th>날짜시간</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${datas}" var="data">
        <tr>
            <td>${data.stringCol}</td>
            <td>${data.intCol}</td>
            <td>${data.decCol}</td>
            <td>${data.dateCol}</td>
            <td>${data.dateTimeCol}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
