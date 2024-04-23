USE w3schools;

SELECT *
FROM Employees;

SELECT *
FROM Employees
ORDER BY EmployeeID DESC;

# 지우기 전에 꼭 같은 WHERE 로 SELECT 해보기
DELETE
FROM Employees
WHERE EmployeeID = 4101;

DELETE
FROM Employees
WHERE EmployeeID = 4100;

DELETE
FROM Employees
WHERE LastName = '허';

# 모든 레코드 지우기: WHERE 안쓰면 됨
# 주의해야!!!
SELECT *
FROM Employees;

DELETE
FROM Employees;

