package org.comstudy21.phonebook.view;

import java.util.HashMap;

import org.comstudy21.phonebook.model.PhonebookDto;
import static org.comstudy21.phonebook.R.*;

public class Input implements View {

	@Override
	public void show(HashMap<String, Object> request) {
		System.out.println("::: INPUT :::");
		// 입력 받아서 R의 request에 "inputDto"로 저장한다.
		PhonebookDto dto = new PhonebookDto();
		System.out.print("성명 입력 >>> ");
		dto.setName(scan.next());
		System.out.print("전화번호 입력 >>> ");
		dto.setPhone(scan.next());
		
		request.put("inputDto", dto);
	}

}
