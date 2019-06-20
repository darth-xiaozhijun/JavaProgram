package com.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
	
	private ServerSocket serverSocket;

	public static void main(String[] args) {
		Server2 server = new Server2();
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
			
			Response response = new Response(socket);
			response.print("<html>");
			response.print("<head>");
			response.print("<meta http-equiv=\"content-type\" content=\"txt/html; charset=utf-8\" />");
			response.print("<title>");
			response.print("服务器响应成功");
			response.print("</title>");
			response.print("</head>");
			response.print("<body>");
			response.print("server终于回来了。。。。");
			response.print("</body>");
			response.print("</html>");
			
			response.pushToBrowser(200);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("客户端错误");
		}
	}
	
	public void stop(){
		
	}
}
