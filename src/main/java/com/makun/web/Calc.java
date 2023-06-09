package com.makun.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calc extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String x_ = request.getParameter("x");
		String y_ = request.getParameter("y");
		String op = request.getParameter("operator");	
		
		int x = 0;
		int y = 0;
		int result = 0;
		
		if(!x_.equals("")) x = Integer.parseInt(x_);
		if(!y_.equals("")) y = Integer.parseInt(y_);
		
		switch (op) {
			case "덧셈": {
				result = x+y;
				break;
			}
			case "뺄셈": {
				result = x-y;
				break;
			}
			
		}
		
		
		response.getWriter().printf("답은 %d 입니다.", result);
		
	}

}