package com.makun.web.jsp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/notice/list")
public class A004list extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM NOTICE";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "MASKUN", "0000");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			List<A005notice> list = new ArrayList<>();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("TITLE");
				Date regdate = rs.getDate("REGDATE");
				String writer_id = rs.getString("WRITER_ID");
				int hit = rs.getInt("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("content");
	
				A005notice notice = new A005notice(id, title, regdate, writer_id, hit, files, content);
				
				list.add(notice);
				
			}
			request.setAttribute("list", list);
			
			rs.close();
			st.close();
			con.close();
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
		}
		
		request.getRequestDispatcher("/notice/list.jsp").forward(request, response);
		



	}
}
