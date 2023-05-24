package com.makun.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@WebServlet("/calc2_1")
public class Calc2_1 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//상태유지. 세션 사용하여 연산하기(appl와 다른점은 세션내(현재 접속한 사용자의 환경)에서만 사용가능, 브라우저가 바뀌면 다른 사용자로 인식)
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");	
		HttpSession session = request.getSession();
		
		int v = 0;
		int result = 0;
		
		if(!v_.equals("")) v = Integer.parseInt(v_);	
		
		//계산
		if(op.equals("=")) {
			
			int x = (Integer)session.getAttribute("value");
			int y = v;
			String operator = (String)session.getAttribute("operator");
			
			
			
			if(operator.equals("+"))
				result = x+y;
			else {
				result = x-y;
			}
		//출력
		response.getWriter().printf("답은 %d 입니다.", result);
		}
			
		else {
		
		session.setAttribute("value", v);
		session.setAttribute("operator", op);
		
		}
	}

}
