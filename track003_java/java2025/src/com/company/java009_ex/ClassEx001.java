package com.company.java009_ex;
// 1. 클래스는 부품 객체
// 2. 클래스는 상태(멤버변수)+행위(멤버함수)

class Student001 {
	
	//멤버변수
	String name;
	int no, kor, eng, math, total;
	double avg;
	//멤버 함수
	void info() {
		total = kor + eng + math;
		avg = total / 3.0;

		System.out.printf("이름 : %s \n총점 : %d \n평균 : %.2f", this.name, this.total, this.avg);
	}

}
////////////////////////////////////////////////////
public class ClassEx001 {
	public static void main(String[] args) {
				//1)new(1번지-객체 생성) 2)Student001 초기값 3)s1에 주소
		Student001 s1 = new Student001();
		s1.name = "first";
		s1.no = 11;
		s1.kor = 100;
		s1.eng = 100;
		s1.math = 99;
		s1.info();

	}

}
//////////////////////////////////////////
/*
-----------------------------------[runtime data area]
[method : 정보, static, final - 공용 정보] 
Student001.class, ClassEx001.class		1)
-------------------------------------------------------										
[heap : 동적]								|[stack : 잠깐 빌리기]
												
생성자가 해주는 일
ㄴ1번지{name=null, no=0, kor=0, eng=0, math=0}

1번지{name=first, no=11, kor=100, eng=100, math=99} <-sl[1번지]

											|main
--------------------------------------------------------

 */
 