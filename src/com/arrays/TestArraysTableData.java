package com.arrays;

import java.util.Arrays;

/**
 * 测试二维数组储存表格数据
 * @author Administrator
 *
 */
public class TestArraysTableData {

	public static void main(String[] args) {
		
		Object[] object = {1001,"小张",18,"程序员","2018-09-11"};
		Object[] object2 = {1002,"小李",32,"架构师","2008-09-11"};
		Object[] object3= {1003,"小刘",22,"测试","2014-09-11"};
		
		Object[][] tableData = new Object[3][];
		tableData[0] = object;
		tableData[1] = object2;
		tableData[2] = object3;
		
		for (Object[] objects : tableData) {
			System.out.println(Arrays.toString(objects));
		}
	}
}
