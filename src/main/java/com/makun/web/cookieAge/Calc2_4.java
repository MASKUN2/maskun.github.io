package com.makun.web.cookieAge;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calc2_4")
public class Calc2_4 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//상태유지. 쿠키 유지 기간 설정. 
		//장기간, 특정 페이지의 데이터는 쿠키에 저장한다.
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
			valueCookie.setMaxAge(24*60*60); // 24시간 유지 쿠키
			opCookie.setMaxAge(24*60*60); 
			valueCookie.setPath("/"); 
			opCookie.setPath("/"); 
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
			
		}
	}

}
