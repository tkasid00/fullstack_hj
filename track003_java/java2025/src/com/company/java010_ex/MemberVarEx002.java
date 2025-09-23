package com.company.java010_ex;

class Student {
    String name = "홍길동";        
    int kor = 90;                  
    int eng = 85;                 
    static int studentCount = 0;    

    static int total = kor + eng;      //static에 인스턴스 변수 kor, eng 사용 불가  ->this. 붙여서 타입 확인 가능

    static int maxScore = 100;     

    public Student() { //*****생성자 : 클래스명과 동일+리턴값 없음!!!*****
        studentCount++;       //static 사용 가능
    }

    public int getTotalScore() {
        return kor + eng;        
    }

    public static void showStudentCount() {
        System.out.println("전체 학생 수: " + studentCount);  
    }

   public static void showName() {
         System.out.println(name);  //인스턴스 사용x
   }

    public void showInfo() {
        System.out.println("이름: " + name);            
        System.out.println("총점: " + getTotalScore());    
    }
}

/////////////////////////////////////////////////////////////
public class MemberVarEx002 {
	
	   public static void main(String[] args) {
	        Student s1 = new Student();     
	        Student s2 = new Student();     

	        s1.showInfo();                  
	        Student.showStudentCount();    
	    }
	}
///////////////////////////////////////////////////////////
/*

- 문제 1. 다음 코드에서 인스턴스변수, 클래스변수, 지역변수를 구분하시오.  ( 보관되는 영역도 추가 )
->인스턴스변수(heap): name, kor, eng, studentCount
	클래스변수(method) : total, maxScore
	지역변수(stack): s1, s2, args

- 문제 2. 인스턴스메서드와 클래스메서드를 구분하시오.  
-> 인스턴스메서드 : Student(), getTotalScore(), showInfo()
	클래스메서드 : showStudentCount(), showName()
	
- 문제 3. 오류가 발생하는 이유를 설명하시오.
->static은 this 사용 불가 : this는 new로 heap 영역을 할당받은 다음 사용 가능하기 때문에 바로 사용 가능한 static과 시점이 맞지 않음. 


- 문제 4. runtime data area 위치영역 그림그리기
 
------------------------[ runtime data area]
[method: 정보, static, final : 공용정보]
>Student.class, MemberVarEx002.class
>static : Student.showStudentCount(), Student.showName()
		Student.studentCount, Student.maxScore	
------------------------------------
[heap: 동적]            		| [stack : 잠깐빌리기]
2번지						<-s2[2번지] 40줄
1번지						<-sl[1번지] 39줄
{name="홍", kor=90, eng=85<명시적 초기화값
showInfo(), getTotalScore()}
							|main
------------------------------------


초기화 순서 : 			기본값 		명시적 초기화		초기화 블록				생성자
studentCount			0				0(x)		  0(x)					0
maxScore				0				100			  100(x)				100
s1(name, kor, eng)		null, 0		홍길동, 90, 85	홍길동, 90, 85(x)		홍길동, 90, 85(x)
*/
