package com.makun.web.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
@WebFilter("/*")
public class CharacterEncondingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, 
			ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("before Filter!");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");//송신 인코딩 지정
		response.setContentType("text/html; charset = UTF-8");
		
		chain.doFilter(request, response);
		
		System.out.println("after Filter!");

	}

}
