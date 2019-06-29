package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * 测试PreparedStatement的基本用法
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true","root","123456");
			
			String sql = "INSERT INTO t_user_info (username,password,create_time,update_time) VALUES (?,?,?,?);";
			ps = conn.prepareStatement(sql);
//			ps.setString(1, "李四");	//参数索引是从1开始计算， 而不是0
//			ps.setString(2, "123456");
//			ps.setDate(3, new java.sql.Date(System.currentTimeMillis()));
//			ps.setDate(4, new java.sql.Date(System.currentTimeMillis()));
			
			//可以使用setObject方法处理参数
			ps.setObject(1, "王五");
			ps.setObject(2, "234567");
			ps.setObject(3, new java.sql.Date(System.currentTimeMillis()));
			ps.setObject(4, new java.sql.Date(System.currentTimeMillis()));
			
			
			System.out.println("插入一行记录");
			ps.execute();
//			int count = ps.executeUpdate();
//			System.out.println(count);
			
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
