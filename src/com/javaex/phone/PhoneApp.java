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
				String name2 = sc.next();
				System.out.print("휴대전화 > ");
				String hp2 = sc.next();
				System.out.print("회사번호 > ");
				String company2 = sc.next();
				
				
				PersonVo person = new PersonVo(name2, hp2, company2); //스캐너로 입력받은 값 person에 담기
				
				phoneDao.personInsert(person); //PhoneDao에 있는 입력메서드에 person을 담고 사용
				
		
				break;
				
			case 3: number = 3; //수정
				System.out.println("<3.수정>");
				System.out.print("번호 > ");
				int num3 = sc.nextInt();
				System.out.print("이름 > ");
				String name3 = sc.next();
				System.out.print("휴대전화 > ");
				String hp3 = sc.next();
				System.out.print("회사번호 > ");
				String company3 = sc.next();
				
				PersonVo person3 = new PersonVo(name3, hp3, company3, num3);
				
				phoneDao.personUpdate(person3);
				break;
				
			case 4: number = 4; //삭제
				System.out.println("<4.삭제>");
				System.out.print(">번호 : ");
				int num4 = sc.nextInt();
				phoneDao.personDelete(num4);
				break;
				
			case 5: number = 5; //검색
			System.out.println();
			System.out.println("<5.검색>");
			System.out.println();
			
			sc.nextLine();
			
			System.out.print("검색어> ");
			String keyword = sc.nextLine();
			
			List<PersonVo> fullList2 = phoneDao.personSelect(keyword);
			
			for(int i = 0; i<fullList2.size(); i++) {
					 
				PersonVo personVo = fullList2.get(i);
				System.out.println(personVo.getPersonId()+" | "+personVo.getName()+" | "+personVo.getHp()+" | "+personVo.getCompany());
				
			}
			
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
