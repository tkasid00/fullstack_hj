--pettype

CREATE TABLE pettype (
  pettypeid NUMBER PRIMARY KEY,
  pettypename VARCHAR2(50) NOT NULL
);

--INSERT INTO pettype (pettypeid, pettypename) VALUES (1, '강아지');
--INSERT INTO pettype (pettypeid, pettypename) VALUES (2, '고양이');
--DESC pettype;
--select * from pettype;
--




--### --4. table (foodbrand) + sequence (foodbrand_seq)
--| 컬럼명      | 데이터 타입       | 제약 조건        | 설명 |
--|-------------|-------------------|------------------|------|
--| `brandid`   | `NUMBER`          | `PRIMARY KEY`    | 브랜드 ID |
--| `brandname` | `VARCHAR2(100)`   | `NOT NULL`       | 브랜드 이름 |
--| `country`    | `VARCHAR2(100)`   | —                | 제조 국가 |

CREATE TABLE foodbrand(
brandid NUMBER PRIMARY KEY,
brandname VARCHAR2(100) NOT NULL, country VARCHAR2(100)
);






--### --5. table (food) + sequence (foodseq)
--| 컬럼명              | 데이터 타입       | 제약 조건                                              | 설명 |
--|---------------------|-------------------|----------------------------------------------------|------|
--| `foodid`            | `NUMBER`          | `PRIMARY KEY`                                       | 사료 ID |
--| `foodname`          | `VARCHAR2(100)`   | `NOT NULL`                                          | 사료 이름 |
--| `brandid`           | `NUMBER`          | `FOREIGN KEY REFERENCES foodbrand(brandid)`         | 브랜드 ID |
--| `description`       | `VARCHAR2(500)`   | `NOT NULL`                                          | 설명 |
--| `mainingredient`     | `VARCHAR2(200)`   | `NOT NULL`                                         | 주 재료    |
--| `subingredient`      | `VARCHAR2(200)`   | —                                                  | 부 재료    |   
--| `pettypeid`   | `NUMBER`          | `FOREIGN KEY REFERENCES pettype(pettypeid)`         | 대상 반려동물 종류 |



CREATE TABLE food (

  foodid NUMBER PRIMARY KEY,
  foodname VARCHAR2(100) NOT NULL,
  brandid NUMBER,
  description VARCHAR2(500),
  mainingredient varchar(200) NOT NULL,
  subingredient VARCHAR2(200),
  pettypeid NUMBER,
  FOREIGN KEY (brandid) REFERENCES foodbrand(brandid),
  FOREIGN KEY (pettypeid) REFERENCES pettype(pettypeid)
);


CREATE SEQUENCE foodseq START WITH 1 INCREMENT BY 1;


CREATE TABLE foodpost (
    userid           NUMBER(30)      NOT NULL,
    foodpostid       NUMBER(30)      PRIMARY KEY,
    title            VARCHAR2(200),
    content          VARCHAR2(500),
    postpass         VARCHAR2(30),
    hit              NUMBER(30),
    foodid           NUMBER(30)      NOT NULL,
    foodname         VARCHAR2(100),
    brandid          NUMBER(30),
    mainingredient   VARCHAR2(100),
    subingredient    VARCHAR2(100),
    pettypeid        NUMBER(30),
    createdat        DATE
);
    
    select * from foodpost;
    
    CREATE SEQUENCE foodpostseq START WITH 1 INCREMENT BY 1;
    
--    DROP TABLE foodpost;




-- FOOD BRAND

INSERT INTO foodbrand (brandid, brandname, country) VALUES (1, '네밥이아니야', '미국');
INSERT INTO foodbrand (brandid, brandname, country) VALUES (2, '명냥스티드', '캐나다');
INSERT INTO foodbrand (brandid, brandname, country) VALUES (3, '모모와밥상', '일본');
INSERT INTO foodbrand (brandid, brandname, country) VALUES (4, '밥쌈없다', '네덜란드');
INSERT INTO foodbrand (brandid, brandname, country) VALUES (5, '식탁의정체', '대한민국');
INSERT INTO foodbrand (brandid, brandname, country) VALUES (6, '츄츄는고양이였다', '호주');
INSERT INTO foodbrand (brandid, brandname, country) VALUES (7, '푸드랑탐탐', '뉴질랜드');

SELECT * FROM foodbrand;
COMMIT;
SELECT reviewid, brandid FROM review;

-- FOOD INSERT

INSERT INTO food (foodid, foodname, brandid, description, mainingredient, subingredient, pettypeid)
VALUES (foodseq.NEXTVAL, '처방식 신장케어 연어 앤 귀리', 1, '신장 건강을 위한 연어와 귀리의 조화, 물 많이 마시게 될지도?', '연어', '귀리', 1);

INSERT INTO food (foodid, foodname, brandid, description, mainingredient, subingredient, pettypeid)
VALUES (foodseq.NEXTVAL, '처방식 심장케어 연어 앤 치아씨드', 1 ,'심장 튼튼 프로젝트, 연어와 치아씨드로 펄떡펄떡!', '연어', '치아씨드', 2);
INSERT INTO food VALUES (foodseq.NEXTVAL, '처방식 알러지케어 오리 앤 감자', 1, '알러지 방어막, 오리와 감자가 든든하게 지켜줍니다.', '오리', '감자', 2);
INSERT INTO food VALUES (foodseq.NEXTVAL, '처방식 체중조절 칠면조 앤 고구마', 1, '다이어트 파트너, 칠면조와 고구마로 살은 빼고 맛은 살리고!', '칠면조', '고구마', 2);
INSERT INTO food VALUES (foodseq.NEXTVAL, '처방식 관절케어 닭고기 앤 브로콜리', 1, '관절을 위한 닭고기와 브로콜리, 뛰는 게 즐거워질지도?', '닭고기', '브로콜리', 2);

INSERT INTO food VALUES (foodseq.NEXTVAL, '시니어 오리 앤 감자', 2, '우아한 노년을 위한 오리와 감자, 품격 있는 한 끼!', '오리', '감자', 1);
INSERT INTO food VALUES (foodseq.NEXTVAL, '라이트 치킨 앤 귀리', 2, '에너지 폭발을 위한 치킨과 귀리, 집사도 놀랄 활력!', '치킨', '귀리', 1);
INSERT INTO food VALUES (foodseq.NEXTVAL, '인도어 청어 앤 고구마', 2, '숲속 체질에 맞춘 청어와 고구마, 자연을 담은 레시피!', '청어', '고구마', 1);
INSERT INTO food VALUES (foodseq.NEXTVAL, '라이트 연어 앤 고구마', 2, '짧은 다리에도 근육은 필요해요—연어와 고구마로 탄탄하게!', '연어', '고구마', 2);
INSERT INTO food VALUES (foodseq.NEXTVAL, '시니어 참치 앤 감자', 2, '웃는 얼굴을 위한 참치와 감자, 기분도 사료도 촉촉하게!', '참치', '감자', 2);
INSERT INTO food VALUES (foodseq.NEXTVAL, '처방식 알러지케어 연어 앤 귀리', 2, '알러지 걱정 없는 연어와 귀리, 예민한 아이에게 딱!', '연어', '귀리', 1);
INSERT INTO food VALUES (foodseq.NEXTVAL, '시니어 참치 앤 현미', 2, '노년을 위한 참치와 현미, 부드럽고 소화 잘 되는 한 끼!', '참치', '현미', 1);

INSERT INTO food VALUES (foodseq.NEXTVAL, '키튼 참치 앤 현미', 3, '부드러운 털을 위한 참치와 현미, 고양이계의 실크로드!', '참치', '현미', 2);
INSERT INTO food VALUES (foodseq.NEXTVAL, '인도어 참치 앤 감자', 3, '활동량 많은 아이를 위한 참치와 감자, 산책 후에도 에너지 충전!', '참치', '감자', 2);
INSERT INTO food VALUES (foodseq.NEXTVAL, '처방식 피부케어 연어 앤 치아씨드', 3, '피부 고민 해결사, 연어와 치아씨드로 반짝반짝!', '연어', '치아씨드', 2);
INSERT INTO food VALUES (foodseq.NEXTVAL, '라이트 닭고기 앤 치아씨드', 3, '활동량 많은 아이를 위한 닭고기와 치아씨드, 가볍고 든든하게!', '닭고기', '치아씨드', 2);
INSERT INTO food VALUES (foodseq.NEXTVAL, '헬시웨이트 연어 앤 감자', 3, '체중 조절을 위한 연어와 감자, 맛있게 건강하게!', '연어', '감자', 2);

INSERT INTO food VALUES (foodseq.NEXTVAL, '라이트 오리 앤 귀리', 4, '체중 관리, 오리와 귀리로 맛있게 슬림하게!', '오리', '귀리', 2);
INSERT INTO food VALUES (foodseq.NEXTVAL, '시니어 연어 앤 감자', 4, '노년을 위한 연어와 감자, 뇌도 입맛도 만족!', '연어', '감자', 2);
INSERT INTO food VALUES (foodseq.NEXTVAL, '키튼 치킨 앤 현미', 4, '귀여운 성장기, 치킨과 현미로 작지만 강하게!', '치킨', '현미', 2);
INSERT INTO food VALUES (foodseq.NEXTVAL, '인도어 청어 앤 감자', 4, '든든한 하루를 위한 청어와 감자, 묵직한 매력에 영양까지!', '청어', '감자', 2);

INSERT INTO food VALUES (foodseq.NEXTVAL, '시니어 닭고기 앤 치아씨드', 5, '부드러운 털을 위한 닭고기와 치아씨드, 털복숭이의 선택!', '닭고기', '치아씨드', 1);
INSERT INTO food VALUES (foodseq.NEXTVAL, '시니어 청어 앤 귀리', 5, '든든한 하루를 위한 청어와 귀리, 묵직한 매력에 영양까지!', '청어', '귀리', 2);
INSERT INTO food VALUES (foodseq.NEXTVAL, '키튼 오리 앤 귀리', 5, '귀여운 키튼 시절을 위한 오리와 귀리, 작지만 영양은 꽉!', '오리', '귀리', 2);
INSERT INTO food VALUES (foodseq.NEXTVAL, '키튼 오리 앤 현미', 5, '작은 입에도 잘 맞는 오리와 현미, 키튼 시절을 위한 영양 설계!', '오리', '현미', 2);

INSERT INTO food VALUES (foodseq.NEXTVAL, '키튼 치킨 앤 청어', 6, '우아한 성장기, 치킨과 청어로 품격 있는 한 끼!', '치킨', '청어', 2);
INSERT INTO food VALUES (foodseq.NEXTVAL, '시니어 연어 앤 치아씨드', 6, '예민한 입맛을 위한 연어와 치아씨드, 까다로운 고양이도 OK!', '연어', '치아씨드', 1);
INSERT INTO food VALUES (foodseq.NEXTVAL, '처방식 요로케어 닭고기 앤 크랜베리', 6, '요로 건강을 위한 닭고기와 크랜베리, 화장실 걱정 끝!', '닭고기', '크랜베리', 1);
INSERT INTO food VALUES (foodseq.NEXTVAL, '인도어 참치 앤 브로콜리', 6, '실내 생활에 맞춘 참치와 브로콜리, 속 편한 하루를 위한 선택!', '참치', '브로콜리', 1);

INSERT INTO food VALUES (foodseq.NEXTVAL, '인도어 참치 앤 고구마', 7, '실크 같은 털을 위한 참치와 고구마, 미용실 갈 필요 없어요!', '참치', '고구마', 1);
INSERT INTO food VALUES (foodseq.NEXTVAL, '헬시웨이트 닭고기 앤 브로콜리', 7, '귀여운 체형을 위한 닭고기와 브로콜리, 균형 잡힌 귀여움!', '닭고기', '브로콜리', 1);
INSERT INTO food VALUES (foodseq.NEXTVAL, '키튼 연어 앤 현미', 7, '짧은 다리에도 에너지 충전, 연어와 현미로 점프력 상승!', '연어', '현미', 2);
INSERT INTO food VALUES (foodseq.NEXTVAL, '인도어 칠면조 앤 고구마', 7, '민감한 피부를 위한 칠면조와 고구마, 부드럽게 케어!', '칠면조', '고구마', 2);

SELECT * FROM food;

delete food;


--구조확인

desc foodbrand;
desc food;
desc pettype;
desc foodpost;

-- 입력값확인
select * from pettype;
select * from foodbrand;
select * from food;
select * from foodpost;

-- 드랍
DROP TABLE foodbrand;
DROP TABLE food;
DROP SEQUENCE foodseq;
DROP table pettype;


SELECT table_name FROM user_tables;
SELECT sequence_name FROM user_sequences;

SELECT sequence_name, last_number
FROM user_sequences;


SELECT 
  f.foodid,
  f.foodname,
  fb.brandname,
  f.description,
  f.pettypeid,
  f.mainingredient,
  f.subingredient,
  fb.country
FROM food f
JOIN foodbrand fb ON f.brandid = fb.brandid;

 SELECT * FROM food f join  foodpost p on f.foodid = p.foodid ;
insert into foodpost ( USERID, FOODPOSTID , TITLE , CONTENT , POSTPASS , HIT , FOODID , FOODNAME , BRANDID, MAININGREDIENT , SUBINGREDIENT , PETTYPEID , CREATEDAT ) values (  11  , 12 , '제목' ,  '내용'  ,  '123' , 1 , 13 , '참치구이', 444, '메인재료' , '서브재료' , '1' , SYSDATE );
desc foodpost;
delete from foodpost;
drop table foodpost;

commit;






INSERT INTO food VALUES (1, '처방식 신장케어 연어 앤 귀리', 1, '신장 건강을 위한 연어와 귀리의 조화, 물 많이 마시게 될지도?', '연어', '귀리', 1);
INSERT INTO food VALUES (2, '처방식 심장케어 연어 앤 치아씨드', 1 ,'심장 튼튼 프로젝트, 연어와 치아씨드로 펄떡펄떡!', '연어', '치아씨드', 2);
INSERT INTO food VALUES (3, '처방식 알러지케어 오리 앤 감자', 1, '알러지 방어막, 오리와 감자가 든든하게 지켜줍니다.', '오리', '감자', 2);
INSERT INTO food VALUES (4, '처방식 체중조절 칠면조 앤 고구마', 1, '다이어트 파트너, 칠면조와 고구마로 살은 빼고 맛은 살리고!', '칠면조', '고구마', 2);
INSERT INTO food VALUES (5, '처방식 관절케어 닭고기 앤 브로콜리', 1, '관절을 위한 닭고기와 브로콜리, 뛰는 게 즐거워질지도?', '닭고기', '브로콜리', 2);

INSERT INTO food VALUES (6, '시니어 오리 앤 감자', 2, '우아한 노년을 위한 오리와 감자, 품격 있는 한 끼!', '오리', '감자', 1);
INSERT INTO food VALUES (7, '라이트 치킨 앤 귀리', 2, '에너지 폭발을 위한 치킨과 귀리, 집사도 놀랄 활력!', '치킨', '귀리', 1);
INSERT INTO food VALUES (8, '인도어 청어 앤 고구마', 2, '숲속 체질에 맞춘 청어와 고구마, 자연을 담은 레시피!', '청어', '고구마', 1);
INSERT INTO food VALUES (9, '라이트 연어 앤 고구마', 2, '짧은 다리에도 근육은 필요해요—연어와 고구마로 탄탄하게!', '연어', '고구마', 2);
INSERT INTO food VALUES (10, '시니어 참치 앤 감자', 2, '웃는 얼굴을 위한 참치와 감자, 기분도 사료도 촉촉하게!', '참치', '감자', 2);
INSERT INTO food VALUES (11, '처방식 알러지케어 연어 앤 귀리', 2, '알러지 걱정 없는 연어와 귀리, 예민한 아이에게 딱!', '연어', '귀리', 1);
INSERT INTO food VALUES (12, '시니어 참치 앤 현미', 2, '노년을 위한 참치와 현미, 부드럽고 소화 잘 되는 한 끼!', '참치', '현미', 1);

INSERT INTO food VALUES (13, '키튼 참치 앤 현미', 3, '부드러운 털을 위한 참치와 현미, 고양이계의 실크로드!', '참치', '현미', 2);
INSERT INTO food VALUES (14, '인도어 참치 앤 감자', 3, '활동량 많은 아이를 위한 참치와 감자, 산책 후에도 에너지 충전!', '참치', '감자', 2);
INSERT INTO food VALUES (15, '처방식 피부케어 연어 앤 치아씨드', 3, '피부 고민 해결사, 연어와 치아씨드로 반짝반짝!', '연어', '치아씨드', 2);
INSERT INTO food VALUES (16, '라이트 닭고기 앤 치아씨드', 3, '활동량 많은 아이를 위한 닭고기와 치아씨드, 가볍고 든든하게!', '닭고기', '치아씨드', 2);
INSERT INTO food VALUES (17, '헬시웨이트 연어 앤 감자', 3, '체중 조절을 위한 연어와 감자, 맛있게 건강하게!', '연어', '감자', 2);

INSERT INTO food VALUES (18, '라이트 오리 앤 귀리', 4, '체중 관리, 오리와 귀리로 맛있게 슬림하게!', '오리', '귀리', 2);
INSERT INTO food VALUES (19, '시니어 연어 앤 감자', 4, '노년을 위한 연어와 감자, 뇌도 입맛도 만족!', '연어', '감자', 2);
INSERT INTO food VALUES (20, '키튼 치킨 앤 현미', 4, '귀여운 성장기, 치킨과 현미로 작지만 강하게!', '치킨', '현미', 2);
INSERT INTO food VALUES (21, '인도어 청어 앤 감자', 4, '든든한 하루를 위한 청어와 감자, 묵직한 매력에 영양까지!', '청어', '감자', 2);

INSERT INTO food VALUES (22, '시니어 닭고기 앤 치아씨드', 5, '부드러운 털을 위한 닭고기와 치아씨드, 털복숭이의 선택!', '닭고기', '치아씨드', 1);
INSERT INTO food VALUES (23, '시니어 청어 앤 귀리', 5, '든든한 하루를 위한 청어와 귀리, 묵직한 매력에 영양까지!', '청어', '귀리', 2);
INSERT INTO food VALUES (24, '키튼 오리 앤 귀리', 5, '귀여운 키튼 시절을 위한 오리와 귀리, 작지만 영양은 꽉!', '오리', '귀리', 2);
INSERT INTO food VALUES (25, '키튼 오리 앤 현미', 5, '작은 입에도 잘 맞는 오리와 현미, 키튼 시절을 위한 영양 설계!', '오리', '현미', 2);

INSERT INTO food VALUES (26, '키튼 치킨 앤 청어', 6, '우아한 성장기, 치킨과 청어로 품격 있는 한 끼!', '치킨', '청어', 2);
INSERT INTO food VALUES (27, '시니어 연어 앤 치아씨드', 6, '예민한 입맛을 위한 연어와 치아씨드, 까다로운 고양이도 OK!', '연어', '치아씨드', 1);
INSERT INTO food VALUES (28, '처방식 요로케어 닭고기 앤 크랜베리', 6, '요로 건강을 위한 닭고기와 크랜베리, 화장실 걱정 끝!', '닭고기', '크랜베리', 1);
INSERT INTO food VALUES (29, '인도어 참치 앤 브로콜리', 6, '실내 생활에 맞춘 참치와 브로콜리, 속 편한 하루를 위한 선택!', '참치', '브로콜리', 1);

INSERT INTO food VALUES (30, '인도어 참치 앤 고구마', 7, '실크 같은 털을 위한 참치와 고구마, 미용실 갈 필요 없어요!', '참치', '고구마', 1);
INSERT INTO food VALUES (31, '헬시웨이트 닭고기 앤 브로콜리', 7, '귀여운 체형을 위한 닭고기와 브로콜리, 균형 잡힌 귀여움!', '닭고기', '브로콜리', 1);
INSERT INTO food VALUES (32, '키튼 연어 앤 현미', 7, '짧은 다리에도 에너지 충전, 연어와 현미로 점프력 상승!', '연어', '현미', 2);
INSERT INTO food VALUES (33, '인도어 칠면조 앤 고구마', 7, '민감한 피부를 위한 칠면조와 고구마, 부드럽게 케어!', '칠면조', '고구마', 2);
