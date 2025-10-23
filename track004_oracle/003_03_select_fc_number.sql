--1. 문자열
--2. 숫자 : round/trunc(반올림/버림), ceil(올림), floor(내림), mod(나머지)
--3. 날짜 : sysdate(시스템 날짜), add_months(n달 뒤에), next_day(다음날), last_day(마지막날)
--4. 변환함수 : to_char(날짜 형식 변환), to_date
--5. 조건함수 : nvl, nv12 decode, case
--------------------------------------------------------------------------------
--2. 숫자 : round/trunc(반올림/버림), ceil(올림), floor(내림), mod(나머지)

select round(1234.5678)  -- 1235 : 0.5(디폴트 - 소수점 첫째자리)
from dual;

select round(1234.5678), round(1234.5678, 2), trunc(1234.5678, 2) from dual; 
          -- 1235              1234.57              1234.56

select ceil(1.1), floor(4.8), mod(10,3) from dual;
--          2           4            1


--3. 날짜 : sysdate(시스템 날짜, 시간 반환), add_months(n달 뒤에), next_day(다음날), last_day(마지막날)
select sysdate, add_months(sysdate, 2),  months_between('25-12-1', '24-12-1') from dual;
--     25/10/16           25/12/16                     간격 구하기 : 12

select next_day(SYSDATE, '월요일') "다음 주 월요일", last_day(SYSDATE) "해당 월의 마지막 날짜" from dual;  
--                      ->언어 설정에 따라 MONDAY 적용 불가, 한글로 써야 인식됨
select next_day(SYSDATE, 1) "다음 주 월요일", last_day(SYSDATE) "해당 월의 마지막 날짜" from dual;  
--              25/10/19                         25/10/31

--4. 변환함수 : to_char(날짜 형식 변환), to_date
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD')  -- 날짜->문자
    ,  TO_DATE('2025-10-16',  'YYYY-MM-DD') -- 문자->날짜
FROM DUAL;

SELECT TO_CHAR(1234) + 1   -- (1235)숫자 1234를 문자열로 변환하고 다음 +1 , 연산 중 자동 형변환 이루어짐
    , TO_NUMBER('5678')+1 
FROM DUAL;

SELECT   "1234" + 1   , 1 + "1234" FROM DUAL; --자료형이 맞지 않아 오류 발생

SELECT TO_CHAR('일이삼사') + 1 TO_NUMBER('일이삼사')+1 FROM DUAL; --오류 발생

--5. 조건함수 : nvl, nv12 decode, case

SELECT NVL(NULL, '대체값')  --NULL이면 대체값 null value replacement/logic
FORM DUAL;

SELECT NVL(COMM, '입력 안됨') --(숫자, 문자) 자료형 맞지 않아 대체 불가, 오류 발생
FROM EMP;

SELECT NVL(TO_CHAR(COMM), '입력 안됨') --(문자, 문자) 자료형 일치
FROM EMP;

SELECT NVL2(NULL, 'A', 'B') FROM DUAL; --NULL일 때 B, 아니면 A

SELECT NVL2(MGR, MGR, '--') FROM EMP; -- 오류 이유 : MGR은 숫자, '--'는 문자여서 자료형이 맞지 않음
SELECT NVL2(TO_CHAR(MGR), TO_CHAR(MGR), '상위 관리자X') FROM EMP; -- 해결
-- NVL, NVL2 : NULL일 때 값 반환, 자료형 맞추기!   

SELECT DECODE(DEPTNO, 10, '부서10', 20, '부서20', 30, '부서30') -- 자료형 맞지 않아도 반환됨/값 지정하지 않은 DEPTNO는 NULL값 반환 
FROM EMP;

SELECT CASE WHEN THEN ELSE END --한 문장
FROM EMP;

SELECT CASE
            WHEN DEPTNO=10 THEN '부서10'   
            WHEN DEPTNO=20 THEN '부서20'
            WHEN DEPTNO=30 THEN '부서30'
            ELSE                '부서X'
       END
FROM EMP;        
-------------------
SELECT CASE DEPTNO
            WHEN 10 THEN '부서10'   
            WHEN 20 THEN '부서20'
            WHEN 30 THEN '부서30'
            ELSE         '부서X'
       END
FROM EMP;  



--##1. 연습문제 45~49
--45.EMP테이블에서 NVL 함수를 사용하여 다음과 같이 출력하시오.
SELECT EMPNO, ENAME, SAL, COMM, SAL+COMM, NVL(COMM,0), SAL+NVL(COMM,0) --NULL값일 경우 0으로 바꿔야 연산이 제대로 됨
FROM EMP;

--46.EMP테이블에서 NVL2 함수를 사용하여 다음과 같이 출력하시오.
SELECT EMPNO, ENAME, COMM, NVL2(COMM, 'O', 'X'), 12*SAL AS ANNSAL 
FROM EMP;

--47.EMP테이블에서 DECODE 함수를 사용하여 다음과 같이 출력하시오.
--JOB이 MANAGER 는 급여의 10% 인상한 급여
--SALESMAN 는 급여의 5% 인상한 급여
--ANALYST 는 그대로
--나머지는 3% 인상된 급여

SELECT EMPNO, ENAME, JOB, SAL, 
DECODE( JOB, 'MANAGER', SAL*1.1, 'SALESMAN', SAL*1.05, 'ANALYST', SAL, SAL*1.03) AS UPSAL
FROM EMP


--48. EMP테이블에서 CASE 함수를 사용하여 다음과 같이 출력하시오.
--JOB이 MANAGER 는 급여의 10% 인상한 급여
--SALESMAN 는 급여의 5% 인상한 급여
--ANALYST 는 그대로
--나머지는 3% 인상된 급여
SELECT EMPNO, ENAME, JOB, SAL, 
        CASE JOB
            WHEN 'MANAGER' THEN SAL*1.1
            WHEN 'SALESMAN' THEN SAL*1.05
            WHEN 'ANALYST' THEN SAL
            ELSE SAL*1.03 END AS UPSAL
FROM EMP;

--49. 기준데이터 없이 조건식으로만 CASE 사용가능
--COMM 값이 NULL 이면 해당사항 없음 
--0 이면 수당없음
--0 초과시 초과한 수당을 출력력
-- job이랑 다르게 comm은 조건이 달라서 축약x when에 넣어줘야됨

SELECT EMPNO, ENAME, COMM, 
        CASE
            WHEN COMM IS NULL THEN '해당사항 없음'
            WHEN COMM=0 THEN '수당 없음'
            WHEN COMM>0 THEN TO_CHAR(COMM) 
            END AS COMM_TEXT
FROM EMP;


SELECT EMPNO, ENAME, COMM, 
        CASE
            WHEN COMM IS NULL THEN '해당사항 없음'
            WHEN COMM=0 THEN '수당 없음'
            WHEN COMM>0 THEN '수당 : ' || COMM -- 혹은 '수당 : ' || comm 이렇게 연결 가능
            END AS COMM_TEXT
FROM EMP;



--------------------------------------------------------------------------------
--사고확장

--1.EMP 테이블에서 다음과 같은 결과가 나오도록 SQL문을 작성하시오.
--EMP 테이블에서 ENAME이 다섯글자 이상이며 여섯글자 미만인 사원을 조회하시오.
--MASKING_EMPNO 는 EMPNO 앞두자리외 뒷자리를 *로 출력
--MASKING_ENAME 는 사원이름의 첫글자만 보여주고 나머지는 *로 출력
--※ 앞자리 추출 - SUBSTR(문자열, 어디에서, 몇개)
--※ RPAD - RPAD( 문자열, 몇자리, 채울값)
SELECT EMPNO
, RPAD(SUBSTR(EMPNO, 1, 2), 4, '*') AS MASKING_EMPNO
,  ENAME
,RPAD(SUBSTR(ENAME, 1, 1), LENGTH(ENAME), '*') AS MASKING_ENAME
FROM EMP
WHERE LENGTH(ENAME)>=5 AND LENGTH(ENAME) <6;


--2. EMP 테이블에서 다음과 같은 결과가 나오도록 SQL문을 작성하시오.
--EMP 테이블에서 사원들의 월 평균 근무일 수는 21.5일
--2 하루 근무시간을 8시간으로 보았을때 사원들의 하루급여(DAY_PAY) 와 시급(TIME_PAY)을 계산하여 결과를 조회하시오.
--※ 하루급여는 소수점 세번째 자리에서 버리고(TRUNC), 시급은 두번째 소수점에서 반올림(ROUND)하시오

SELECT EMPNO
, ENAME
, SAL
, TRUNC(SAL/21.5, 2)  AS DAY_PAY
, ROUND((SAL/21.5)/8 ,1) AS TIME_PAY
FROM EMP;


--3. EMP 테이블에서 다음과 같은 결과가 나오도록 SQL문을 작성하시오.
--EMP테이블에서 사원들은 입사일(HIREDATE)을 기준으로 3개월이 지난 후 첫 월요일에 정직원이 됨
--사원들이 정직원이 되는 날짜(R_JOB)를 YYYY-MM-DD 형식으로 오른쪽과 같이 출력하시오.
--추가 수당(COMM)이 없는 사원들의 추가수당은 N/A로 출력하시오.
--****R_JOB에서 연도 형식 바꾸는 방법**** >REPLACE 말고 TOCHAR 쓰면됨!!
SELECT EMPNO
, ENAME
, HIREDATE
, TO_CHAR( NEXT_DAY(ADD_MONTHS(HIREDATE, 3), '월요일'), 'YYYY-MM-DD')AS R_JOB
, NVL(TO_CHAR(COMM), 'N/A') COMM
FROM EMP;


--4. EMP 테이블에서 다음과 같은 결과가 나오도록 SQL문을 작성하시오.
--직속상관의 사원번호(MGR)를 다음과 같은 조건을 기준으로 변환해서 CHG_MGR열에 출력하시오
--직속상관의 사원번호가 존재하지 않을경우 : 00000
--직속상관의 사원번호 앞 두자리가 75일 경우 : 5555
--직속상관의 사원번호 앞 두자리가 76일 경우 : 6666
--직속상관의 사원번호 앞 두자리가 77일 경우 : 7777
--직속상관의 사원번호 앞 두자리가 78일 경우 : 8888
--그 외 직속상관 사원번호의 경우 : 본래 직속상관의 사원번호 그대로 출력

SELECT EMPNO
, ENAME
, MGR
, CASE  
    WHEN MGR IS NULL THEN 00000
    WHEN SUBSTR(MGR, 1, 2) = 75 THEN 5555 -- 숫자는 큰것부터 거르는게 유리(중복 검사 줄임)
    WHEN SUBSTR(MGR, 1, 2) = 76 THEN 6666
    WHEN SUBSTR(MGR, 1, 2) = 77 THEN 7777
    WHEN SUBSTR(MGR, 1, 2) = 78 THEN 8888 
    ELSE                            MGR
    END AS CHG_MGR
FROM EMP;

--SUBSTR(JOB, 1, 2) 는 어떤 결과를 반환하나요?
-- > JUB 첫번째부터 2자릿수 : JO
--INSTR(ENAME, 'S') > 0 은 어떤 조건을 의미하나요?
-- >  ENAME에서 S의 위치가 0보다 큼
--ROUND(SAL / 21.5 / 8, 1) 은 어떤 계산을 수행하나요?
-- > SAL을 21.5로 나누고 다시 8로 나눈 다음 소수점 둘째자리에서 반올림 해서 첫째자리까지 출력
--TO_CHAR(SYSDATE, 'DAY') 는 어떤 정보를 보여주나요?
-- > 현재 요일
--NVL(COMM, 0) 은 어떤 상황에서 유용한가요?
-- > 값이 존재하지 않는 상태일 때 숫자 0으로 변환해서 연산식 오류 방지






-- 문자열 연습문제 (19~44)
--19. ROUND를 이용하여 반올림 된 숫자 출력하기
SELECT ROUND(1234.5678) --1235
, ROUND(1234.5678,0) --1235
, ROUND(1234.5678,1) --1234.6
, ROUND(1234.5678,2) --1234.57
, ROUND(1234.5678,-1)  --1230 음수의 경우 숫자가 제거됨
, ROUND(1234.5678,-2) --1200
FROM DUAL;

--20. 특정위치에서 버리는 TRUNC 함수
SELECT TRUNC(1234.5678) --1234
, TRUNC(1234.5678, 0) --1234
, TRUNC(1234.5678, 1) --1234.5
, TRUNC(1234.5678, 2) --1234.56
, TRUNC(1234.5678 -1) --1230
, TRUNC(1234.5678 -2) --1200
FROM DUAL;

--21. CEIL : 가장 가까운 큰 정수, FLOOR : 가장 가까운 작은 정수 반환
SELECT CEIL(3.14)  --4
, FLOOR(3.14) --3
, CEIL(-3.14) -- -3
, FLOOR(-3.14) -- -4
FROM DUAL;

-- Q22  MOD : 특정 숫자를 나누고 그 나머지 출력
--   10을 3으로 나눴을때 나머지  , 10을 2로 나눴을때 나머지 
SELECT MOD(10, 3), MOD(10, 2), MOD(10, 4) FROM DUAL;
--           1           0           2

-- Q23  SYSDATE 함수를 사용하여 날짜 출력 (하루 이전, 이후)
SELECT SYSDATE 오늘, SYSDATE-1 어제, SYSDATE+1 내일 FROM DUAL;

--24.ADD_MONTHS 3개월 후 날짜
SELECT SYSDATE, ADD_MONTHS(SYSDATE, 3) FROM DUAL;

--25. EMP 테이블에서 입사 10주년이 되는 사원들의 데이터를 출력하시오.
SELECT EMPNO
, ENAME
, HIREDATE
, ADD_MONTHS(HIREDATE, 120) AS WOK10YEAR
FROM EMP;

--26. EMP 테이블에서 입사 42년 미만인 사원데이터를 출력하시오.
--12*42 = 504
--42년이 지나 안나올 수 도 있음. 안나오면 개월수 늘려서 테스트해볼것
SELECT EMPNO
, ENAME
, HIREDATE
, SYSDATE
FROM EMP
WHERE HIREDATE >  ADD_MONTHS(SYSDATE, -504); --  ADD_MONTHS(SYSDATE, 504) <SYSDATE;

--27. EMP 테이블에서 HIREDATE와 SYSDATE사이의 개월수를 출력하시오.
--MONTHS_BETWEEN 이용**
SELECT EMPNO 
, ENAME
, HIREDATE
, TO_DATE('2024-12-21','YYYY-MM-DD')
, MONTHS_BETWEEN(HIREDATE, TO_DATE('2024-12-21','YYYY-MM-DD')) AS MONTHS1
, MONTHS_BETWEEN( TO_DATE('2024-12-21','YYYY-MM-DD'), HIREDATE)  AS MONTHS2 
, TRUNC(MONTHS_BETWEEN( TO_DATE('2024-12-21','YYYY-MM-DD'), HIREDATE) ) AS MONTHS3
FROM EMP;


--28.돌아오는 요일에 해당하는 날짜와 달의 마지막 날짜를 자동으로 계산
SELECT SYSDATE
, NEXT_DAY(SYSDATE, '월요일')
, LAST_DAY(SYSDATE)
FROM DUAL;

--29.ROUND를 사용하여 날짜 데이터를 출력하시오.
SELECT SYSDATE
, ROUND(SYSDATE, 'CC') AS FORMAT_CC --CENTURY 세기
, ROUND(SYSDATE, 'YYYY')  AS FORMAT_YYYY --★ 다음 연도
, ROUND(SYSDATE, 'Q')  AS FORMAT_Q --분기
, ROUND(SYSDATE, 'DDD')  AS FORMAT_DDD --연중 일수 >반올림이라 12시 지나면 내일 날짜 출력
, ROUND(SYSDATE, 'HH')  AS FORMAT_HH --시간
FROM DUAL;

--30. TRUNC 함수를 사용하여 날짜 데이터를 출력하시오
SELECT SYSDATE
, TRUNC(SYSDATE, 'CC') AS FORMAT_CC --CENTURY 세기
, TRUNC(SYSDATE, 'YYYY')  AS FORMAT_YYYY --★ 다음 연도
, TRUNC(SYSDATE, 'Q')  AS FORMAT_Q --분기
, TRUNC(SYSDATE, 'DDD')  AS FORMAT_DDD --연중 일수 >버림, 12시 지나도 오늘 출력
, TRUNC(SYSDATE, 'HH')  AS FORMAT_HH --시간
FROM DUAL;

--31. 숫자와 문자열을 더하여 출력하시오
-- EMPNO(숫자) + '500'(문자) : 알파벳 포함X -> 자동형변환 처리
SELECT EMPNO, ENAME, EMPNO+'500' FROM EMP WHERE ENAME='SCOTT';

SELECT EMPNO, ENAME, EMPNO+TO_NUMBER('500') FROM EMP WHERE ENAME='SCOTT'; --권장(안전)

--32.문자열과 숫자를 더하여 출력하시오/오류가 난다면 그 이유를 적으시오.
SELECT EMPNO, ENAME, EMPNO+'500A' FROM EMP WHERE ENAME='SCOTT'; -- 자동 변환 불가

--33.SYSDATE 날짜 형식 지정하여 출력하시오.
SELECT SYSDATE
, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') AS "현재날짜시간"
FROM DUAL;

--34~38 SKIP
-- Q6-34
SELECT SYSDATE,
       TO_CHAR(SYSDATE, 'MM') AS MM,
       TO_CHAR(SYSDATE, 'MON') AS MON,
       TO_CHAR(SYSDATE, 'MONTH') AS MONTH,
       TO_CHAR(SYSDATE, 'DD') AS DD,
       TO_CHAR(SYSDATE, 'DY') AS DY,
       TO_CHAR(SYSDATE, 'DAY') AS DAY
  FROM DUAL;

-- Q6-35
SELECT SYSDATE,
       TO_CHAR(SYSDATE, 'MM') AS MM,
       TO_CHAR(SYSDATE, 'MON', 'NLS_DATE_LANGUAGE = KOREAN' ) AS MON_KOR,
       TO_CHAR(SYSDATE, 'MON', 'NLS_DATE_LANGUAGE = JAPANESE') AS MON_JPN,
       TO_CHAR(SYSDATE, 'MON', 'NLS_DATE_LANGUAGE = ENGLISH' ) AS MON_ENG,
       TO_CHAR(SYSDATE, 'MONTH', 'NLS_DATE_LANGUAGE = KOREAN' ) AS MONTH_KOR,
       TO_CHAR(SYSDATE, 'MONTH', 'NLS_DATE_LANGUAGE = JAPANESE') AS MONTH_JPN,
       TO_CHAR(SYSDATE, 'MONTH', 'NLS_DATE_LANGUAGE = ENGLISH' ) AS MONTH_ENG
  FROM DUAL;

-- Q6-36
SELECT SYSDATE,
       TO_CHAR(SYSDATE, 'MM') AS MM,
       TO_CHAR(SYSDATE, 'DD') AS DD,
       TO_CHAR(SYSDATE, 'DY', 'NLS_DATE_LANGUAGE = KOREAN' ) AS DY_KOR,
       TO_CHAR(SYSDATE, 'DY', 'NLS_DATE_LANGUAGE = JAPANESE') AS DY_JPN,
       TO_CHAR(SYSDATE, 'DY', 'NLS_DATE_LANGUAGE = ENGLISH' ) AS DY_ENG,
       TO_CHAR(SYSDATE, 'DAY', 'NLS_DATE_LANGUAGE = KOREAN' ) AS DAY_KOR,
       TO_CHAR(SYSDATE, 'DAY', 'NLS_DATE_LANGUAGE = JAPANESE') AS DAY_JPN,
       TO_CHAR(SYSDATE, 'DAY', 'NLS_DATE_LANGUAGE = ENGLISH' ) AS DAY_ENG
  FROM DUAL;

-- Q6-37
SELECT SYSDATE,
       TO_CHAR(SYSDATE, 'HH24:MI:SS') AS HH24MISS,
       TO_CHAR(SYSDATE, 'HH12:MI:SS AM') AS HHMISS_AM,
       TO_CHAR(SYSDATE, 'HH:MI:SS P.M.') AS HHMISS_PM
  FROM DUAL;

-- Q6-38
SELECT SAL,
       TO_CHAR(SAL, '$999,999') AS SAL_$,
       TO_CHAR(SAL, 'L999,999') AS SAL_L,
       TO_CHAR(SAL, '999,999.00') AS SAL_1,
       TO_CHAR(SAL, '000,999,999.00') AS SAL_2,
       TO_CHAR(SAL, '000999999.99') AS SAL_3,
       TO_CHAR(SAL, '999,999,00') AS SAL_4
  FROM EMP;
  
  
--39.문자데이터와 숫자데이터를 연산하여 출력하시오.
--숫자+'숫자로만 이루어진 문자열' ->가능
SELECT  1300-'1500', '1300'+1500 FROM DUAL;

--40~41. 문자데이터끼지 연산하여 출력하시오/오류가 난다면 그 이유를 적으시오.
-- 문자 ',' 삽입 시 숫자로 인식X
SELECT  '1500' - '1300' FROM DUAL; --O
SELECT  '1,500' - '1,300' FROM DUAL;--X
SELECT  TO_NUMBER('1,500', '999,999') - TO_NUMBER('1,300','999,999') FROM DUAL;

--42.TO_DATE를 이용하여 문자 데이터를 날짜 데이터로 변환하시오.
SELECT TO_DATE('1015-10-17', 'YYYY-MM-DD')
FROM DUAL;

--43~44
-- Q6-43
SELECT *
  FROM EMP
 WHERE HIREDATE > TO_DATE('1981/06/01', 'YYYY/MM/DD');

-- Q6-44
SELECT TO_DATE('49/12/10', 'YY/MM/DD') AS YY_YEAR_49,
       TO_DATE('49/12/10', 'RR/MM/DD') AS RR_YEAR_49,
       TO_DATE('50/12/10', 'YY/MM/DD') AS YY_YEAR_50,
       TO_DATE('50/12/10', 'RR/MM/DD') AS RR_YEAR_50,
       TO_DATE('51/12/10', 'YY/MM/DD') AS YY_YEAR_51,
       TO_DATE('51/12/10', 'RR/MM/DD') AS RR_YEAR_51
  FROM DUAL;
