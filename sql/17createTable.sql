USE w3schools;

# CREATE TABLE : 새 테이블 만들기
# 테이블 생성시 컬럼들 정의해야함
# CREATE TABLE 테이블명(
# 컬럼명1 컬럼데이터타입,
# 컬럼명2 컬럼데이터타입,
# );

# 테이블명, 컬럼명: (Upper/lower) snake case
# UPPER_SNAKE_CASE
# lowe_snake_case

CREATE TABLE my_table1
(
    address varchar(30),
    city    varchar(50),
    country varchar(20)
);

INSERT INTO my_table1(address, city, country)
VALUES ('신촌', '서울', '한국');

SELECT *
FROM my_table1;

DESCRIBE my_table1;
DESC my_table1;

# my_table2 만들기
# name varchar(30), age varchar(30) 컬럼
# desc 테이블 확인
# insert 레코드 추가
# select 조회
CREATE TABLE my_table2
(
    name varchar(30),
    age  varchar(20)
);

DESC my_table2;

INSERT INTO my_table2(name, age)
VALUES ('kangin', '24');

SELECT *
FROM my_table2;




