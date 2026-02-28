## 📚 day01 복습  


>>>> CSS 
CSS 다음 빈칸에 알맞은 코드를 채우시오.
  <div class="container c1">
    <div class="item i1">aaa</div>
    <div class="item i2">bbbbb</div>
    <div class="item i3">cc</div>
  </div>


/* [c1] 기본 html 흐름  display의 어떤속성이다  
AAA
BBB
CCC
*/
.c1{ ①  }

/* [c2] 자식요소들을 가로로 정렬하고, 유연한 레이아웃 사용하려고한다.   
AAA  BBB   CCC
*/
.c2{ ②   }

/* [c3] flex 방향 :기본  
AAA  BBB   CCC
*/
.c3{  ③    ④    }

/* [c4] flex 방향 : column - 거꾸로 세로방향  
CCC
BBB
AAA     
*/
.c4{ ⑤   ⑥   }

/* [c5] flex 방향 : 네비게이션 + 오른쪽정렬  
HOME  ABOUT		CONTACT
*/
.c5{  ⑦   }  	   /* 5-1. 네이게이션메뉴 가로배치 - 줄바꿈 방지 */
.c5 .item{ ⑧   }	    /* 5-2. 항목들 사이즈-크기를 한번에 설정 (none)  */
.c5 .item.i3{ ⑨    }  /*  5-3.  마지막항목을 오른쪽 끝으로 정렬 */ 




>>>> CSS  ANSWER
CSS 다음 빈칸에 알맞은 코드를 채우시오.
  <div class="container c1">
    <div class="item i1">aaa</div>
    <div class="item i2">bbbbb</div>
    <div class="item i3">cc</div>
  </div>


/* [c1] 기본 html 흐름  display의 어떤속성이다  
AAA
BBB
CCC
*/
.c1{ ① display: block; }

/* [c2] 자식요소들을 가로로 정렬하고, 유연한 레이아웃 사용하려고한다.   
AAA  BBB   CCC
*/
.c2{ ② display: flex; }

/* [c3] flex 방향 :기본  
AAA  BBB   CCC
*/
.c3{  ③ display: flex;  ④ flex-direction: row;  }

/* [c4] flex 방향 : column - 거꾸로 세로방향  
CCC
BBB
AAA     
*/
.c4{ ⑤ display: flex;  ⑥ flex-direction: column-reverse;  }

/* [c5] flex 방향 : 네비게이션 + 오른쪽정렬  
HOME  ABOUT		CONTACT
*/
.c5{  ⑦ display: flex; }  	   /* 5-1. 네이게이션메뉴 가로배치 - 줄바꿈 방지 */
.c5 .item{ ⑧ flex : none;   }	    /* 5-2. 항목들 사이즈-크기를 한번에 설정 (none)  */
.c5 .item.i3{ ⑨ margin-left:auto;  }  /*  5-3.  마지막항목을 오른쪽 끝으로 정렬 */ 

 
