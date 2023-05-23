package com.makun.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//상태유지. 어플리케이션 저장소(서블릿 컨텍스트) 사용하여 연산하기(저장시 하얗게 빈페이지뜸)
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");	
		ServletContext application = request.getServletContext();
		
		int v = 0;
		int result = 0;
		
		if(!v_.equals("")) v = Integer.parseInt(v_);	
		
		//계산
		if(op.equals("=")) {
			
			int x = (Integer)application.getAttribute("value");
			int y = v;
			String operator = (String)application.getAttribute("operator");
			
			
			
			if(operator.equals("+"))
				result = x+y;
			else {
				result = x-y;
			}
		//출력
		response.getWriter().printf("답은 %d 입니다.", result);
		}
			
		else {
		
		application.setAttribute("value", v);
		application.setAttribute("operator", op);
		
		}
	}

}
