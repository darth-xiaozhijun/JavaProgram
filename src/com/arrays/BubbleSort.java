package com.arrays;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author Administrator
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		
		int[] values = {3,1,6,2,9,0,7,4,5,8};
		int temp = 0;
		
		for(int i=0; i<values.length-1; i++){
			
			boolean isExchange = true;
			for(int j=0; j<values.length-1-i; j++){
				
				if(values[j] > values[j+1]){
					temp = values[j+1];
					values[j+1] = values[j];
					values[j] = temp;
					
					isExchange = false;
				}
				
				System.out.println(Arrays.toString(values));
			}
			
			System.out.println("第"+(i+1)+"趟排序");
			if(isExchange){
				break;
			}
		}
	}
}
