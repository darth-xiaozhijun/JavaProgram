package com.jdbc;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


/**
 * 测试CLOB  文本大对象的使用
 * 包含：将字符串、文件内容插入数据库中的CLOB字段、将CLOB字段值取出来的操作。
 *
 */
public class Demo09 {
	
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Reader r  = null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true","root","123456");
			
//			ps = conn.prepareStatement("insert into t_user_info (username,my_info,create_time) values (?,?,?) ");
//			ps.setString(1, "高淇");
////			ps.setClob(2, new FileReader(new File("d:/b.txt")));  //将文本文件内容直接输入到数据库中
//			ps.setObject(3, new Date());
//			
//			//将程序中的字符串输入到数据库的CLOB字段中
//			ps.setClob(2, new BufferedReader(new InputStreamReader(new ByteArrayInputStream("aaaabbbbbb".getBytes()))));
//			ps.executeUpdate();
			
			ps = conn.prepareStatement("select * from t_user_info where id=?");
			ps.setObject(1, 1011);
			
			rs = ps.executeQuery();
			while(rs.next()){
				Clob c = rs.getClob("my_info");
				r  = c.getCharacterStream();
				int temp = 0;
				while((temp=r.read())!=-1){
					System.out.print((char)temp);
				}
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(r!=null){
					r.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
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
