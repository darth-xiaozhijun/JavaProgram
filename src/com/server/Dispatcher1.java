package com.server;

import java.io.IOException;
import java.net.Socket;

import com.server.basic.servlet.Servlet;

public class Dispatcher1 implements Runnable {
	
	private Socket client;
	
	private Request request;
	
	private Response response;
	
	public Dispatcher1(Socket client) {
		this.client = client;
		try {
			request =new Request(client);
			response =new Response(client);
		} catch (IOException e) {
			e.printStackTrace();
			this.release();
		}
	}

	@Override
	public void run() {
		
		try {
			
			Servlet servlet = WebApp.getServletFromUrl(request.getUrl());
			if(null != servlet){
				servlet.Service(request, response);
				response.pushToBrowser(200);
			}else{
				response.pushToBrowser(404);
			}
			
		} catch (IOException e) {
			try {
				response.pushToBrowser(500);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		release();
		
	}
	
	//释放资源
	private void release() {
		try {
			client.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
