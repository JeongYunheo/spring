<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="padding: 20px">
    ${message}
</div>
<h3>고객 정보 조회 및 수정</h3>
<form action="">
    id
    <input type="number" name="id">
    <button>조회</button>
</form>

<hr>
<c:if test="${empty customer}">
    조회된 고객이 없습니다
</c:if>
<c:if test="${not empty customer}">
    <form action="/main32/sub7/update" method="post">
        <div>
            id
            <input type="number" value="${customer.id}" name="id">
        </div>
        <div>
            customer name
            <input type="text" value="${customer.name}" name="name">
        </div>
        <div>
            contact name
            <input type="text" value="${customer.contactName}" name="contactName">
        </div>
        <div>
            address
            <input type="text" value="${customer.address}" name="address">
        </div>
        <div>
            city
            <input type="text" value="${customer.city}" name="city">
        </div>
        <div>
            postal code
            <input type="text" value="${customer.postalCode}" name="postalCode">
        </div>
        <div>
            country
            <input type="text" value="${customer.countryName}" name="countryName">
        </div>
        <div>
            <input type="submit" value="수정">
        </div>
    </form>
</c:if>
</body>
</html>
