package pakageJDBC.Service;

import java.sql.SQLException;
import java.util.List;

public class B01Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		A01ConsoleUI ui = new A01ConsoleUI();
		boolean loopChk = true;
		int page = 1; //페이지
		
		
		while (loopChk) {
			
			ui.showMain(page);
			
			switch (ui.slctOrder()) {
				case 1: {//이전페이지
					page = ui.prvPage(page);
					break;
				}
				case 2: {//다음페이지
					page = ui.nxtPage(page);
					break;
				}
				case 3: {//글쓰기
					ui.write();
					break;
				}
				case 4: {//검색
					break;
				}
				case 5: {//종료
					ui.exitPrg();
					loopChk = false;
					break;
				}      
				default: 
					ui.ShowErr();
				
			}
		
		}
	}

}
