<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="attr1" value="page value2" scope="page"/>
<c:set var="attr1" value="request value2" scope="request"/>

<div>

    <div>
        <%--        page value2--%>
        ${pageScope.attr1}, ${pageScope["attr1"]}, ${attr1}
    </div>

    <div>
        <%--        request value2--%>
        ${requestScope.attr1}, ${requestScope["attr1"]}
    </div>

</div>
