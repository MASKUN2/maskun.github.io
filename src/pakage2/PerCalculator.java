package pakage2;

import java.text.DecimalFormat;
import java.util.Scanner;

public class PerCalculator {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DecimalFormat Form = new DecimalFormat("###,###,####,###");
		DecimalFormat Form2 = new DecimalFormat("###,###,####,###.###");
		//숫자 자릿수 변환 https://jamesdreaming.tistory.com/203
		Boolean LoopCheck = true;
		int Menu ;
		
		int SharePrice = 0;
		int Earning = 0;
		int OutstandingShare = 0 ;
		double Eps = 0;
		double Per = 0;
		
		while (LoopCheck) {
			System.out.println("PER 계산기입니다. 번호를 입력하세요");
			System.out.println("1. 주당시장가격 입력");
			System.out.println("2. 주당 순이익 입력");
			System.out.println("3. 계산결과 확인");
			System.out.println("4. 종료");
			Menu = sc.nextInt();
			
			switch (Menu) {
			case 1: {
				System.out.println("1. 주당시장가격 입력");
				System.out.println("현재주가를 입력해주세요(단위: 원)");
				SharePrice = sc.nextInt();
				System.out.println(Form.format(SharePrice));
				System.out.printf("입력된 값은 %s 원입니다. %n%n", Form.format(SharePrice));
				break;
			}
			
			case 2: {
				System.out.println("2. 주당 순이익 입력");
				System.out.println("당기순이익을 입력해주세요(단위: 원)");
				Earning = sc.nextInt();
				System.out.printf("입력된 값은 %s 원입니다. %n%n", Form.format(Earning));
				
				System.out.println("유통주식수를 입력해주세요(단위: 원)");
				OutstandingShare = sc.nextInt();
				System.out.printf("입력된 값은 %s 입니다. %n%n",Form.format(OutstandingShare));
				Eps = Earning / (double)OutstandingShare;
				System.out.printf("계산된 주당 순이익은 %s 원 입니다. %n %n", Form2.format(Eps));
								
				break;
			}
			case 3: {
				Per = SharePrice / Eps;
				System.out.println("3. 계산결과 확인");
				System.out.printf("PER은 %s 배 입니다. %n%n", Form2.format(Per));
				break;
			}
			case 4: {
				System.out.println("잘 가셔요!");
				LoopCheck = false;
				break;
			}
			default: {
				System.out.println("Wrong input \n");
			}
				
			}
			
			

			}
			
		}
	
		

	}


