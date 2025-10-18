## 📚 day033 복습 

-- Ex001 union 과 union all 의 차이 -  중복없이 합집합, 중복있게 합집합

-- Ex002 EMP테이블에서 COMM 이 없고 , MGR은 존재하면 JOB 이 'MANAGER', 'CLERK' 인 사원 중 사원의 이름2번째 글자기 L 이 아닌 사원의 정보를 조회하시오
-- EMP테이블에서 
-- COMM 이 없고 , 
-- MGR은 존재하면 
-- JOB 이 'MANAGER', 'CLERK' 인 사원 중 
-- 사원의 이름2번째 글자가 L 이 아닌 사원의 정보를 조회하시오
select  *
from    emp
where   comm is null   
and     mgr is not null
and     job in('MANAGER', 'CLERK' )
and     ename not like '_L%';

--Ex003
-- EMP 테이블에서 UPPER를 이용하여 ENAME에 AM인 포함된 데이터를 조회하시오.
-- 대소문자 상관없이 AM인 사람을 조회하는 것이 가능해짐. 
select  ename from    emp   where   upper(ename) like upper('%AM%'); 

--EX004 해당하는 함수를 적으시오.
-- 1-1. (upper)  대문자, (lower) 소문자, (initcap) 대소문자 변환
-- 1-2. (length) 문자열길이
-- 1-3. (substr) 부분문자열 ,   (instr)  위치문자열
-- 1-4. (replace) 바꾸기 ,  (lpad), rpad 채우기
-- 1-5. (trim) , (ltrim), (rtrim)  공백빼기
-- 1-6. (concat) 문자열연결