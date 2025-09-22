package com.company.java009_ex;

import java.util.Scanner;

class Calc{
		  int num1, num2;  
		  char op;  
		  double result;

			public Calc() { super(); }

			void input() {
				Scanner scanner = new Scanner(System.in);

				System.out.print("1)숫자를 입력하세요 : ");
				this.num1 = scanner.nextInt();
				System.out.print("2)숫자를 입력하세요 : ");
				this.num2 = scanner.nextInt();
				System.out.print("3)연산자를 입력하세요(+,-,*,/) : ");
				this.op = scanner.next().charAt(0);
			}

			void opcalc() {
				switch (op) {
				case '+':
					this.result = this.num1 + this.num2;break;
				case '-':
					this.result = this.num1 - this.num2;break;
				case '*':
					this.result = this.num1 * this.num2;break;
				case '/':
					this.result = (double)this.num1 / this.num2;break;
				}
			}


			
			void show() {
				opcalc(); 
				if (this.op == '+' || this.op == '-' || this.op == '*') {
					System.out.printf("%d%s%d=%.0f\n\n", this.num1, this.op, this.num2, this.result);
				} else if (this.op == '/') {
					System.out.printf("%d%s%d=%.2f\n\n", this.num1, this.op, this.num2, this.result);
				}

			}
			
		
		public Calc(int num1, int num2, char op) {
						super();
						this.num1 = num1;
						this.num2 = num2;
						this.op = op;
					}

}

///////////////////////////////////////////////////
public class ClassEx007 {

	   public static void main(String[] args) {
		   Calc  c1= new Calc(10,3,'+');  
		   c1.show();
		   
		   Calc  c2= new Calc();  
		   c2.input();   
		   c2.show(); 
		    
		   }
		}

///////////////////////////////////////////////////