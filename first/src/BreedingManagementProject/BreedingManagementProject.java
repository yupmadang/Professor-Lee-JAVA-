package BreedingManagementProject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BreedingManagementProject {
	
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		BreedingMode mode = new BreedingMode(); //BreedingMode 참조자료형인 mode이름의 인스턴스 생성
		
		int menu;
		do {
			try {
				System.out.println("Breeding Management Project입니다");
				System.out.println("(1)개체목록 추가 (2)개체목록 제거 (3)개체목록 편집 (4)개체목록 출력 (5)종료");
				System.out.print("메뉴를 입력해 주십시오 : "); menu = stdin.nextInt();
				switch(menu) {
				
				case 1://개체 추가
					do{//개체를 사용자가 원하는 만큼 입력이 가능하도록 반복문 사용
						System.out.println("1, Add Insect");
						System.out.print("개체 코드 : ");int category = stdin.nextInt();
						System.out.print("이름을 입력 : "); String insect = stdin.next();
						System.out.print("무게 입력 : "); double weight = stdin.nextDouble();
						System.out.print("톱밥종류 입력 : "); String stock = stdin.next();
						mode.Add_Insect(category, insect, weight, stock);
						System.out.println();
						System.out.print("추가를 종료하시겠습니까? (0(종료)/1(반복)): "); int a = stdin.nextInt();
						
						if(a == 0) {
							break;
						}
						else if(a == 1) {
							continue;
						}
						
						else {
							System.out.println("유효하지 않은 입력입니다.");
						}
					}while(true);
					break;
					
				case 2://개체 제거
					System.out.println("2, Delete Insect"); 
				    System.out.print("삭제할 유형을 선택 (0 : 전체삭제 / 1 : 선택삭제) : "); int num = stdin.nextInt();
				    if(num == 1) {
				    	System.out.print("삭제할 개체 번호 : "); int num2 = stdin.nextInt();
				    	mode.Delete_Insect(num2);//특정 개체를 삭제하기 위해 Delete_Insect(num2)메서드 사용
				    }
				    else if(num == 0) {
				    	mode.Info_Name.clear();//리스트의 값을 모드 제거하는 메서드clear()호출
				    }
					System.out.println();
					break;
					
				case 3://개체 편집
					System.out.println("3, Edit Insect");
					System.out.print("변경할 개체 번호 : "); int num1 = stdin.nextInt();//개체를 구분하기 위한 아이디 입력
					System.out.print("무게 : "); double num2 = stdin.nextDouble();//그 개체의 변경할 무게 입력
					System.out.print("교체 횟수 : "); int num3 = stdin.nextInt();//개체 먹이 교체 횟수 변경
					mode.Edit_Insect(num1, num2, num3);//Edit_Insect(num1, num2, num3)메서드 호출
					System.out.println();
					break;
					
				case 4://개체 출력
					System.out.println("4, View Insect");
					mode.ShowAll_Insect();//ShowAll_Insect()메서드 호출
					System.out.println();
					break;
				}
			
				if(menu > 5 || menu < 1) {//모드의 값이 범위를 벗어난 경우
					System.out.println("지원하지 않는 모드입니다.");
				}
				
				if(menu == 5) {//프로그램 종료
					System.out.println("프로젝트를 종료합니다.");
					System.out.println();
					break;
				}
			}catch(InputMismatchException e) {//입력의 자료형과 변수의 자료형이 다를 경우 예외처리
				System.out.println("유효하지 않은 입력입니다. 프로젝트를 종료합니다.");
				break;
			}
		}while(true);
		
		stdin.close(); //스트림 닫기
	}
}