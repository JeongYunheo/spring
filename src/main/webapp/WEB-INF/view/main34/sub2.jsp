<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
        td, tr, th, table {
            border-collapse: collapse;
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h3>고객별 구매금액 조회</h3>
<form action="">
    <div>
        년도
        <select name="year">
            <option value="1996" ${year == 1996 ? 'selected' : ''}>1996</option>
            <option value="1997" ${year == 1997 ? 'selected' : ''}>1997</option>
            <option value="1998" ${year == 1998 ? 'selected' : ''}>1998</option>
        </select>
    </div>
    <div>
        월
        <select name="month">
            <option value="1" ${month == '1' ? 'selected' : ''}>1</option>
            <option value="2" ${month == '2' ? 'selected' : ''}>2</option>
            <option value="3" ${month == '3' ? 'selected' : ''}>3</option>
            <option value="4" ${month == '4' ? 'selected' : ''}>4</option>
            <option value="5" ${month == '5' ? 'selected' : ''}>5</option>
            <option value="6" ${month == '6' ? 'selected' : ''}>6</option>
            <option value="7" ${month == '7' ? 'selected' : ''}>7</option>
            <option value="8" ${month == '8' ? 'selected' : ''}>8</option>
            <option value="9" ${month == '9' ? 'selected' : ''}>9</option>
            <option value="10" ${month == '10' ? 'selected' : ''}>10</option>
            <option value="11" ${month == '11' ? 'selected' : ''}>11</option>
            <option value="12" ${month == '12' ? 'selected' : ''}>12</option>
        </select>
    </div>
    <div>
        <input type="submit" value="조회">
    </div>
</form>
<hr>
<c:if test="${empty purchaseList}">
    <div>
        조회결과가 없습니다
    </div>
    <div>
        1996년 7월부터 1998년 6월 중에 조회해주세요
    </div>
</c:if>
<c:if test="${not empty purchaseList}">
    <h3>${year}년 ${month}월 조회 결과</h3>
    <div>
        <table>
            <thead>
            <tr>
                <td>#</td>
                <td>Customer name</td>
                <td>구매액</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${purchaseList}" var="item" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${item.customerName}</td>
                    <td>${item.income}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</c:if>
</body>
</html>
