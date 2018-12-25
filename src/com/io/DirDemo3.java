package com.io;

public class DirDemo3 {

	public static void main(String[] args) {
		
		getTen(1);
	}
	
	public static void getTen(int n){
		 if(n>10){
			return; 
		 }
		 
		 System.out.println(n);
		 getTen(n+1);
	}
}
