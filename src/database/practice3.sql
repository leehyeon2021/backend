/*[실습] 제출용 */

-- 아래 샘플 SQL 전체 실행 : ctrl+shift+enter
DROP DATABASE IF EXISTS practice3;
CREATE DATABASE practice3;
USE practice3;

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

-- 2. 주문 테이블
CREATE TABLE orders (
    order_id     INT AUTO_INCREMENT,             -- 주문번호
    book_id      INT NOT NULL,                   -- 도서번호 (FK)
    customer     VARCHAR(20) NOT NULL,           -- 고객명
    order_qty    INT NOT NULL,                   -- 주문수량
    order_date   DATE,                           -- 주문일
    CONSTRAINT PRIMARY KEY (order_id),         -- 기본키 제약조건
    CONSTRAINT FOREIGN KEY (book_id) REFERENCES books(book_id) on update cascade on delete cascade -- 외래키 제약조건
);

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

-- [문제 1]books 테이블에 다음 정보를 가진 도서를 추가하세요.
-- book_id : 1012
-- title : 'MySQL 실습'
-- author : '김민수'
-- genre : '컴퓨터'
-- price : 17000
-- stock : 25
-- pub_date : '2023-03-01'
insert into books values( 1012 , 'MySQL 실습' , '김민수' , '컴퓨터' , 17000 , 25 , '2023-03-01');
select * from books;

-- [문제 2]books 테이블에 다음 정보를 가진 도서를 추가하세요.
-- book_id : 1013
-- title : '데이터베이스 개론'
-- author : '이영희'
-- genre : '컴퓨터'
-- price : 22000
-- stock : NULL
-- pub_date : '2022-09-10'
insert into books(book_id , title , author , genre , price , pub_date) values(1013 , '데이터베이스 개론' , '이영희' , '컴퓨터' , 22000 , '2022-09-10');
select * from books;

-- [문제 3]orders 테이블에 다음 정보를 가진 주문 데이터를 추가하세요.(※ order_id는 AUTO_INCREMENT)
-- book_id : 1002
-- customer : '최지훈'
-- order_qty : 1
-- order_date : '2023-08-15'
insert into orders(book_id , customer , order_qty , order_date)values(1002,'최지훈',1,'2023-08-15'); -- id는 자동이라 그냥 null로 두는구나
select*from orders;

-- [문제 4]books 테이블에서 book_id가 1004 인 도서의 price를 15000 으로 수정하세요.
update books set price = 15000 where book_id = 1004;
select*from books;

-- [문제 5]books 테이블에서 장르(genre)가 '소설' 인 도서의 price를기존 가격에서 2000원 인상하도록 수정하세요.(산술연산자 사용)
update books set price = price + 2000 where genre = '소설';
select*from books;

-- [문제 6]books 테이블에서 재고(stock)가 NULL인 도서의 stock 값을 0 으로 수정하세요.
update books set stock = 0 where stock is null;
select*from books;

-- [문제 7]orders 테이블에서 고객명(customer)이 '이서연' 인 주문 데이터를 모두 삭제하세요.
delete from orders where customer = '이서연';
select*from orders;

-- [문제 8]books 테이블에서 재고(stock)가 0 이하(<= 0) 인 도서를 삭제하세요.
delete from books where stock <= 0; -- 왜 안 됨 -> fk에 on update cascade on delete cascade 안 해서 그런 거였음. 참조한 외래키가 사라지면 곤란하니까...
select*from books;

-- [문제 9]orders 테이블에서 주문수량(order_qty)이 3 이상(>=) 인 주문 데이터를 삭제하세요.
delete from orders where order_qty >= 3;
select*from orders;

-- [문제 10]books 테이블에서 모든 도서의 모든 컬럼을 조회하세요.
select*from books;

-- [문제 11]books 테이블에서 title, price 컬럼만 조회하세요.
select title , price from books;

-- [문제 12]books 테이블에서 price가 20000 초과(>) 인 도서의 title, price를 조회하세요.
select title , price from books where price > 20000;

-- [문제 13]books 테이블에서 price가 15000 이상(>=) 이고 stock이 10 이상(>=) 인 도서의 title, price, stock을 조회하세요.
select title, price, stock from books where price >= 15000 and stock >= 10;

-- [문제 14] books 테이블에서 장르(genre)가 '컴퓨터' 또는 '경제' 인 도서의 title, genre를 조회하세요. (IN 연산자 사용)
select title , genre from books where genre = '컴퓨터' or genre = '경제';

-- [문제 15] books 테이블에서 장르(genre)가 '소설'이 아닌 도서의 모든 정보를 조회하세요. (NOT 사용)
select * from books where genre != '소설';

-- [문제 16] books 테이블에서 재고(stock)가 NULL인 도서의 title, stock을 조회하세요.(IS NULL 사용)
select title , stock from books where stock is null; -- 아까 다 0으로 바꾸고 지워서 없음.

-- [문제 17] books 테이블에서 재고(stock)가 NULL이 아닌 도서의 title, stock을 조회하세요. (IS NOT NULL 사용)
select title , stock from books where stock is not null;

-- [문제 18]books 테이블에서 price가 14000 ~ 18000 사이인 도서의 title, price를 조회하세요. (BETWEEN 사용)
select title , price from books where price between 14000 and 18000;

-- [문제 19] books 테이블에서 도서명(title)에 '자'가 포함된 도서의 title, author를 조회하세요. (LIKE '%자%' 사용)
select title , author from books where title like '%자%'; -- where 속성명 like 라이크~~~

-- [문제 20] books 테이블에서 저자(author)가 '김'으로 시작하는 3글자인 도서의 title, author를 조회하세요. (LIKE '김__' 사용)
select title , author from books where author like '김__';

