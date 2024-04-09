<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--표현언어 jsp el(ezpression language)--%>

<%--값 1--%>
<p>${data}</p>
<p>${requestScope.data}</p>
<p>${requestScope["data"]}</p>

<%--삼--%>
<p>${requestScope["3"]}</p>

<%--값2--%>
<p>${requestScope["데이타"]}</p>

</body>
</html>
