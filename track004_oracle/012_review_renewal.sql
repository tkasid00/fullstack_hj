---------------리뷰--------------------
desc review;   
---------------------------------------
--이름            널?       유형            
--------------- -------- ------------- 
--REVIEWID      NOT NULL NUMBER             리뷰아이디(시퀀스)
--USERID        NOT NULL NUMBER             유저 아이디(users)
--BRANDID                NUMBER             브랜드 아이디(foodbrand)
--FOODID                 NUMBER             사료 아이디(food)
--RATING                 NUMBER(1)          별점
--TITLE                  VARCHAR2(100)      제목
--REVIEWCOMMENT          VARCHAR2(500)      리뷰 내용
--CREATEDAT              DATE               작성일
--UPDATEDAT              DATE               수정일

------------------------------------------------------
--CREATE
------------------------------------------------------
CREATE TABLE REVIEW (
    REVIEWID NUMBER PRIMARY KEY,
    USERID NUMBER NOT NULL,
    BRANDID NUMBER,
    FOODID NUMBER,
    RATING NUMBER(1) CHECK (RATING BETWEEN 1 AND 5),
    TITLE VARCHAR2(100), 
    REVIEWCOMMENT VARCHAR2(500),
    CREATEDAT DATE DEFAULT SYSDATE,
    UPDATEDAT DATE DEFAULT NULL
);    

CREATE SEQUENCE REVIEW_SEQ
START WITH 1 INCREMENT BY 1
NOCACHE;

DROP SEQUENCE REVIEW_SEQ;


---------------------------------------------------------
-- 리스트에서 토글로 상세 내용까지 출력(select) :
	 select r.reviewid, fb.brandname, f.foodname, f.foodimg, r.reviewimg, r.rating, r.title, r.reviewcomment, u.nickname, r.createdat, r.updatedat
			from review r join food f on(r.foodid=f.foodid)
               join foodbrand fb on(r.brandid=fb.brandid)
               join users u on(u.userid=r.userid);

-- 특정 리뷰 선택, 수정 시 사용(select) :
		select * from review where reviewid=#{reviewid};

-- 리뷰 작성(insert) : 	
	insert into review (reviewid, userid, brandid, foodid, reviewimg, rating, title, reviewcomment)
            values(review_seq.nextval, #{userid},#{brandid},#{foodid},#{reviewimg},#{rating},#{title},#{reviewcomment})
	
-- 리뷰 수정(update)	:
	update review set brandid=#{brandid}, foodid=#{foodid}, reviewimg=#{reviewimg}, 
						rating=#{rating}, title=#{title}, 
						reviewcomment=#{reviewcomment}, updatedat=sysdate
			where reviewid=#{reviewid} 

--리뷰 삭제(delete) : 
		delete from review where reviewid=#{reviewid} 