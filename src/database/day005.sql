drop database if exists mydb0210;
create database mydb0210;
use mydb0210;

create table table1(
	num_pk int , constraint primary key(num_pk)
);
create table table2(
	no_pk int , 
    constraint primary key(no_pk),
    num_fk int,
    constraint foreign key(num_fk) references table1(num_pk)
);
insert into table1 values (1) , (2) , (3) , (4) , (5); -- pk 5개
insert into table2 values (1 , 1) , (2 , 2) , (3 , 1) , (4 , 1) , (5 , 2); -- fk 5개

select*from table1;
select*from table2;

# 관계형데이터베이스(RDMS) 정규화(테이블 나는 과정): 테이블 분해 과정 -- 뭔지 모르겟음
# 조회(select) 하는 과정에서 다시 테이블들을 합치기(생성x조회o)
# 즉] 정규화가 많아지면(테이블을 너무 나누다 보면) 조회가 복잡하다. vs. 반정규화(테이블 나누지 않는 과정. 최소한의 중복을 허용한다.)는 조회가 간소화된다.

# 1. 두 개 이상의 테이블을 같이 조회하기
select * from table1, table2; -- 25개. 하나의 레코드가 다른 테이블의 모든 레코드를 표현한다.
-- table1(5개 레코드) table2(5개 레코드) 조회시 10개가 아닌 25개가 조회된다. 5*5
-- 주의할 점: 두 테이블 이상 조회 시 데카르트곱으로 표현한다.

# 2. 교집합/내부조인(INNER JOIN): 두 테이블 간의 공통된 값 기준으로 레코드 조회
# 2-1) where절 이용한 pk속성값과 fk속성값이 같으면 교집합 구할 수 있음. -- 일반 조건과 구분이 어렵기 때문에 권장하진 않는다.
select*from table1 , table2 where table1.num_pk = table2.num_fk; -- 5개. 교집합. 
# 2-2) inner join on 절: `from 테이블명A inner join 테이블B on 테이블명A.pk속성명 = 테이블명B.FK속성명` -- 표준.
select*from table1 inner join table2 on table1.num_pk = table2.num_fk;
-- select*from table1 inner join table2 inner join table3 on table1.num_pk = table2.num_fk; -- inner join 더 써도 됨.
# 2-3) join on 절 
# 주의할 점: 테이블명과 속성명에 띄어쓰기 금지. 띄어쓰기는 별칭 as
select*from table1 as t1 join table2 as t2 on t1.num_pk = t2.num_fk;
# 2-4) natural join 절 (가장 쉬움) , **전제 조건: pk와 fk 속성명이 같다. 전제 조건이 필요하다.** -- 간단한 거 할 때만 좋음.
-- select*from table1 t1 natural join table2 t2; -- 조인 조건 생략 가능. (지금은 전제조건 안 맞아서 안 됨)
# 2-5) join using 절 : using( 속성명 ), 전제조건: pk속성명과 fk속성명이 같다는 조건
select*from table1 t1 join table2 t2 using( num );

# 3. 외부조인(OUTER JOIN): OUTER JOIN ON 절. *OUTER 생략 가능.*
# 3-1) 왼쪽 테이브르이 모든 레코드 조회 + 오른쪽 테이블의 교집합 레코드 조회. 없으면 null.
select*from table1 t1 left outer join table2 t2 on t1.num_pk = t2.num_fk;
# 3-2) 오른쪽 테이블의 모든 레코드 조회 + 왼쪽 테이블의 교집합 레코드 조회. 없으면 null. 
select*from table1 t1 right outer join table2 t2 on t1.num_pk = t2.num_fk;

# 4. 합집합 , MySQL과 ORACLE은 다르다. 
-- MySQL: UNION(중복 레코드 제외하고 레코드 합쳐줌.) / ORACLE: FULL OUTER JOIN
select*from table1 t1 left join table2 t2 on t1.num_pl = t2.num_fk
	union 
    select*from table1 t1 right join table2 t2 on t1.num_pk = t2.num_fk;
    
# 5. 차집합 (교집합 제외한 레코드)
# 왼쪽 테이블의 차집합 
select t1.* from table1 t1 left join table2 t2 on t1.num_pk = t2.num_fk where t2.num_fk is null; -- is null : 교집합이 아니면 (겹치는 거 없으면)
# 오른쪽 테이블의 차집합
select t2.* from table1 t1 right join table2 t2 on t1.num_pk = t2.num_fk where t1.num_pk is null;
-- 이 두 개 합치면 교집합 제외한 모든 것.
