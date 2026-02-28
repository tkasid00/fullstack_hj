desc userinfo;
--이름    널?       유형            
------- -------- ------------- 
--NO    NOT NULL NUMBER        
--EMAIL NOT NULL VARCHAR2(100) 
--AGE            NUMBER        

insert into userinfo values(2, 'test@mail.com', 10);
select * from userinfo;
select * from userinfo where no=2;
update userinfo set no=1, email='test@test.test', age=20 where no=2;
delete from userinfo where no=1;

create sequence userinfo_seq;

insert into userinfo values(userinfo_seq.nextval, 'test@mail.com', 10);
select * from userinfo;
select * from userinfo where no=1;
update userinfo set email='test@test.test', age=20 where no=1;
delete from userinfo where no=1;


create table milk (
mno number not null,
nmame varchar2(100) not null,
nnum number not null,
mtotal number
);

create sequence milk_seq;

desc milk;

insert into milk(mno, nmame, nnum, mtotal) values(milk_seq.nextval, '바나나우유', 1, 1000 );
select * from milk;
select * from milk where mno=1;
update milk set nmame='딸기우유', nnum=2, mtotal=2000 where mno=1;
delete from milk where mno=1;



-----------------------

--   연습문제) 프로젝트 새로만들기~!
--      Q1. spring 프로젝트 spring005 만드시오.
--      Q2. datasource설정하는 
--         root-context.xml 과  application.properties를 작성하시오.
--      Q3. ApplicationContext, DataSource를 테스트하시오.
--      Q4. mybatis를   
--         root-context.xml 에 설정하고 mybatis 테스트를 하시오.
--      Q5. table 작성 - sql 기본구문 5개 작성
--      Q6. dto 작성
--      Q7. dao 작성
--      Q8. dao 테스트
--
--      SQL> desc sboard1;
--      Name                                      Null?    Type
--      ----------------------------------------- -------- ----------------------------
--      ID                                        NOT NULL NUMBER
--      APP_USER_ID                               NOT NULL NUMBER
--      BTITLE                                    NOT NULL VARCHAR2(1000)
--      BCONTENT                                  NOT NULL CLOB
--      BPASS                                     NOT NULL VARCHAR2(255)
--      BFILE                                              VARCHAR2(255)
--      BHIT                                               NUMBER(10)
--      BIP                                       NOT NULL VARCHAR2(255)
--      CREATE_AT                                          TIMESTAMP(6)


--
--이름          널?       유형             
------------- -------- -------------- 
--ID          NOT NULL NUMBER         
--APP_USER_ID NOT NULL NUMBER         
--BTITLE      NOT NULL VARCHAR2(1000) 
--BCONTENT    NOT NULL CLOB           
--BPASS       NOT NULL VARCHAR2(255)  
--BFILE                VARCHAR2(255)  
--BHIT                 NUMBER         
--BIP         NOT NULL VARCHAR2(255)  
--CREATE_AT            TIMESTAMP(6)   

drop table sboard1;
drop sequence sboard1_seq;

create table sboard1(
    id number not null,
    app_user_id number not null,
    btitle varchar2(1000) not null,
    bcontent clob not null,
    bpass varchar2(255) not null,
    bfile varchar2(255),
    bhit number default 0,
    bip varchar2(255) not null,
    create_at timestamp(6) default sysdate
    
);

desc sboard1;

create sequence sboard1_seq;

insert into sboard1(id, app_user_id, btitle, bcontent, bpass, bfile, bip, create_at)
    values(sboard1_seq.nextval, 1, 'test001', '1234', '1111', '#', '****',  sysdate);
    
select * from sboard1;
select * from sboard1 where id=3;

update sboard1 set btitle= 'test02', bcontent= '5678', bpass= '1111', bfile='*' where id=3;

delete from sboard1 where id=1;


commit;
    
    