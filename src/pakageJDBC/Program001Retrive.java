package pakageJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

import oracle.jdbc.oracore.Util;

public class Program001Retrive {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM NOTICE";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "MASKUN", "0000");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		
		while(rs.next()) {
		
		int id = rs.getInt("ID");
		String title = rs.getString("title");
		String writerid = rs.getString("writer_id");
		Date regData =  rs.getDate("regdate");
		System.out.printf("id: %d title %s regData : %s\n", id, title, regData);
		
		
		
		}
		rs.close();
		st.close();
		con.close();
		
		

	}

}
