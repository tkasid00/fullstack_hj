-- 조건에 맞는 데이터 조회
-- #1. where
-- #2. 비교 연산자 : 같다 = / 다르다 !=, <>, ^=
-- #3. 논리 연산자 : AND, BETWEEN AND(범위), OR/IN, NOT
-- #4. like : 패턴 검색
-- #5. null 처리 : 데이터 존재 여부 확인
-- #6. 집합 연산자 : UNION(중복제거 합집합), UNION ALL(중복 포함 합집합), MINUS(차집합), INTERSECT(교집합)

-- SQL 처리 순서(ex.5)
-- select *                 ③ *(모든 컬럼값)
-- from emp                 ①emp 테이블 읽어오기
-- where sal*12=36000;      ②각 행에 대해(1명분의 자료 묶음) 조건 평가

-- #1. 전체 데이터 조회(emp)
select * from emp;

--#2. where 조건 조회
select * from emp where empno = 7839; -- 같다 =
select * from emp where empno != 7839; -- 다르다 !=
select * from emp where empno <> 7839; -- 다르다 <>
select * from emp where empno ^= 7839; -- 다르다 ^=

select * from emp where ename = 'KING'; --대소문자 구분 

select * from emp where empno=7839 and ename = 'KING'; -- and : 두 조건 만족 
select * from emp where empno=7839 and ename = 'SCOTT'; -- 출력X
select * from emp where empno=7839 or ename = 'SCOTT'; -- or : 둘 중의 하나

select * from emp where sal*12 = 36000 ;
select * from emp where sal >= 3000 ;

select * from emp where ename >='F';  --아스키코드값으로 문자 비교 가능
select * from emp where ename <='SOR'; --1순위, 2순위, 3순위 

select * from emp where deptno>=20 and deptno<=30;
select * from emp where deptno between 20 and 30; -- between 이상 and 이하

select * from emp where deptno = 10 or deptno = 30;
select * from emp where deptno in(10, 30);

select * from emp where ename = 'KING';  --명확하게 알 때
select * from emp where ename like 'A%';  --A로 시작
select * from emp where ename like '%A%'; --중간에 A가 들어감
select * from emp where ename like '%G';  --G로 끝남
select * from emp where ename like '_I%'; -- 두 번째 글자가 I

select * from emp where comm = null; -- null은 빈칸이라 비교할 값이 존재하지 않음, 단순 데이터 부존재 상태 표시
select * from emp where comm is null; 
select * from emp where comm is not null; 

-- 연습문제(1~29)

-- 1. 테이블의 모든 열
select * from emp;

-- 2. 부서 번호 30
select * from emp where deptno=30;

--3. and 사용, 부서번호 30, job salesman
select * from emp where deptno=30 and job= 'SALESMAN';

--4. OR 이용 부서번호 30, JOB CLERK
select * from emp where deptno=30 or job= 'CLERK';

--5. sal 열에 12 곱한 값이 36000
select * from emp where sal*12=36000;

--6. sal 3000 이상
select * from emp where sal>=3000;

--7. ename 첫문자 f와 같거나 뒤에 있는 행 == F보다 큰 알파벳 시작
select * from emp where ename >= 'F';

--8. 첫문자 F, 두번째 O, 세번째 R, 네번째 Z보다 앞에 있는 행
select * from emp where ename <='FORZ';

--9. != 이용 sal이 3000이 아님
select * from emp where sal!=3000;

--10. <> 이용 sal이 3000이 아님
select * from emp where sal<>3000;

--11. ^= 이용 sal이 3000이 아님
select * from emp where sal^=3000;

--12. not 이용 sal이 3000이 아님***
select * from emp where not sal = 3000; 

--13. or 이용 job이 manager, salesman, clerk 중 하나라도 포함
select * from emp where job = 'MANAGER' OR job = 'SALESMAN' OR job = 'CLERK';

--14. in 이용 job이 manager, salesman, clerk 중 하나라도 포함
select * from emp where job in('MANAGER','SALESMAN','CLERK');

--15. 등가연산자 + and 이용 job이 manager, salesman, clerk 중 하나라도 포함x
select * from emp where job != 'MANAGER' and job ^= 'SALESMAN' and job <> 'CLERK';

--16. not in 이용 job이 manager, salesman, clerk 중 하나라도 포함x
select * from emp where job not in('MANAGER','SALESMAN','CLERK');  -- (not in)은 한 덩어리로 묶기 / not job in 출력 자체는 가능

--17. 대소비교연산 + and 이용 sal이 2000 이상 3000 이하 
select * from emp where  sal >=2000 and sal <= 3000;

--18. between and 이용 sal이 2000 이상 3000 이하 
select * from emp  where  sal between 2000 and 3000;

--19. not between and 이용 sal이 2000 이상 3000 이하 이외
select * from emp  where  sal not between 2000 and 3000;

--20. ename s로 시작
select * from emp where ename like 'S%';

--21. ename 두 번째 글자가 L인 행
select * from emp where ename like '_L%';

--22. ename AM 포함
select * from emp where ename like '%AM%';

--23. ename AM 포함X
select * from emp where ename NOT like '%AM%';

--24. 별칭 ANNSAL 사용해서 연간총수입 조회
select ename, sal, 12*sal+comm  as annsal, comm from emp;   

--25. 코드 확인
select * from emp where  comm = null;

--26. is null
select * from emp where  comm is null;

--27. 직속상관 있는 데이터 조회
select * from emp where mgr is not null;

--28. sal>null 성립 불가(비교할 값 자체 존재x) comm is null 가능 -> and 때문에 출력 자체 x

--29.  sal>null 성립 불가 comm is null 가능 -> or로 comm is null 만족 부분 출력

