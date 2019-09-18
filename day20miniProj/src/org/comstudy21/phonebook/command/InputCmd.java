package org.comstudy21.phonebook.command;

import java.util.HashMap;

import org.comstudy21.phonebook.model.PhonebookDto;
import static org.comstudy21.phonebook.R.*;

public class InputCmd implements Command {

	@Override
	public String action(HashMap<String, Object> request) {
		System.out.println("### InputCmd ###");
		// System.out.println((String)request.get("inputChk"));
		// �� �Է� �� ����
		// �䰡 ���� �� �Ŀ��� Dao�� ȣ���ϰ� ���������� view�� ���� �ϵ��� �����Ѵ�.
		System.out.println("### View ���� �� ...");
		// --- Dao�� �Է� �� �����͸� �߰��Ѵ�.
		if (request.get("inputDto") != null) {
			// reqquest�� value�� Object Ÿ���̹Ƿ� ��� �Ҷ��� �ٿ�ĳ���� �ʿ�.
			PhonebookDto dto = (PhonebookDto) request.get("inputDto");
			dao.insert(dto);
			System.out.println("### ������ �Է� �Ϸ�!");
		}

		request.put("inputChk", null);

		return null;
	}

}
