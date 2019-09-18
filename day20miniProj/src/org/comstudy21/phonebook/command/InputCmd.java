package org.comstudy21.phonebook.command;

import java.util.HashMap;

import org.comstudy21.phonebook.model.PhonebookDto;
import static org.comstudy21.phonebook.R.*;

public class InputCmd implements Command {

	@Override
	public String action(HashMap<String, Object> request) {
		System.out.println("### InputCmd ###");
		// System.out.println((String)request.get("inputChk"));
		// 뷰 입력 후 실행
		// 뷰가 실행 된 후에는 Dao를 호출하고 실행전에는 view를 실행 하도록 제어한다.
		System.out.println("### View 실행 후 ...");
		// --- Dao에 입력 된 데이터를 추가한다.
		if (request.get("inputDto") != null) {
			// reqquest의 value는 Object 타입이므로 사용 할때는 다운캐스팅 필요.
			PhonebookDto dto = (PhonebookDto) request.get("inputDto");
			dao.insert(dto);
			System.out.println("### 데이터 입력 완료!");
		}

		request.put("inputChk", null);

		return null;
	}

}
