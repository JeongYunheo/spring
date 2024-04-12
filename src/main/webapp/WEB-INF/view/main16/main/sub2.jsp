<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--navbar2.jsp 절대--%>
<%--navbar2.jsp 상대--%>
<c:import url="../../../fragment/footer2.jsp"/>
<c:import url="/WEB-INF/fragment/footer2.jsp"/>

<div>
    sub2 content
</div>

<%--footer2.jsp 절대--%>
<%--footer2.jsp 상대--%>
<c:import url="../../../fragment/navbar2.jsp"/>
<c:import url="/WEB-INF/fragment/navbar2.jsp"/>
</body>
</html>
