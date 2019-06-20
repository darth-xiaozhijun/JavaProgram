package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试Statement接口的用法，执行SQL语句，以及SQL注入问题
 * @author Administrator
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接(连接对象内部其实包含了Socket对象，是一个远程的连接。比较耗时！这是Connection对象管理的一个要点！)
			//真正开发中，为了提高效率，都会使用连接池来管理连接对象！
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true","root","123456");
			
			stmt = conn.createStatement();
//			String sql = "INSERT INTO t_user_info (username,password,create_time,update_time) VALUES (\"张三\",\"zhangsan\",\"2019-06-20 10:59:00\",\"2019-06-20 11:00:00\");";
//			stmt.execute(sql);
			
			//测试SQL注入
			String id = "5 or 1=1 ";
			String sql = "delete from t_user_info where id="+id;
//			stmt.execute(sql);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
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
