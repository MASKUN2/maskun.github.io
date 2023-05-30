package com.makun.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello") // 만약 web.xml 에 metadata-complete 설정이 없다면 자동으로 false로 인식: https://blog.naver.com/PostView.nhn?isHttpsRedirect=true&blogId=woosuk288&logNo=220282261776&parentCategoryNo=&categoryNo=19&viewDate=&isShowPopularPosts=false&from=postView
public class Mumu extends HttpServlet{
	@Override

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//송신 인코딩 지정
		response.setContentType("text/html; charset = UTF-8"); //수신 문서확장자, 인코딩 지정
			
		PrintWriter out = response.getWriter(); // 
		for(int i=0; i<2;i++) {
		out.println("한글<br>");
		}
		//기본적인 웹 요청은 문서 GET임, 이 때 쿼리 스트링을 함께 전달가능
		// /hello?cnt=3  :  이 페이지에 cnt 변수에 3으로 쿼리
		int cnt = 0;
//		cnt = Integer.parseInt(request.getParameter("cnt"));
//		for(int j=0; j<cnt;j++) {
//			out.println("cnt 쿼리스트링만큼 출력<br>");
//		
//		}
		
		//쿼리스트링이 없거나 미완성의 경우 기본값 사용하기
		String temp = request.getParameter("cnt");
		if (temp != null &  !temp.equals("")) {
			
			cnt = Integer.parseInt(temp);
	
			for(int j=0; j<cnt;j++) {
			out.println("cnt 쿼리스트링만큼 출력(예외처리)<br>");
			}
		}
		
	}
}
