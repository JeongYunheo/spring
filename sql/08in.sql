USE w3schools;

# IN 하나라도 같으면 ..
SELECT *
FROM Customers
WHERE Country = 'Germany'
   OR Country = 'UK';

SELECT *
FROM Customers
WHERE Country IN ('Germany', 'uk');

SELECT *
FROM Customers
WHERE Country IN ('germany', 'uk', 'sweden', 'france');

# 2,3,6 번 카테고리 상품들
# 브라질, 일본, 이탈리아에 있는 공급자

SELECT *
FROM Products
WHERE CategoryID IN (2, 3, 6);

SELECT *
FROM Suppliers
WHERE Country IN ('brazil', 'japan', 'italy');
