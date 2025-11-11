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