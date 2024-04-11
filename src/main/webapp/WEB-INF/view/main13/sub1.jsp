<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- set : 직접 attribute 추가--%>
<c:set var="attr1" value="손흥민"></c:set>
<c:set var="attr2" value="이강인"></c:set>
<c:set var="attr3" value="김하성" scope="page"></c:set>

<%--생성 후 출력해야함--%>
<p>${attr1}</p>
<p>${attr2}</p>
<p>${attr3}</p>

<hr>
<c:set target="${obj1}" property="address" value="강남"></c:set>

<%--obj1 attribute의 age property를 55로 바꾸기--%>
<c:set target="${obj1}" property="age" value="55"></c:set>

<p>${obj1.address}</p>
<p>${obj1.city}</p>
<p>${obj1.age}</p>
<%--필드와 메소드 구분됨, 영향 주고받지 않음--%>

</body>
</html>
