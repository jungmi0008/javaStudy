package org.comstudy21.phonebook.view;

import org.comstudy21.phonebook.model.*;

public class Search implements View{
	public DTO dto;

	@Override
	public void show() {
		System.out.println("::: SEARCH :::");
		System.out.print("�˻��� ���� �Է� >>> ");
		
		String name = null;
		
		resource.scan.nextLine();
		name = resource.scan.nextLine();
		
		dto = new DTO(0,name,null);
		resource.menuNo = 0;

	}
}
