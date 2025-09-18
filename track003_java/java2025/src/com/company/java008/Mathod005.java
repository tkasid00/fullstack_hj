package com.company.java008;

import java.util.Arrays;

public class Mathod005 {
	
	public static void call(int a) {System.out.println(a +">" +(a+10));}
	
	public static void call(int [] arr) {
		for(int i=0; i<arr.length;i++) {arr[i]+=100;}
		System.out.println("call[주소]" + System.identityHashCode(arr)
										+ Arrays.toString(arr));
		
		//[3]의 주소와 같은지 확인
		//[4] main에서의 배열값과 같은지 확인
	}

	/////////////////////////////////////
	public static void main(String[] args) {
		
		int[] arr = {10,20,30}; //call by value : 주어진 값을 복사하기 때문에 배열값이 변경되지 않음.
		
		call(10);		//+10 마법상자
		call(arr[0]);	
		System.out.println("[1]main : " + System.identityHashCode(arr));
		System.out.println("[2]main : " +Arrays.toString(arr));
		
		
		call(arr);		//+100    
						// call by reference : 주소를 참조, 배열값을 직접 변경시킴
		System.out.println("[1]main : " + System.identityHashCode(arr));
		System.out.println("[2]main : " +Arrays.toString(arr));
	}
///////////////////////////////////////////////
}
