package org.comstudy21.phonebook.model;

import java.util.Arrays;
import java.util.Scanner;

public class DAO {
	// 임의로 만들어진 부분
	// 이 부분은 나중에 DB를 배우고 나서 DB에 저장 되는 부분입니다.
	public static final Scanner scan = new Scanner(System.in);
	private static final int MAX = 100;
	private static DTO[] list = new DTO[MAX];
	private static int squence = 0; // idx가 된다.
	private static int top = 0;
	{
		list[top++] = new DTO(squence++, "KIM","010-1111-1111");
		list[top++] = new DTO(squence++, "LEE","010-2222-2222");
		list[top++] = new DTO(squence++, "PARK","010-3333-3333");
		list[top++] = new DTO(squence++, "KANG","010-4444-4444");
	}
	
	
	public void insert(DTO dto) {
		System.out.println("### insert ...");
		if(top >= list.length) {
			System.out.println("### 더이상 입력 할수 없습니다!!");
			return;
		}
		dto.setIdx(squence++);
		list[top++] = dto;
	}
	
	public DTO[] selectAll() {
		if(top <= 0) {
			System.out.println("### 저장 된 데이터가 없습니다!!");
			return null;
		}
		DTO[] dtoList = new DTO[top];
		for(int i=0; i<dtoList.length; i++) {
			dtoList[i] = new DTO();
			dtoList[i].setIdx(list[i].getIdx());
			dtoList[i].setName(list[i].getName());
			dtoList[i].setPhone(list[i].getPhone());
		}
		return dtoList;
	}
	
	public static DTO[] select(DTO dto) {
		DTO[] arr1 = new DTO[top];
		DTO[] arr2 = null;
		int size = 0;
		String sName = dto.getName();
		
		for(int i=0; i<top; i++) {
			if(sName.equals(list[i].getName())) {
				arr1[size] = new DTO();
				arr1[size].setIdx(list[i].getIdx());
				arr1[size].setName(list[i].getName());
				arr1[size].setPhone(list[i].getPhone());
				size++;
			}
		}
		
		if(size <= 0) {
			System.out.println("### 검색 결과가 없습니다!");
			return null;
		}
		arr2 = new DTO[size];
		for(int i=0; i<arr2.length; i++) {
			arr2[i] = arr1[i];
		}
		
		return arr2;
	}
	
	public static DTO modify(DTO dto) {
		System.out.println("-> 수정 항목을 선택하세요.");
		System.out.print("1.성명 2.전화번호 3.모두 >>> ");
		int select = scan.nextInt();
		scan.nextLine();
		switch(select) {
		case 3 : 
			System.out.print("새 이름 입력 >>> ");
			dto.setName(scan.nextLine());
		case 2 : 
			System.out.print("새 전화번호 입력 >>> ");
			dto.setPhone(scan.nextLine()); 
			break;
		case 1 :
			System.out.print("새 이름 입력 >>> ");
			dto.setName(scan.nextLine()); 
			break;
		default : System.out.println("선택 오류!");
		}
		return dto;
	}
	
	public static void update(DTO dto) {
		for(int i=0; i<top; i++) {
			if(dto.getIdx() == list[i].getIdx()) {
				list[i] = dto;
				System.out.println("### 수정 되었습니다.");
				return;
			}
		}
		System.out.println("### 수정 되지 않았다!");
	}

	public static DTO convert(DTO[] dtoList) {
		DTO dto = null;
		for(int i=0; i<dtoList.length; i++) {
			dto = dtoList[i];
		}
		return dto;
	}
	
	public static void delete(DTO dto) {
		for(int i=0; i<top; i++) {
			if(dto.getIdx() == list[i].getIdx()) {
				for(int j=i; j<top-1; j++) {
					list[j] = list[j+1];
				}
				System.out.println("### 삭제 완료!");
				top--;
				break;
			}
		}
	}
}
