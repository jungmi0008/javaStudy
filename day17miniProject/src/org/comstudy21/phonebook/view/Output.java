package org.comstudy21.phonebook.view;

import org.comstudy21.phonebook.model.*;

public class Output  implements View {

	@Override
	public void show() {
		System.out.println("::: Output :::");
		if(resource.dtoList == null) {
			System.out.println("출력 내용이 없습니다!");
			return;
		}
		
		DTO[] list = resource.dtoList;
		
		for(DTO dto : list) {
			System.out.println(dto);
		}
		
		//resource.menuNo = 0;
	}

}
