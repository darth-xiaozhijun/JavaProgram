package com.arrays;

/**
 * 测试二维数组
 * @author Administrator
 *
 */
public class Test2DArrays {

	public static void main(String[] args) {
		
//		int[] a = new int[3];
		Car[] car = new Car[3];
		
		int[][] a = new int[3][];
		
		a[0] = new int[]{20,30};
		a[1] = new int[]{10,15,80};
		a[2] = new int[]{50,60};
		
		System.out.println(a[1][2]);
		
		int[][] b = {
				{10,20},
				{40,50,60},
				{70,80,90}
		};
		
		System.out.println(b[1][2]);
	}
}

class Car{
	
}