# (INNER) JOIN
# LEFT (OUTER) JOIN
# RIGHT (OUTER) JOIN
# FULL (OUTER) JOIN : mariaDB에는 없음 but UNION으로 대체 가능

# UNION
USE mydb2;

CREATE TABLE table10
(
    col1 INT1
);
CREATE TABLE table11
(
    col_a INT
);
INSERT INTO table10
VALUES (3),
       (4),
       (4),
       (5);
INSERT INTO table11
VALUES (3),
       (4),
       (7);

SELECT *
FROM table10
UNION
-- 중복된 값이 있을 수 없다
SELECT *
FROM table11;

# LEFT JOIN
SELECT *
FROM table10
         LEFT JOIN table11
                   ON col1 = col_a
UNION
#RIGHT JOIN
SELECT *
FROM table10
         RIGHT JOIN table11
                    ON col1 = col_a;

# INNER JOIN
SELECT *
FROM table10
         JOIN table11 ON col1 = col_a;


# UNION ALL
# LEFT JOIN
SELECT *
FROM table10
         LEFT JOIN table11
                   ON col1 = col_a
UNION ALL
#RIGHT JOIN
SELECT *
FROM table10
         RIGHT JOIN table11
                    ON col1 = col_a;
