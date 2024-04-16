<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty message}">
    <div style="padding: 50px; background-color: pink">${message}</div>
</c:if>
<h1>Lorem ipsum dolor.</h1>
<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aspernatur dolores laborum mollitia repellat? Ab ducimus et
    ipsa perferendis qui quo suscipit! Aliquam culpa ducimus earum in minima nam odio rerum!
</p>
</body>
</html>
