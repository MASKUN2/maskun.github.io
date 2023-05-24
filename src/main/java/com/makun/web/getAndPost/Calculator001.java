package com.makun.web.getAndPost;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
// get, post 요청에 따른 전문화
@WebServlet("/calculator001")
public class Calculator001 extends HttpServlet {
 @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 if(request.getMethod().equals("GET")) {
			 System.out.println("GET");
		 }
		 else if (request.getMethod().equals("POST")) {
			 System.out.println("POST");
			
		 }
		 
		 super.service(request,response); // 겟,포스트 요청에 따른 do 함수 호출
		 //405 에러 : URL is exist. but its method is not exist.
		 }
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 System.out.println("POST");
			
		}
}
