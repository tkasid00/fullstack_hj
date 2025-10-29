--		1. table(post) + sequence(post_seq)
--
--			| 컬럼명        | 데이터 타입       | 제약 조건       | 설명 |
--			|---------------|-------------------|------------------|------|
--			| `id`          | `NUMBER`          | `PRIMARY KEY`    | 게시글 고유 ID |
--			| `app_user_id` | `NUMBER`          | `NOT NULL`       | 작성자 ID (`appuser` 테이블 참조) |
--			| `title`       | `VARCHAR2(200)`   | `NOT NULL`       | 게시글 제목 |
--			| `content`     | `CLOB`            | `NOT NULL`       | 게시글 내용 (대용량 텍스트, 최대 4GB) |
--			| `pass`        | `VARCHAR2(100)`   | —                | 비회원 삭제용 비밀번호 |
--			| `created_at`  | `DATE`            | `DEFAULT SYSDATE`| 작성일 |
--			| `hit`         | `NUMBER`          | `DEFAULT 0`      | 조회수 |
--			| —             | —                 | `FOREIGN KEY`    | `app_user_id`는 `appuser(app_user_id)` 참조 |
--
--			SQL> desc post
--			Name                                      Null?    Type
--			----------------------------------------- -------- ----------------------------
--			ID                                        NOT NULL NUMBER
--			APP_USER_ID                               NOT NULL NUMBER
--			TITLE                                     NOT NULL VARCHAR2(200)
--			CONTENT                                   NOT NULL CLOB
--			PASS                                               VARCHAR2(100)
--			CREATED_AT                                         DATE
--			HIT                                                NUMBER



CREATE TABLE POST(
        ID          NUMBER          PRIMARY KEY,
        APP_USER_ID NUMBER          NOT NULL,
        TITLE       VARCHAR2(200)   NOT NULL,
        CONTENT     CLOB            NOT NULL,
        PASS        VARCHAR2(100),
        CREATED_AT  DATE            DEFAULT SYSDATE,
        HIT         NUMBER          DEFAULT 0
        
     --PRIMARY KEY(ID) 이렇게 따로 써도 됨!   
        
);

DESC POST;

CREATE SEQUENCE POST_SEQ;

SELECT * FROM POST;


--------------------------------dao 테스트---------------------------------------
--1.[글쓰기] 글쓰기할 때 필요한 sql 
INSERT INTO POST (  ID,              APP_USER_ID, TITLE, CONTENT, PASS, CREATE_AT, HIT) 
		   VALUES( POST_SEQ.NEXTVAL,   ?        ,   ?  ,     ?  ,   ? ,       ?  ,   ?      );
           
--테스트           
INSERT INTO POST (  ID, APP_USER_ID, TITLE, CONTENT, PASS) VALUES( POST_SEQ.NEXTVAL, 1, 'TITLE', 'CONTETN', '1111');           


--2.[전체보기] 전체 글 가져오기, appuser 테이블에서 email도 같이 가져오기 sql
SELECT  P.*, U.EMAIL
FROM POST P JOIN APPUSER U ON(P.APP_USER_ID=U.APP_USER_ID);


--3.[상세보기] 글 번호에 해당하는 글 가져오기 sql
SELECT * FROM POST WHERE ID=?;
UPDATE POST SET HIT=HIT+1 WHERE ID=?;   //조회수 올리기

--테스트
SELECT * FROM POST WHERE ID=1;
UPDATE POST SET HIT=HIT+1 WHERE ID=1;


--4. 글 수정하기 sql
UPDATE POST SET TITLE=?, CONTENT=? WHERE ID=? AND PASS=?;

--테스트
UPDATE POST SET TITLE='NEW_TITLE', CONTENT='CONTENT2' WHERE ID=1 AND PASS=1111;


--5. 글 삭제하기 sql 
DELETE FROM POST WHERE ID=? AND PASS=?;

---테스트
DELETE FROM POST WHERE ID=1 AND PASS=1111;