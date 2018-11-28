package com.arrays;

import java.util.Arrays;

/**
 * 二分查找（折半检索）
 * @author Administrator
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
		
		int[] arr = {30,20,50,10,80,9,7,12,100,400,8};
		Arrays.sort(arr);
		
		System.out.println(Arrays.toString(arr));
		System.out.println(binarySearch(arr, 400));
	}
	
	/**
	 * 二分查找
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int binarySearch(int[] arr,int value){
		
		int low = 0;
		int high = arr.length - 1;
		
		while(low <= high){
			
			int mid = (high + low)/2;
			
			if(arr[mid] == value){
				return mid;
			}
			
			if(value > arr[mid]){
				low = mid + 1;
			}
			
			if(value < arr[mid]){
				high = mid - 1;
			}
		}
		
		return -1;
	}
}
