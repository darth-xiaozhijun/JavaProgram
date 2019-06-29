package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 测试批处理的基本用法
 *
 */
public class Demo05 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true","root","123456");
			
			conn.setAutoCommit(false);  //设为手动提交
			long start = System.currentTimeMillis();
			stmt = conn.createStatement();
			
			for(int i=0;i<20000;i++){
				stmt.addBatch("insert into t_user_info (username,password,create_time,update_time) values ('肖"+i+"狗',666666,now(),now())");
			}
			stmt.executeBatch();
			conn.commit();  //提交事务
			long end = System.currentTimeMillis();
			System.out.println("插入20000条数据，耗时(毫秒)："+(end-start));
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//遵循：resultset-->statment-->connection这样的关闭顺序！一定要将三个trycatch块，分开写！
			try {
				if(rs!=null){
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(stmt!=null){
					stmt.close();
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
