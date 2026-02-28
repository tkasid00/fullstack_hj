--1. 시퀀스 : 자동 번호 생성기 ★
--2. 뷰 : 가상 테이블(SELECT문 결과를 저장한 객체) ★
--3. 동의어 : 객체에 대한 별칭
--4. 인덱스 : 검색 성능 향상 ★
--5. 클러스터 : 여러 테이블을 물리적으로 같은 공간에 저장 
--------------------------------------------------------------------------------
--1. 시퀀스 : 자동 번호 생성기 
--#1. 시퀀스 만들기
CREATE SEQUENCE EMP_SEQ; --1부터 1개씩 증가, 최대값 10^27
CREATE SEQUENCE DEPT_SEQ;


CREATE SEQUENCE EMP_SEQ2
START WITH 1000 --시작값
INCREMENT BY 1  --증가 단위
MAXVALUE 9999 --최대값 지정
NOCACHE;  --메모리에 미리 몇 개 저장할지


--#2. 시퀀스 사용하기
SELECT * FROM EMP_SEQ;  --테이블 아님, 조회 불가

SELECT EMP_SEQ.NEXTVAL FROM DUAL; --다음 번호 조회
SELECT DEPT_SEQ.NEXTVAL FROM DUAL;

DESC DEPT_TEMP;

INSERT INTO DEPT_TEMP VALUES(DEPT_SEQ.NEXTVAL, 'AI', 'INCHEON');
SELECT * FROM DEPT_TEMP;

--Q. APPUSER 테이블에서 APPUSER_SEQ 시퀀스 만들기
CREATE SEQUENCE APPUSER_SEQ;

ALTER TABLE APPUSER MODIFY EMAIL VARCHAR2(100) UNIQUE;  --유일한 값

SELECT COLUMN_NAME FROM USER_IND_COLUMNS WHERE TABLE_NAME ='APPUSER' AND COLUMN_NAME='EMAIL';  --확인용
DESC APPUSER;

DELETE FROM APPUSER;
SELECT * FROM APPUSER;