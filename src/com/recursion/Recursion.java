package com.recursion;

public class Recursion {

	public static void main(String[] args) {
//		a();
		long startTime = System.currentTimeMillis();
		System.out.println(factorial(10));
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		
		factorialLoop(10);
	}
	
	static int count = 0;
	public static void a(){
//		System.out.println("a");
		count++;
		if(count < 10){
			System.out.println("a");
			a();
		}else {
			return;
		}
	}
	
	public static void b(){
		System.out.println("b");
		
	}
	
	public static int factorial(int n){
		
		if(n == 1){
			return n;
		}else {
			return n * factorial(n - 1);
		}
	}
	
	public static int factorialLoop(int n){
		long startTime = System.currentTimeMillis();
		int result = 1;
		while(n > 1){
			result *= n * (n -1 );
			n -= 2;
		}
		long endTime = System.currentTimeMillis();
		System.out.println(result);
		System.out.println(endTime - startTime);
		
		return result;
	}
}
