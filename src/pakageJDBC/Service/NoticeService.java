package pakageJDBC.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoticeService {
	
	public List<Notice> getList() throws ClassNotFoundException, SQLException {
	
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM NOTICE";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "MASKUN", "0000");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		List<Notice> list = new ArrayList<>();
		
		while(rs.next()) {
		
		int id = rs.getInt("ID");
		String title = rs.getString("title");
		String writerId = rs.getString("writer_id");
		Date regData =  rs.getDate("regdate");
		String content = rs.getString("content");
		int hit = rs.getInt("hit");
		
		Notice notice = new Notice(id,title,writerId,regData,content,hit);
		
		list.add(notice);
		
	
		}
		rs.close();
		st.close();
		con.close();
		
		
		return list;
		
	
	}
	public int insert(Notice notice) throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "MASKUN", "0000");

		String title = notice.getTitle();
		String writerId = notice.getWriterId();
		String content = notice.getContent();
		String files = notice.getGetFiles();
		
		String sql = "INSERT INTO NOTICE ("
				+ " TITLE,"
				+ " writer_id,"
				+ " content,"
				+ " files"
				+ ") VALUES (?,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql); // 여기서 쿼리문을 받음
		st.setString(1, title); // ? 에 넣기
		st.setString(2, writerId);
		st.setString(3, content);
		st.setString(4, files);
		
		int result = st.executeUpdate(); // 샐럭트가 아니기 때문에 작동여부만 판단가능
		System.out.println(result);
		
		st.close();
		con.close();
		return result;
		
	}
	public int update(Notice notice) throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "MASKUN", "0000");
		
		String title = notice.getTitle();
		String writerId = notice.getWriterId();
		String content = notice.getContent();
		int id = notice.getId();
		
		String sql = "UPDATE notice SET"
				+ "    TITLE =?,"
				+ "    CONTENT = ?,"
				+ "    FILES =?"
				+ "WHERE ID = ?";
		
		
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
		return result;
		
	}
	public int delete(int index) throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "MASKUN", "0000");
		
		int id = index;
		
		String sql = "DELETE NOTICE WHERE ID = ?";
		
		//Statement st = con.createStatement();
		PreparedStatement st = con.prepareStatement(sql); // 여기서 쿼리문을 받음
		st.setInt(1, id);
		
		int result = st.executeUpdate(); // 샐럭트가 아니기 때문에 작동여부만 판단가능
		System.out.println(result);
		
		st.close();
		con.close();
		return result;
		
	}

}
	


