package com.makun.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add2")
public class Add2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] num_ = request.getParameterValues("num");
		int result = 0;
		
		for(int i=0; i<num_.length;i++) {
			if (num_[i].equals("")) {
				num_[i] = "0";
			}
			int num = Integer.parseInt(num_[i]);
			result +=num;
		}
		
		
		response.getWriter().printf("답은 %d 입니다.", result);
		
	}

}
