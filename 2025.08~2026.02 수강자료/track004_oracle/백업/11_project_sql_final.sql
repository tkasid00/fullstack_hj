-------------------------------------------
-- users 테이블, 시퀀스
CREATE TABLE users (
  userid     NUMBER PRIMARY KEY,
  email      VARCHAR2(200) NOT NULL UNIQUE,
  nickname   VARCHAR2(100) NOT NULL,
  password   VARCHAR2(100) NOT NULL,
  createdat  DATE NOT NULL
);

CREATE SEQUENCE users_seq;

drop table users;

-- users 데이터 예시없이 회원가입 하시먼 됩니다.
------------------------------------------
-- pettype 테이블, 최종데이터
CREATE TABLE pettype (
  pettypeid NUMBER PRIMARY KEY,
  pettypename  VARCHAR2(100) NOT NULL
);

INSERT INTO pettype (pettypeid, pettypename) VALUES (1, '고양이');
INSERT INTO pettype (pettypeid, pettypename) VALUES (2, '강아지');

select * from pettype;
-----------------------------------------
-- pet 테이블, 시퀀스, 임시데이터
CREATE TABLE pet (
  petid      NUMBER PRIMARY KEY,
  userid     NUMBER NOT NULL,
  petname    VARCHAR2(100) NOT NULL,
  petbreed   VARCHAR2(100) NOT NULL,
  birthdate  VARCHAR2(100),
  pettypeid  NUMBER NOT NULL,
  createdat  DATE NOT NULL,
  
  CONSTRAINT fk_pet_user FOREIGN KEY (userid)
    REFERENCES users(userid),
    
  CONSTRAINT fk_pet_type FOREIGN KEY (pettypeid)
    REFERENCES pettype(pettypeid)
);

CREATE SEQUENCE pet_seq;



INSERT INTO pet VALUES (pet_seq.NEXTVAL, 1, '겨울이', '페르시안', '2022-06-12', 1, SYSDATE);

----------------------------------------------------------------------------------------
select table_name from user_tables;



-- 질환 보드 테이블
create table DISEASE(
    disno number   primary key,
    disname varchar2(50),
    disex   varchar2(150),
    kindpet varchar2(200),
    infval  varchar2(200),
    mannote varchar2(200)
    );

create sequence disease_seq;
select sequence_name from user_sequences;
create sequence disno_seq;
desc disease;
select * from disease;
delete from disease;


    
    insert into disease 
    values(disno_seq.nextval
    ,'고관절 이형성증 (CHD)'
    ,'대퇴골과 골반 연결 부위 비정상 발달로 통증 및 관절염 유발.'
    ,'리트리버, 셰퍼드 등 대형견'
    ,'발생률: 특정 대형견 품종에서 **15% ∼ 50%**까지 보고됨.'
    ,'🚨 OFA/PennHIP 평가: 유전적 소양을 생후 4개월부터 평가하여 관리 방향 설정.');
    
    insert into disease 
    values(disno_seq.nextval,
    '슬개골 탈구 (PL)'
    ,'무릎의 슬개골이 정상 위치에서 벗어남.'
    ,'말티즈, 푸들, 포메라니안 등 소형견'
    ,'국내 유병률: 소형견에서 60% ∼ 70% 이상 보고됨.'
    ,'등급 구분: 4단계 (Grade I ∼ IV) 로 구분되며, 보통 Grade II 이상에서 수술적 교정을 고려.');
    
    insert into disease 
    values(disno_seq.nextval,
    '비대성 심근증 (HCM)'
    ,'심장 근육이 두꺼워져 심장 기능 저하. 고양이 최다 발병 심장병.'
    ,'메인쿤, 랙돌, 스핑크스'
    ,'메인쿤 발생률: 20% ∼ 30% 유전적 소인 높음.'
    ,'벽 두께: 좌심실 후벽 및 중격의 두께가 6 mm 이상일 때 진단 (품종별 기준 다름).');
    
    insert into disease 
    values(disno_seq.nextval,
    '추간판 탈출증 (IVDD)'
    ,'척추 디스크 돌출로 신경 압박.'
    ,'닥스훈트, 웰시코기 등 장단족 견종'
    ,'닥스훈트 발생률: 전체 견종 중 약 20% ∼ 25% 차지 (유전적으로 취약).'
    ,'등급 구분: 5단계 (Grade I ∼ V) 로 구분되며, Grade III 이상은 마비 증상 위험.');
    
    insert into disease 
    values(disno_seq.nextval,
    '기관 허탈 (기관지 붕괴)'
    ,'기관 연골 약화로 기관이 납작하게 좁아짐.'
    ,'요크셔테리어, 포메라니안, 치와와'
    ,'발병 연령: 주로 4 ∼ 14세에 나타나며, 소형견 기관 질환의 **약 80%**를 차지.'
    ,'단계 구분: 기관 내강이 0% ∼ 100% 좁아진 정도로 심각성 평가.');
    

    
    insert into disease 
    values(disno_seq.nextval,
    '진행성 망막 위축 (PRA)'
    ,'망막 시세포 점진적 손상으로 실명.'
    ,'푸들, 코카 스패니얼, 닥스훈트'
    ,'실명 진행: 초기(야맹증)부터 최종 실명까지 수개월 ∼ 2년 내외 소요 (품종별 다름).'
    ,'유전자 검사: 특정 품종은 DNA 검사로 발병 유전자 보유 여부를 99% 정확도로 확인 가능.'
    );
    
    insert into disease 
    values(disno_seq.nextval,
    '다낭성 신장 질환 (PKD)'
    ,'신장에 낭종(물혹)이 생겨 신부전 유발.'
    ,'페르시안, 엑조틱, 히말라얀'
    ,'페르시안 유병률: 지역 및 혈통에 따라 **최대 30% ∼ 50%**에서 유전자 검사 양성.'
    ,'낭종 크기: 신장 초음파 상 1 mm 크기의 낭종부터 확인 가능하며 크기 증가에 따라 신기능 저하.'
    );
    
    
    insert into disease 
    values(disno_seq.nextval,
    '뇌수두증 (Hydrocephalus)'
    ,'뇌척수액 과다 축적으로 뇌 압박.'
    ,'치와와, 말티즈, 포메라니안 등 소형견'
    ,'진단 기준: MRI/CT 상 뇌실 지수(VH Ratio)가 0.4 이상일 때 의심.'
    ,'수술 성공률: 션트 수술 성공률은 보고에 따라 **50% ∼ 90%**로 다양.'
    );
    
    insert into disease 
    values(disno_seq.nextval,
    '폰 빌레브란트 병 (vWD)'
    ,'혈액 응고 인자 부족으로 출혈 경향.'
    ,'도베르만, 셰틀랜드 쉽독, 푸들'
    ,'도베르만 유병률: **약 60%**의 개체가 유전자 변이를 보유하며, **최소 10%**가 출혈 증상을 보임.'
    ,'응고 인자 수치: vWF 인자 농도가 50% 이하일 때 임상 증상 위험 증가.'
    );
    
    insert into disease 
    values(disno_seq.nextval,
    '체리아이 (Cherry Eye)'
    ,'제3안검 눈물샘이 밖으로 돌출.'
    ,'불독, 비글, 코카 스패니얼, 시츄'
    ,'재발률: 단순 봉합술 시 재발률이 **5% ∼ 40%**로 보고되며, 수술 방법에 따라 다름.'
    ,'돌출 지속 시간: 수 시간 이내에 복원 수술을 받는 것이 눈물샘 기능 유지에 유리.'
    );
    
    commit;

   -- 다음단계 진행시 사용 예정  반려동물 질환테이블 
    
    create table PETDISEASE(
    disid varchar2(20),
    disname varchar2(50),
    Fedm number(10),
    Pdm  number(10),
    Proteindm number(10)
    );
    
    select * from disease;


insert into petdisease 
values(
'PET-D-005'
,'고관절 이형성증 (CHD)'
,80
,0.5
,25
);

insert into petdisease 
values(
'PET-D-001'
,'슬개골 탈구 (PL)'
,80
,0.5
,25
);

insert into petdisease 
values(
'PET-D-034'
,'비대성 심근증 (HCM)'
,80
,0.5
,25
);

insert into petdisease 
values(
'PET-D-038'
,'추간판 탈출증 (IVDD)'
,80
,0.5
,25
);

insert into petdisease 
values(
'PET-D-025'
,'기관 허탈'
,80
,0.5
,25
);

insert into petdisease 
values(
'PET-D-006'
,'진행성 망막 위축 (PRA)'
,80
,0.5
,25
);

insert into petdisease 
values(
'PET-D-040-C'
,'다낭성 신장 질환 (PKD)'
,80
,0.5
,25
);

insert into petdisease 
values(
'PET-D-036'
,'뇌수두증'
,80
,0.5
,25
);


insert into petdisease 
values(
'PET-D-043-vW'
,'폰 빌레브란트 병 (vWD)'
,80
,0.5
,25
);

insert into petdisease 
values(
'PET-D-048'
,'체리아이'
,80
,0.5
,25
);

select * from petdisease;
select * from disease;

commit;

-------------------------------------------------------------------------

--운동정보테이블 (1단계 CRUD 파트)
--| 필드명             | 타입           | 설명 |
--|--------------------|----------------|------|
--| `execid`      | INT (PK)       | 운동 고유 ID |
--| `exectype`    | VARCHAR(50)    | 운동 종류 (예: 산책, 수영, 노즈워크 등) |
--| `description`      | VARCHAR(255)   | 운동에 대한 간단 설명 |
--| `avgkcal30min` | FLOAT        | 평균 칼로리 소모량 (소형견 기준, 30분 기준) |
--| `exectargetmin` | INT   | 권장 운동 시간 (분) |
--| `suitablefor`     | VARCHAR(100)   | 추천 대상 (예: 소형견, 노령견 등) |
--| `intensitylevel`  | VARCHAR(20)    | 운동 강도 (예: 저강도, 중강도, 고강도) |
--| `createdat`       | DATETIME       | 등록일 |
--| `updated_at`       | DATETIME       | 수정일 |


--(1, '산책', '가장 기본적인 야외 운동으로 스트레스 해소와 사회성 향상에 효과적입니다.', 80.0, 30, '모든 견종, 노령견 포함', '저강도', NOW(), NOW()),
--
--(2, '노즈워크', '간식을 숨겨두고 냄새로 찾게 하는 놀이로, 정신 자극과 집중력 향상에 좋습니다.', 60.0, 20, '실내 생활견, 고양이도 가능', '저강도', NOW(), NOW()),
--
--(3, '수영', '관절에 부담이 적고 전신 근육을 사용하는 고강도 운동입니다.', 120.0, 25, '중형견 이상, 관절 약한 반려동물', '고강도', NOW(), NOW()),
--
--(4, '터그놀이', '줄다리기 형태의 놀이로, 근력과 집중력을 동시에 향상시킵니다.', 70.0, 15, '활동적인 소형견, 고양이도 가능', '중강도', NOW(), NOW()),
--
--(5, '레이저 포인터 추적', '고양이에게 인기 있는 실내 운동으로, 사냥 본능을 자극합니다.', 50.0, 10, '고양이 전용, 실내 생활 반려동물', '중강도', NOW(), NOW());

-- desc exerciseinfo;
-- delete from exerciseinfo;
-- commit;

-- select     column_name, data_default
-- from       user_tab_columns
-- where      table_name='POST';

create sequence exerciseinfo_seq;

create table exerciseinfo(
    execid         int           primary key,
    exectype       VARCHAR2(50),
    description    VARCHAR2(255),
    avgkcal30min   FLOAT,
    exectargetmin  int,
    suitablefor    VARCHAR2(100),
    intensitylevel VARCHAR2(100),
    createdat      DATE  DEFAULT SYSDATE,
    updatedat      DATE  DEFAULT SYSDATE
 );

insert into exerciseinfo (execid, exectype, description, avgkcal30min, exectargetmin, suitablefor, intensitylevel ) 
values(exerciseinfo_seq.nextval, '산책', '기본적인 야외활동/스트레스 해소', 80.0, 30, '모든 견종, 노령견 포함', '저강도' );

select * from exerciseinfo;

select * from exerciseinfo  where  execid=1;  
  
update exerciseinfo set exectype='1', description='1', avgkcal30min=10.0, exectargetmin=5, suitablefor='1', intensitylevel='1'     where  execid=1;

delete from exerciseinfo   where  execid=1;

commit;

drop table exerciseinfo;

--insert into exerciseinfo(execid,
--                         exectype,
--                         description,
--                         avgkcal30min,
--                         exectargetmin,
--                         suitablefor,
--                         intensitylevel,
--                         createdat,
--                         updatedat) 
--values ( 1,
--        '산책',
--        '가장 기본적인 야외 운동으로 스트레스 해소와 사회성 향상에 효과적입니다.',
--        80.0,
--        30,
--        '모든 견종, 노령견 포함',
--        '저강도',
--        2025/11/3,
--        2025/11/3);

insert into exerciseinfo (execid, exectype, description, avgkcal30min, exectargetmin, suitablefor, intensitylevel ) 
values(exerciseinfo_seq.nextval,
       '노즈워크', 
       '간식을 숨겨두고 냄새로 찾게 하는 놀이로, 정신 자극과 집중력 향상에 좋습니다.', 
       60.0,
       20, 
       '실내 생활견, 고양이도 가능',
       '저강도');
       
insert into exerciseinfo (execid, exectype, description, avgkcal30min, exectargetmin, suitablefor, intensitylevel ) 
values(exerciseinfo_seq.nextval,
       '수영', 
       '관절에 부담이 적고 전신 근육을 사용하는 고강도 운동', 
       120.0, 
       25, 
       '중형견 이상, 관절 약한 반려동물', 
       '고강도'
 );
  
insert into exerciseinfo (execid, exectype, description, avgkcal30min, exectargetmin, suitablefor, intensitylevel ) 
values(exerciseinfo_seq.nextval,
        '터그놀이', 
        '줄다리기 형태의 놀이로, 근력과 집중력을 동시에 향상', 
        70.0,
        15, 
        '활동적인 소형견, 고양이도 가능',
        '중강도'
        );
  
 
insert into exerciseinfo (execid, exectype, description, avgkcal30min, exectargetmin, suitablefor, intensitylevel ) 
values(exerciseinfo_seq.nextval,
        '레이저 포인터 추적', 
        '고양이에게 인기 있는 실내 운동, 사냥 본능을 자극', 
        50.0, 
        10, 
        '고양이 전용, 실내 생활 반려동물', 
        '중강도'
    );













commit;
