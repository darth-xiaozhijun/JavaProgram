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
public class Server5 {
	private ServerSocket serverSocket ;
	public static void main(String[] args) {
		Server5 server = new Server5();
		server.start();
	}
	//启动服务
	public void start() {
		try {
			serverSocket =  new ServerSocket(8888);
			 receive();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("服务器启动失败....");
		}
	}
	//接受连接处理
	public void receive() {
		try {
			Socket client = serverSocket.accept();
			System.out.println("一个客户端建立了连接....");
			//获取请求协议
			Request request =new Request(client);
			
			Response response =new Response(client);
			
			Servlet servlet = null;
			
			if(request.getUrl().equals("login")){
				
				servlet = new LoginServlet();
				servlet.Service(request, response);
				
			}else if(request.getUrl().equals("reg")){
				
				servlet = new RegisterServlet();
				servlet.Service(request, response);
				
			}else {
				
			}
			//关注了状态码
			response.pushToBrowser(200);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("客户端错误");
		}
	}
	//停止服务
	public void stop() {
		
	}
}
