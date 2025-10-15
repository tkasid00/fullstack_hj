-- #6. UNION(중복제거 합집합)
-- 결과 : 3개(3+3=3)
SELECT *
FROM EMP
WHERE DEPTNO=10
--------------------------
UNION
--------------------------
SELECT *
FROM EMP
WHERE DEPTNO=10;

-- #8. UNION ALL(중복 포함 합집합)
-- 결과 : 6개(3+3)
SELECT *
FROM EMP
WHERE DEPTNO=10
--------------------------
UNION ALL
--------------------------
SELECT *
FROM EMP
WHERE DEPTNO=10;

-- #9. MINUS(차집합)
-- 결과 : 9개( 전체 행(14)- 20인 행(5) )
SELECT *
FROM EMP
--------------------------
MINUS
--------------------------
SELECT *
FROM EMP
WHERE DEPTNO=20;

-- #10. INTERSECT(교집합)
-- 결과 : 5개( (전체 행)14 - (20이 아닌 겹치지 않는 행)9 )
SELECT *
FROM EMP
--------------------------
INTERSECT
--------------------------
SELECT *
FROM EMP
WHERE DEPTNO=20;


-- 연습문제  (30~37)  ~ :50
-- https://sally03915.github.io/stackventure_250825/004_oracle/oracle003_select_where#71

-- 30. UNION 이용 DEPTNO 10이거나 20인 데이터의 EMPNO, ENAME, SAL, EEPTNO열
SELECT EMPNO, ENAME, SAL, DEPTNO 
FROM EMP
WHERE DEPTNO=10
UNION
SELECT EMPNO, ENAME, SAL, DEPTNO 
FROM EMP
WHERE DEPTNO=20;

--31. 열의 개수가 다를 때 에러 (3 =/= 4)
SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE DEPTNO=10
UNION
SELECT EMPNO, ENAME, SAL, DEPTNO 
FROM EMP
WHERE DEPTNO=20;
--오류 메시지 : 
--ORA-01789: query block has incorrect number of result columns
--
--https://docs.oracle.com/error-help/db/ora-01789/01789. 00000 -  "query block has incorrect number of result columns"
--*Cause:    All of the queries participating in a set expression do
--           not contain the same number of SELECT list columns.
--*Action:   Check that all the queries in the set expression have
--           the same number of SELECT list columns.



--32. 자료형이 다를 때 에러
-- SELECT에 서술한 순서대로 나열이 되는데 
-- ENAME, SAL의 순서를 바꿀 경우 문자, 숫자의 위치가 바뀜, 자료형이 달라서 합산 불가.
SELECT EMPNO, ENAME, SAL, DEPTNO 
FROM EMP
WHERE DEPTNO=10
UNION
SELECT EMPNO, SAL, ENAME, DEPTNO 
FROM EMP
WHERE DEPTNO=20;
--오류 메시지 : 
--ORA-01790: expression must have same datatype as corresponding expression
--
--https://docs.oracle.com/error-help/db/ora-01790/01790. 00000 -  "expression must have same datatype as corresponding expression"
--*Cause:    A SELECT list item corresponds to a SELECT list item
--           with a different datatype in another query of the same set
--           expression.
--*Action:   Check that all corresponding SELECT list items have
--           the same datatypes. Use the TO_NUMBER, TO_CHAR, and TO_DATE
--           functions to do explicit data conversions.
--82행, 15열에서 오류 발생

-- 33. 동작 이유? 출력 열 개수와 자료형이 같으면 동작 가능
-- 합산 기준은 UNION 이전 먼저 서술된 테이블 따름
SELECT EMPNO, ENAME, SAL, DEPTNO 
FROM EMP
WHERE DEPTNO=10
UNION
SELECT EMPNO, JOB, DEPTNO, SAL 
FROM EMP
WHERE DEPTNO=20;

--34. UNION, UNION ALL 차이
-- UNION은 중복 제거, UNION ALL은 중복 없이 전부 합산
SELECT *
FROM EMP
WHERE DEPTNO=10
UNION
SELECT *
FROM EMP
WHERE DEPTNO=10;

--35. UNION, UNION ALL 차이
-- UNION은 중복 제거, UNION ALL은 중복 없이 전부 합산
SELECT *
FROM EMP
WHERE DEPTNO=10
UNION ALL
SELECT *
FROM EMP
WHERE DEPTNO=10;

--36. MINUS의 의미는?
--  차집합
SELECT *
FROM EMP
MINUS
SELECT *
FROM EMP
WHERE DEPTNO=10;

--37. INTERSECT의 의미는?
-- 교집합
SELECT *
FROM EMP
INTERSECT
SELECT *
FROM EMP
WHERE DEPTNO=10;

-- 사고확장  (1~6)
-- https://sally03915.github.io/stackventure_250825/004_oracle/oracle003_select_where#87
--1. ENAME이 S로 끝나는 사원 
SELECT * FROM EMP WHERE ENAME LIKE '%S';

--2. DEPTNO가 30인 사원 중 JOB이 SALESMAN인 사원의 EMPNO, ENAME, JOB, SAL, DEPTNO
SELECT EMPNO, ENAME, JOB, SAL, DEPTNO 
FROM EMP
WHERE DEPTNO=30 AND JOB='SALESMAN';

--3-1. UNION을 사용하지 말고 IN 연산자 이용, DEPTNO 20 또는 30인 사원의 SAL이 2000 초과
SELECT EMPNO, ENAME, JOB, SAL, DEPTNO
FROM EMP
WHERE DEPTNO IN(20,30) AND SAL>2000;

--3-2. UNION을 사용 DEPTNO 20 또는 30인 사원의 SAL이 2000 초과
-- **DEPTNO IN(20,30) /UNION/ SAL>2000으로 분리하면 전체가 조회됨!
SELECT EMPNO, ENAME, JOB, SAL, DEPTNO
FROM EMP
WHERE DEPTNO IN(20) AND SAL>2000
UNION
SELECT * 
FROM EMP
WHERE DEPTNO IN(30) AND SAL>2000;

--4-1. NOT BETWEEN AND 이용하지 않고 SAL이 2000 이상 3000 이하
SELECT * 
FROM EMP
WHERE SAL>=2000
INTERSECT
SELECT * 
FROM EMP
WHERE SAL<=3000;

--4-2. NOT BETWEEN AND 이용하지 않고 SAL이 2000 이상 3000 이하가 아님
SELECT * 
FROM EMP
WHERE SAL <2000 OR SAL >3000;

-- 2000~3000 사이 2개
SELECT * FROM EMP WHERE SAL>=2000 AND SAL <=3000;
SELECT * FROM EMP WHERE SAL BETWEEN 2000 AND 3000;
-- 2000~3000 사이 아닌 값 NOT BETWEEN
SELECT * FROM EMP WHERE SAL NOT BETWEEN 2000 AND 3000;
-- 2000~3000 사이 아닌 값 OR
SELECT * FROM EMP WHERE SAL <2000 OR SAL >3000;

--5. ENAME에 E가 포함되고 DEPTNO가 30인 사원의 급여가 1000~2000 사이가 아닌 사원의 ENAME, EMPNO, SAL, DEPTNO 조회
SELECT ENAME, EMPNO, SAL, DEPTNO 
FROM EMP
WHERE ENAME LIKE '%E%' AND DEPTNO=30 
MINUS
SELECT ENAME, EMPNO, SAL, DEPTNO 
FROM EMP
WHERE SAL BETWEEN 1000 AND 2000;

--6. COMM이 없고 MGR은 존재하면 JOB이 MANAGER, CLERK인 사원 중 사원의 이름의 2번째 글자가 L이 아닌 사원
SELECT *
FROM EMP
WHERE COMM IS NULL 
    AND MGR IS NOT NULL
    AND JOB IN ('MANAGER', 'CLERK')
    AND ENAME NOT LIKE '_L%';

--SAL BETWEEN 2000 AND 3000 의미 : SAL이 2000~3000 사이
--ENAME LIKE '_L%'; 의미 : ENAME 두 번째 글자가 L
--COMM IS NULL 의미 : COMM이 NULL값을 가진다(데이터 부존재)
--UNION, UNION ALL 차이 : UNION은 중복 제거 합집합, UNION ALL은 전체 합집합
--SAL ^=3000 의미 : SAL이 3000이 아니다