-- 조작어 , 연산자 --

drop database if exists mydb0204;
create database mydb0204;
use mydb0204;

create table test(
	mno int auto_increment,
    constraint primary key(mno),
    mname varchar(30) not null unique,
	mcount int default 2
);
/* DML 조작어
- DML: 조작어 (실제로는 MySQL이 아니라 DAO에서 실행한다.)
   1. INSERT (저장)
      : 레코드/행/튜플(DTO1개) 삽입 (가로)
   2. SELECT (조회)
	  : 레코드 조회.
      - 주의: 조회 결과 테이블과 원본 테이블은 상관없다. (단순 조회. 수정/삭제가 불가능하다는 걸 말씀하시는 것 같음.)
   3. UPDATE (수정)
      : 레코드의 값 수정.
      - 주의: mysql workbench의 safeMode를 해제해야 한다. (자바에서는 상관 없음.)
         - 수정과 삭제는 위험하므로 workbench에서는 수정/삭제 차단 상태. 
         해제 방법: `set SQL_SAFE_UPDATES = 0;`
         활성화 방법: `set SQL_SAFE_UPDATES = 1;`
   4. DELETE (삭제)
      : 레코드 삭제.
      - 주의: delete는 레코드 삭제 vs. truncate는 모든 레코드 삭제 vs. drop은 테이블/데이터베이스 삭제.
*/
# (1. insert)
-- 1. `insert into 테이블명( 속성명1 , 속성명2 ) values( 값1 , 값2 );`
insert into test( mno , mname , mcount) values( 1 , "유재석" , 30 );
-- 2. 속성명의 순서와 대응하는 값은 위치가 일치해야 한다.
insert into test(mcount , mname , mno) values( 40, "강호동" , 2);
-- 3. auto_increment는 생략해도 된다.
insert into test( mname , mcount ) values( "하하" , 50 );
-- 4. default 기본값 있으므로 생략해도 된다.
insert into test( mname ) values( "홍길동" );
-- 5. not null 제약조건 속성은 꼭 삽입 자료가 존재해야 한다.
 -- `insert into test( mno , mcount ) values( 5 , 23 );` -- 오류 발생
-- 6. unique 제약조건 속성은 중복값이 불가능하다.
 -- `insert into test( mname ) values( "유재석" );` -- 오류 발생
-- 7. 모든 속성에 대해 값을 삽입할 경우 속성명 생략 가능하다. 값 대응시 속성명 순서가 일치해야 한다.
insert into test values( 5 , "심사임당" , 60 ); -- 모든 속성을 삽입할 경우엔 속성명 생략해도 됨~~
-- 8. 하나의 명령어에서 다수 레코드를 삽입할 때는 `values( 레코드1 ) , ( 레코드2 ) , ( 레코드3 );`
insert into test values( 6 , "김만덕" , 70 ) , ( 7 , "박 씨 부인" , 31 ) , ( 8 , "나" , 65 );
select * from test;

# (2. select)
-- 1. `select * from 테이블명;`
select * from test;
-- 2. `selct 속성명1 , 속성명2 , 속성명3 from 테이블명;` -> 원래는 * 아니고 속성명 다 써야 함
select mname , mcount from test;
-- 3. `selct 속성명 from 테이블명 where 조건절;`
select * from test where mname = "유재석";	-- SQL 주의: SQL에서는 =를 같다는 기호로 사용. vs. 프로그래밍언어는 =를 대입이라는 기호로 사용.
select * from test where mcount >= 40; 		-- 조건절에서는 연산 이용한 조회가 가능하다.

# (3. update) (into 안 씀)
set SQL_SAFE_UPDATES = 0; -- 해제
-- set SQL_SAFE_UPDATES = 1; -- 활성화
-- 1. 전체수정: `update 테이블명 set 수정할속성명 = 수정할값 , 수정할속성명2 = 수정할값;` <- 조건 안 들어가면 전체 수정 됨...
update test set mcount = 0; -- where조건이 없으면 전체 수정 됨.
-- 2. 조건수정: 일반적으로 전체수정이 아니라 조건 수정을 한다. `update 테이블명 set 수정할속성명 = 수정할값 , 수정할속성명2 = 수정할값 where 조건;`
update test set mcount = 10 where mname = "유재석"; -- mname 속성값이 "유재석"이면 mcount 속성값을 10으로 변경해라.
update test set mcount = 20 , mname = "강호동2" where mno = 2; -- mno 속성값이 2이면 mcount 속성값을 20, mname 속성값을 "강호동2"로 변경해라.

# (4. delete)
-- 1. 조건삭제: delete from 테이블명 where 조건;
delete from test where mno = 2; -- mno속성값이 2이면 (강호동레코드)를 삭제해라.
-- 2. 전체삭제: delete from 테이블명;
delete from test;	 -- 조건이 없으므로 모든 레코드 삭제.	DML이라서 취소 가능.
truncate table test; -- 해당 테이블의 모든 레코드 삭제.		DDL이라서 취소 불가능.
drop table test;	 -- 해당 테이블 삭제

/*
- DDL: 데이터베이스 정의 언어
   - 뒤로가기(롤백 = 트랜젝션) 불가능.
   - 예) `create` , `drop` , `truncate`
- DML: 데이터베이스 조작 언어
   - 뒤로가기(롤백 = 트랜젝션) 가능.
   - 예) `insert` , `select` , `update` , `delete`
- DCL: 데이터베이스 관리 언어? (나중에 배움)
*/

-- ------------------------------------------------------------------------
-- ------------------------------------------------------------------------
/* 연산자
1. 산술 연산자
   : +더하기 -빼기 *곱하기 /나누기  div몫  mod나머지 (뒤에 두 개는 회사마다 다르대)
   - ⚠️ 주의: 결과는 항상 표/테이블 단위로 나온다.⚠️
   `select (산술가능) from 테이블명 where (산술가능)`
   
2. 비교 연산자
    : >초과 >=이상 <미만 <=이하 =같다 !=같지않다
   `select 속성명 from 테이블명 where (비교가능)`
   
3. 논리 연산자
    : and이면서 or이거나 not부정
   `select 속성명 from 테이블 where (논리가능)`

4. 기타 연산자
   `where 속성명 between 시작값 and 끝값;` <- mysql에선 가능
   `where 속성명 in( 값1 , 값2 , 값3);` <- mysql에선 가능

5. null 연산자
    : null(자료가 없다는 뜻.)은 비교 연산자가 별도로 존재한다. (`is null` , `is not null`)
   (x) select * from member where mphone1 = null; <-- null은 =같다 라는 비교가 불가능하다.
   (o) select * from member where mphone1 is null; <-- null은 is라는 연산자로 비교 가능.
   (o) select * from member where mphone1 is not null;
   
6. 문자 패턴 비교
   : `속성명 like '문자패턴';`
   - 검색 기능 만들 때 사용.
     1. `%` : 문자대응(개수 상관 없음)
     2. `_` : 문자대응(_개수 만큼 대응)
*/

-- 샘플 데이터 --
# SQL 연산자
# 1. 회원테이블
create table member(    # 아이돌 그룹
 mid char(8) not null ,   # 식별키   최대 8자리
    mname varchar(10) not null , # 그룹명  최대 10자리
    mnumber int not null ,   # 인원수  정수 +-21억정도
    maddr char(2) not null ,   # 지역  최대 2자리
    mphone1 char(3) ,    # 지역번호 최대 2자리
    mphone2 char(8) ,    # 전화번호  최대 8자리
    mheight smallint ,    # 평균키   정수 +-3만정도
 mdebut date ,     # 데뷔일   yyyy-mm-dd
    constraint primary key ( mid )    # 제약조건
);
# 2. 구매테이블
create table buy(
 bnum int auto_increment ,    # 구매번호 정수  자동번호 부여
    mid char(8),      # 구매자  FK
    bpname char(6) not null ,   # 제품명  최대 6자리
    bgname char(4) ,      # 분류명   최대 4자리
    bprice int not null ,    # 가격   정수
    bamount smallint not null ,   # 구매수량 정수
    constraint primary key(bnum) ,     # 제약조건
    constraint foreign key ( mid ) references member(mid) # 제약조건
);
# 샘플데이터
INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015.10.19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016.08.08');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015.01.15');
INSERT INTO member VALUES('OMY', '오마이걸', 7, '서울', NULL, NULL, 160, '2015.04.21');
INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울', '02', '44444444', 168, '2007.08.02');
INSERT INTO member VALUES('ITZ', '잇지', 5, '경남', NULL, NULL, 167, '2019.02.12');
INSERT INTO member VALUES('RED', '레드벨벳', 4, '경북', '054', '55555555', 161, '2014.08.01');
INSERT INTO member VALUES('APN', '에이핑크', 6, '경기', '031', '77777777', 164, '2011.02.10');
INSERT INTO member VALUES('SPC', '우주소녀', 13, '서울', '02', '88888888', 162, '2016.02.25');
INSERT INTO member VALUES('MMU', '마마무', 4, '전남', '061', '99999999', 165, '2014.06.19');
INSERT INTO buy VALUES(NULL, 'BLK', '지갑', NULL, 30, 2);
INSERT INTO buy VALUES(NULL, 'BLK', '맥북프로', '디지털', 1000, 1);
INSERT INTO buy VALUES(NULL, 'APN', '아이폰', '디지털', 200, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '아이폰', '디지털', 200, 5);
INSERT INTO buy VALUES(NULL, 'BLK', '청바지', '패션', 50, 3);
INSERT INTO buy VALUES(NULL, 'MMU', '에어팟', '디지털', 80, 10);
INSERT INTO buy VALUES(NULL, 'GRL', '혼공SQL', '서적', 15, 5);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 2);
INSERT INTO buy VALUES(NULL, 'APN', '청바지', '패션', 50, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 1);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 4);
-- 샘플 데이터 end --

# 1. 별칭 키워드: `as`
-- : 조회 결과의 속성명 변경, as는 생략 (띄어쓰기를 대신 해야 함) 가능하다.
--   속성명/테이블명이 길거나 복잡한 경우에 사용한다.
select mid from member; -- select 속성명 from 테이블명;
select mid as 회원아이디 from member;  -- 'mid' 속성명에게 '회원아이디'라는 별칭을 지어준다.
select mid 회원아이디 from member;
select mid from member as m;		-- 'min' 테이블명에게 'm'이라는 별칭을 지어준다.
select mid from member m;

# 2. 중복 제거: distinct (별개의, 뚜렷한)
-- : 속성명/속성값이 중복인 레코드를 제거할 때 사용
select distinct maddr as 주소 from member; -- 회원테이블 주소 속성값의 중복을 제거(distinct)해서 조회(select)한다.

# 3. 산술 연산자
select mnumber + 3 as 더하기 from member; -- 기존 거에 +3 됨.
select mnumber + 3 as 더하기 , mnumber - 3 as 빼기 , mnumber / 3 as 나누기 ,
	mnumber * 3 as 곱하기 , mnumber div 3 as 몫 , mnumber mod 3 나머지 
	from member;

# 4. 비교 연산자
select * from member where mname = "블랙핑크"; 					-- = 같다. 대입아님...
select * from member where mnumber = 4;
select * from member where mnam != "블랙핑크";					-- != 같지않다
select * from member where not mname = "블랙핑크";				-- not 비교 연산
select * from member where mheight <= 162;						-- <= 이하
select * from member where mheight >= 165 and mheight <=170;	-- and 이면서
select * from member where mheight between 165 and 170;			-- 속성명 between 시작값 and 끝값
select * from member where maddr = '경기' or maddr = 'wjsska';	-- or 이거나
select * from member where maddr in('경기' , '전남' , '경남');		-- in 하나라도 포함

# 주의할 점: null은 비교 연산자가 별도로 존재한다.
-- select * from member where mphone1 = null; <-- null은 =같다 라는 비교가 불가능하다.
select * from member where mphone1 is null; -- null은 is라는 연산자로 비교 가능.
select * from member where mphone1 is not null;

# 문자 패턴 비교: 속성명 like '문자패턴'
-- 1. % : 문자대응(개수 상관 없음) / 2. _ : 문자대응(_개수 만큼 대응)
select * from member where mname like "에이%";	-- mname 속성값이 '에이'로 시작하는 문자
select * from member where mname like "에이_";	-- mname 속성값이 '에이'로 시작하면서 3글자 문자(에 이 머시기).
select * from member where mname like "%핑크";	-- '핑크'로 끝나는 문자.
select * from member where mname like "%이%";	-- '이'가 들어가는 문자.
select * from member where mname like "_이%";	-- 두 번째 글자가 '이'인 문자.
