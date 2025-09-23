package com.company.java010;

//1. final 변경 금지
//클래스=부품객체
//클래스	=		상태(멤버변수)		+	행위(멤버함수)
//상속X 		[상수:변하지 않는 값]		override X
class FinalEx extends Object{
final static String gaecheon="10-3"; //클래스 변수 - method area - new x - this x - 생성자 x >바로 사용 가능
	String name;						 //인스턴스 변수 - heap - new - this - 생성자 >메모리 각각
final void show() {System.out.println(FinalEx.gaecheon + "\t" + name);
	}
}

class FinalSon extends FinalEx{
	//@Override void show() {  super.show(); } 
	//오버라이드: 상속 시 자식 클래스에서 부모 클래스 재수정
	
}

///////////////////////////////////////////////////////
public class Final001 {

	public static void main(String[] args) {
//		FinalEx.gaecheon = "10-1"; //The final field FinalEx.gaecheon cannot be assigned
//		FinalEx.show()  //new 없음 =show가 메모리에 올라간 적 없어서 사용x 
		
		FinalEx saram = new FinalEx();
		saram.name = "dobby";
		saram.show();
	}

}
//////////////////////////////////////////////////////