package com.company.java010_bank;

public class UserInfo {
	private String id;
	private String pass;
	private double balance;
	//2
	public UserInfo() {super();}

	//3
	public UserInfo(String id, String pass, double balance) {
		super();
		this.id = id;
		this.pass = pass;
		this.balance = balance;

	}
	
	//4

	
	//g+s
	public String getId() { return id; } 
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", pass=" + pass + ", balance=" + balance + "]";
	}

	public String getPass() { return pass; }  
	public void setPass(String pass) { this.pass = pass; }  
	public double getBalance() { return balance; }  
	public void setBalance(double balance) { this.balance = balance; }  
	public void setId(String id) { this.id = id; } 


}


/*유저 정보 1인분 보관
	[-id:String		-pass:String	-balance:String]
*/