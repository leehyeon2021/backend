-- 아래 샘플 SQL 전체 실행 : ctrl+shift+enter
DROP DATABASE IF EXISTS practice4;
CREATE DATABASE practice4;
USE practice4;

-- 1. 도서 테이블
CREATE TABLE books (
    book_id      INT NOT NULL,                   -- 도서번호
    title        VARCHAR(50) NOT NULL,           -- 제목
    author       VARCHAR(20) NOT NULL,           -- 저자
    genre        VARCHAR(10) NOT NULL,           -- 장르
    price        INT NOT NULL,                   -- 가격
    stock        INT,                            -- 재고
    pub_date     DATE,                           -- 출판일
    CONSTRAINT PRIMARY KEY (book_id)           -- 기본키 제약조건
);
select * from books;

-- 2. 주문 테이블
CREATE TABLE orders (
    order_id     INT AUTO_INCREMENT,             -- 주문번호
    book_id      INT NOT NULL,                   -- 도서번호 (FK)
    customer     VARCHAR(20) NOT NULL,           -- 고객명
    order_qty    INT NOT NULL,                   -- 주문수량
    order_date   DATE,                           -- 주문일
    CONSTRAINT PRIMARY KEY (order_id),         -- 기본키 제약조건
    CONSTRAINT FOREIGN KEY (book_id) REFERENCES books(book_id) -- 외래키 제약조건
);
select*from orders;

-- 샘플 데이터 삽입
INSERT INTO books VALUES(1001, '혼공 SQL', '우재남', '컴퓨터', 22000, 15, '2020-01-01');
INSERT INTO books VALUES(1002, '이것이 자바다', '신용권', '컴퓨터', 30000, 30, '2018-05-20');
INSERT INTO books VALUES(1003, '불편한 편의점', '김호연', '소설', 14000, 5, '2021-04-20');
INSERT INTO books VALUES(1004, '달러구트 꿈 백화점', '이미예', '소설', 13800, 25, '2020-07-08');
INSERT INTO books VALUES(1005, '트렌드 코리아 2023', '김난도', '경제', 19000, 50, '2022-10-05');
INSERT INTO books VALUES(1006, '원씽(The One Thing)', '게리 켈러', '자기계발', 14000, 12, '2013-08-20');
INSERT INTO books VALUES(1007, '역사의 쓸모', '최태성', '역사', 16000, 0, '2018-11-26');
INSERT INTO books VALUES(1008, '파친코', '이민진', '소설', 15800, 3, '2022-07-14');
INSERT INTO books VALUES(1009, 'Do it! 점프 투 파이썬', '박응용', '컴퓨터', 18800, NULL, '2019-06-20');
INSERT INTO books VALUES(1010, '코스모스', '칼 세이건', '과학', 19500, 8, '2006-12-20');
INSERT INTO books VALUES(1011, '혼공 JAVA', '우재남', '컴퓨터', 24000, 17, '2019-01-01');

INSERT INTO orders VALUES(NULL, 1001, '김민준', 2, '2023-01-15');
INSERT INTO orders VALUES(NULL, 1002, '이서연', 1, '2023-01-18');
INSERT INTO orders VALUES(NULL, 1003, '박지훈', 1, '2023-02-01');
INSERT INTO orders VALUES(NULL, 1004, '김민준', 3, '2023-02-05');
INSERT INTO orders VALUES(NULL, 1005, '최수아', 1, '2023-02-11');
INSERT INTO orders VALUES(NULL, 1001, '박지훈', 1, '2023-02-12');
INSERT INTO orders VALUES(NULL, 1008, '이서연', 2, '2023-03-02');
INSERT INTO orders VALUES(NULL, 1009, '정현우', 5, '2023-03-05');
INSERT INTO orders VALUES(NULL, 1002, '김민준', 2, '2023-03-10');
INSERT INTO orders VALUES(NULL, 1006, '최수아', 1, '2023-04-01');
INSERT INTO orders VALUES(NULL, 1003, '박지훈', 3, '2023-04-02');
INSERT INTO orders VALUES(NULL, 1001, '이서연', 1, '2023-04-08');
INSERT INTO orders VALUES(NULL, 1005, '김민준', 2, '2023-04-15');
INSERT INTO orders VALUES(NULL, 1004, '정현우', 1, '2023-04-20');
INSERT INTO orders VALUES(NULL, 1008, '최수아', 1, '2023-05-01');
INSERT INTO orders VALUES(NULL, 1010, '박지훈', 2, '2023-05-05');
INSERT INTO orders VALUES(NULL, 1002, '최수아', 1, '2023-05-12');
INSERT INTO orders VALUES(NULL, 1006, '이서연', 2, '2023-05-20');
INSERT INTO orders VALUES(NULL, 1009, '김민준', 1, '2023-06-01');
INSERT INTO orders VALUES(NULL, 1001, '정현우', 3, '2023-06-07');
INSERT INTO orders VALUES(NULL, 1003, '이서연', 2, '2023-06-15');
INSERT INTO orders VALUES(NULL, 1005, '박지훈', 1, '2023-07-01');
INSERT INTO orders VALUES(NULL, 1010, '김민준', 1, '2023-07-03');
INSERT INTO orders VALUES(NULL, 1004, '최수아', 2, '2023-07-10');

-- [문제 1] orders 테이블에서 고객(customer) 목록을 중복 없이 조회하는 SQL을 작성하세요. (GROUP BY 사용)
select customer from orders group by customer;
-- select distinct customer from orders; 이것도 됨~~

-- [문제 2] books 테이블에서 장르(genre) 목록을 중복 없이 조회하는 SQL을 작성하세요.
select genre from books group by genre;

-- [문제 3] orders 테이블에서 도서번호(book_id)별 주문이 존재하는 도서 목록을 조회하세요. (중복 제거)
select book_id , sum(order_qty) as qty from orders group by book_id having qty > 0;
-- 아닌가봄 ㅠㅠ
select book_id from orders group by book_id; -- order 테이블에 있으니 이미 주문이 존재하는 것이었음... 이런!!

-- [문제 4] books 테이블에서 저자(author)별로 그룹화하여 저자 목록만 조회하세요.
select author from books group by author;

-- [문제 5] orders 테이블에서 전체 주문 건수를 구하세요. (COUNT(*))
select count(*) from orders;

-- [문제 6] orders 테이블에서 전체 주문수량(order_qty)의 합계를 구하세요. (SUM())
select sum(order_qty) from orders;

-- [문제 7] books 테이블에서 도서 가격(price)의 평균을 구하세요. (AVG())
select avg(price) from books;

-- [문제 8] books 테이블에서 최고가/최저가 도서 가격을 각각 구하세요. (MAX(), MIN())
select max(price), min(price) from books;

-- [문제 9] books 테이블에서 재고(stock)가 NULL이 아닌 도서 수를 구하세요. (COUNT(stock))
select COUNT(stock) from books;
-- 다른 방법
select count(*) from books where stock is not null;

-- [문제 10] orders 테이블에서 고객별 주문 건수를 조회하세요. (customer, count)
select customer, count(order_qty) from orders group by customer;
select customer as 고객, count(order_qty) as 주문건수 from orders group by customer;

-- [문제 11] orders 테이블에서 도서번호(book_id)별 총 주문수량 합계를 조회하세요. (book_id, sum)
select book_id , sum(order_qty) from orders group by book_id;

-- [문제 14] orders에서 고객별 총 주문수량 합계가 5 이상인 고객만 조회하세요.
-- 출력: customer, 총주문수량
-- 조건: HAVING 사용
select customer , sum(order_qty) as 총주문수량 from orders group by customer having 총주문수량 >= 5;

-- [문제 15] orders에서 도서번호(book_id)별 주문 건수가 3회 이상인 도서만 조회하세요.
-- 출력: book_id, 주문건수
-- select book_id , sum(order_qty) as 주문건수 from orders group by book_id having 주문건수 >=3; 	-- 누적 판매량 (한 명이 3개 삼 -> 3)
select book_id , count(order_qty) as 주문건수 from orders group by book_id having 주문건수 >=3; 		-- 주문 건수   (한 명이 3개 삼 -> 1)

-- [문제 17] books 테이블에서 가격(price) 내림차순으로 정렬하여 조회하세요.
select * from books order by price desc;

-- [문제 18] books 테이블에서 가격(price) 내림차순 정렬 후 상위 3권만 조회하세요. (ORDER BY + LIMIT)
select * from books order by price desc limit 3;
