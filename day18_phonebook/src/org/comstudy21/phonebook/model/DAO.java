package org.comstudy21.phonebook.model;

import java.util.Arrays;
import java.util.Scanner;

public class DAO {
	// ���Ƿ� ������� �κ�
	// �� �κ��� ���߿� DB�� ���� ���� DB�� ���� �Ǵ� �κ��Դϴ�.
	public static final Scanner scan = new Scanner(System.in);
	private static final int MAX = 100;
	private static DTO[] list = new DTO[MAX];
	private static int squence = 0; // idx�� �ȴ�.
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
			System.out.println("### ���̻� �Է� �Ҽ� �����ϴ�!!");
			return;
		}
		dto.setIdx(squence++);
		list[top++] = dto;
	}
	
	public DTO[] selectAll() {
		if(top <= 0) {
			System.out.println("### ���� �� �����Ͱ� �����ϴ�!!");
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
			System.out.println("### �˻� ����� �����ϴ�!");
			return null;
		}
		arr2 = new DTO[size];
		for(int i=0; i<arr2.length; i++) {
			arr2[i] = arr1[i];
		}
		
		return arr2;
	}
	
	public static DTO modify(DTO dto) {
		System.out.println("-> ���� �׸��� �����ϼ���.");
		System.out.print("1.���� 2.��ȭ��ȣ 3.��� >>> ");
		int select = scan.nextInt();
		scan.nextLine();
		switch(select) {
		case 3 : 
			System.out.print("�� �̸� �Է� >>> ");
			dto.setName(scan.nextLine());
		case 2 : 
			System.out.print("�� ��ȭ��ȣ �Է� >>> ");
			dto.setPhone(scan.nextLine()); 
			break;
		case 1 :
			System.out.print("�� �̸� �Է� >>> ");
			dto.setName(scan.nextLine()); 
			break;
		default : System.out.println("���� ����!");
		}
		return dto;
	}
	
	public static void update(DTO dto) {
		for(int i=0; i<top; i++) {
			if(dto.getIdx() == list[i].getIdx()) {
				list[i] = dto;
				System.out.println("### ���� �Ǿ����ϴ�.");
				return;
			}
		}
		System.out.println("### ���� ���� �ʾҴ�!");
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
				System.out.println("### ���� �Ϸ�!");
				top--;
				break;
			}
		}
	}
}
