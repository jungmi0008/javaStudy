package org.comstudy21.phonebook.command;

import static org.comstudy21.phonebook.R.dao;
import java.util.HashMap;

import org.comstudy21.phonebook.model.PhonebookDto;

public class OutputCmd implements Command {

	@Override
	public String action(HashMap<String, Object> request) {
		System.out.println("### OutputCmd ###");
		// view ���� ���� dao���� ����� �����´�.
		PhonebookDto[] arr = dao.selectAll();
		// ������ ����� request�� �����Ѵ�.
		request.put("dtoArr", arr);
		// View ����
		return OUTPUT;
	}

}
