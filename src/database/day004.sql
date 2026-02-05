drop database if exists mydb0205;
create database mydb0205;
use mydb0205;

-- 샘플 코드. 전체 실행 필요. --
# DB 생성
drop database if exists mydb0205;
create database mydb0205;
use mydb0205;

# 1. 회원 테이블 (member)
create table member(
 mid char(8) not null,   # 식별키 (최대 8자리)
    mname varchar(10) not null,  # 그룹명 (최대 10자리)
    mnumber int not null,   # 인원수
    maddr char(2) not null,   # 지역 (최대 2자리)
    mphone1 char(3),    # 지역번호
    mphone2 char(8),    # 전화번호
    mheight smallint,    # 평균키
 mdebut date,     # 데뷔일 (yyyy-mm-dd)
    constraint primary key (mid)
);

# 2. 구매 테이블 (buy)
create table buy(
 bnum int auto_increment,   # 구매번호 (자동증가)
    mid char(8),     # 구매자 (FK)
    bpname char(6) not null,  # 제품명
    bgname char(4),     # 분류명
    bprice int not null,   # 가격
    bamount smallint not null,  # 구매수량
    constraint primary key(bnum),
    constraint foreign key (mid) references member(mid)
);

# 샘플 데이터
INSERT INTO member VALUES
('TWC','트와이스',9,'서울','02','11111111',167,'2015-10-19'),('BLK','블랙핑크',4,'경남','055','22222222',163,'2016-08-08'),
('WMN','여자친구',6,'경기','031','33333333',166,'2015-01-15'),('OMY','오마이걸',7,'서울',NULL,NULL,160,'2015-04-21'),
('GRL','소녀시대',8,'서울','02','44444444',168,'2007-08-02'),('ITZ','잇지',5,'경남',NULL,NULL,167,'2019-02-12'),
('RED','레드벨벳',4,'경북','054','55555555',161,'2014-08-01'),('APN','에이핑크',6,'경기','031','77777777',164,'2011-02-10'),
('SPC','우주소녀',13,'서울','02','88888888',162,'2016-02-25'),('MMU','마마무',4,'전남','061','99999999',165,'2014-06-19');

INSERT INTO buy VALUES
(NULL,'BLK','지갑',NULL,30,2),(NULL,'BLK','맥북프로','디지털',1000,1),
(NULL,'APN','아이폰','디지털',200,1),(NULL,'MMU','아이폰','디지털',200,5),
(NULL,'BLK','청바지','패션',50,3),(NULL,'MMU','에어팟','디지털',80,10),
(NULL,'GRL','혼공SQL','서적',15,5),(NULL,'APN','혼공SQL','서적',15,2),
(NULL,'APN','청바지','패션',50,1),(NULL,'MMU','지갑',NULL,30,1),
(NULL,'APN','혼공SQL','서적',15,1),(NULL,'MMU','지갑',NULL,30,4);

# 샘플 확인
select * from member;
select * from buy;
-- 샘플 --

# 1. 테이블에서 그룹절: `group by` 절 , 같은 종류 끼리. (주로 집계 함수랑 사용한대.)
# `select 속성명 from 테이블명 group by 그룹기준;`
# 주의할 점: select * from buy group by bpname 불가능. select 때문에.
	# 그룹 기준 외 다른 속성들에 대해 어떻게 보여줄지 정의 안 됨. ( 조회 결과는 무조건 표/테이블. ) 
	# 뭔 소리야 -> 속성을 하나로 정해서 표/테이블로 보여줘야 하는데 여러 개 선택해버리면(공통적 속성이 아니면) 그룹지을 수 없다. 
-- SELECT * FROM buy GROUP BY bpname; -- 오류남
SELECT bpname FROM buy GROUP BY bpname; -- 근데 이거 할 거면 distinct 사용하는 게 더 낫대... 뭔소린지 모르겠지만 일단 중복이 제거된다는 뜻인가봄(그룹명나누듯하나씩만가져가나봄)

# 2. 집계 함수 ( 이것도 표/테이블로 나옴. select 단위는 표/테이블이라는 걸 잊지 말기~~ )
select sum( bamount ) from buy; -- buy 테이블 내 bamount 속성값 들의 전체 합계
select avg( bamount ) from buy; -- buy 테이블 내 bamount 속성값 들의 전체 평균
select max( bamount ) from buy; -- buy 테이블 내 bamount 속성값 들의 전체 중 최댓값
select min( bamount ) from buy; -- buy 테이블 내 bamount 속성값 들의 전체 중 최솟값
select count( bamount ) from buy; -- buy 테이블 내 bamount 속성값 들의 전체 레코드 수 ( null 제외 )
select count( * ) from buy; -- buy 테이블 내 bamount 속성값 들의 전체 레코드 수 ( null 포함 ) -- * 이걸 와일드카드라고 하나봐~~

# 3. 그룹절과 집계 함수
#    1. 회원 아이디별 구매 수량 합계
select * from buy;										-- buy 테이블 전체 조회한다.
select * from buy group by mid;							-- buy 테이블 mid 기준으로 그룹짓는다.
select mid , sum( bamount ) from buy group by mid; 		-- buy 테이블 mid 기준으로 그룹지어 bamount 총 합계를 구한다.
#    2. 회원 아이디별 총 구매금액( 구매수량 * 구매가격 )
select mid , sum( bamount * bprice ) from buy group by mid;
#    3. 총 판매 횟수 , 회원아이디별로 판매 횟수
select count(*) from buy;
select mid , count(*) from buy group by mid;

# 4. having : 그룹절의 조건절 ( where: 그룹하기 전에 넣는 조건 vs. having: 그룹한 후에 넣는 조건 )
#    1. 그룹 전 조건 (where)
select * from buy where bamout > 3; -- 그룹짓기 전에. 구매수량(그룹 전에 존재하는 속성)이 3 이상인
#    2. 그룹 후 조건 (having)
select mid , sum( bamount * bprice) as 총구매금액 
	from buy group by mid 
	having 총구매금액 > 1000; -- 총구매금액(그룹 후에 존재하는 속성)이 1000 이상인
-- select 속성명 from 테이블명 where 일반조건절 group by 그룹기준 having 그룹조건절;  -- 작성 순서 정해져있음. / +) 컴퓨터 처리 순서는 from > where > group by > having .

# 5. order by : 정렬 , asc 오름차순(기본값) , desc 내림차순. (하루 바뀌면 +1)
select * from member order by mdebut asc; -- 과거 날짜부터
select * from member order by mdebut desc; -- 최근 날짜부터
	# 주의할 점: 다중정렬 - order by 1차정렬기준 , 2차정렬기준
    # -> 1차 정렬 후 동일한 값 끼리의 2차 정렬 실행.
	# 뭔소리야 -> 1차정렬: 1차로 maddr(주소) 정렬한 후 -> 2차정렬: 2차로 동일한 maddr(주소)끼리 mdebut(날짜) 정렬한다.
		# 1차 정렬: 전남 서울(3) 서울(1) 서울(2) 경기 -> 2차 정렬: 전남 서울(1) 서울(2) 서울(3) 경기
		# 만약 주소값이 다 다르다면 정렬하는 의미가 없기 때문에 그 점을 유의하기. 
select * from member order by maddr desc , mdebut asc; -- 다중정렬

# 6. limit : 조회 결과에 제한 두기. 검색/페이징에서 사용. (cf: 페이징 vs. 무한스크롤)
-- `limit 시작번호 , 개수`
select * from member limit 2; 		-- 조회 결과 중 위에서 2개만 조회한다.
select * from member limit 0 , 2;	-- 조회 결과 중 0(첫번째레코드) 부터 2개 조회한다. 0부터 2.
select * from member limit 0 , 5;	-- 1페이지에서 5개 조회 (1페이지)
select * from member limit 5 , 5;	-- 2페이지에서 5개 조회 (2페이지)

# ⭐ select 작성 규칙/순서
-- `select 속성명 from 테이블명 where 일반조건 group by 그룹기준 having 그룹조건 order by 정렬기준 limit 개수조건;`
# ⭐ select 처리 순서
-- from -> where -> group by -> having -> order by -> limit 