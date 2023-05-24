package com.makun.web.dynamicPage.servletMerge;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
// 하나의 서블릿으로 계산기 서블릿을 통합 (get and Post 조건처리)
@WebServlet("/calculator002")
public class Calculator002 extends HttpServlet {
 @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 super.service(request,response); 
		 
		 }
	 @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			}
			else if(operator != null && operator.equals("C")) {
				exp = "";
				
			}
			else {
				exp += (value == null)? "":value;
				exp += (operator == null)? "":operator;
				exp += (dot== null)? "":dot;
				
			}
			Cookie expCookie = new Cookie("exp", exp);
			
			if(operator != null && operator.equals("C")) {
				expCookie.setMaxAge(0);
			}
			expCookie.setPath("/calculator002"); // 해당 페스에 한정한 쿠키발행
			response.addCookie(expCookie);
			response.sendRedirect("calculator002"); // 동일한 서블릿을 요청함
				
		}
	 @Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset = UTF-8");
			
			PrintWriter out = response.getWriter();
			
			String exp ="0";
			Cookie[] cookies = request.getCookies();
			if(cookies != null)
				for(Cookie c : cookies) 
					if(c.getName().equals("exp")) {
						exp = c.getValue();
						break;
					}
			
			out.write("<!DOCTYPE html>");
			out.write("<html>");
			out.write("<head>");
			out.write("<meta charset=\"UTF-8\">");
			out.write("<title>Insert title here</title>");
			out.write("<style>");
			out.write("input{");
			out.write("width:50px;");
			out.write("height:50px;");
			out.write("}");
			out.write(".output{");
			out.write("height:50px;");
			out.write("background: #e9e9e9;");
			out.write("font-size:24px;");
			out.write("font-weight:bold;");
			out.write("text-align: right;");
			out.write("padding: 0px 5px;");
				
			out.write("}");
			out.write("</style>");
			out.write("</head>");
			out.write("<body>");
			out.write("<!-- 동적서블릿 페이지 -->");
			out.write("<div>");
			out.write("<form method=\"post\">"); // 동일페이지를 호출하므로 action을 지워도 가능
			out.write("<table>");
			out.write("<tr>");
			out.printf("<td class=\"output\" colspan=\"4\">%s</td>", exp);
			out.write("</tr>");
			out.write("<tr>");
			out.write("<td><input type=\"submit\" value=\"CE\" name=\"operator\"/></td>");
			out.write("<td><input type=\"submit\" value=\"C\" name=\"operator\"/></td>");
			out.write("<td><input type=\"submit\" value=\"BS\" name=\"operator\"/></td>");
			out.write("<td><input type=\"submit\" value=\"/\" name=\"operator\"/></td>");
			out.write("</tr>");
			out.write("<tr>");
			out.write("<td><input type=\"submit\" value=\"7\" name=\"value\"/></td>");
			out.write("<td><input type=\"submit\" value=\"8\" name=\"value\"/></td>");
			out.write("<td><input type=\"submit\" value=\"9\" name=\"value\"/></td>");
			out.write("<td><input type=\"submit\" value=\"*\" name=\"operator\"/></td>");
			out.write("</tr>");
			out.write("<tr>");
			out.write("<td><input type=\"submit\" value=\"4\" name=\"value\"/></td>");
			out.write("<td><input type=\"submit\" value=\"5\" name=\"value\"/></td>");
			out.write("<td><input type=\"submit\" value=\"6\" name=\"value\"/></td>");
			out.write("<td><input type=\"submit\" value=\"-\" name=\"operator\"/></td>");
			out.write("</tr>");
			out.write("<tr>");
			out.write("<td><input type=\"submit\" value=\"1\" name=\"value\"/></td>");
			out.write("<td><input type=\"submit\" value=\"2\" name=\"value\"/></td>");
			out.write("<td><input type=\"submit\" value=\"3\" name=\"value\"/></td>");
			out.write("<td><input type=\"submit\" value=\"+\" name=\"operator\"/></td>");
			out.write("</tr>");
			out.write("<tr>");
			out.write("<td><input type=\"submit\" value=\"±\" name=\"operator\"/></td>");
			out.write("<td><input type=\"submit\" value=\"0\" name=\"value\"/></td>");
			out.write("<td><input type=\"submit\" value=\".\" name=\"dot\"/></td>");
			out.write("<td><input type=\"submit\" value=\"=\" name=\"operator\"/></td>");
			out.write("</tr>");
			out.write("</table>");
						
			out.write("</form>");
				
			out.write("</div>");

			out.write("</body>");
			out.write("</html>");
	 	}
}
