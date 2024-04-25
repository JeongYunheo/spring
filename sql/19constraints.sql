USE w3schools;

# 제약사항 constraints
# 특정 컬럼에 제약사항을 줌 (예: 꼭 값이 있어야함, 기본값, 중복불가 등 .. )

# NOT NULL: 꼭 값이 있어야 함
CREATE TABLE my_table11
(
    col1 VARCHAR(10),
    col2 VARCHAR(10) NOT NULL
);
DESC my_table11;
INSERT INTO my_table11
    (col1, col2)
VALUES ('value', 'value');
INSERT INTO my_table11
    (col2)
VALUES ('value');
INSERT INTO my_table11
    (col1)
VALUES ('value');

SELECT *
FROM my_table11;

SELECT *
FROM my_table11
WHERE col2 = 'value';
SELECT *
FROM my_table11
WHERE col1 = 'value';
# 해당 컬럼에 값이 없는 레코드 조회
SELECT *
FROM my_table11
WHERE col1 is null;

# 해당 컬럼에 값이 있는 레코드 조회
# NULL 과의 연산 결과는 모두 FALSE(<> , != 불가능)
SELECT *
FROM my_table11
WHERE col1 IS NOT NULL;

# my_table12 테이블 만들고 2개의 컬럼에 제약사항 NOT NULL 추가
CREATE TABLE my_table12
(
    col1 VARCHAR(10) NOT NULL,
    col2 VARCHAR(10) NOT NULL
);
DESC my_table12;

INSERT INTO my_table12
    (col1, col2)
VALUES ('lee', 'kangin');

INSERT INTO my_table12
    (col1)
VALUES ('lee');

SELECT *
FROM my_table12;
