package com.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.server.basic.servlet.LoginServlet;
import com.server.basic.servlet.RegisterServlet;
import com.server.basic.servlet.Servlet;

/**
 * 目标: 封装请求信息中参数转成map
 * 
 *
 */
public class Server7 {
	private ServerSocket serverSocket ;
	private boolean isRunning = false;
	public static void main(String[] args) {
		Server7 server = new Server7();
		server.start();
	}
	//启动服务
	public void start() {
		try {
			serverSocket =  new ServerSocket(8888);
			isRunning = true;
			 receive();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("服务器启动失败....");
		}
	}
	//接受连接处理
	public void receive() {
		
		while(isRunning){
			try {
				Socket client = serverSocket.accept();
				new Thread(new Dispatcher(client)).start();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("客户端错误");
			}
		}
	}
	
	public void stop() {
		isRunning = false;
		try {
			this.serverSocket.close();
			System.out.println("服务器已停止");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
