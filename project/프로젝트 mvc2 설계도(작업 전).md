4) mvc2
	▶model 
		1. table (review) + sequence (review_seq)

    ### --12. table (review) + sequence (review_seq)
    | 컬럼명      | 데이터 타입       | 제약 조건                                                | 설명 |
    |-------------|-------------------|----------------------------------------------------------|------|
    | `reviewid`  | `NUMBER`          | `PRIMARY KEY`                                            | 리뷰 ID |
    | `userid`     | `NUMBER`          | `FOREIGN KEY REFERENCES user(userid)`                   | 작성자 |
    | `password`   | `VARCHAR2(50)`     | `NOT NULL`                                               | 글 비밀번호|
    | `brandid`    | `NUMBER`          | `FOREIGN KEY REFERENCES food_brand(brand_id)`            | 브랜드 ID |
    | `foodid`    | `NUMBER`          | `FOREIGN KEY REFERENCES food(food_id)`                  | 사료 ID |
    | `foodimg`    | `VARCHAR2(300)`   | `우선 null값 채우기`                                      | 사료 이미지 |
    | `rating`     | `NUMBER(1)`       | `CHECK (rating BETWEEN 1 AND 5)`                         | 평점 |
    | `reviewcomment`    | `VARCHAR2(500)`   | —                                                 | 리뷰 내용 |
    | `createdat` | `VARCHAR2(200)`   | —                                                        | 작성일 |

            이름            널?       유형            
            ------------- -------- ------------- 
            REVIEWID      NOT NULL NUMBER        
            USERID                 NUMBER        
            PASSWORD      NOT NULL VARCHAR2(50)  
            BRANDID                NUMBER        
            FOODID                 NUMBER        
            FOODIMG                VARCHAR2(300) 
            RATING                 NUMBER(1)     
            REVIEWCOMMENT          VARCHAR2(500) 
            CREATEDAT              DATE   



        3. dto
            [com.company.patfooddb] - ReDto.java(클래스 파일)
        | 컬럼명      | 데이터 타입       | 제약 조건                                                | 설명 |
        |-------------|-------------------|----------------------------------------------------------|------|
        | `reviewid`  | `NUMBER`          | `PRIMARY KEY`                                            | 리뷰 ID |
        | `userid`     | `NUMBER`          | `FOREIGN KEY REFERENCES user(userid)`                   | 작성자 |
        | `password`   | `VARCHAR2(50)`     | `NOT NULL`                                                | 글 비밀번호|
        | `brandid`    | `NUMBER`          | `FOREIGN KEY REFERENCES food_brand(brand_id)`            | 브랜드 ID |
        | `foodid`    | `NUMBER`          | `FOREIGN KEY REFERENCES food(food_id)`                  | 사료 ID |
        | `foodimg`    | `VARCHAR2(300)`   | `우선 null값 채우기`                                      | 사료 이미지 |
        | `rating`     | `NUMBER(1)`       | `CHECK (rating BETWEEN 1 AND 5)`                         | 평점 |
        | `title`     | `VARCHAR2(100)`       |                                                      | 제목 |
        | `reviewcomment`    | `VARCHAR2(500)`   | —                                                 | 리뷰 내용 |
        | `createdat` | `DATE`   | —                                                        | 작성일 |




		4. dao
            [com.pawject.controller] - ReDao.java(클래스 파일)
	▶view
		1. list.jsp
		2. write.jsp
		3. edit.jsp
		4. delete.jsp

	▶controller
		1. frontcontroller
         1-1. @WebServlet 개발용    *.do, *.member, *.hj
         [1-2. web.xml     배포용] 

       [com.pawject.controller]  - ReController
            ㄴindex.jsp
                ㄴ[전체글보기]/ReBoard/list.jsp (or login.jsp 등등 가능)
                            >/list.do           ■ ReList 불러오고 /  ReBoard/list.jsp로 넘김
                ㄴ[글쓰기폼]   /writeView.do      □ 기능X 단순 폼 소환 / ReBoard/write.jsp
                ㄴ[글쓰기기능] /write.do          ■ ReInsert         /  list.do 
                ㄴ[글수정폼]   /editView.do       ■ ReUpdateView   /  ReBoard/edit.jsp 
                ㄴ[글수정기능] /edit.do           ■ ReUpdate       /  알림창 + ReBoard/detail.jsp 
                ㄴ[글삭제폼]   /deleteView.do     ■ ReDeleteView   /  ReBoard/delete.jsp 
                ㄴ[글삭제기능] /delete.do         ■ ReDelete       /  알림창 + list.do 

            1-1. frontcontroller       web.xml       [com.pawject.controller] - ReController
            1-2. view 연결


        2. service
        [com.company.service]
            ReService<<interface>>
                △..ReList             넘겨받을 데이터 x / selectAll()
                △..ReInsert           데이터 o / insert(ReDto dto)
                △..ReUpdateView       데이터 o / select(int id)
                △..ReUpdate           데이터 o / update(ReDto dto)
                △..ReDeleteView       데이터 o / select(int id)
                △..ReDelete           데이터 o / delete(ReDto dto)



---
작업 중 변경 사항
1. food dto, dao 추가
2. service에서 id만 선택하면 내가 쓴 모든 글 삭제 현상 발생->reviewid를 메인으로