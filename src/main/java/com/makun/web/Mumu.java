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
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("hello!");
	}
}
