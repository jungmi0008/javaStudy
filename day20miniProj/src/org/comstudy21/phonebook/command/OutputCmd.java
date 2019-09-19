package org.comstudy21.phonebook.command;

import static org.comstudy21.phonebook.R.dao;
import java.util.HashMap;

import org.comstudy21.phonebook.model.PhonebookDto;

public class OutputCmd implements Command {

	@Override
	public String action(HashMap<String, Object> request) {
		System.out.println("### OutputCmd ###");
		// view 실행 전에 dao에서 목록을 가져온다.
		PhonebookDto[] arr = dao.selectAll();
		// 가져온 목록을 request에 저장한다.
		request.put("dtoArr", arr);
		// View 실행
		return OUTPUT;
	}

}
