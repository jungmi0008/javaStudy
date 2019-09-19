package org.comstudy21.phonebook.model;

import java.util.ArrayList;

public class PhonebookDao {
	private ArrayList<PhonebookDto> list = new ArrayList<>();
	private int squence = 0;
	
	public void insert(PhonebookDto dto) {
		dto.setIdx(squence++);
		list.add(dto);
		
		System.out.println(list);
	}

	public PhonebookDto[] selectAll() {
		PhonebookDto[] arr = new PhonebookDto[list.size()];
		list.toArray(arr);	//복사본을 만들어준다.
		return arr;
	}
	
	
}
