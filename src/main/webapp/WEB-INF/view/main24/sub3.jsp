<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>고객이 있는 나라 중복없이</h3>
<table>
    <thead>
    <tr>
        <th></th>
        <th>나라</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${customers}" varStatus="status" var="country">
        <tr>
            <td>${status.count}</td>
            <td>${country}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
