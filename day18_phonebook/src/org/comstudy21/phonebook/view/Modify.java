package org.comstudy21.phonebook.view;

import org.comstudy21.phonebook.model.*;

public class Modify implements View{
	public String name;
	public DTO dto;
	
	@Override
	public void show() {
		System.out.println("::: MODIFY :::");
		System.out.print("������ ���� �Է� >>> ");
		
		String name = null;
		
		resource.scan.nextLine();
		name = resource.scan.nextLine();
		
		dto = new DTO(0,name,null);
		resource.menuNo = 0;
	}
}