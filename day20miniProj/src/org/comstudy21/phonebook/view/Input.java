package org.comstudy21.phonebook.view;

import java.util.HashMap;

import org.comstudy21.phonebook.model.PhonebookDto;
import static org.comstudy21.phonebook.R.*;

public class Input implements View {

	@Override
	public void show(HashMap<String, Object> request) {
		System.out.println("::: INPUT :::");
		// �Է� �޾Ƽ� R�� request�� "inputDto"�� �����Ѵ�.
		PhonebookDto dto = new PhonebookDto();
		System.out.print("���� �Է� >>> ");
		dto.setName(scan.next());
		System.out.print("��ȭ��ȣ �Է� >>> ");
		dto.setPhone(scan.next());
		
		request.put("inputDto", dto);
	}

}
