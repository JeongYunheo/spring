USE w3schools;

# 문자열
# varchar(길이)
CREATE TABLE my_table3
(
    name  varchar(3),
    title varchar(5),
    notes VARCHAR(1000)
);
DESC my_table3;
INSERT INTO my_table3
    (name, title, notes)
VALUES ('이강인', '축구선수', '파리생제르망');
INSERT INTO my_table3
    (name, title, notes)
VALUES ('네이마르', '야구선수', '브라질');


# my_table4
# 책 제목, 내용, 저자
CREATE TABLE my_table4
(
    title   varchar(15),
    content varchar(10000),
    writer  varchar(5)
);
DESC my_table4;
INSERT INTO my_table4
    (title, content, writer)
VALUES ('로미오와 줄리엣', '매뇽루나ㅣㄻㅇㄹ마ㅓㅏㅓ모아ㅓ미ㅗㄹ', '셰익스피어');
SELECT *
FROM my_table4;


# 수
# 정수 INT
# 실수 DECIMAL, DEC(총 길이, 소수점 이하 길이)
CREATE TABLE my_table5
(
    age    INT,
    height DEC(5, 2)
);
DESC my_table5;
INSERT INTO my_table5
    (age, height)
VALUES (10, 170.25);
SELECT *
FROM my_table5;
INSERT INTO my_table5(age, height)
VALUES (10, 1000.25);
INSERT INTO my_table5(age, height)
VALUES (10, 170.333);
INSERT INTO my_table5(age, height)
VALUES (10, 170.339);
SELECT *
FROM my_table5;

# 새 테이블 my_table6
# 한개의 정수타입 컬럼과 , 한 개의 실수 타입 컬럼
# DESC 테이블, 레코드 추가, 조회
CREATE TABLE my_table6
(
    age    INT,
    weight DEC(5, 3)
);
DESC my_table6;
INSERT INTO my_table6(age, weight)
VALUES (24, 75);
INSERT INTO my_table6(age, weight)
VALUES (33, 90.963);
SELECT *
FROM my_table6;


# 날짜시간
# DATE : 날짜(YYYY-MM-DD)
# DATETIME : 날짜시간(YYYY-MM-DD HH:MM:SS)
CREATE TABLE my_table7
(
    col1 DATE,
    col2 DATETIME
);
DESC my_table7;
INSERT INTO my_table7
    (col1, col2)
VALUES ('2024-04-24', '2002-11-26 11:26:02');
SELECT *
FROM my_table7;


# my_table8번에 두 컬럼(DATE, DATETIME) 정의하고
# 레코드 넣고 조회
CREATE TABLE my_table8
(
    col1 DATE,
    col2 DATETIME
);
DESC my_table8;
INSERT INTO my_table8(col1, col2)
VALUES ('1998-02-19', '2002-11-26 08:05:30');
SELECT *
FROM my_table8;

CREATE TABLE my_table9
(
    string_col    VARCHAR(30),
    int_col       INT,
    dec_col       DEC(10, 2),
    date_col      DATE,
    date_time_col DATETIME
);
INSERT INTO my_table9(string_col, int_col, dec_col, date_col, date_time_col)
VALUES ('집에가고싶다 곱창먹으러', 10000, 72934.77, '2024-04-24', '1998-02-19 11:26:02');
SELECT *
FROM my_table9;

CREATE TABLE my_table10
(
    title     VARCHAR(30),
    name      VARCHAR(30),
    age       INT,
    price     DEC(10, 3),
    published DATE,
    inserted  DATETIME
);

INSERT INTO my_table10(title, name, age, price, published, inserted)
VALUES ('이것이 자바다', '신용권', 40, 3421.123, '1999-10-01', '1999-10-10 12:12:12'),
       ('스프링부트', '신용권', 40, 12345.123, '1888-10-10', '1888-12-12 12:12:10');


SELECT *
FROM my_table9;
SELECT *
FROM my_table10;
