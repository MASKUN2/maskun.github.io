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
			ServletResponse reponse, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("before Filter!");
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, reponse);
		System.out.println("after Filter!");

	}

}
