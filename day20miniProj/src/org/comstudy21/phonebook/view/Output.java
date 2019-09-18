package org.comstudy21.phonebook.view;

import java.util.HashMap;

import org.comstudy21.phonebook.model.PhonebookDto;

public class Output implements View {

	@Override
	public void show(HashMap<String, Object> request) {
		System.out.println("::: OUTPUT :::");
		if(request.get("dtoArr") != null) {
			PhonebookDto[] arr = (PhonebookDto[])request.get("dtoArr");
			for(PhonebookDto dto : arr) {
				System.out.println(dto);
			}
		}
	}

}
