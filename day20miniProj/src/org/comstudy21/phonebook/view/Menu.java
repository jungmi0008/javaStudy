package org.comstudy21.phonebook.view;

import java.util.HashMap;

import static org.comstudy21.phonebook.R.*;

public class Menu implements View {
	
	@Override
	public void show(HashMap<String, Object> request) {
		System.out.println("::: MENU :::");
		for(int i=1; i<menuStr.length; i++) {
			System.out.print(i+"." + menuStr[i]+ " ");
		}
		System.out.println();
		System.out.print("Choice>>> ");
		int no = scan.nextInt();
		while (no < 1 || no > menuStr.length-1) {
			System.out.printf("%d~%d사이 값만 입력 하세요.\n", 1, menuStr.length);
			System.out.print("Choice>>> ");
			no = scan.nextInt();
		}
		// 1~3사이의 값만 no에 들어왔다
		// menuStr배열에서 key를 가져와서 request에 저장 해 둔다.
		request.put("menuKey", menuStr[no]);
	}

}
