package com.makun.web.dynamicPage;

import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calc3")
public class Calc3 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 동적 서버페이지 구현
		Cookie[] cookies = request.getCookies();
		
		String value = request.getParameter("value");
		String operator = request.getParameter("operator");	
		String dot = request.getParameter("dot");	
		
		String exp = "";
		
		if(cookies != null)
			for(Cookie c : cookies) 
				if(c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
		
		
		if(operator != null && operator.equals("=")) {
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("graal.js");
			try {
				exp = String.valueOf(engine.eval(exp));
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			exp += (value == null)? "":value;
			exp += (operator == null)? "":operator;
			exp += (dot== null)? "":dot;
			
		}
		Cookie expCookie = new Cookie("exp", exp);
		
		
		response.addCookie(expCookie);
		response.sendRedirect("calcpage"); // 같은 레벨문서는 / 접두안해도 됨
			
		
	}

}
