<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
        thead, th, tr, td {
            border: 1px solid black;
            border-collapse: collapse;
        }

        table {
            width: 100%;
        }
    </style>
</head>
<body>
<h3>직원들 조회 메소드</h3>
<form action="/main25/sub8">
    <input type="text" name="search" placeholder="이름을 입력하세요">
    <input type="submit" value="검색">
</form>
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>first</th>
        <th>last</th>
        <th>birth</th>
        <th>photo</th>
        <th>note</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employees}" var="employee">
        <td>${employee.id}</td>
        <td>${employee.firstName}</td>
        <td>${employee.lastName}</td>
        <td>${employee.birth}</td>
        <td>${employee.photo}</td>
        <td>${employee.note}</td>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
