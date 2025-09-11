package com.company.java006;

public class Array001 {
	public static void main(String[] args) {
		
		//1. 변수 활용 시 
		int a=1, b=2, c=3;
		
		//2. 배열?
		//[같은 타입]의 데이터를 [연속된 공간에 저장]하는 자료 구조
		//각 데이터의 저장 위치 [인덱스] 통해 접근
		// int[] arr -> 주소 보관할 준비 완 /  null -> 값은 없음(초기화)
		int[] arr = null;
		System.out.println(arr);
		
		//[stack] 주소 보관 = {heap} 같은 타입 데이터 1,2,3을 연속된 공간에 저장 
		int		[] arr2  = 	{1,2,3};
		//		arr2(1000번지) → 1000번지{1,2,3}
		//								[0][1][2] 숫자는 0부터!
		
		System.out.println(arr2);  //[I@28a418fc 주소값 출력
		System.out.println("1 꺼내 쓰기>"+arr2[0]);
		System.out.println("2 꺼내 쓰기>"+arr2[1]);
		System.out.println("3 꺼내 쓰기>"+arr2[2]);
		
		//3. 배열 예시(1) : arr3 1 2 3 4 5
		
		int [] arr3 = {1,2,3,4,5}; // 인덱스 0~4
		System.out.println(arr3[2]);
		
		
		//3. 배열 예시(2) : arr4 100 200 300
		int[] arr4 = {100,200,300}; //0~2
		System.out.println(arr4[0]);
		
		//3. 배열 예시(3) : arr5 1.1 1.2 1.3
		double[] arr5 = {1.1,1.2,1.3};
		System.out.println(arr5[2]); //0~2
		
		
		//3. 배열 예시(4) : arr6 a b c
		char[] arr6 = {'a','b','c'}; //0~2
	 	System.out.println(arr6[0]);
		System.out.println(arr6[1]);
		System.out.println(arr6[2]);
		
		
		//4. 배열.length : 배열의 개수 
		System.out.println("배열의 개수 출력 : "+arr6.length);
		
		//{반복} {변수} for(시작;종료;변화)
		for(int i=0;i<=2;i++){System.out.print(arr6[i]);}
		for(int i=0;i<3;i++){System.out.print(arr6[i]);}
		for(int i=0;i<arr6.length;i++){System.out.print(arr6[i]);}// 0부터 arr6.length(개수)까지 
		
	}

}
