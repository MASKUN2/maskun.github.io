package pakage7.UI분리;

public class PerCalculator {
	// 복수 기업의 P/E 계산, 정렬기
	
	public static void main(String[] args) {
		boolean LoopCheck = true;
		
		ConsoleUi console = new ConsoleUi();

		while (LoopCheck) {
			//메뉴선택
			
			switch (console.getMenu()) {
				case 1: {
					//값 입력
					console.inputData();
					break;
				}
				
				case 2: {
					//결과 값 출력
					console.outputCal();
					break;
				}
				case 3: {
					//종료
					console.exit();
					LoopCheck = false;
					break;
				}
		
				default: {
					//잘못된 메뉴 입력
					console.wrong();
				}
		
			}
		}
	}
	

}


