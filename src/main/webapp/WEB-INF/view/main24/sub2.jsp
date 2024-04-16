<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>고객 목록</h3>
<table>
    <thead>
    <tr>
        <th></th>
        <th>이름</th>
        <th>국적</th>
        <th>도시</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customers}" var="customer" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${customer.name}</td>
            <td>${customer.country}</td>
            <td>${customer.city}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
