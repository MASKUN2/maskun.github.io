package com.makun.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/notice-reg") // 만약 web.xml 에 metadata-complete 설정이 없다면 자동으로 false로 인식: https://blog.naver.com/PostView.nhn?isHttpsRedirect=true&blogId=woosuk288&logNo=220282261776&parentCategoryNo=&categoryNo=19&viewDate=&isShowPopularPosts=false&from=postView
public class NoticeReg extends HttpServlet{
	@Override

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//송신 인코딩 지정
		response.setContentType("text/html; charset = UTF-8"); //수신 문서확장자, 인코딩 지정
		//request.setCharacterEncoding("UTF-8"); // post를 송신받을 때 한글은 인코딩해서 읽어야함, 필터로 대체가능
		PrintWriter out = response.getWriter(); // 
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		out.println(title);
		out.println(content);
		
	} 
}
