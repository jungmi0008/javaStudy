package org.comstudy21.phonebook.view;

import org.comstudy21.phonebook.model.*;

public class Delete implements View{
	public static int i = 0;
	public DTO dto;
	@Override
	public void show() {
		System.out.println("::: DELETE :::");
		System.out.print("������ ���� �Է� >>> ");
		
		String name = null;
		
		resource.scan.nextLine();
		name = resource.scan.nextLine();
		
		dto = new DTO(0,name,null);
		
		System.out.print("1.delete 2.cancel >>>");
		i = resource.scan.nextInt();
		resource.menuNo = 0;
	}
}
