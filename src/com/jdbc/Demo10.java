package com.jdbc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;



/**
 * 测试BLOB  二进制大对象的使用
 *
 */
public class Demo10 {
	
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		InputStream is  = null;
		OutputStream os = null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true","root","123456");
			
//			ps = conn.prepareStatement("insert into t_user_info (username,head_img,create_time) values (?,?,?) ");
//			ps.setString(1, "金鱼");
//			ps.setBlob(2, new FileInputStream("d:/a.jpg"));
//			ps.setObject(3, new Date());
//			ps.execute();
			
			
			ps = conn.prepareStatement("select * from t_user_info where id=?");
			ps.setObject(1, 1012);
			
			rs = ps.executeQuery();
			while(rs.next()){
				Blob b = rs.getBlob("head_img");
				is  = b.getBinaryStream();
				os = new FileOutputStream("d:/b.jpg");
				int temp = 0;
				while((temp=is.read())!=-1){
					os.write(temp);
				}
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(is!=null){
					is.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if(os!=null){
					os.close();
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
