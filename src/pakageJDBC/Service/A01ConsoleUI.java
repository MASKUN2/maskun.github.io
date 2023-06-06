package pakageJDBC.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class A01ConsoleUI {
	private int windowSize = 10;
	private String column = "ID";
	private String keyword = "*";
	
	public void showMain(int page) throws ClassNotFoundException, SQLException {
		int pagePrsnt = page;
		int windSz = windowSize;
		int lastPage;
		int lastId;
		
		List<C02Notice> list = new ArrayList<>();
		
		C01Service srv = new C01Service();
		list = srv.getList(windSz, pagePrsnt);
		lastId = srv.getLastId();
		lastPage = (lastId % windSz == 0 )? (lastId / windSz) : (lastId/ windSz + 1);
	    
		System.out.printf("page : %d / %d", pagePrsnt , lastPage);
		System.out.println("    [공지사항 게시판] \n ID  제목   작성자   날짜    내용 조회수 파일");
		for (C02Notice rs : list) {
	
			int id = rs.getId();
			String title = rs.getTitle();
			String writerId = rs.getWriterId();
			Date regData =  rs.getRegData();
			String content = rs.getContent();
			int hit = rs.getHit();
			String files = rs.getFiles();
			System.out.printf(" %d %s %s %s %s %d %s \n", id, title, writerId, regData, content, hit, files);
		
		
		}
	}

	public int slctOrder() {
		int orderIndx = 0;
		System.out.println("        [명령번호 입력] \n 1이전 2다음 3글쓰기 4검색 5종료\n");
		Scanner scn = new Scanner(System.in);
		orderIndx = scn.nextInt();
		
		return orderIndx;
	}


	public int prvPage(int page) {
		int pagePrsnt = page;

		if (pagePrsnt == 1) {
			System.out.println("이전 페이지가 없습니다.");
			return pagePrsnt;
		}else {
			return (pagePrsnt-1);
		}
		
	}

	public int nxtPage(int page) throws ClassNotFoundException, SQLException {
		int pagePrsnt = page;
		int windSz = windowSize;
		C01Service srv = new C01Service();
		int lastId = srv.getLastId();
		
		int lastPage = (lastId % windSz == 0 )? (lastId / windSz) : (lastId/ windSz + 1);
		
		if (pagePrsnt == lastPage) {
			System.out.println("다음페이지가 없습니다.");
			return pagePrsnt;
		}else {
			return (pagePrsnt+1);
		}
		
		
		
	}
	public void exitPrg() {
		System.out.println("Shutdown Program");
		
	}
	
	public void ShowErr() {
		System.out.println("Wrong Order");
		
	}

	public void write() throws ClassNotFoundException, SQLException {
		Scanner scn = new Scanner(System.in);
		System.out.println(" [글쓰기] \n 제목을 입력해주세요.");
		String title = scn.nextLine();
		System.out.println(" 작성자를 입력해주세요.");
		String writerId = scn.nextLine();
		System.out.println(" 내용을 입력해주세요.");
		String content= scn.nextLine();
		System.out.println(" 첨부파일을 입력해주세요.");
		String files= scn.nextLine();
		
		C02Notice ntc = new C02Notice();
		ntc.setTitle(title);
		ntc.setWriterId(writerId);
		ntc.setContent(content);
		ntc.setFiles(files);
		
		C01Service srv = new C01Service();
		srv.insert(ntc);
		System.out.println("글쓰기가 완료되었습니다.");
	}

}
