/*[실습] 제출용 */
-- 아래 문제는 'practice2' 데이터베이스 생성 후 진행 합니다.
create database practice2;
-- [문제 1]아래 조건에 맞는 members 테이블을 생성하는 SQL을 작성하세요.
-- 테이블명: members
-- 컬럼 정보
-- member_id (회원번호): 정수, Primary Key, 자동 증가
-- member_name (회원이름): 문자열(50), NULL 허용 안함
-- email (이메일): 문자열(100), Unique, NULL 허용 안함
-- join_date (가입일): 날짜/시간, Default 현재 날짜/시간
-- is_active (활성여부): 논리형(bool), Default true
create table members(
	member_id int auto_increment ,
    member_name varchar(50) not null ,
    email varchar(100) unique not null ,
    join_date datetime default now() ,
    is_active bool default true,
    constraint primary key(member_id)
);
select * from members;

-- [문제 2]
-- 아래 조건에 맞는 products 테이블을 생성하는 SQL을 작성하세요.
-- 테이블명: products
-- 컬럼 정보
-- product_id (상품번호): 정수, Primary Key, 자동 증가
-- product_name (상품명): 문자열(100), NULL 허용 안함
-- price (가격): 정수, unsigned, NULL 허용 안함
-- stock (재고수량): 정수, Default 0, NULL 허용 안함
-- created_at (등록일): 날짜/시간, Default 현재 날짜/시간
create table products(
	product_id int auto_increment ,
    product_name varchar(100) not null ,
    price int unsigned not null ,
    stock int default 0 not null ,
    created_at datetime default now() ,
    constraint primary key(product_id)
);
select * from products;

-- [문제 3]
-- 아래 조건에 맞는 orders 테이블을 생성하는 SQL을 작성하세요.
-- 테이블명: orders
-- 컬럼 정보
-- order_id (주문번호): bigint, Primary Key, 자동 증가
-- member_id (회원번호): 정수, Foreign Key → members(member_id)
-- order_date (주문일): 날짜/시간, Default 현재 날짜/시간
-- total_price (총금액): int unsigned, NULL 허용 안함
create table orders(
	order_id bigint auto_increment ,
    order_date datetime default now() ,
    total_price int unsigned not null ,
    constraint primary key(order_id),
    member_id int ,
    constraint foreign key(member_id) references members(member_id) 
);
select * from orders;

-- [문제 4]
-- 아래 조건에 맞는 order_items 테이블을 생성하는 SQL을 작성하세요.
-- 테이블명: order_items
-- 컬럼 정보
-- item_id (항목번호): 정수, Primary Key, 자동 증가
-- order_id (주문번호): bigint, Foreign Key → orders(order_id)
-- product_id (상품번호): 정수, Foreign Key → products(product_id)
-- quantity (수량): 정수, Default 1
-- price (단가): int unsigned, NULL 허용 안함
create table order_items(
	item_id int auto_increment ,
    constraint primary key(item_id),
    order_id bigint ,
    constraint foreign key(order_id) references orders(order_id) ,
    product_id int ,
    constraint foreign key(product_id) references products(product_id) ,
    quantity int default 1 ,
    price int unsigned not null
);
select * from order_items;

-- [문제 5]
-- 아래 조건에 맞는 students 테이블을 생성하는 SQL을 작성하세요.
-- 테이블명: students
-- 컬럼 정보
-- student_id (학번): 문자열(10), Primary Key
-- student_name (이름): 문자열(30), NULL 허용 안함
-- major (전공): 문자열(50)
-- grade (학년): tinyint unsigned
-- enrolled_date (입학일): date
create table students(
	student_id varchar(10) ,
    student_name varchar(30) not null ,
    major varchar(50) ,
    grade tinyint unsigned ,
    enrolled_date date ,
    constraint primary key(student_id)
);
select * from students;

-- [문제 6]
-- 아래 조건에 맞는 employees 테이블을 생성하는 SQL을 작성하세요.
-- 테이블명: employees
-- 컬럼 정보
-- emp_id (사번): int, Primary Key, 자동 증가
-- emp_name (이름): varchar(40), NULL 허용 안함
-- salary (급여): int unsigned, NULL 허용 안함
-- hire_date (입사일): date, NULL 허용 안함
-- department (부서): varchar(50)
create table employess(
	emp_id int auto_increment,
    emp_name varchar(40) not null ,
    salary int unsigned not null ,
    hire_date date not null ,
    department varchar(50) ,
    constraint primary key(emp_id)
);
select*from employess;

-- [문제 7]
-- 아래 조건에 맞는 boards 테이블을 생성하는 SQL을 작성하세요.
-- 테이블명: boards
-- 컬럼 정보
-- board_id (게시물번호): int, Primary Key, 자동 증가
-- title (제목): varchar(200), NULL 허용 안함
-- content (내용): text, NULL 허용 안함
-- writer_id (작성자회원번호): int, Foreign Key → members(member_id)
-- created_at (작성일): datetime, Default 현재 날짜/시간
create table boards(
	board_id int auto_increment ,
    title varchar(200) not null ,
    content text not null ,
    writer_id int,
    created_at datetime default now() ,
    constraint primary key(board_id) ,
    constraint foreign key(writer_id) references members(member_id)
);
select*from boards;

-- [문제 8]
-- 아래 조건에 맞는 comments 테이블을 생성하는 SQL을 작성하세요.
-- 테이블명: comments
-- 컬럼 정보
-- comment_id (댓글번호): int, Primary Key, 자동 증가
-- board_id (게시물번호): int, Foreign Key → boards(board_id)
-- writer_id (작성자회원번호): int, Foreign Key → members(member_id)
-- content (댓글내용): varchar(300), NULL 허용 안함
-- created_at (작성일): datetime, Default 현재 날짜/시간
create table comments(
	comment_id int auto_increment ,
    board_id int ,
    writer_id int ,
    content varchar(300) not null ,
    created_at datetime default now() ,
    constraint primary key(comment_id),
    constraint foreign key(board_id)references boards(board_id),
    constraint foreign key(writer_id)references members(member_id)
);
select*from comments;

-- [문제 9]
-- 아래 조건에 맞는 payments 테이블을 생성하는 SQL을 작성하세요.
-- 테이블명: payments
-- 컬럼 정보
-- payment_id (결제번호): bigint, Primary Key, 자동 증가
-- order_id (주문번호): bigint, Foreign Key → orders(order_id)
-- payment_amount (결제금액): int unsigned, NULL 허용 안함
-- payment_method (결제수단): varchar(30)
-- payment_date (결제일): datetime, Default 현재 날짜/시간
create table payments(
	payment_id bigint auto_increment, 
    order_id bigint ,
    payment_amount int unsigned not null ,
    payment_method varchar(30) ,
    payment_date datetime default now() ,
    constraint primary key(payment_id),
    constraint foreign key(order_id)references orders(order_id)
);
select*from payments;

-- [문제 10]
-- 아래 조건에 맞는 reviews 테이블을 생성하는 SQL을 작성하세요.
-- 테이블명: reviews
-- 컬럼 정보
-- review_id (리뷰번호): int, Primary Key, 자동 증가
-- product_id (상품번호): int, Foreign Key → products(product_id)
-- member_id (회원번호): int, Foreign Key → members(member_id)
-- rating (평점): tinyint unsigned, NULL 허용 안함
-- review_text (리뷰내용): text
-- created_at (작성일): datetime, Default 현재 날짜/시간
create table reviews(
	review_id int ,
    constraint primary key(review_id) ,
    product_id int ,
    constraint foreign key(product_id)references products(product_id) ,
    member_id int ,
    constraint foreign key(member_id)references members(member_id) ,
    rating tinyint unsigned not null ,
    review_text text ,
    created_at datetime default now()
);
select*from reviews;

