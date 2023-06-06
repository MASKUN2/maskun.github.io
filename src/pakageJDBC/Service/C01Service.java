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

public class C01Service {
	private String url ="jdbc:oracle:thin:@localhost:1521/xepdb1";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String uid = "MASKUN";
	private String pw = "0000";
	
	public List<C02Notice> getList(int windowSize, int pagePrsnt) throws ClassNotFoundException, SQLException {
	
		Connection con = DriverManager.getConnection(url, uid, pw);
		Class.forName(driver);
		
		String sql = "SELECT * From notice_view where num between ? and ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, (pagePrsnt * windowSize - (windowSize - pagePrsnt)));
		st.setInt(2, (pagePrsnt * windowSize));
		
		ResultSet rs = st.executeQuery();
		
		List<C02Notice> list = new ArrayList<>();
		
		while(rs.next()) {
		
			int id = rs.getInt("ID");
			String title = rs.getString("title");
			String writerId = rs.getString("writer_id");
			Date regData =  rs.getDate("regdate");
			String content = rs.getString("content");
			int hit = rs.getInt("hit");
			String files = rs.getString("files");
			
			C02Notice notice = new C02Notice(id,title,writerId,regData,content,hit,files);
			
			list.add(notice);
		
	
		}
		rs.close();
		st.close();
		con.close();
		
		
		return list;
		
	
	}
	
	public int insert(C02Notice notice) throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pw);

		String title = notice.getTitle();
		String writerId = notice.getWriterId();
		String content = notice.getContent();
		String files = notice.getFiles();
		
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
	public int update(C02Notice notice) throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pw);
		
		String title = notice.getTitle();
		String writerId = notice.getWriterId();
		String content = notice.getContent();
		String files = notice.getFiles();
		int id = notice.getId();
		
		String sql = "UPDATE notice SET"
				+ "    TITLE =?,"
				+ "    WRITER_ID = ?,"
				+ "    CONTENT = ?,"
				+ "    FILES =?"
				+ "WHERE ID = ?";
		
		
		//Statement st = con.createStatement();
		PreparedStatement st = con.prepareStatement(sql); // 여기서 쿼리문을 받음
		st.setString(1, title); // ? 에 넣기
		st.setString(2, writerId);
		st.setString(3, content);
		st.setString(4, files);
		st.setInt(5, id);
		
		int result = st.executeUpdate(); // 샐럭트가 아니기 때문에 작동여부만 판단가능
		System.out.println(result);
		
		st.close();
		con.close();
		return result;
		
	}
	public int delete(int index) throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pw);
		
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
	public int getLastId() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pw);
		
		String sql = "SELECT COUNT (ID) AS LAST FROM notice_view";
		
		Statement st = con.createStatement(); 
		ResultSet rs = st.executeQuery(sql); 
		
		rs.next();
		int result = rs.getInt("LAST");
		
		rs.close();
		st.close();
		con.close();
		
		return result;
	
		
	}

}
	


