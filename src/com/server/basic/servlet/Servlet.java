package com.server.basic.servlet;

import com.server.Request;
import com.server.Response;

public interface Servlet {

	void Service(Request request,Response response);
}
