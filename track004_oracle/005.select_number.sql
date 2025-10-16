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