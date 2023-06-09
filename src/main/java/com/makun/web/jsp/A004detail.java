package com.makun.web.jsp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/notice/detail")
public class A004detail extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("ID"));
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM NOTICE WHERE ID = ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "MASKUN", "0000");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			rs.next();
			
			String title = rs.getString("TITLE");
			Date regdate = rs.getDate("REGDATE");
			String writer_id = rs.getString("WRITER_ID");
			int hit = rs.getInt("HIT");
			String files = rs.getString("FILES");
			String content = rs.getString("content");
			
			request.setAttribute("title", title);
			request.setAttribute("regdate", regdate);
			request.setAttribute("writer_id" , writer_id);
			request.setAttribute("hit",hit );
			request.setAttribute("files",files );
			request.setAttribute("content",content );
			
			
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
		}
			request.getRequestDispatcher("/notice/detail.jsp").forward(request, response);
	}

}
