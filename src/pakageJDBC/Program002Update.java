package pakageJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

import oracle.jdbc.oracore.Util;

public class Program002Update {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String title = "test4";
		String writerId = "명정";
		String content = "hah";
		int id = 3;
		
		String sql = "UPDATE notice SET"
				+ "    TITLE =?,"
				+ "    CONTENT = ?,"
				+ "    FILES =?"
				+ "WHERE ID = ?";
		
		Connection con = DriverManager.getConnection(url, "MASKUN", "0000");
		//Statement st = con.createStatement();
		PreparedStatement st = con.prepareStatement(sql); // 여기서 쿼리문을 받음
		st.setString(1, title); // ? 에 넣기
		st.setString(2, writerId);
		st.setString(3, content);
		st.setInt(4, id);
		
		int result = st.executeUpdate(); // 샐럭트가 아니기 때문에 작동여부만 판단가능
		System.out.println(result);
		
		st.close();
		con.close();
		
		

	}

}
