<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
        thead, th, tr, td {
            border: 1px solid black;
            border-collapse: collapse;
        }

        table {
            width: 100%;
        }
    </style>
</head>
<body>
<h3>주문일로 주문 조회</h3>
<form>
    <div>시작:
        <input value="${prevStart}" type="date" name="start">
    </div>
    <div>종료:
        <input value="${prevEnd}" type="date" name="end">
    </div>
    <div>
        <button>조회</button>
    </div>
</form>
<hr>
<c:if test="${empty orderList}" var="emptyOrder">
    <div>
        주문목록이 없습니다
    </div>
</c:if>
<c:if test="${not emptyOrder}">
    <table>
        <thead>
        <tr>
            <th>id</th>
            <th>customer</th>
            <th>employee</th>
            <th>date</th>
            <th>shipper</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${orderList}" var="order">
            <tr>
                <td>${order.id}</td>
                <td>${order.customer}</td>
                <td>${order.employee}</td>
                <td>${order.date}</td>
                <td>${order.ship}</td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</c:if>
</body>
</html>
