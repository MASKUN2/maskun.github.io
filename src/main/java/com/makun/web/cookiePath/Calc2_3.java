package com.makun.web.cookiePath;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calc2_3")
public class Calc2_3 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//상태유지. 쿠키 URL Path 설정
		Cookie[] cookies = request.getCookies();
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");	
		
		int v = 0;
		int result = 0;
		
		if(!v_.equals("")) v = Integer.parseInt(v_);	
		
		//계산
		if(op.equals("=")) {
			int x = 0;
			String operator ="";
			
			for(Cookie c : cookies) 
				if(c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
					
			
			int y = v;
			
			for(Cookie c : cookies) 
				if(c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}
			
			if(operator.equals("+"))
				result = x+y;
			else {
				result = x-y;
			}
			//출력
			response.getWriter().printf("답은 %d 입니다.", result);
		}else{
		
			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie opCookie = new Cookie("op", op);
			valueCookie.setPath("/"); //모든 페이지, ""안의 경로가 "/notice" 인경우 URL 지정 페이지에서 쿠키를 가져올 수있음
			opCookie.setPath("/"); //모든 페이지, ""안의 경로가 "/notice" 인경우 URL 지정 페이지에서 쿠키를 가져올 수있음
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
			
		}
	}

}
