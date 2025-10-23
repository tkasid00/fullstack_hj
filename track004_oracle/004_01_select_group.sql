--1. 전체 테이블 확인
SELECT * FROM EMP;

--2. 집계함수 SUM, MAX, MIN, AVG, COUNT
SELECT SUM(SAL) FROM EMP; --급여의 합계
SELECT SUM(COMM) FROM EMP; --NULL값이 있어도 계산 가능

 --      14줄   1줄      1줄...    오류 발생! 필드 개수 맞아야됨
--SELECT SAL, SUM(SAL), MAX(SAL), MIN(SAL),AVG(SAL),COUNT(SAL) FROM EMP;
SELECT SUM(SAL) "합" , MAX(SAL) "최대", MIN(SAL) "최소", ROUND(AVG(SAL),2) "평균" , COUNT(SAL) "개수" FROM EMP; 

--3, GROUP BY
-- FWGHSO
--SELECT --5
--FROM   --1
--WHERE  --2 전체에서 필터링
--GROUP BY  --3 그룹핑
--HAVING  --4 그룹 안에서 조건(그룹핑 후 필터링)
--ORDER BY;  --6

--부서별 급여의 합
SELECT DEPTNO, SUM(SAL)
FROM  EMP
GROUP BY DEPTNO;


--4. HAVING (합계를 구했을 때 9000 이상인 그룹)
SELECT DEPTNO, SUM(SAL), COUNT(*)
FROM  EMP
GROUP BY DEPTNO
HAVING  SUM(SAL)>=9000;


-- https://sally03915.github.io/stackventure_250825/004_oracle/oracle005_select_group#14
--Q1~24

--1. EMP 테이블에서 SUM 함수를 이용하여 급여 합계(SAL)를 출력하시오.
SELECT SUM(SAL) FROM EMP;

--2. EMP 테이블에서 SUM 함수를 이용하여 사원이름과 급여 합계를 출력하시오.
--에러가 난다면 그이유를 적으시오. > ENAME은 14줄, SAL은 1줄로 출력 불가
SELECT ENAME, SUM(SAL) FROM EMP;

--3. EMP 테이블에서 SUM 함수를 이용하여 추가수당(COMM) 합계를 출력하시오.
SELECT SUM(COMM) FROM EMP;

--4. EMP 테이블에서 SUM (DISTINCT, ALL)함수를 이용하여 급여 합계를 출력하시오.
SELECT SUM(DISTINCT(SAL)), SUM(SAL) , SUM(SAL) FROM EMP;

--5. EMP 테이블에서 COUNT를 이용하여 데이터의 갯수를 출력하시오.
SELECT COUNT(*) FROM EMP;

--6. EMP 테이블에서 COUNT를 이용하여 부서번호가(DEPTNO) 30인 데이터의 갯수를 출력하시오.
SELECT COUNT(*) FROM EMP WHERE DEPTNO=30;

--7. EMP 테이블에서 COUNT ( DISTINCT, ALL) 를 이용하여 데이터의 갯수를 출력하시오.
SELECT COUNT(DISTINCT(SAL)) AS 
,  COUNT(ALL(SAL)) 
,  COUNT(SAL) 
FROM EMP;

--8. EMP 테이블에서 COUNT를 이용하여 추가수당(COMM) 열의 갯수를 출력하시오.
SELECT COUNT(COMM) FROM EMP;

--9. EMP 테이블에서 COUNT를 이용하여 추가수당(COMM) 열의 갯수를 출력하시오.
--COUNT는 NULL 처리가 들어가 있음. ->COUNT는 NULL 있어도 계산 가능
SELECT COUNT(COMM) FROM EMP
WHERE COMM IS NOT NULL;

--10 EMP 테이블에서 MAX를 이용하여 부서번호(DEPTNO)가 10번인 사원들의 최대 급여를 출력하시오.
SELECT MAX(SAL) 
FROM EMP
GROUP BY DEPTNO 
HAVING DEPTNO=10;

--11. EMP 테이블에서 부서번호(DEPTNO)가 10번인 사원들의 최소 급여를 출력하시오.
SELECT MIN(SAL) 
FROM EMP
GROUP BY DEPTNO
HAVING DEPTNO=10;

--12. EMP 테이블에서 부서번호가 20인 사원의 입사일(HIREDATE) 중 제일 최근 입사일을 출력하시오.
SELECT MAX(HIREDATE)
FROM EMP
GROUP BY DEPTNO
HAVING DEPTNO=20;

--13.EMP 테이블에서 부서번호가 20인 사원의 입사일(HIREDATE) 중 제일 오래된 입사일을 출력하시오.
SELECT MIN(HIREDATE)
FROM EMP
GROUP BY DEPTNO
HAVING DEPTNO=20;

--14.EMP 테이블에서 부서번호가 30인 사원의 평균급여를 출력하시오.
SELECT AVG(SAL)
FROM EMP
GROUP BY DEPTNO
HAVING DEPTNO=30;

--15.EMP 테이블에서 부서번호가 30인 사원의 DISTINCT로 중복을 제거한 급여 열의 평균급여를 출력하시오.
SELECT AVG(DISTINCT SAL) 
FROM EMP
GROUP BY DEPTNO
HAVING DEPTNO=30;

--16.EMP 테이블에서 집합연산자(UNION ALL) 를 사용하여 각 부서별 평균급여를 출력하시오
SELECT AVG(SAL), DEPTNO
FROM EMP 
GROUP BY DEPTNO
HAVING DEPTNO=10
UNION ALL
SELECT AVG(SAL), DEPTNO
FROM EMP 
GROUP BY DEPTNO
HAVING DEPTNO=20
UNION ALL
SELECT AVG(SAL), DEPTNO
FROM EMP 
GROUP BY DEPTNO
HAVING DEPTNO=30;

SELECT AVG(SAL), '10' AS DEPTNO FROM EMP WHERE DEPTNO=10
UNION ALL
SELECT AVG(SAL), '20' AS DEPTNO FROM EMP WHERE DEPTNO=20
UNION ALL
SELECT AVG(SAL), '30' AS DEPTNO FROM EMP WHERE DEPTNO=30;

--17.EMP 테이블에서 GROUP BY를 사용하여 부서별 평균급여를 출력하시오.
SELECT AVG(SAL), DEPTNO
FROM EMP 
GROUP BY DEPTNO;

--18. EMP 테이블에서 부서번호(DEPTNO) 및 직책별(JOB) 평균급여(SAL)로 정렬한 후 출력하시오.
SELECT DEPTNO, JOB, AVG(SAL)
FROM EMP
GROUP BY DEPTNO, JOB
ORDER BY DEPTNO;

--19.EMP 테이블에서 GROUP BY절에 없는 열을 SELECT절에 포함하면 에러가 난다. 그이유를 적으시오.
-- >그룹화하지 않은 열은 전체 열을 출력하는데 그룹화한 열은 전체 열보다 수가 적어서 오류가 남

--20. EMP 테이블에서 GROUP BY 와 HAVING 절을 이용하여 각부서의 직책별 평균급여를 구하되 그 평균급여가 2000이상인 그룹만 출력하시오.
SELECT DEPTNO, JOB, AVG(SAL)
FROM EMP
GROUP BY DEPTNO, JOB --집계함수(AVG, SAL, MIN, MAX, COUNT) 빼고 다 그룹핑
HAVING AVG(SAL)>=2000
ORDER BY DEPTNO;

--21. 다음 코드가 오류나는 이유를 적으시오
-- >그룹에 대한 조건은 WHERE이 아니라 HAVING을 써야함
SELECT DEPTNO, JOB, AVG(SAL)
FROM EMP
WHERE AVG(SAL) >= 2000
GROUP BY DEPTNO, JOB
ORDER BY DEPTNO, JOB;

--22. WHERE 절을 사용하지 않고 HAVING절만 사용한 경우
SELECT DEPTNO, JOB, AVG(SAL)
FROM EMP
GROUP BY DEPTNO, JOB
HAVING AVG(SAL)>=2000
ORDER BY DEPTNO;

--23. WHERE절과 HAVING절을 모두 사용한경우
SELECT DEPTNO, JOB, AVG(SAL)
FROM EMP
WHERE JOB IN('MANAGER', 'ANALYST')
GROUP BY DEPTNO, JOB
HAVING AVG(SAL)>=2000
ORDER BY DEPTNO;

--24. 부서별(큰그룹) 직책(소그룹)의 사원수, 가장 높은 급여, 급여의 합, 평균급여를 출력하시오.
SELECT DEPTNO, JOB, COUNT(*), MAX(SAL), SUM(SAL), AVG(SAL)
FROM EMP
GROUP BY DEPTNO, JOB
ORDER BY DEPTNO;