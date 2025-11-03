--■ 제약 조건
1. NOT NULL NULL    입력 금지
2. UNIQUE           중복 금지(NULL 허용)
3. PRIMARY KEY      고유 식별자(중복, NULL 금지)
4. FOREIGN KEY      다른 테이블 참조
5. CHECK            조건 검사


--rdb
--테이블 관계 속성
--FOREIGN KEY
--1. 다른 테이블 참조
--2. 부모 테이블의 값만 입력 가능
--3. 참조무결성 유지(부모 속성 파생)


--부서는 많은 사원(EMP_FK)을 가진다 
--부서 테이블이 먼저 존재해야됨(부모 테이블 DEPT_FK)

CREATE TABLE DEPT_FK (
    DEPTNO NUMBER PRIMARY KEY, --기본키
    DNAME VARCHAR2(50) NOT NULL
);


CREATE TABLE EMP_FK (
    EMPNO NUMBER PRIMARY KEY, --기본키
    ENAME VARCHAR2(50) NOT NULL,
    DEPTNO NUMBER(2),
    CONSTRAINT FK_DEPT FOREIGN KEY(DEPTNO) REFERENCES DEPT_FK(DEPTNO) ON DELETE CASCADE
                                 -- 내 테이블            부모테이블      같이 삭제
);

DESC DEPT_FK;
DESC EMP_FK;

SELECT * FROM DEPT_FK;
SELECT * FROM EMP_FK;

--1. INSERT DEPT_FK (부서 테이블 삽입)
INSERT INTO DEPT_FK(DEPTNO, DNAME) VALUES(10, 'BUG_HUNTER');
INSERT INTO DEPT_FK(DEPTNO, DNAME) VALUES(20, 'PAWJECT');
INSERT INTO DEPT_FK(DEPTNO, DNAME) VALUES(30, 'TEST');

INSERT INTO EMP_FK(EMPNO, ENAME, DEPTNO) VALUES(1, 'CHATGPT', 30);
INSERT INTO EMP_FK(EMPNO, ENAME, DEPTNO) VALUES(2, 'COPILOT', 40); -- parent key not found 부모값 40 존재X

--2. ON DELETE CASCADE
DELETE FROM DEPT_FK WHERE DEPTNO=30 ;  --부모 삭제 시 자식 DEPTNO 연결된 데이터 같이 삭제


---Q1. JSP+ORACLE 외래키 설정
--1. 구조 파악
DESC APPUSER;
--이름           널?       유형            
-------------- -------- ------------- 
--APP_USER_ID  NOT NULL NUMBER(5)     
--EMAIL        NOT NULL VARCHAR2(100) 
--PASSWORD              VARCHAR2(100) 
--MBTI_TYPE_ID          NUMBER(38)    
--CREATED_AT            DATE   


DESC POST;
--이름          널?       유형            
------------- -------- ------------- 
--ID          NOT NULL NUMBER        
--APP_USER_ID NOT NULL NUMBER        
--TITLE       NOT NULL VARCHAR2(200) 
--CONTENT     NOT NULL CLOB          
--PASS                 VARCHAR2(100) 
--CREATED_AT           DATE          
--HIT                  NUMBER 

--2. 부모자식 관계
-- 유저는 많은 글을 가질 수 있다 ㅇ
                                --본인_부모
ALTER TABLE POST ADD CONSTRAINT FK_POST_APPUSER FOREIGN KEY(APP_USER_ID) REFERENCES APPUSER(APP_USER_ID);

DELETE FROM APPUSER;  --POST 삭제 후 APPUSER 삭제(반대 방향 불가)
DELETE FROM POST;



-- DB상담
-- 프로젝트 올리기