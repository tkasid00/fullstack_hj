-- #1. 테이블 구조 확인
desc emp;
desc dept;

show user;  -- 현재 줄 드래그해서 선택 후 ctrl+enter
select table_name from user_tables  -- 현재 사용할 수 있는 테이블 확인 

-- #2. 전체 테이블 조회
select * from emp;

-- #3. 원하는 열 조회
select empno, ename from emp;
select ename, job from emp;

-- #4. 중복 제거(distinct)
select distinct job from emp;
select all job from emp;

-- #5. 연산 및 별칭
desc emp;

-- 3달치 급여
select ename "유저", sal as "월급", sal+sal+sal as "3달치월급" from emp;     -- 문자 오류나면 ""

-- #6. 정렬
select ename, sal 
from emp 
order by sal asc;  -- asc 오름차순

select ename, sal
from emp
order by sal desc; -- desc 내림차순

-- ## step3 연습문제
--https://sally03915.github.io/stackventure_250825/004_oracle/oracle002_select_basic#15

-- Q1. emp 테이블 구성
desc emp;

-- Q2.dept 테이블 구성
desc dept;

-- Q3.salgrade 테이블 구성
desc salgrade;

-- Q4. emp 테이블 전체 열 조회
select * from emp;

-- Q5. emp 테이블 empno, ename, deptno,  조회
select empno, ename, deptno from emp;

-- Q6. emp 테이블 deptno 열 중복 제거 조회
select distinct deptno from emp;

-- Q7. emp 테이블 job, deptno 열 중복 제거 조회
select distinct job,  deptno from emp;

-- Q8. emp 테이블 job, deptno 열 중복 제거하지 않고 그대로 조회
select all job, deptno from emp;

-- Q9. emp 테이블 열에 연산식 이용하여 연간총수입을 구하시오
select ename, sal, sal*12+comm, comm from emp;

-- Q10. emp 테이블 열+열 더하기 연산식 이용하여 연간총수입을 조회하시오
select ename, sal, sal+sal+sal+sal+sal+sal+sal+sal+sal+sal+sal+sal+comm, comm from emp;

-- Q11. emp 테이블에 열 별칭을 사용하여 연간총수입 조회하시오
select ename, sal, sal*12+comm as annsal, comm from emp;

-- Q12. emp 테이블 모든 열을 급여 기준으로 오름차순 정리
select * from emp order by sal asc;  -- asc 생략 가능(디폴트)

-- Q13. emp 테이블 모든 열을 급여 기준으로 내림차순 정리
select * from emp order by sal desc;

-- Q14. emp 테이블 모든 열을 부서번호(오름차순) 급여(내림차순) 기준으로 내림차순 정리
select * from emp order by deptno asc, sal desc;

-- 1. 테이블 구성
-- 2. emp 테이블에서 deptno 중복 제거
-- 3. 연간총수입 
-- 4. deptno 오름차순, sal 내림차순 정렬

-- 사용 가능 테이블 확인
select table_name from user_tables;

-- emp 테이블 삭제(복구 불가)
drop table emp;
select table_name from user_tables;

--emp 테이블 만들기 정의어(DDL) - CREATE, ALTER, DROP ->CAD
CREATE TABLE emp (
  empno NUMBER(4),
  ename VARCHAR2(10),
  job VARCHAR2(9),
  mgr NUMBER(4),
  hiredate DATE,
  sal NUMBER(7,2),
  comm NUMBER(7,2),
  deptno NUMBER(2)
);
-- 구조 확인
DESC EMP;

-- emp 테이블 값 넣기 조작어(DML) - INSERT(삽입), SELECT(조회), UPDATE(수정), DELETE(지우기)  ...> CRUD
INSERT INTO emp VALUES (7839, 'KING', 'PRESIDENT', NULL, TO_DATE('1981-11-17','YYYY-MM-DD'), 5000, NULL, 10);
INSERT INTO emp VALUES (7698, 'BLAKE', 'MANAGER', 7839, TO_DATE('1981-05-01','YYYY-MM-DD'), 2850, NULL, 30);
INSERT INTO emp VALUES (7782, 'CLARK', 'MANAGER', 7839, TO_DATE('1981-06-09','YYYY-MM-DD'), 2450, NULL, 10);
INSERT INTO emp VALUES (7566, 'JONES', 'MANAGER', 7839, TO_DATE('1981-04-02','YYYY-MM-DD'), 2975, NULL, 20);
INSERT INTO emp VALUES (7902, 'FORD', 'ANALYST', 7566, TO_DATE('1981-12-03','YYYY-MM-DD'), 3000, NULL, 20);
INSERT INTO emp VALUES (7369, 'SMITH', 'CLERK', 7902, TO_DATE('1980-12-17','YYYY-MM-DD'), 800, NULL, 20);
INSERT INTO emp VALUES (7788, 'SCOTT', 'ANALYST', 7566, TO_DATE('1987-07-13','YYYY-MM-DD'), 3000, NULL, 20);
INSERT INTO emp VALUES (7876, 'ADAMS', 'CLERK', 7788, TO_DATE('1987-07-13','YYYY-MM-DD'), 1100, NULL, 20);
INSERT INTO emp VALUES (7934, 'MILLER', 'CLERK', 7782, TO_DATE('1982-01-23','YYYY-MM-DD'), 1300, NULL, 10);
INSERT INTO emp VALUES (7654, 'MARTIN', 'SALESMAN', 7698, TO_DATE('1981-09-28','YYYY-MM-DD'), 1250, 1400, 30);
INSERT INTO emp VALUES (7499, 'ALLEN', 'SALESMAN', 7698, TO_DATE('1981-02-20','YYYY-MM-DD'), 1600, 300, 30);
INSERT INTO emp VALUES (7844, 'TURNER', 'SALESMAN', 7698, TO_DATE('1981-09-08','YYYY-MM-DD'), 1500, 0, 30);
INSERT INTO emp VALUES (7900, 'JAMES', 'CLERK', 7698, TO_DATE('1981-12-03','YYYY-MM-DD'), 950, NULL, 30);
INSERT INTO emp VALUES (7521, 'WARD', 'SALESMAN', 7698, TO_DATE('1981-02-22','YYYY-MM-DD'), 1250, 500, 30);

select * from emp;

delete from emp;
INSERT INTO emp VALUES (7839, 'KING', 'PRESIDENT', NULL, TO_DATE('1981-11-17','YYYY-MM-DD'), 5000, NULL, 10);
INSERT INTO emp VALUES (7698, 'BLAKE', 'MANAGER', 7839, TO_DATE('1981-05-01','YYYY-MM-DD'), 2850, NULL, 30);
INSERT INTO emp VALUES (7782, 'CLARK', 'MANAGER', 7839, TO_DATE('1981-06-09','YYYY-MM-DD'), 2450, NULL, 10);
INSERT INTO emp VALUES (7566, 'JONES', 'MANAGER', 7839, TO_DATE('1981-04-02','YYYY-MM-DD'), 2975, NULL, 20);
INSERT INTO emp VALUES (7902, 'FORD', 'ANALYST', 7566, TO_DATE('1981-12-03','YYYY-MM-DD'), 3000, NULL, 20);
INSERT INTO emp VALUES (7369, 'SMITH', 'CLERK', 7902, TO_DATE('1980-12-17','YYYY-MM-DD'), 800, NULL, 20);
INSERT INTO emp VALUES (7788, 'SCOTT', 'ANALYST', 7566, TO_DATE('1987-07-13','YYYY-MM-DD'), 3000, NULL, 20);
INSERT INTO emp VALUES (7876, 'ADAMS', 'CLERK', 7788, TO_DATE('1987-07-13','YYYY-MM-DD'), 1100, NULL, 20);
INSERT INTO emp VALUES (7934, 'MILLER', 'CLERK', 7782, TO_DATE('1982-01-23','YYYY-MM-DD'), 1300, NULL, 10);
INSERT INTO emp VALUES (7654, 'MARTIN', 'SALESMAN', 7698, TO_DATE('1981-09-28','YYYY-MM-DD'), 1250, 1400, 30);
INSERT INTO emp VALUES (7499, 'ALLEN', 'SALESMAN', 7698, TO_DATE('1981-02-20','YYYY-MM-DD'), 1600, 300, 30);
INSERT INTO emp VALUES (7844, 'TURNER', 'SALESMAN', 7698, TO_DATE('1981-09-08','YYYY-MM-DD'), 1500, 0, 30);
INSERT INTO emp VALUES (7900, 'JAMES', 'CLERK', 7698, TO_DATE('1981-12-03','YYYY-MM-DD'), 950, NULL, 30);
INSERT INTO emp VALUES (7521, 'WARD', 'SALESMAN', 7698, TO_DATE('1981-02-22','YYYY-MM-DD'), 1250, 500, 30);

select * from emp;

commit;


-- ex1. emp 테이블 job 열 데이터 중복 없이 조회
select distinct job from emp;

--ex2.
select 
empno as employee_no, ename as employee_name, job, mgr as manager, hiredate,
sal as salary, comm as commission, deptno as department_no 
from emp 
order by deptno desc, ename asc;  -- 우선순위는 나열한 순서대로(depno->ename) 