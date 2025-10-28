## 📚 day041 복습 

Q1.  form 태그에서 요청할때,  눈여겨봐야할부분은 (action, method, name ) 이다.
Q2.  넘겨받은 값을 확인할때는 request.getParameter("name명")
Q3.  jdbc 연동할때 ojdbc6.jar  파일의 위치는?   [WEB-INF]-[lib]
Q4.  jdbc연동할때 순서는?  드커프리
   Class.forName( 드라이버이름)
   Connection  conn = DriverManger.getConnection(url, id, pass);

> 다음과 같이 테이블이 있다.
SQL>  desc dept
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 DEPTNO                                    NOT NULL NUMBER(2)
 DNAME                                              VARCHAR2(14)
 LOC                                                VARCHAR2(13)

Q5. insert     ( 필드넣는방식, 안넣는방식)
위의 테이블에    (50, 'DATABASE' , 'INCHEON')   /  (60, 'AI' , 'INCHEON')
insert into dept ( deptno, dname, loc) values  (50, 'DATABASE' , 'INCHEON')
insert into dept                                values  (60, 'AI' , 'INCHEON')

Q6. update 
번호가 60인 데이터의 LOC를 BUSAN으로 변경
update dept  set  LOC = 'BUSAN'  where deptno = 60

Q7. delete
50번 이상의 데이터를 삭제하시오.
delete from dept  where deptno >= 50

Q8. 위의 내용을 반영하려면?
commit


 