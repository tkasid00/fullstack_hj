--1. 문자열
-- upper 대문자, lower 소문자, initcap 대소문자 변환
-- lenght 문자열 길이(lenghtb 바이트 수 확인)
-- substr 부분 문자열 추출, instr 위치 문자열(문자열 존재 확인)->위치 번호로 추출됨
-- replace 치환, pad(lpad, rpad) 개수 만큼 채우기 [123**]
-- trim(ltrim, rtrim) 공백 빼기 -> 수초 트리밍 생각하면 편함 
--2. 숫자
--3. 날짜
--4. 변환함수
--5. 조건함수
--------------------------------------------------------------------------------

--1. 문자열

--#1. 대소문자
-- initcap(ename) -> 첫 글자만 대문자
select ename, upper(ename), lower(ename), initcap(ename)
from emp;

--#2. 문자열 길이
select ename, length(ename), '킹', length('킹'), lengthb('킹')
from emp;

--#3. substr 부분문자열(문자열, 어디서부터, 몇 개), instr 위치문자열
select ename, substr(ename,1,2), substr(ename,1,3), substr(ename,2,2), substr(ename,3,2), substr(ename,-3,2) 
from emp;

--       뒤 1번째부터 끝까지,    뒤 3번째부터 끝까지,   뒤 3번째부터 2개
select  substr('oracle',-1), substr('oracle',-3), substr('oracle',-3,2) from dual;
--                   e                  cle                  cl              dual->범위 테이블

--o(1) r(2) a(3) c(4) l(5) e(6) 
select instr('oracle','a') from dual;  -- 3
select ename, instr(ename, 'A') from emp; --있으면 위치 번호, 없으면 0


--#4. replace 바꾸기, pad(lpad, rpad) 채우기
select replace('010-1234-5678','-',' ') from dual;  --'', ' ' 둘 다 가능
select lpad('oracle',10, '#') from dual; --left 채우기 [####oracle]
select rpad('oracle',10, '#') from dual; --right 채우기 [oracle####]


--#5. 공백 제거
select trim('  *oracle*  '), ltrim('  *oracle*  '), rtrim('  *oracle*  ') from dual;

--#6. concat 문자열 연결(2개의 문자열만 연결 가능)
select concat('Hello','Oracle') from dual; -- HelloOracle
select concat('Hello','Oracle', '★') from dual; --오류!
select concat( concat('Hello','Oracle') , '★') from dual; --중첩 사용, HelloOracle★

select 'Hello'||'Oracle'||'♥' from dual; -- HelloOracle♥

--------------------------------------------------------------------------------
-- ##1. 문자열 연습문제   (1~18)
-- https://sally03915.github.io/stackventure_250825/004_oracle/oracle004_select_fn#14

--1. EMP 테이블에서 ENAME을 대문자, 소문자, 첫글자만 대문자로 조회하시오.
SELECT ENAME, UPPER(ENAME), LOWER(ENAME), INITCAP(ENAME)
FROM EMP;

--2. EMP 테이블에서 UPPER를 이용하여 ENAME이 KING인 데이터를 조회하시오.
SELECT ENAME 
FROM EMP
WHERE UPPER(ENAME)=UPPER('KING');  --WHERE LOWER(ENAME)=LOWER('king');

--3. EMP 테이블에서 UPPER를 이용하여 ENAME에 KING인 포함된 데이터를 조회하시오.
SELECT ENAME 
FROM EMP
WHERE UPPER(ENAME) LIKE UPPER('%KING%');

--4. EMP 테이블에서 LENGTH를 이용하여 ENAME의 문자열 길이를 조회하시오.
SELECT ENAME, LENGTH(ENAME)
FROM EMP;

--5. EMP 테이블에서 ENAME의 문자열 길이가 5이상인 데이터를 조회하시오.
SELECT ENAME, LENGTH(ENAME)
FROM EMP
WHERE LENGTH(ENAME)>=5;

--6. LENGTH('한글'), LENGTHB('한글')
SELECT LENGTH('한글'), LENGTHB('한글') FROM DUAL;

--7. 문자열 일부분을 추출
--SUBSTR( 문자열 , 시작위치, 추출길이)
SELECT JOB, SUBSTR(JOB,1,2), SUBSTR(JOB,3,2), SUBSTR(JOB,5) FROM EMP;

--8. - 의 의미는? 뒤에서 n번째
--C(-5)L(-4)E(-3)R(-2)K(-1)
SELECT JOB, SUBSTR(JOB, -LENGTH(JOB) ), SUBSTR(JOB, -LENGTH(JOB),2 ),SUBSTR(JOB,-3) FROM EMP;

--9.특정문자위치 찾기
--INSTR(문자열, 찾을거, 시작위치, 몇번째)
--'HELLO, ORACLE!' 문자열에서 다음과 같이 찾으시오.
--해당 위치의 글자가 뭔지 확인 3(L), 12(L), 4(L)

SELECT INSTR('HELLO, ORACLE!', 'L') AS INSTR_1, 
        INSTR('HELLO, ORACLE!', 'L', 1, 3) AS INSTR_2, 
        --INSTR('HELLO, ORACLE!', 'L', 5) AS INSTR_2
        INSTR('HELLO, ORACLE!', 'L', -9) AS INSTR_3
        --INSTR('HELLO, ORACLE!', 'L', 2,2) AS INSTR_3
FROM DUAL;

--10. EMP테이블에서 INSTR 함수로 사원이름에 S가 있는 데이터를 조회하시오
SELECT *
FROM EMP
WHERE INSTR(ENAME, 'S')^=0; --INSTR(ENAME, 'S')>0

--11. EMP테이블에서 LIKE를 이용하여 사원이름에 S가 있는 데이터를 조회하시오
SELECT *
FROM EMP
WHERE ENAME LIKE '%S%';

--12.REPLACE를 이용하여 연락처의 -을 공백으로, -을 뺀데이터로 조회하시오오
SELECT '010-1234-5678' AS REPLACE_BEFORE, 
REPLACE('010-1234-5678', '-', ' ') AS REPLACE_1,
REPLACE('010-1234-5678', '-') AS REPLACE_2 --' ' 생략 가능
FROM DUAL;

--13.LPAD, RPAD를 이용하여 다음과 같이 데이터를 출력하시오
SELECT 'Oracle', 
LPAD('Oracle',10, '#') AS LPAD_1,
RPAD('Oracle',10, '*') AS RPAD_1,
LPAD('Oracle',10, ' ') AS LPAD_2,
RPAD('Oracle',10, ' ') AS RPAD_2
FROM DUAL;

--14. RPAD를 이용하여 개인정보뒷자리 *로 출력하시오.
SELECT 
RPAD('911225-', 14, '*') AS RPAD_JUMIN,
RPAD('010-1234-', 13,'*')AS RPAD_PHONE
FROM DUAL;

--15. EMP 테이블에서 EMPNO와 ENAME 사이에 :을 넣고 문자열을 연결하시오.
SELECT CONCAT(EMPNO, ENAME),
CONCAT(CONCAT(EMPNO, ':'), ENAME)
FROM EMP
WHERE ENAME='SCOTT';

--16. TRIM을 이용하여 다음과 같이 공백을 제거하고 출력하시오.
SELECT TRIM(' * *Oracle* * ') AS TRIM ,
      TRIM(LEADING ' ' FROM ' * *Oracle* * ') AS TRIM_LEADING ,
      TRIM(TRAILING ' ' FROM ' * *Oracle* * ') AS TRIM_TRAILING ,
      TRIM(BOTH ' ' FROM ' * *Oracle* * ') AS TRIM_BOTH
FROM DUAL;

--[ _ _Oracle_ _ ] 표현
-- '[ _ _Oracle_ _ ]' 사용 시 '_'가 사라짐->*로 대체
SELECT '[' || TRIM (' _ _Oracle_ _ ') || ']' AS TRIM
FROM DUAL;
---

SELECT '[' || TRIM (' * *Oracle* * ') || ']' AS TRIM --양쪽 공백 제거(중간 공백은 제거하지 않음)
    , '[' || LTRIM (' * *Oracle* * ') || ']' AS LTRIM
    , '[' || RTRIM (' * *Oracle* * ') || ']' AS RTRIM
    , '[' || TRIM (' * *Oracle* * ') || ']'  AS TRIM
FROM DUAL;


SELECT TRIM(' * *Oracle* * ') AS TRIM  -- 양쪽 공백 제거
      ,TRIM(LEADING FROM ' * *Oracle* * ') AS TRIM_LEADING -- 앞쪽 공백 제거 =LTRIM
     , TRIM(TRAILING FROM ' * *Oracle* * ') AS TRIM_TRAILING --뒤쪽 공백 제거 =RTRIM
     , TRIM(BOTH FROM ' * *Oracle* * ') AS TRIM_BOTH  --양쪽 공백 제거 =TRIM
FROM DUAL;


--17. TRIM을 이용하여 삭제할 문자('_') 삭제후 출력 가능
--' * *Oracle* * '(공백+*) 순서인 경우 *이 중간에 오기 때문에 제거되지 않음
select
   '[' ||  trim(' * *Oracle* * ') || ']' as trim 
,  '[' ||  trim( LEADING '*'  FROM   '* *Oracle* *') || ']' AS TRIM_LEADING
,  '[' ||  trim( TRAILING '*' FROM   '* *Oracle* *') || ']' AS TRIM_TRAILING
,  '[' ||  trim( BOTH  '*'    FROM   '* *Oracle* *') || ']' AS TRIM_BOTH 
from   dual;

--18.TRIM, LTRIM, RTRIM 사용하여 문자열 출력하기기
SELECT '[' || TRIM (' * *Oracle* * ') || ']' AS TRIM 
    , '[' || LTRIM (' * *Oracle* * ') || ']' AS "L.TRIM 1" --왼쪽 공백 제거
    , '[' || LTRIM ('*-Oracle-*', '*' ) || ']'  AS "L.TRIM 2" --원하는 왼쪽 문자 제거
    , '[' || RTRIM (' * *Oracle* * ') || ']' AS "R.TRIM 1" --오른쪽 공백 제거
    , '[' || RTRIM ('*-Oracle-*', '*' ) || ']'  AS "R.TRIM 2" --원하는 오른쪽 문자 제거
FROM DUAL;