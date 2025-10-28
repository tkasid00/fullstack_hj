--★ 데이터베이스 언어
--CRUD(create, read, update, delete)
--1. DML 조작어(데이터) : insert(삽입), select(조회), update(수정), delete(삭제) -> CRUD
--2. DDL 정의어(구조) : create(테이블 만들기), alter(테이블 수정), drop(테이블 삭제-복구 불가) -> CAD
--3. DCL 제어어(접근 권한) : grant(권한 부여), revoke(권한 회수) 
--4. TCL 제어어(트랜젝션) : commit(반영), rollback(되돌리기), savepoint(지점)
--------------------------------------------------------------------------------
--1. DML 조작어(데이터) : ■insert(삽입), select(조회), update(수정), delete(삭제)

--#1. 테이블 복사해오기
CREATE TABLE DEPT_TEMP AS SELECT * FROM DEPT;
--구조 확인
DESC DEPT_TEMP;  --[이름     널? 유형]    -> 널? : 널 허용
SELECT * FROM DEPT_TEMP;

--#2. INSERT-------------------------------------------------
 INSERT INTO 테이블명(필드1, 필드2....) VALUES(값1, 값2...)
-------------------------------------------------------------
INSERT INTO DEPT_TEMP(DEPTNO, DNAME, LOC) VALUES(50, 'DATABASE', 'SEOUL'); --필드와 값 일치
INSERT INTO DEPT_TEMP                     VALUES(60, 'NETWORK','BUSAN'); --필드 순서 동일할 경우 생략 가능
INSERT INTO DEPT_TEMP                     VALUES(70, 'WEB', NULL); 
INSERT INTO DEPT_TEMP(DEPTNO, LOC, DNAME) VALUES(80, '','FRONT'); 
INSERT INTO DEPT_TEMP(LOC, DNAME, DEPTNO) VALUES('INCHEON','BACK',90); 
INSERT INTO DEPT_TEMP(DEPTNO, DNAME) VALUES(99, 'MOBILE'); --NULL일 경우 필드 생략

COMMIT; --오라클에서는 커밋해야 반영됨
SELECT * FROM DEPT_TEMP;

--Q1. EMP 테이블 복사해서 EMP_TEMP 만드시오(구조 확인, 전체 테이터 확인)
CREATE TABLE EMP_TEMP AS SELECT * FROM EMP; 
DESC EMP_TEMP;
SELECT * FROM EMP_TEMP;

--Q2. 모든 필드 명시하여 다음의 값 넣기 
--  9999, '홍길동', 'PRESIDENT', NULL, '2001/01/01', 5000, 1000, 10
INSERT INTO EMP_TEMP(EMPNO, ENAME,    JOB,       MGR,    HIREDATE,   SAL, COMM, DEPTNO) 
              VALUES(9999, '홍길동', 'PRESIDENT', NULL, '2001/01/01', 5000, 1000, 10);

--Q3. 필드 명시하지 않고 다음의 값 넣기
-- 1111, '성춘향', 'MANAGER', 9999, '2001-01-05', 4000, NULL, 20

INSERT INTO EMP_TEMP VALUES(1111, '성춘향', 'MANAGER', 9999, '2001-01-05', 4000, NULL, 20);

COMMIT;
SELECT * FROM EMP_TEMP;

--------------------------------------------------------------------------------
--1. DML 조작어(데이터) : insert(삽입), select(조회), ■update(수정), ■delete(삭제) 
--#0. 
SELECT * FROM DEPT_TEMP;

--#1. UPDATE ----------------------------------
UPDATE 테이블명 
SET 바꿀 필드1 = 바꿀 값1, 바꿀 필드2 = 바꿀 값2...
WHERE 조건;
------------------------------------------------
--#2-1. 전체 테이터 UPDATE
UPDATE DEPT_TEMP SET LOC = 'INCHEON'; -- WHERE 미지정 시 일괄 변동

--#2-2. 개별 데이터 UPDATE
UPDATE DEPT_TEMP SET LOC = 'NEW YORK' WHERE DEPTNO=10; --WHERE에 해당하는 데이터 변동
UPDATE DEPT_TEMP SET LOC = 'DALLAS' WHERE DEPTNO=20 AND DNAME='RESEARCH'; 

SELECT * FROM DEPT_TEMP;


--#3. DELETE : 데이터 삭제(필드는 유지)------
DELETE FROM 테이블명 WHERE 조건
------------------------------------------
DELETE FROM DEPT_TEMP;  --조건이 없을 시 전체 데이터 삭제

DELETE FROM DEPT_TEMP WHERE DEPTNO=10;
DELETE FROM DEPT_TEMP WHERE DEPTNO >=30;

--재삽입
INSERT INTO DEPT_TEMP(DEPTNO, DNAME, LOC) 
               SELECT DEPTNO, DNAME, LOC  FROM DEPT;
COMMIT ;
SELECT * FROM DEPT_TEMP;


--Q1. DEPT_TEMP에서 모든 데이터 삭제
DELETE FROM DEPT_TEMP;

--Q2. INSERT 이용해서 데이터 삽입, 반영
INSERT INTO DEPT_TEMP SELECT * FROM DEPT;
rollback; -- 되돌리기
COMMIT;

--Q3. DEPT_TEMP 테이블에서 40번 부서의 이름을 DATABASE, 지역을 SEOUL로 수정하시오
UPDATE DEPT_TEMP SET DNAME='DATABASE', LOC='SEOUL' WHERE DEPTNO=40;

--Q4. 위의 데이터 되돌리기(*같이)

--------------------------------------------------------------------------------
--4. TCL 제어어(트랜젝션) : commit(반영), rollback(되돌리기), savepoint(지점)
--------------------------------------------------------------------------------

-- #0. 준비 -  다음 문제들을 풀으시오
-- Q1. DEPT 테이블을 복사해 DEPT_TCL테이블을 작성하시오.
CREATE TABLE DEPT_TCL AS SELECT * FROM DEPT;

-- Q2. DEPT_TCL 테이블에 다음과 같이 데이터를 입력, 수정, 삭제 하시오.
--    2-1.  데이터 삽입   50, 'DATABASE', 'SEOUL'
INSERT INTO DEPT_TCL VALUES(50, 'DATABASE', 'SEOUL');

--    2-2.  부서번호가 40인  LOC를 INCHEON 으로 수정
UPDATE DEPT_TCL SET LOC='INCHEON' WHERE DEPTNO=40;

--    2-3.  DNAMD이 RESEARCH 인데이터 삭제
DELETE FROM DEPT_TCL WHERE DNAME='RESEARCH';

--    2-4.  전체데이터 확인
SELECT * FROM DEPT_TCL;


--#1. 데이터 반영
COMMIT;

--#2. 데이터 되돌리기(COMMIT 이후에는 롤백 효과X, 이전 COMMIT까지 되돌림)
ROLLBACK;

INSERT INTO DEPT_TCL DETP_TCL VALUES(20, 'AI', 'INCHEON');


--#3. SAVEPOINT - 작업 후 저장
INSERT INTO DEPT_TCL DETP_TCL VALUES(60, 'AI', 'INCHEON'); --INSERT 
SAVEPOINT SP_INSERT;  --기준점 설정

UPDATE DEPT_TCL SET DEPTNO=20 WHERE DEPTNO=60; --UPDATE 설정
SAVEPOINT SP_UPDATE; --INSERT 확정, 이후 작업만 되돌리기(기준점 설정2)

ROLLBACK TO SP_INSERT;

--------------------------------------------------------------------------------
--2. DDL 정의어(구조) : create(테이블 만들기), alter(테이블 수정), drop(테이블 삭제-복구 불가)
--------------------------------------------------------------------------------
--#1. CREATE------------------------
CREATE TABLE 테이블명 (
    필드명1 자료형 옵션(제약조건), 
    필드명2 자료형 옵션(제약조건),
    필드명3 자료형 옵션(제약조건)
    );
-----------------------------------------------------
필드명 - 영문소문자
자료형 - 숫자 NUMBER / 문자열 VARCHAR2(개수) / 날짜 DATE 
옵션 - 필수 입력 NOT NULL / 기본값 PRIMARY KEY 
-----------------------------------------------------
CREATE TABLE DEPT_DDL (
    DEPTNO NUMBER(2) PRIMARY KEY,
    DNAME VARCHAR(50) NOT NULL,
    LOC VARCHAR2(50) 
);

DESC DEPT_DDL;

-- 컬럼 추가-------------------------------------
ALTER TABLE 테이블명  ADD    필드명 자료형
                    DROP    필드명
                    MODIFY  필드명 자료형 
-----------------------------------------------
--추가
ALTER TABLE DEPT_DDL ADD ADMIN VARCHAR(50);

--수정
ALTER TABLE DEPT_DDL MODIFY ADMIN VARCHAR(100) NOT NULL;

--삭제
ALTER TABLE DEPT_DDL DROP COLUMN ADMIN;


------------------
DROP TABLE 테이블명
------------------
DROP TABLE DEPT_DDL;
ROLLBACK;               --DROP은 롤백 불가.
DESC DEPT_DDL;


--------------------------------------------------------------------------------
--PART)  테이블 만들기
--✅ 문제 1:  다음과 같이 테이블을 작성하고 데이터를 삽입하세요
--※AppUser 의 FK는 무시하세요.
--
--#### 1. `MbtiType`
--| 필드명 | 타입 | 설명 |
--|--------|------|------|
--| mbti_type_id | INT (PK) | MBTI 유형 ID |
--| name | VARCHAR(10) | 유형 이름 (예: ENFP) |
--| description | TEXT | 성향 설명 |
--
--**예시 데이터**
--```sql
--(3, 'ENFP', '열정적이고 창의적인 성향')
--(7, 'INTJ', '논리적이고 전략적인 성향')
--```

CREATE TABLE MbtiType (
--          필드명         자료형     옵션
        mbti_type_id  NUMBER  PRIMARY KEY,
        NAME    VARCHAR(10),
        DESCRIPTION     VARCHAR(200)   
);
DESC MBTITYPE;

--#### 2. `AppUser`
--| 필드명 | 타입 | 설명 |
--|--------|------|------|
--| app_user_id | INT (PK) | 사용자 고유 ID |
--| email | VARCHAR(100) | 이메일 주소 |
--| password | VARCHAR(255) | 암호화된 비밀번호 |
--| mbti_type_id | INT (FK → MbtiType.mbti_type_id) | 연결된 MBTI 유형 |
--| created_at | DATETIME | 가입일 |
--
--**예시 데이터**
--```sql
--(1, 'alice@example.com', 'hashed_pw_123', 3, 2, '2025-10-01 10:00:00')
--(2, 'bob@example.com', 'hashed_pw_456', 7, 1, '2025-10-02 14:30:00')
--```

CREATE TABLE APPUSER(
    app_user_id NUMBER(5) PRIMARY KEY,  --INT는 정수, 실수 가능
    email   VARCHAR(100),
    password  VARCHAR(255),
    mbti_type_id INT,
    created_at  DATE
);

DESC APPUSER;

--PART)  ALTER
--✅ 문제 1: AppUser 테이블에 사용자 이름(name) 컬럼을 추가하세요.
--컬럼 타입은 VARCHAR2(50)이며 NULL 허용
ALTER TABLE APPUSER ADD NAME VARCHAR2(50);

--✅ 문제 2: AppUser 테이블의 email 컬럼에 NOT NULL 제약을 추가하세요.
ALTER TABLE APPUSER MODIFY EMAIL NOT NULL;
 
--✅ 문제 3: AppUser 테이블의 password 컬럼 길이를 255 → 100으로 줄이세요.
ALTER TABLE APPUSER MODIFY PASSWORD VARCHAR(100);
-- 
--✅ 문제 4: MbtiType 테이블에 컬럼 category를 추가하세요. 
--타입은 VARCHAR2(20)이며 기본값은 '기본'
ALTER TABLE MBTITYPE ADD CATEGORY VARCHAR2(20) DEFAULT '기본';

--✅ 문제 5: MbtiType 테이블의 description 컬럼 이름을 details로 변경하세요.
ALTER TABLE MBTITYPE RENAME COLUMN DESCRIPTION TO DETAILS;
-- 
--✅ 문제 6: AppUser 테이블의 name 컬럼을 삭제하세요.
ALTER TABLE APPUSER DROP COLUMN NAME;

--✅ 문제 7:  MbtiType 테이블 이름을 MbtiInfo로 변경하세요.
ALTER TABLE MBTITYPE RENAME TO MBTIINFO;
    
DESC MBTIINFO;
DESC MBTITYPE;
--다시 되돌리기
ALTER TABLE MBTIINFO RENAME TO MBTITYPE;

SELECT * FROM APPUSER;
SELECT * FROM MBTITYPE;