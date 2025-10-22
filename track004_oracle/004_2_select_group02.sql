--1. 
SELECT * FROM EMP;

--2. 집계함수 SUM, COUNT, MAX, MIN, AVG
SELECT SUM(SAL) FROM EMP; --개

--3. 부서별 급여 평균
SELECT DEPTNO, AVG(SAL) FROM EMP; -- 평균값 그룹화로 인한 데이터 길이 차로 오류 발생
SELECT DEPTNO, AVG(SAL) FROM EMP GROUP BY DEPTNO; --그룹별로 묶어서 해결
SELECT DEPTNO, JOB, AVG(SAL) FROM EMP GROUP BY DEPTNO, JOB ORDER BY DEPTNO, JOB; -- 최종, 집계함수 앞은 다 그룹으로 묶기

--4. WHERE / HAVING [급여의 평균]에서 2000 이상 찾기
-- 순서 : FWGHSO
SELECT DEPTNO, JOB, AVG(SAL) --5 
FROM EMP                     --1
WHERE SAL >=1500             --2 전체 데이터에서 필터링
GROUP BY DEPTNO, JOB         --3
HAVING AVG(SAL) >=2000       --4 그룹화한 이후 필터링
ORDER BY DEPTNO, JOB;        --6


--5. ROLLUP, CUBE, GROUPING SETS / PIVOT, UNPIVOT
-- 부서의 직업별 인원 수, 급여 평균

-- ROLLUP : [10부서 직업별 평균 - 10부서 평균] - [20부서 직업별 평균 - 20부서 평균] - [30부서 직업별 평균 - 30부서 평균] - [전체 총계] 
-- 작은 단위에서 큰 단위, 먼저 묶고 소계 출력
SELECT DEPTNO, JOB, COUNT(*), ROUND(AVG(SAL),1)
FROM EMP
GROUP BY ROLLUP(DEPTNO, JOB);

-- CUBE : [DEPTNO+JOB 전체 총계] - [JOB 총계] - [DEPTNO 총계] - [DEPTNO+JOB 각각 세부 내용]
-- 큰 단위에서 작은 단위로
SELECT DEPTNO, JOB, COUNT(*), ROUND(AVG(SAL),1)
FROM EMP
GROUP BY CUBE(DEPTNO, JOB);

-- GROUPING SETS
SELECT DEPTNO, JOB, GROUPING(DEPTNO), GROUPING(JOB) --해당 컬럼 실제 그룹화 여부 확인 -> 0은 그룹화에 포함됨, 1은 그룹화에 포함되지 않음
FROM EMP
GROUP BY CUBE(DEPTNO, JOB); -- DEPTNO+JOB, JOB, DEPTNO, 각각 세부사항

--PIVOT : 행 데이터를 열로
SELECT *
FROM (SELECT 컬럼1, 컬럼2, 집계대상컬럼 FROM 테이블명); --원본 데이터 : PIVOT 적용 대상
PIVOT (집계함수(집계 대상) FOR 컬럼 기준 IN(값1, 값2, 값3)); --집계함수 : 어떤 컬럼 기준으로 만들 것인지 지정
--1) JOB별 부서 10,20,30의 최대 급여
SELECT *
FROM (SELECT DEPTNO, JOB, SAL FROM EMP) 
PIVOT (MAX(SAL) FOR DEPTNO IN(10,20,30)); --JOB별 DEPTNO 10, 20, 30의 최대 급여
 
--2) 직무별 부서 사원 수
SELECT *
FROM(SELECT JOB, DEPTNO,  EMPNO FROM EMP)
PIVOT (COUNT(EMPNO) FOR DEPTNO IN(10,20,30));

--3) 부서별 직무 평균 급여
SELECT * 
FROM(SELECT DEPTNO, JOB, SAL FROM EMP)
PIVOT(AVG(SAL) FOR JOB IN('CLERK', 'MANAGER', 'SALESMAN'));

--UNPIVOT : 열 데이터를 행으로
SELECT *
FROM () --원본 데이터 :  UNPIVOT을 적용해야 할 대상(열 형태로 집계된 데이터)
UNPIVOT (); --UNPIVOT : 열을 행으로 변환, 기준 컬럼 열 이름이었던 것을 행 값으로 변환


--DECODE(JOB, 'CLERK', SAL) JOB이 CLERK인 경우 SAL 아니면 NULL 반환
SELECT * 
FROM(
    SELECT DEPTNO
    , MAX(DECODE(JOB, 'CLERK', SAL)) AS "CLERK" 
    , MAX(DECODE(JOB, 'MANAGER', SAL)) AS "MANAGER"
    FROM EMP 
    GROUP BY DEPTNO
    )
UNPIVOT(
    SAL FOR JOB IN(CLERK, MANAGER)
-- DEPTNO, CLERK(열), MANAGER(열)
-- DEPTNO, JOB(CLERK, MANAGER), SAL
);

--25~39
--https://sally03915.github.io/stackventure_250825/004_oracle/oracle005_select_group#38


--25. EMP 테이블에서 ROLLUP 함수를 이용하여 부서별(큰그룹) 직책(소그룹)의 사원수, 가장 높은 급여, 급여의 합, 평균급여를 출력하시오.
SELECT DEPTNO, JOB, COUNT(*), MAX(SAL), SUM(SAL), AVG(SAL)
FROM EMP
GROUP BY ROLLUP(DEPTNO,JOB);

--26.EMP 테이블에서 CUBE(DEPTNO, JOB) 함수를 이용하여 부서별(큰그룹) 직책(소그룹)의 사원수, 가장 높은 급여, 급여의 합, 평균급여를 출력하시오.
SELECT DEPTNO, JOB, COUNT(*),  MAX(SAL), SUM(SAL), AVG(SAL)
FROM EMP
GROUP BY CUBE(DEPTNO, JOB)
ORDER BY DEPTNO, JOB;

--27.EMP 테이블에서 DEPTNO를 먼저 그룹화한후 ROLLUP 함수에 JOB을 지정하여 사원수를 출력하시오.
SELECT DEPTNO, JOB, COUNT(*)
FROM EMP
GROUP BY DEPTNO, ROLLUP(JOB);

--28.EMP 테이블에서 JOB을 먼저 그룹화한후 ROLLUP 함수에 DEPTNO을 지정하여 사원수를 출력하시오.
SELECT DEPTNO, JOB, COUNT(*)
FROM EMP
GROUP BY JOB, ROLLUP(DEPTNO);

--29.EMP 테이블에서 GROUPING SETS (DEPTNO, JOB) 함수를 사용하여 열별 그룹으로 묶어어 결과로 출력하시오.
SELECT DEPTNO, JOB, COUNT(*)
FROM EMP
GROUP BY  GROUPING SETS (DEPTNO, JOB)
ORDER BY DEPTNO, JOB;
--GROUP BY DEPTNO -> JOB NULL로
--GROUP BY JOB이 -> DEPTNO NULL로

--30. EMP 테이블에서 DEPTNO JOB열의 그룹화결과를 GROUPING 함수로 출력하시오.
SELECT DEPTNO, JOB, COUNT(*), MAX(SAL), SUM(SAL), AVG(SAL), GROUPING(DEPTNO), GROUPING(JOB)
FROM EMP
GROUP BY CUBE( DEPTNO, JOB)
ORDER BY DEPTNO, JOB;


--31. DECODE문으로 GROUPING 함수를 적용하여 결과를 표기하시오오
SELECT 
    DECODE(TO_CHAR(DEPTNO), '10', '10', '20', '20', '30', '30', 'ALL_DEPT' ) AS DEPTNO
    , DECODE(JOB, 'CLERK', 'CLERK', 'MANAGER', 'MANAGER', 'PRESIDENT', 'PRESIDENT', 'ANALYST', 'ANALYST', 'SALESMAN', 'SALESMAN', 'ALL_JOB') JOB
    , COUNT(*), MAX(SAL), SUM(SAL), AVG(SAL)
FROM EMP
GROUP BY CUBE( DEPTNO, JOB)
ORDER BY DEPTNO, JOB;

--▽▽▽▽
SELECT
    DECODE(GROUPING(DEPTNO),1, 'ALL_DEPT', DEPTNO) AS DEPTNO
    , DECODE(GROUPING(JOB),1, 'ALL_JOB', JOB) AS JOB
    , COUNT(*), MAX(SAL), SUM(SAL), AVG(SAL)
FROM EMP
GROUP BY CUBE( DEPTNO, JOB)
ORDER BY DEPTNO, JOB;


--32. DEPTNO, JOB을 함께 명시한 GROUPING_ID 함수를 사용하시오.
-- GROUPING은 CUBE와 함께 씀
SELECT DEPTNO, JOB, COUNT(*), SUM(SAL)
        , GROUPING(DEPTNO), GROUPING(JOB), GROUPING_ID(DEPTNO, JOB)    --몇 번 집계했는지
FROM EMP
GROUP BY CUBE(DEPTNO, JOB)
ORDER BY DEPTNO, JOB;

1)DEPTNO(0)        JOB(0)         GROUPING_ID(0)  DEPTNO(실제값)-JOB(실제값)  0*2^1 + 0*2^0=0 (정상 조합) 
2)DEPTNO(0)        JOB(1:NULL)    GROUPING_ID(1)  DEPTNO(실제값)-JOB(NULL)   0*2^1 + 1*2^0=1
3)DEPTNO(1:NULL)   JOB(0)         GROUPING_ID(2)  DEPTNO(NULL)-JOB(실제값)   1*2^1 + 0*2^0=2
4)DEPTNO(1:NULL)   JOB(1:NULL)    GROUPING_ID(3)  DEPTNO(NULL)-JOB(NULL)    1*2^1 + 1*2^0=3   2^0=1



--33. EMP 테이블에서 GROUP BY로 그룹화하여 부서번호와 사원이름을 출력하시오.
SELECT DEPTNO, ENAME
FROM EMP
GROUP BY DEPTNO, ENAME;

--34.EMP 테이블에서 부서별 사원이름을 나란히 나열하여 출력하시오.
--LISTAGG( 나열할 열, 구분자)
--WITHIN GROUP(ORDER BY 나열할 열의 정렬기준)
SELECT DEPTNO, LISTAGG(ENAME, ',') WITHIN GROUP(ORDER BY SAL DESC) AS ENAMES
FROM EMP
GROUP BY DEPTNO;

SELECT * FROM EMP;


--35. EMP 테이블에서 부서, 직책별 그룹화하여 최고급여데이터를 출력하시오
SELECT DEPTNO, JOB, MAX(SAL)
FROM EMP
GROUP BY DEPTNO, JOB
ORDER BY DEPTNO, JOB;

--36. EMP 테이블에서 PIVOT함수를 사용하여 직책별* 부서별 최고급여를 2차원 표 형태로 출력하시오
SELECT *
FROM (SELECT DEPTNO, JOB, SAL FROM EMP )
PIVOT (MAX(SAL) FOR DEPTNO IN(10,20,30) )
ORDER BY JOB;

--37.EMP 테이블에서 PIVOT함수를 사용하여 부서별*직책책별 최고급여를 2차원 표 형태로 출력하시오
SELECT *
FROM (SELECT JOB, DEPTNO, SAL FROM EMP)
PIVOT(MAX(SAL) FOR JOB IN ('CLERK', 'SALESMAN', 'PRESIDENT', 'MANAGER', 'ANALYST') )
ORDER BY DEPTNO;

--38. EMP 테이블에서 DECODE문을 활용하여 PIVOT 함수와 같은 결과를 출력하시오
SELECT DEPTNO
    ,MAX(DECODE(JOB,'CLERK', SAL )) AS "CLERK"
    ,MAX(DECODE(JOB,'SALESMAN', SAL )) AS "SALESMAN"
    ,MAX(DECODE(JOB,'PRESIDENT', SAL )) AS "PRESIDENT"
    ,MAX(DECODE(JOB,'MANAGER', SAL )) AS "MANAGER"
    ,MAX(DECODE(JOB,'ANALYST', SAL )) AS "ANALYST"
FROM EMP
GROUP BY DEPTNO;
                

--39. EMP 테이블에서 UNPIVOT 활용하여 열로 구분된 그룹을 행으로 출력하시오
SELECT *
FROM(
SELECT DEPTNO
    ,MAX(DECODE(JOB,'CLERK', SAL )) AS "CLERK"
    ,MAX(DECODE(JOB,'SALESMAN', SAL )) AS "SALESMAN"
    ,MAX(DECODE(JOB,'PRESIDENT', SAL )) AS "PRESIDENT"
    ,MAX(DECODE(JOB,'MANAGER', SAL )) AS "MANAGER"
    ,MAX(DECODE(JOB,'ANALYST', SAL )) AS "ANALYST"
FROM EMP
GROUP BY DEPTNO)
UNPIVOT( SAL FOR JOB IN("CLERK", "SALESMAN", "PRESIDENT", "MANAGER", "ANALYST")  )
ORDER BY DEPTNO, JOB;


--Ex001. EMP 테이블을 이용하여 다음과 같이 출력하시오.
--부서번호(DEPTNO) , 평균급여(AVG_SAL) , 최고급여(MAX_SAL) , 최저급여(MIN_SAL) , 사원수(CNT) 를 조회하시오
--평균급여를 출력시 소수점을 제외하고 각 부서번호별로 출력하시오.
SELECT DEPTNO, TRUNC(AVG(SAL)), MAX(SAL), MIN(SAL), COUNT(EMPNO) AS CNT
FROM EMP
GROUP BY DEPTNO;

--Ex002. 같은직책(JOB)에 종사하는 사원이 3명 이상인 직책과 인원수를 출력하시오.
SELECT JOB, COUNT(*)
FROM EMP
GROUP BY JOB
HAVING JOB IN ('SALESMAN', 'CLERK', 'MANAGER');

--Ex003. 사원들의 입사년도(HIRE_YEAR)를 기준으로 부서별 몇명이 입사했는지 조회하시오.
SELECT TO_CHAR(HIREDATE, 'YYYY') AS HIRE_YEAR, DEPTNO, COUNT(*) AS CNT
FROM EMP
GROUP BY TO_CHAR(HIREDATE, 'YYYY'), DEPTNO;
--정렬 기준을 모르겠어요

--Ex004. 추가수당(COMM)을 받는 사원수와 받지않는 사원수를 조회하시오.
SELECT COMM, COUNT(*) AS CNT
FROM(
    SELECT 
        CASE WHEN TO_CHAR(COMM) IS NULL THEN 'X'
             WHEN TO_CHAR(COMM) IS NOT NULL THEN '0' 
             END                                    AS COMM 
             FROM EMP )
GROUP BY COMM
ORDER BY COMM DESC;

--Ex005. EMP 테이블을 이용하여 다음과 같이 출력하시오.
--각 부서의 입사연도별 사원수, 최고급여, 급여합, 평균급여를 출력하고
--각 부서별 소계와 총계를 출력하시오. (ROLLUP)
SELECT DEPTNO
, TO_CHAR(HIREDATE, 'YYYY') AS HIRE_YEAR
, COUNT(*) AS CNT
, MAX(SAL), SUM(SAL), AVG(SAL)
FROM EMP
GROUP BY ROLLUP(DEPTNO, TO_CHAR(HIREDATE, 'YYYY'));

--GROUP BY DEPTNO, JOB 은 어떤 기준으로 그룹화하나요? -> DEPTNO, JOB
--HAVING AVG(SAL) >= 2000 은 어떤 조건을 의미하나요? -> 평균 급여가 2000 이상
--ROLLUP(DEPTNO, JOB) 은 어떤 결과를 생성하나요? -> [부서+직업] - [부서] - [총계] 순으로 나옴
--GROUPING_ID(DEPTNO, JOB) 은 어떤 정보를 제공하나요?  -> 집계한 횟수
--PIVOT(MAX(SAL) FOR DEPTNO IN (10, 20, 30)) 은 어떤 형태로 결과를 출력하나요? ->JOB별 DEPTNO 10, 20, 30의 최대 급여
