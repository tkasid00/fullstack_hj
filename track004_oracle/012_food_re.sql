CREATE TABLE testfoodbrand (
    brandid        NUMBER        NOT NULL,
    brandname      VARCHAR2(100) NOT NULL,
    country        VARCHAR2(100),
    brandtype      VARCHAR2(50)  NOT NULL,   
    category       VARCHAR2(50),             
    brandinfo      VARCHAR2(500),           
    CONSTRAINT pk_foodbrand PRIMARY KEY (brandid)
);


CREATE TABLE testfood (
    foodid          NUMBER          NOT NULL,
    foodname        VARCHAR2(100)   NOT NULL,
    brandid         NUMBER          NOT NULL,
    description     VARCHAR2(500),
    mainingredient  VARCHAR2(200)   NOT NULL,
    subingredient   VARCHAR2(200),
    pettypeid       NUMBER          NOT NULL,   -- 1=고양이, 2=강아지
    category        VARCHAR2(50)    NOT NULL,   -- 처방식/일반/시니어 등
    petagegroup     VARCHAR2(50),               -- 키튼/어덜트/시니어
    isgrainfree     CHAR(1),                    -- Y/N
    calorie         NUMBER(5,1),                -- kcal/100g
    foodtype        VARCHAR2(20),               -- 건식/습식
    foodimg         VARCHAR2(300),              -- 사료 이미지 경로
    CONSTRAINT pk_food PRIMARY KEY (foodid)
);


INSERT INTO testfoodbrand (
    brandid, brandname, country, category, brandtype, brandinfo
) VALUES (
    1,
    'PureTail',
    '미국',
    '해외',
    '프리미엄',
    '프리미엄 단백질과 기능성 영양 균형에 집중한 브랜드'
);

INSERT INTO testfoodbrand (
    brandid, brandname, country, category, brandtype, brandinfo
) VALUES (
    2,
    'NaturalForest',
    '캐나다',
    '해외',
    '자연식',
    '자연에서 온 재료로 민감한 아이들도 편하게 먹는 브랜드'
);

INSERT INTO testfoodbrand (
    brandid, brandname, country, category, brandtype, brandinfo
) VALUES (
    3,
    'BopTenTen',
    '한국',
    '국내',
    '데일리',
    '일상적인 급여에 맞춘 한국형 데일리 브랜드'
);

INSERT INTO testfoodbrand (
    brandid, brandname, country, category, brandtype, brandinfo
) VALUES (
    4,
    'MediPaw',
    '독일',
    '해외',
    '처방식',
    '수의학 영양학 기반의 전문 처방식 브랜드'
);


INSERT INTO testfood VALUES (1, '신장케어 연어 앤 귀리', 1,
'신장 부담을 줄여주는 저인·저단백 연어 기반 처방식.',
'연어', '귀리', 1, '처방식', '어덜트', 'N', 330.0, '건식', '/static/food/food_001.png');

INSERT INTO testfood VALUES (2, '저지방 칠면조 앤 렌틸', 1,
'슬림한 몸매 유지에 도움 주는 저지방 포뮬러.',
'칠면조', '렌틸콩', 1, '체중관리', '어덜트', 'N', 315.0, '건식', '/static/food/food_002.png');

INSERT INTO testfood VALUES (3, '그레인프리 연어 앤 완두', 1,
'곡물 민감한 고양이를 위한 그레인프리 프리미엄 레시피.',
'연어', '완두콩', 1, '일반', '어덜트', 'Y', 365.0, '건식', '/static/food/food_003.png');

INSERT INTO testfood VALUES (4, '키튼 칠면조 앤 달걀', 1,
'성장기 고양이를 위한 고단백 영양 집중 레시피.',
'칠면조', '달걀', 1, '키튼', '키튼', 'N', 405.0, '건식', '/static/food/food_004.png');

INSERT INTO testfood VALUES (5, '헤어볼 케어 치킨 앤 비트펄프', 1,
'털뭉치 관리가 필요한 실내 고양이를 위한 기능식.',
'닭고기', '비트펄프', 1, '기능식', '어덜트', 'N', 340.0, '건식', '/static/food/food_005.png');

INSERT INTO testfood VALUES (6, '퍼피 연어 앤 코코넛', 1,
'성장기 강아지를 위한 연어 단백질 중심 퍼피 포뮬러.',
'연어', '코코넛', 2, '퍼피', '퍼피', 'N', 395.0, '건식', '/static/food/food_006.png');

INSERT INTO testfood VALUES (7, '저알레르기 오리 앤 감자', 1,
'피부 민감한 강아지를 위한 저자극 기능식.',
'오리고기', '감자', 2, '저알레르기', '어덜트독', 'N', 355.0, '건식', '/static/food/food_007.png');

INSERT INTO testfood VALUES (8, '그레인프리 치킨 앤 렌틸', 1,
'활동량 많은 강아지를 위한 고단백 그레인프리 레시피.',
'닭고기', '렌틸콩', 2, '일반', '어덜트독', 'Y', 390.0, '건식', '/static/food/food_008.png');

INSERT INTO testfood VALUES (9, '시니어 연어 앤 단호박', 1,
'나이 든 강아지를 위한 소화 가능한 포뮬러.',
'연어', '단호박', 2, '시니어', '시니어', 'N', 315.0, '건식', '/static/food/food_009.png');


INSERT INTO testfood VALUES (10, '인도어 참치 앤 고구마', 2,
'실내 생활 고양이를 위한 부드러운 자연식 조합.',
'참치', '고구마', 1, '일반', '어덜트', 'N', 345.0, '건식', '/static/food/food_010.png');

INSERT INTO testfood VALUES (11, '그레인프리 오리 앤 사과', 2,
'곡물 없이 자연의 단맛을 활용한 자연식 레시피.',
'오리고기', '사과', 1, '일반', '어덜트', 'Y', 370.0, '건식', '/static/food/food_011.png');

INSERT INTO testfood VALUES (12, '시니어 양고기 앤 브로콜리', 2,
'노령묘의 소화를 돕는 부드러운 자연식 구성.',
'양고기', '브로콜리', 1, '시니어', '시니어', 'N', 325.0, '건식', '/static/food/food_012.png');

INSERT INTO testfood VALUES (13, '키튼 치킨 앤 호박', 2,
'자연식 기반 성장기 고양이 맞춤 레시피.',
'닭고기', '호박', 1, '키튼', '키튼', 'N', 395.0, '건식', '/static/food/food_013.png');

INSERT INTO testfood VALUES (14, '퍼피 오리 앤 바나나', 2,
'소화 잘되고 영양 가득한 자연식 퍼피 조합.',
'오리고기', '바나나', 2, '퍼피', '퍼피', 'N', 420.0, '건식', '/static/food/food_014.png');

INSERT INTO testfood VALUES (15, '어덜트 치킨 앤 당근', 2,
'자연 재료 중심의 안정적인 데일리 레시피.',
'닭고기', '당근', 2, '일반', '어덜트독', 'N', 350.0, '건식', '/static/food/food_015.png');

INSERT INTO testfood VALUES (16, '그레인프리 양고기 앤 코코넛', 2,
'피부 예민한 강아지를 위한 자연식 그레인프리.',
'양고기', '코코넛', 2, '저알레르기', '어덜트독', 'Y', 385.0, '건식', '/static/food/food_016.png');

INSERT INTO testfood VALUES (17, '시니어 칠면조 앤 현미', 2,
'부드럽고 소화 쉬운 시니어 자연식 조합.',
'칠면조', '현미', 2, '시니어', '시니어', 'N', 300.0, '건식', '/static/food/food_017.png');


INSERT INTO testfood VALUES (18, '데일리 치킨 앤 현미', 3,
'매일 먹여도 부담 없는 한국형 데일리 사료.',
'닭고기', '현미', 1, '일반', '어덜트', 'N', 360.0, '건식', '/static/food/food_018.png');

INSERT INTO testfood VALUES (19, '참치 앤 멸치 미니', 3,
'기호성 높은 해산물 기반 데일리 레시피.',
'참치', '멸치', 1, '일반', '어덜트', 'N', 350.0, '건식', '/static/food/food_019.png');

INSERT INTO testfood VALUES (20, '저지방 닭고기 앤 양배추', 3,
'다이어트가 필요한 고양이를 위한 저지방 구성.',
'닭고기', '양배추', 1, '체중관리', '어덜트', 'N', 315.0, '건식', '/static/food/food_020.png');

INSERT INTO testfood VALUES (21, '키튼 닭고기 앤 우유', 3,
'부드럽고 영양감 높은 성장기 레시피.',
'닭고기', '우유', 1, '키튼', '키튼', 'N', 400.0, '건식', '/static/food/food_021.png');

INSERT INTO testfood VALUES (22, '데일리 소고기 앤 감자', 3,
'든든하고 심플한 데일리 영양식.',
'소고기', '감자', 2, '일반', '어덜트독', 'N', 370.0, '건식', '/static/food/food_022.png');

INSERT INTO testfood VALUES (23, '어덜트 닭고기 앤 현미', 3,
'실속형 강아지 데일리 고정템 조합!',
'닭고기', '현미', 2, '일반', '어덜트독', 'N', 350.0, '건식', '/static/food/food_023.png');

INSERT INTO testfood VALUES (24, '시니어 소고기 앤 단호박', 3,
'소화 부담 낮춘 시니어 전용 레시피.',
'소고기', '단호박', 2, '시니어', '시니어', 'N', 330.0, '건식', '/static/food/food_024.png');

INSERT INTO testfood VALUES (25, '퍼피 닭고기 앤 달걀', 3,
'튼튼하게 자라는 퍼피를 위한 균형 영양식.',
'닭고기', '달걀', 2, '퍼피', '퍼피', 'N', 410.0, '건식', '/static/food/food_025.png');

INSERT INTO testfood VALUES (26, '요로케어 닭고기 앤 크랜베리', 4,
'요로 문제 예방에 도움 주는 전문 처방식.',
'닭고기', '크랜베리', 1, '처방식', '어덜트', 'N', 330.0, '건식', '/static/food/food_026.png');

INSERT INTO testfood VALUES (27, '체중관리 칠면조 앤 호박', 4,
'살짝 통통한 고양이를 위한 전문 다이어트 포뮬러.',
'칠면조', '호박', 1, '처방식', '어덜트', 'N', 295.0, '건식', '/static/food/food_027.png');

INSERT INTO testfood VALUES (28, '저알레르기 오리 앤 타피오카', 4,
'알레르기 반응 최소화를 목표로 설계된 저자극식.',
'오리고기', '타피오카', 1, '처방식', '어덜트', 'Y', 340.0, '건식', '/static/food/food_028.png');

INSERT INTO testfood VALUES (29, '신장케어 백신어 앤 귀리', 4,
'저인·저단백 신장 관리 전용 사료.',
'백신어', '귀리', 1, '처방식', '시니어', 'N', 310.0, '건식', '/static/food/food_029.png');

INSERT INTO testfood VALUES (30, '관절케어 연어 앤 녹색홍합', 4,
'관절 약한 강아지를 위한 전문 관절 관리 포뮬러.',
'연어', '녹색홍합', 2, '처방식', '시니어', 'N', 320.0, '건식', '/static/food/food_030.png');

INSERT INTO testfood VALUES (31, '위장케어 닭고기 앤 감자전분', 4,
'소화기 문제를 가진 강아지를 위한 전문 위장 케어.',
'닭고기', '감자전분', 2, '처방식', '어덜트독', 'N', 330.0, '건식', '/static/food/food_031.png');

INSERT INTO testfood VALUES (32, '체중관리 오리 앤 호박', 4,
'비만 경향 있는 친구를 위한 전문 다이어트 처방식.',
'오리고기', '호박', 2, '처방식', '어덜트독', 'N', 300.0, '건식', '/static/food/food_032.png');

INSERT INTO testfood VALUES (33, '신장케어 흰살생선 앤 귀리', 4,
'신장 민감한 강아지를 위한 저인·저단백 식단.',
'흰살생선', '귀리', 2, '처방식', '시니어', 'N', 305.0, '건식', '/static/food/food_033.png');


commit;
drop table testfoodbrand;
select * from testfoodbrand;
select * from testfood;
select  foodname, brandname, pettypeid from testfood f join testfoodbrand b using(brandid);

select * from sboard1;
desc testfood;

select foodid, foodname from testfood;

create table test1(
a number,
b varchar2(10));

create table test2(
a number,
b varchar2(10));

delete from test1;

insert into test1 values(1, 'a');
insert into test1 values(2, 'b');
insert into test1 values(3, 'g');
insert into test1 values(4, 'd');

insert into test2 values(3, 'c');
insert into test2 values(4, 'd');
insert into test2 values(5, 'e');
insert into test2 values(6, 'f');


select * from test1 join  test2 on(test1.a=test2.a);
    
    SELECT a, b FROM test1
INTERSECT
SELECT a, b FROM test2;

select * from testfood where foodid=1;

