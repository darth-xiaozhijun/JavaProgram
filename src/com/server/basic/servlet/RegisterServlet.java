package com.server.basic.servlet;

import com.server.Request;
import com.server.Response;

public class RegisterServlet implements Servlet {

	@Override
	public void Service(Request request, Response response) {

		response.print("<html>"); 
		response.print("<head>"); 
		response.print("<meta http-equiv=\"content-type\" content=\"txt/html; charset=utf-8\" />");
		response.print("<title>");
		response.print("服务器响应成功");
		response.print("</title>");
		response.print("</head>");
		response.print("<body>");
		response.print("注册成功(っ•̀ω•́)っ✎"+request.getParameter("uname"));
		response.print("</body>");
		response.print("</html>");
	}

}
