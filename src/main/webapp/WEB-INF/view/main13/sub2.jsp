<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--url : 주소를 생성하고 저장할 수 있는 태그--%>
<%--여러 곳에서 반복해서 쓰는 구조--%>
<%--request parameter를 추가--%>
<%--request parameter 외 url encoding(한글변환)--%>
<c:url value="https://search.naver.com/search.naver" var="naverUrl">
    <c:param name="query" value="이강인"/>
    <c:param name="where" value="nexearch"/>
    <c:param name="sm" value="tap_hty.top"/>
</c:url>

<a href="https://search.naver.com/search.naver?query=bts">네이버 검색</a>
<a href="${naverUrl}">네이버 검색</a>

<hr>
<a href="https://search.naver.com">네이버</a>
<a href="${naverUrl}">네이버 검색</a>

<hr>
<%--url 태그 사용해서 아래와 같은 주소 만들기--%>
<%--에스파--%>
<c:url value="http://search.naver.com/search.naver" var="naverMy">
    <c:param name="where" value="nexearch"/>
    <c:param name="sm" value="top_hty"/>
    <c:param name="fbm" value="0"/>
    <c:param name="query" value="에스파"/>
</c:url>
<a href="${naverMy}">에스파 검색 결과</a>

</body>
</html>
