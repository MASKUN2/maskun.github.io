package com.makun.web.jsp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class A003MVCmodel2
 */

// URL 맵핑을 안했더니 자동으로 XML에서 클래스명으로 맵핑을 해버려서 나중에 어노테이션 추가했을 때 URL 오류 중복 발생.


@WebServlet("/A003MVCmodel2")
public class A003MVCmodel2 extends HttpServlet {
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
		request.setAttribute("model", model);	
		
		//redirect : 보내는 행위에 이어지는 소스가 없음: 새 요청
		//forward : 있음
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/A003MVCmodel2.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
