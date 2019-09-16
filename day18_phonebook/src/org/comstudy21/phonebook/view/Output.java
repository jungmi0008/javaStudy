package org.comstudy21.phonebook.view;

import org.comstudy21.phonebook.model.*;

public class Output  implements View {

	@Override
	public void show() {
		System.out.println("::: Output :::");
		
		DTO[] list = resource.dtoList;
		
		for(DTO dto : list) {
			System.out.println(dto);
		}
		
		resource.menuNo = 0;
	}

}
