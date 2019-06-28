package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;


/**
 * 测试时间处理(java.sql.Date,Time,Timestamp)
 *
 */
public class Demo07 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true","root","123456");
			
			for(int i=0; i<1000; i++){
				
				ps1 = conn.prepareStatement("insert into t_user_info (username,password,regist_time,last_login_time,create_time,update_time) values (?,?,?,?,?,?)");
				ps1.setObject(1, "肖"+i+"狗");
				ps1.setObject(2, "123456");
				int rand =  100000000+new Random().nextInt(1000000000);
				java.sql.Date date = new java.sql.Date(System.currentTimeMillis()-rand);
				ps1.setDate(3, date);
				Timestamp timestamp = new Timestamp(System.currentTimeMillis()-rand);
				ps1.setTimestamp(4, timestamp);
				ps1.setObject(5, new Date());
				ps1.setObject(6, new Date());
				ps1.execute();
			}
			System.out.println("插入一个用户,肖一狗");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(ps1!=null){
					ps1.close();
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
