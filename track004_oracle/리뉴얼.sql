
--1. 브랜드 외래키X
CREATE TABLE BRAND (
    BRANDID        NUMBER           PRIMARY KEY,
    BRANDNAME      VARCHAR2(100)    NOT NULL,
    COUNTRY        VARCHAR2(100), 
    ORIGIN         VARCHAR2(50),             
    BRANDINFO      VARCHAR2(500)

);
CREATE SEQUENCE BRAND_SEQ 
START WITH 1 INCREMENT BY 1
NOCACHE;

--로얄캐닌
--https://www.royalcanin.com/kr
INSERT INTO BRAND(BRANDID, BRANDNAME, COUNTRY, ORIGIN, BRANDINFO )
VALUES(BRAND_SEQ.NEXTVAL, '로얄캐닌', '프랑스', '해외', '건강에 대한 바른 집념, 로얄캐닌');

--힐스
--https://www.hillspet.co.kr/
INSERT INTO BRAND(BRANDID, BRANDNAME, COUNTRY, ORIGIN, BRANDINFO )
VALUES(BRAND_SEQ.NEXTVAL, '힐스', '미국', '해외', '힐스 펫 뉴트리션, 과학에 기반한 프리미엄 반려동물 사료');

--인스팅트
--http://www.instinctpetfood.co.kr/
INSERT INTO BRAND(BRANDID, BRANDNAME, COUNTRY, ORIGIN, BRANDINFO )
VALUES(BRAND_SEQ.NEXTVAL, '인스팅트', '미국', '해외', '생식에 기반을 둔 영양 인스팅트');

--오리젠
--https://apac.orijenpetfoods.com/ko-KR/homepage
INSERT INTO BRAND(BRANDID, BRANDNAME, COUNTRY, ORIGIN, BRANDINFO )
VALUES(BRAND_SEQ.NEXTVAL, '오리젠', '캐나다', '해외', '자연 유래 영양 성분');

--뉴트리플랜
--http://www.dongwonpet.com/
INSERT INTO BRAND(BRANDID, BRANDNAME, COUNTRY, ORIGIN, BRANDINFO )
VALUES(BRAND_SEQ.NEXTVAL, '뉴트리플랜', '한국', '국내', '냥이 보호자들이 선택한 브랜드');

--웰니스
--https://wellnesspet.kr/
INSERT INTO BRAND(BRANDID, BRANDNAME, COUNTRY, ORIGIN, BRANDINFO )
VALUES(BRAND_SEQ.NEXTVAL, '웰니스', '미국', '해외', '유한양행 사료, 웰니스');

COMMIT; 

--2.푸드 (FK) BRANDID : BFAND(BRANDID)
CREATE TABLE PETFOOD (
    FOODID          NUMBER          PRIMARY KEY,
    FOODNAME        VARCHAR2(100)   NOT NULL,
    BRANDID         NUMBER          NOT NULL,
    DESCRIPTION     VARCHAR2(500),
    MAININGREDIENT  VARCHAR2(200)   NOT NULL,
    SUBINGREDIENT   VARCHAR2(200),
    PETTYPEID       NUMBER           DEFAULT 1,
    PETTYPENAME     VARCHAR2(255)    DEFAULT '고양이',
    CATEGORY        VARCHAR2(50)    NOT NULL,
    PETAGEGROUP     VARCHAR2(50),
    ISGRAINFREE     CHAR(1)         CHECK (UPPER(ISGRAINFREE) IN ('Y','N')),
    CALORIE         NUMBER(5,1),
    FOODTYPE        VARCHAR2(20) DEFAULT '습식',
    FOODIMG         VARCHAR2(300),
    OFFICIALURL     VARCHAR2(500),
    CREATEDAT       DATE DEFAULT SYSDATE,
    UPDATEDAT       DATE DEFAULT NULL 
    );
    
CREATE SEQUENCE petfood_seq
START WITH 1 INCREMENT BY 1
NOCACHE;

--로얄캐닌 : 마더 앤 베이비캣
INSERT INTO PETFOOD(FOODID, FOODNAME, BRANDID, DESCRIPTION, 
                    MAININGREDIENT, SUBINGREDIENT , CATEGORY, PETAGEGROUP, ISGRAINFREE, 
                    CALORIE, FOODIMG, OFFICIALURL)
VALUES(PETFOOD_SEQ.NEXTVAL, '마더 앤 베이비캣', 1, '임신 말기부터 수유기의 어미 반려묘와 생후 4개월까지 반려묘의 건강에 도움을 주는 임신 및 성장기 영양 맞춤 사료',
        '닭', '오리', '일반', '키튼', 'N',
        443.7, '01001.png', 'https://www.royalcanin.com/kr/cats/products/retail-products/mother-%26-babycat-2544');

--조단백 32.0%이상, 조지방 23.0%이상, 칼슘 1.0%이상, 인 0.82%이상, 조회분 8.4%이하, 조섬유 2.8%이하, 수분 6.5%이하
INSERT INTO PETFOODNUTRI(FOODID, NUTRIENTID, AMOUNT) VALUES(1, 1, 32.0);
INSERT INTO PETFOODNUTRI(FOODID, NUTRIENTID, AMOUNT) VALUES(1, 2, 23.0);
INSERT INTO PETFOODNUTRI(FOODID, NUTRIENTID, AMOUNT) VALUES(1, 3, 2.8);
INSERT INTO PETFOODNUTRI(FOODID, NUTRIENTID, AMOUNT) VALUES(1, 4, 8.4);
INSERT INTO PETFOODNUTRI(FOODID, NUTRIENTID, AMOUNT) VALUES(1, 5, 1.0);
INSERT INTO PETFOODNUTRI(FOODID, NUTRIENTID, AMOUNT) VALUES(1, 6, 0.82);
INSERT INTO PETFOODNUTRI(FOODID, NUTRIENTID, AMOUNT) VALUES(1, 1, 6.5);


--로얄캐닌 : 키튼
INSERT INTO PETFOOD(FOODID, FOODNAME, BRANDID, DESCRIPTION, 
                    MAININGREDIENT, SUBINGREDIENT , CATEGORY, PETAGEGROUP, ISGRAINFREE, 
                    CALORIE, FOODIMG, OFFICIALURL)
VALUES(PETFOOD_SEQ.NEXTVAL, '키튼', 1, '생후 4개월 이후부터 12개월까지',
        '닭', '오리', '일반', '키튼', 'N',
        367.0, '01002.png', 'https://www.royalcanin.com/kr/cats/products/retail-products/kitten-2522');

--조단백 34.0%이상, 조지방 16.0%이상, 칼슘 0.99%이상, 인 0.87%이상, 조회분 8.9%이하, 조섬유 3.4%이하, 수분 6.5%이하
--d여기 아이디 바꺼야됨 베이비에 넣었은
INSERT INTO PETFOODNUTRI(FOODID, NUTRIENTID, AMOUNT) VALUES(1, 1, 34.0);
INSERT INTO PETFOODNUTRI(FOODID, NUTRIENTID, AMOUNT) VALUES(1, 2, 16.0);
INSERT INTO PETFOODNUTRI(FOODID, NUTRIENTID, AMOUNT) VALUES(1, 3, 3.4);
INSERT INTO PETFOODNUTRI(FOODID, NUTRIENTID, AMOUNT) VALUES(1, 4, 8.9);
INSERT INTO PETFOODNUTRI(FOODID, NUTRIENTID, AMOUNT) VALUES(1, 5, 0.99);
INSERT INTO PETFOODNUTRI(FOODID, NUTRIENTID, AMOUNT) VALUES(1, 6, 0.87);
INSERT INTO PETFOODNUTRI(FOODID, NUTRIENTID, AMOUNT) VALUES(1, 1, 6.5);
    


        
--3. 영양소 외래키X
CREATE TABLE NUTRI(
    NUTRIENTID NUMBER PRIMARY KEY,
    NUTRIENTNAME VARCHAR2(100) NOT NULL,
    UNIT VARCHAR2(50) 
);


--4.라벨영양소 (FK) FOODID : PETFOOD(FOODID) / NUTRIENTID  : NUTRI(NUTRIENTID)
CREATE TABLE PETFOODNUTRI(
    FOODID      NUMBER NOT NULL,
    NUTRIENTID  NUMBER NOT NULL,
    AMOUNT      NUMBER
);

--5.영양소범위 (FK) NUTRIENTID : NUTRI(NUTRIENTID)		
CREATE TABLE NUTRIRANGE (
    RANGEID      NUMBER          PRIMARY KEY,
    PETTYPEID    NUMBER          NOT NULL,
    NUTRIENTID   NUMBER          NOT NULL,
    MINVALUE     NUMBER          NOT NULL,
    MAXVALUE     NUMBER          NOT NULL,
    RANGELABEL   VARCHAR2(50)    NOT NULL
);

--6. 관리자 계정
CREATE TABLE ADMIN (
  ADMINID        NUMBER          PRIMARY KEY,
  EMAIL          VARCHAR2(100) NOT NULL,
  PASSWORD       VARCHAR2(255) NOT NULL,
  ROLE           VARCHAR2(20) DEFAULT 'ADMIN',
  CREATEDAT      DATE DEFAULT SYSDATE
);


---------------------------------------------------
--영양소 단위
--조단백, 조지방, 조섬유, 조회분, 칼슘, 인, 수분
---------------------------------------------------
INSERT INTO NUTRI VALUES (1, '조단백', '%');
INSERT INTO NUTRI VALUES (2, '조지방', '%');
INSERT INTO NUTRI VALUES (3, '조섬유', '%');
INSERT INTO NUTRI VALUES (4, '조회분', '%');
INSERT INTO NUTRI VALUES (5, '칼슘', '%');
INSERT INTO NUTRI VALUES (6, '인', '%');
INSERT INTO NUTRI VALUES (7, '수분', '%');

---------------------------------------------------
--영양소 범위(추가 검증 필요)
---------------------------------------------------
-- 저단백 (신장/시니어)
INSERT INTO NUTRIRANGE VALUES (1, 1, 1, 18, 26, '저단백');

-- 중단백 (일반 성묘 메인)
INSERT INTO NUTRIRANGE VALUES (2, 1, 1, 27, 34, '중단백');

-- 고단백 (활동량↑, 키튼/컨셉사료)
INSERT INTO NUTRIRANGE VALUES (3, 1, 1, 35, 42, '고단백');

-- 저지방
INSERT INTO NUTRIRANGE VALUES (4, 1, 2, 8, 12, '저지방');

-- 고칼슘 (성장기 기준)
INSERT INTO NUTRIRANGE VALUES (6, 1, 5, 1.4, 1.8, '고칼슘');

-- 저인 (신장 케어 전용)
INSERT INTO NUTRIRANGE VALUES (5, 1, 6, 0.4, 0.7, '저인');

-- 중인 (일반 성묘 대다수)
INSERT INTO NUTRIRANGE VALUES (7, 1, 6, 0.8, 1.2, '중인');

-- 고인 (키튼/고단백 컨셉)
INSERT INTO NUTRIRANGE VALUES (8, 1, 6, 1.3, 1.8, '고인');


COMMIT;