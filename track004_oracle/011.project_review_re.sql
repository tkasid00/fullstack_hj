-----------------------------------
--REVIEWID      NOT NULL NUMBER            고유 글번호 - next.val 처리
--USERIP        NOT NULL VARCHAR2(100)     작성자 자동 정보
--NICKNAME      NOT NULL VARCHAR2(50)      작성자 지정 정보
--PASSWORD      NOT NULL VARCHAR2(50)      작성자 지정 암호
--BRANDID       NOT NULL NUMBER            foodbrand 참조
--FOODID        NOT NULL NUMBER            food 참조
--REVIEWIMG              VARCHAR2(300)     작성자 지정 이미지
--RATING        NOT NULL NUMBER(1)         별점
--TITLE         NOT NULL VARCHAR2(100)     제목
--REVIEWCONTENT          VARCHAR2(500)     내용
--CREATEDAT              DATE              작성일       
--UPDATEDAT              DATE              수정일
-----------------------------------
CREATE TABLE FOODREVIEW(
    REVIEWID NUMBER PRIMARY KEY,
    USERIP VARCHAR2(100) NOT NULL, 
    NICKNAME VARCHAR2(50) DEFAULT '익명' NOT NULL,
    PASSWORD VARCHAR2(50) NOT NULL,
    BRANDID NUMBER NOT NULL, 
    FOODID NUMBER NOT NULL,
    REVIEWIMG VARCHAR2(300) DEFAULT NULL,
    RATING NUMBER(1) NOT NULL,
    TITLE VARCHAR2(100) NOT NULL, 
    REVIEWCONTENT VARCHAR2(500),
    CREATEDAT DATE DEFAULT SYSDATE,
    UPDATEDAT DATE DEFAULT NULL
);

CREATE SEQUENCE FOODREVIEW_SEQ
START WITH 1 INCREMENT BY 1
NOCACHE;

desc foodreview;
select * from foodreview;

commit; 


--
insert into foodreview(
reviewid, 
userip, 
nickname, 
password, 
brandid, 
foodid, 
reviewimg, 
rating, 
title, 
reviewcontent, 
createdat)
values(
foodreview_seq.nextval,
'*',
'test',
'1111',
'1',
'1',
null,
'5',
'test01',
'ㅎㅎ',
sysdate
);


select 
    r.reviewid as reviewid,
    r.userip as userip,
    r.nickname as nickname, 
    r.password as password,
    b.brandname as brandname,
    f.foodname as foodname, 
    f.foodimg as foodimg,
    r.rating as rating,
    r.title as title,
    f.pettypeid as pettypeid,
    r.reviewcontent as reviewcontent,
    r.createdat as createdat,
    r.createdat as createdat
from foodreview r join food f on(r.foodid=f.foodid) 
    join foodbrand b on(f.brandid=b.brandid)
    join pettype p on(p.pettypeid=f.pettypeid);

desc pettype;
update foodreview 
set nickname='user2',
    brandid=2, 
    foodid=2,
    reviewimg='0',
    rating='4',
    title='updatetest',
    reviewcontent='test00',
    updatedat=sysdate
where reviewid=1 and password='1111';
    
     select * from foodreview;
insert into foodreview(
reviewid, 
userip, 
nickname, 
password, 
brandid, 
foodid, 
rating, 
title, 
reviewcontent, 
createdat)
values(
foodreview_seq.nextval,
'*',
'brandtest04',
'1111',
'4',
'4',
'5',
'brand04',
'출력확인',
sysdate
);

commit;


	select 
	    r.reviewid as reviewid,
	    r.userip as userip,
	    r.nickname as nickname, 
	    r.password as password,
	    b.brandname as brandname,
	    f.foodname as foodname, 
	    f.foodimg as foodimg,
	    r.reviewimg as reviewimg,
	    r.rating as rating,
	    r.title as title,
	    r.reviewcontent as reviewcontent,
	    r.createdat as createdat,
	    r.updatedat as updatedat,
	    f.pettypeid as pettypeid
	from foodreview r join food f on(r.foodid=f.foodid) 
	    join foodbrand b on(f.brandid=b.brandid)
	    join pettype p on(p.pettypeid=f.pettypeid);
    
UPDATE foodreview
SET reviewimg = NULL where reviewid=1;
commit;


select f.foodid, f.foodname, f.brandid, b.brandname
from food f
join foodbrand b on f.brandid = b.brandid;


select * from foodreview;


	select 
	    r.reviewid as reviewid,
	    r.userip as userip,
	    r.nickname as nickname, 
	    r.password as password,
	    b.brandname as brandname,
	    f.foodname as foodname, 
	    f.foodimg as foodimg,
	    r.reviewimg as reviewimg,
	    r.rating as rating,
	    r.title as title,
	    r.reviewcontent as reviewcontent,
	    r.createdat as createdat,
	    r.updatedat as updatedat,
	    f.brandid as brandid
	from foodreview r join food f on(r.foodid=f.foodid) 
	    join foodbrand b on(f.brandid=b.brandid);
        


select distinct foodid from foodreview;

select foodid, brandid from food
where foodid in (select distinct foodid from foodreview);

select r.foodid, f.foodid, f.brandid
from foodreview r
join food f on r.foodid=f.foodid;

select brandid from foodreview;



select 
    r.reviewid as reviewid,
    r.userip as userip,
    r.nickname as nickname,
    r.password as password,
    b.brandname as brandname,
    f.foodname as foodname,
    f.foodimg as foodimg,
    r.reviewimg as reviewimg,
    r.rating as rating,
    r.title as title,
    r.reviewcontent as reviewcontent,
    r.createdat as createdat,
    r.updatedat as updatedat,
    r.brandid as brandid
from foodreview r
join foodbrand b on r.brandid = b.brandid
join food f on r.foodid = f.foodid;