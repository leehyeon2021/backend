create database mydb0203; -- db생성
use mydb0203; -- db활성화/선택/사용

-- 1. 테이블 생성
-- create table 테이블명( 속성명 타입 제약조건 , 속성명 타입 제약조건 );
-- 똑같은 이름으로 테이블 생성 불가능. 두 번 실행했다고 두 개 만들어지는 거 아님. 한 번 만들어지고 그 다음부턴 오류남.
create table test1(속성명 int);

-- 2. 테이블 목록 보기
-- show tables;
show tables;
-- 2개 이상의 속성명 정의한 테이블 가능.
-- 속성마다 쉼표로 구분해야 한다.
create table test2(속성명1 int , 속성명2 double);

-- 3. 테이블 삭제
-- drop table test1;
-- 그런데 뭔가 삭제할 때는 if exists 사용을 권장한다.
-- drop table/database if exists 테이블/데이터베이스명
drop table if exists test1;

-- 4. 테이블 간단 조회.
-- select 속성명1 , 속성명2 from 테이블명;
-- select * from 테이블명; select* <- 모두 선택한다. from 테이블명; <- 테이블명에서
select * from test2;

-- 5. 다양한 데이터타입의 테이블 생성 (외우지 말고 검색해서 사용하라고 하심)
create table test3(
	정수속성1 tinyint , 정수속성2 smallint , 정수속성3 mediumint ,
    정수속성4 int , 정수속성5 bigint , 정수속성6 int unsigned , -- signed 부호 있는(+-) , unsigned(부호 없음) unsigned를 사용하여 효율을 높이자. 정수만 사용할 거면 unsigned를 사용하자.
    
    실수속성1 float , 실수속성2 double , 실수속성3 decimal , -- decimal 문자 타입으로 실수표현. (오차x. 부동소수점 사용하지 않는다.)
    
    날짜속성1 date , 날짜속성2 time , 날짜속성3 datetime ,
    
    문자속성1 char(5) , -- 고정길이의 문자 타입. char(5) -> "유재석" 저장 -> [유][재][석][][] 두 칸이 남는다.
    문자속성2 varchar(5) , -- 가변길이의 문자타입. varchar(5) -> "유재석" 저장 -> [유][재][석] x x 남은 두 칸은 삭제한다.
    문자속성3 text , 문자속성4 longtext , -- longtext는 4G 대용량. 사용 자제하기...
    
    논리속성1 bool -- true or false. tinyint 취급. 1 or 0
); 
select * from test3;

-- * 방문록 기록하는 테이블 설계
create table comment(
	content varchar(255) , -- 내용물 최대 255글자
    writer varchar(20) -- 작성자 최대 20글자
);
select * from comment;
-- * 대기 명단 기록하는 테이블설계
create table waiting(
	count tinyint unsigned , -- 인원수 최대 정수 255까지. 원래(signed)는 -128~+127인데 unsignd이라서 정수로.
    phone char(13) -- 연락처 최대 13글자까지 고정길이 문자
);
select * from waiting;

-- 6. 제약조건: 테이블내 데이터들의 문제와 결함이 되는 입력 방지/해결
create table test4(
	# 속성명 타입 제약조건명
    속성명1 tinyint not null ,		-- not null : 해당 속성값들은 null 저장 불가능.
    속성명2 smallint unique , 		-- unique : 해당 속성값들은 중복이 불가능하다.
    속성명3 int default 10 , 			-- default 자료 : 만일 해당 속성에 초기값이 생략되면 기본값 자료 사용한다.
    속성명4 bigint auto_increment , 	-- auto_intrement : 만일 해당 속성의 초기값이 생략되면 자동으로 번호를 부여한다. 1~ (자바에서 번호 자동으로 붙여주던 거 같은 것)
												-- pk랑 같이 사용해야 한다.
    constraint primary key(속성명4)	-- 아래,위 거 PK 안 넣어서 실행 안 되는 바람에 일단 실행하려고 입력함.
    -- 속성명5 mediumint primary key		-- primary key : pk(식별/기본)키 , 식별가능한 고유 값을 가진 키.
													-- 중복없음! unique + 빈칸없음! not null <- 이 두 개가 기본으로 들어가있음. 주로 학번, 사번, 제품번호, 주민번호 등등에 들어감.    
    -- auto_increment primary key : 이렇게 많이 쓴다.
    -- 속성명5 mediumint primary key   vs.  constraint primary key ( PK속성명 ); <- constraint: '제약조건'이라는 뜻.
);

-- 7. 
create table test5(
	속성명1 bigint , 
	constraint foreign key(속성명1)references test4(속성명4) on update set null
    -- foreign key : fk(참조/외래키)
    -- constraint foreign key( PK속성명 ) references 테이블명( pk필드명 )		
    -- 중복가능, 빈칸가능.
	-- pk(1) : fk(n) 1 대 다 관계. 수강신청한학번(fk), 휴가신청한사번(fk), 구매한제품번호(fk)
    
    -- on update/deleate restrict : pk가 삭제/수정될 때 **fk가 참조 중이면** pk를 삭제/수정 불가능한 관계로 만들기. !! 자식이 있으면 부모 삭제 불가능. !! <- 기본값. (fk가 참조 중이 아니라면(자식없으면) 그냥 삭제 가능함.)
    -- on update/deleate cascade : pk가 삭제/수정될 때 fk도 같이 삭제되는 관계. !! 게시물 삭제되면 댓글도 같이 삭제된다. !!
    -- on update/deleate no action : 아무 것도 안 됨 (설명 그냥 넘어가심)
    -- on update/deleate set null : pk가 삭제/수정될 때 fk는 null 변경 관계. !! 게시물 삭제되면 댓글 참조는 null !!
);
select * from test4;
select * from test5;


-- ---------------------------------------
-- [ 회원제 게시판 설계 ] (자바로 했던 거)
-- 관례 순서
drop database if exists boardservice6; -- 이미 존재할 수 있으므로 데이터베이스 삭제
create database boardservice6; -- 데이터베이스 생성
use boardservice6; -- 데이터베이스 활성화/사용
create table member(
	# 회원번호. 정수타입. 자동번호 부여.
	mno int auto_increment ,
    # 회원하이디 , 문자타입(~30) , 빈칸불가능 , 중복불가능
    mid varchar(30) not null unique ,
    # 회원비밀번호 , 문자타입(~30) , 빈칸불가능
    mqw varchar(30) not null ,
    # 회원닉네임 , 문자타입(~10)
    mname varchar(10) ,
    # 회원 연락처 , 문자타입(13) 
    mphone char(13) , 
    # 회원번호를 pk(식별키)로 선정.
    constraint primary key( mno )
);
select * from member;
create table product(
	pno int auto_increment ,
    pname varchar(100) not null unique , 
	pprice int unsigned default 0 , -- 가격이므로 음수는 필요 없어서 unsigned , 초기값 생성시 0
    pcomment longtext , -- 최대 4G 가능한 문자타입
    pdate datetime default now() , -- 날짜/시간타입 , 기본값을 현재시스템 날짜/시간 자동 부여 -- 등록날짜 !!올
    mno int , -- FK로 사용할 필드명의 타입은 PK 필드명과 일치. 필드/속성명 일치 권장.
    -- on deleate casecade 회원이 탈퇴하면 그 회원의 제품도 삭제된다.
    constraint primary key(pno) , -- pno속성에 pk를 설정하겠다.
    constraint foreign key(mno) references member(mno) on delete cascade
);
select * from product;

-- --------------------------------
-- ER 다이어그램 : 여러 테이블 들 간의 관계를 시각적으로 파악하기 위한 것. // 원래는 다이어그램 만든 후에 db 다뤄야 함.alter
-- ERD 다이어그램: 데이터베이스 테이블 간의 관계를 시각적으로 나타낸 것.
-- 상단의 'Database' -> Reverse Engineer(ctrl+R) -> 로컬에서 원하는 DB 선택하여 생성.