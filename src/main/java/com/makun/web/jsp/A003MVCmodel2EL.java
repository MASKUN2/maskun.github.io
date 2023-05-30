package com.makun.web.jsp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/A003MVCmodel2EL")
public class A003MVCmodel2EL extends HttpServlet {
// 컨트롤러(+ 디스패처)
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = 0;	
		String model;
		String num_ = request.getParameter("n");
		if(num_ != null && !num_.equals("")){
			num = Integer.parseInt(num_);
		}
		
		if(num %2 == 0){
			model = "짝수";
		}else{
			model = "홀수";
		}	
		
		String[] names = {"철수" , "영희"};
		Map<String, Object> notice = new HashMap<>();
		notice.put("id", 1);
		notice.put("title", "좋아요");
		
		request.setAttribute("model", model);	
		request.setAttribute("names", names);	
		request.setAttribute("notice", notice);	
		
		//redirect : 보내는 행위에 이어지는 소스가 없음: 새 요청
		//forward : 있음
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/A003MVCmodel2EL.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
