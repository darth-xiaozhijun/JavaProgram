package com.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

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
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("客户端错误");
		}
	}
	
	public void stop(){
		
	}
}
