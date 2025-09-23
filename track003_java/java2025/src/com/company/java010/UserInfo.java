package com.company.java010;

public	class UserInfo {			//한 파일에 여러 개의 클래스가 있을 경우 public이 2개면 우선권 충돌로 오류가 생김
	public 		String name;
	protected 	String safeCode;  //자식한테
				String house;	//default
	private	int iQ;
	public int getiQ() {
		return iQ;
	}
	public void setiQ(int iQ) {
		this.iQ = iQ;
	}
}
