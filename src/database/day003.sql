-- 조작어 배우기 --

drop database if exists mydb0204;
create database mydb0204;
use mydb0204;

create table test(
	mno int auto_increment,
    constraint primary key(mno),
    mname varchar(30) not null unique,
	mcount int default 2
);
/* 
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
set SQL_SAFE_UPDATES = 1; -- 활성화
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
-- 3. 