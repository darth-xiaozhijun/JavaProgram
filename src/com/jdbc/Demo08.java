package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;


/**
 * 测试时间处理(java.sql.Date,Time,Timestamp),取出指定时间段的数据
 *
 */
public class Demo08 {
	
	/**
	 * 将字符串代表的日期转为long数字(格式：yyyy-MM-dd hh:mm:ss)
	 * @param dateStr
	 * @return
	 */
	public static  long  str2Date(String dateStr){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			return format.parse(dateStr).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true","root","123456");
			
//			ps = conn.prepareStatement("select * from t_user_info where regist_time>? and regist_time<?");
//			java.sql.Date start = new java.sql.Date(str2Date("2019-6-27 10:23:45"));
//			java.sql.Date end = new java.sql.Date(str2Date("2019-6-29 10:23:45"));
//			ps.setObject(1, start);
//			ps.setObject(2, end);
			
			ps = conn.prepareStatement("select * from t_user_info where last_login_time>? and last_login_time<?  order by last_login_time ");
			Timestamp start = new Timestamp(str2Date("2019-6-27 8:10:20"));
			Timestamp end = new Timestamp(str2Date("2019-6-29  9:9:10"));
			ps.setObject(1, start);
			ps.setObject(2, end);
			rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt("id")+"--"+rs.getString("username")+"--"+rs.getTimestamp("last_login_time"));
			}
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(ps!=null){
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
