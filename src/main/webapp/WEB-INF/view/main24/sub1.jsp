<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th></th>
        <th>first name</th>
        <th>last name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employees}" var="employee" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${employee.first}</td>
            <td>${employee.last}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
