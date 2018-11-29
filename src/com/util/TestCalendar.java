package com.util;

import java.awt.geom.GeneralPath;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 测试日期类的使用
 * @author Administrator
 *
 */
public class TestCalendar {

	public static void main(String[] args) {
		
		Calendar calendar = new GregorianCalendar(2099,1,9,22,10,50);
		int year = calendar.get(Calendar.YEAR);
		System.out.println(year);
		int month = calendar.get(Calendar.MONTH);//0表示一月，11表示十二月
		System.out.println(month);
		int day = calendar.get(Calendar.DATE);
		System.out.println(day);
		int weekday = calendar.get(Calendar.DAY_OF_WEEK);//1表示星期日，7表示星期六
		System.out.println(weekday);
		System.out.println(calendar);
		
		//设置日期相关元素
		Calendar calendar2 = new GregorianCalendar();
		System.out.println(calendar2);
		
		calendar2.set(Calendar.YEAR,8012);
		System.out.println(calendar2);
		
		//日期的计算
		Calendar calendar3 = new GregorianCalendar();
		calendar3.add(Calendar.YEAR, 100);
		System.out.println(calendar3);
		
		//日期对象和时间对象的转化
		Date date = calendar3.getTime();
		Calendar calendar4 = new GregorianCalendar();
		calendar4.setTime(new Date());
		
		printCalendar(calendar4);
	}
	
	/**
	 * 格式化打印日期
	 * @param calendar
	 */
	public static void printCalendar(Calendar calendar){
		
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		int weekday = calendar.get(Calendar.DAY_OF_WEEK) -1;
		
		String weekDay = weekday == 1 ? "日" : weekday+"";
		
		System.out.println(year + "年" + month + "月" + day + "日 " + hour + "时" + minute + "分" + second + "秒"
				+ " 周" + weekDay); 
	}
}
