package com.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * 可视化日历程序
 * @author Administrator
 *
 */
public class CalendarProgram {

	public static void main(String[] args) throws ParseException {
		
		System.out.println("请输入日期格式：yyyy-MM-dd");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse(str);
		
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		
		int inputDay = calendar.get(Calendar.DATE);
		
		System.out.println("日\t一\t二\t三\t四\t五\t六");
		
		calendar.set(Calendar.DATE, 1);
		for(int i=0; i<calendar.get(Calendar.DAY_OF_WEEK)-1; i++){
			System.out.print("\t");
		}
		
		int daysOfMonth = calendar.getActualMaximum(Calendar.DATE);
		
		for(int i=0; i<daysOfMonth; i++){
			
			if(inputDay == calendar.get(Calendar.DAY_OF_MONTH)){
				System.out.print(calendar.get(Calendar.DAY_OF_MONTH) + "*");
			}else {
				System.out.print(calendar.get(Calendar.DAY_OF_MONTH));
			}
			
			System.out.print("\t");
			
			if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
				System.out.println();
			}
			
			calendar.add(Calendar.DATE, 1);
		}
		
	}
}
