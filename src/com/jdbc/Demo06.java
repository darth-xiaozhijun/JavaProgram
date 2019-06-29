package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


/**
 * 测试事务的基本概念和用法
 *
 */
public class Demo06 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true","root","123456");
			
			conn.setAutoCommit(false); //JDBC中默认是true，自动提交事务
			
			ps1 = conn.prepareStatement("insert into t_user_info (username,password,create_time,update_time) values (?,?,?,?)");
			ps1.setObject(1, "肖一狗");
			ps1.setObject(2, "123456");
			ps1.setObject(3, new Date());
			ps1.setObject(4, new Date());
			ps1.execute();
			System.out.println("插入一个用户,肖一狗");
			
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			ps2 = conn.prepareStatement("insert into t_user_info (username,password,create_time,update_time) values (?,?,?,?)");
			ps2.setObject(1, "肖二狗");
			ps2.setObject(2, "123456");
			ps2.setObject(3, new Date());
//			ps2.setObject(4, new Date());
			ps2.execute();			
			System.out.println("插入一个用户,肖二狗");
			
			
			conn.commit();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			try {
				conn.rollback();	//回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
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
