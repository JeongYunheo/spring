<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>choose, when, otherwise</h3>
<c:choose>
    <c:when test="false">
        <p>첫번째 when</p>
    </c:when>
    <c:when test="true">
        <p>second when</p>
    </c:when>
    <c:otherwise>
        <p>otherwise part</p>
    </c:otherwise>
</c:choose>

<hr>
<c:choose>
    <c:when test="${age < 13}">
        <p>어린이용 컨텐츠</p>
    </c:when>
    <c:when test="${age < 20}">
        <p>청소년용 컨텐츠</p>
    </c:when>
    <c:otherwise>
        <p>성인용 컨텐츠</p>
    </c:otherwise>
</c:choose>

</body>
</html>
