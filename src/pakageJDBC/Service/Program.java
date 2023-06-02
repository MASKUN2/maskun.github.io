package pakageJDBC.Service;

import java.sql.SQLException;
import java.util.List;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		NoticeService service = new NoticeService();
		List<Notice> list = service.getList();
		System.out.println(list.get(0).getTitle() + list.size());
	}

}
