package com.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
	
	private ServerSocket serverSocket;

	public static void main(String[] args) {
		Server server = new Server();
		server.start();
		server.recevie();
	}
	
	public void start(){
		try {
			serverSocket = new ServerSocket(8888);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("服务启动失败...");
		}
	}
	
	public void recevie(){
		try {
			Socket socket = serverSocket.accept();
			System.out.println("一个客户端建立了链接...");
			byte[] bs = new byte[1024*1024];
			InputStream inputStream = socket.getInputStream();
			int len = inputStream.read(bs);
			String context = new String(bs, 0, len);
			System.out.println(context);
			
			StringBuilder content =new StringBuilder();
			content.append("<html>");
			content.append("<head>");
			content.append("<meta http-equiv=\"content-type\" content=\"txt/html; charset=utf-8\" />");
			content.append("<title>");
			content.append("服务器响应成功");
			content.append("</title>");
			content.append("</head>");
			content.append("<body>");
			content.append("server终于回来了。。。。");
			content.append("</body>");
			content.append("</html>");
			int size = content.toString().getBytes().length; //必须获取字节长度
			StringBuilder responseInfo =new StringBuilder();
			String blank =" ";
			String CRLF = "\r\n";
			//返回
			//1、响应行: HTTP/1.1 200 OK
			responseInfo.append("HTTP/1.1").append(blank);
			responseInfo.append(200).append(blank);
			responseInfo.append("OK").append(CRLF);
			//2、响应头(最后一行存在空行):
			/*
			 Date:Mon,31Dec209904:25:57GMT
			Server:shsxt Server/0.0.1;charset=GBK
			Content-type:text/html
			Content-length:39725426
			 */
			responseInfo.append("Date:").append(new Date()).append(CRLF);
			responseInfo.append("Server:").append("Server/0.0.1;charset=UTF-8").append(CRLF);
			responseInfo.append("Content-type:text/html").append(CRLF);
			responseInfo.append("Content-length:").append(size).append(CRLF);
			responseInfo.append(CRLF);
			//3、正文
			responseInfo.append(content.toString());
			
			//写出到客户端			
			BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bw.write(responseInfo.toString());
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("客户端错误");
		}
	}
	
	public void stop(){
		
	}
}
