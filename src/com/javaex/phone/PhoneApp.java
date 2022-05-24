package com.javaex.phone;

import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) {
		System.out.println("***********************************************************");
		System.out.println("*                      전화번호 관리 프로그램                   *");
		System.out.println("***********************************************************");
		Scanner sc = new Scanner(System.in);
		while(true) {
			//메뉴
			System.out.println("");
			System.out.println("1.리스트     2.등록     3.수정     4.삭제     5.검색     6.종료");
			System.out.println("--------------------------------------------------------");
			
			PhoneDao phoneDao = new PhoneDao();
			System.out.print(">메뉴번호: ");
			int number = sc.nextInt();
			
			switch(number) {
			case 1: number = 1; //리스트 출력
			
			List<PersonVo> fullList = phoneDao.personSelect();
			
			for(int i=0; i<fullList.size(); i++) {
				PersonVo personVo = fullList.get(i);
				System.out.println(personVo.getPersonId() + ", " + 
							       personVo.getName() + ", " +
								   personVo.getHp() + ", " +
							       personVo.getCompany());
			}
			
			
				break;
				
			case 2: number = 2; //등록
				System.out.println("<2.등록>");
				
				System.out.print("이름 > ");
				String name = sc.next();
				System.out.print("휴대전화 > ");
				String hp = sc.next();
				System.out.print("회사번호 > ");
				String company = sc.next();
				
				
				PersonVo person = new PersonVo(name, hp, company); //스캐너로 입력받은 값 p01에 담기
				
				phoneDao.personInsert(person); //PhoneDao에 있는 입력메서드에 person을 담고 사용
				
		
				break;
				
			case 3: number = 3; //수정
				System.out.println("수정");
				break;
				
			case 4: number = 4; //삭제
				System.out.println("삭제");
				break;
				
			case 5: number = 5; //검색
				System.out.println("검색");	
				break;
				
			case 6: number = 6; //종료
				System.out.println("");
				System.out.println("******************************************");
				System.out.println("*                 감사합니다                *");
				System.out.println("******************************************");
				break;
			
			default:
				System.out.println("[다시 입력해 주세요.]");
			break;
			}
			if(number == 6) {
				break;
			}
			else {
				continue;
			}
			
			

			
			
		}
		
		
		
		sc.close();	
	}

}
