<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table, tr, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }

        table {
            width: 100%;
        }
    </style>
</head>
<body>
<h3>상품 이름 조회</h3>
<form action="/main25/sub6">
    이름
    <input type="text" placeholder="조회할 고객 이름을 입력하세요." name="search">
    <%--    form의 button 요소는 submit 버튼 역할을 함--%>
    <input type="submit" value="조회">
</form>
<h3> 카테고리 선택</h3>
<form>
    카테고리 선택
    <div>
        <select name="category" multiple>
            <c:forEach items="${categoryList}" var="category">
                <c:set value="false" var="selected"/>
                <c:forEach items="${prevCategorySelect}" var="prevSelect">
                    <c:if test="${category.id == prevSelect}">
                        <c:set value="true" var="selected"/>
                    </c:if>
                </c:forEach>

                <option ${selected ? "selected" : ""} value="${category.id}">${category.name}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <button>조회</button>
    </div>
</form>
<hr>
<c:if test="${empty products}" var="emptyProducts">
    조회된 내용이 없습니다
</c:if>

<c:if test="${not emptyProducts}">
    <table>
        <thead>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>supplier</th>
            <th>category</th>
            <th>unit</th>
            <th>price</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.supplier}</td>
                <td>${product.category}</td>
                <td>${product.unit}</td>
                <td>${product.price}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

</body>
</html>
