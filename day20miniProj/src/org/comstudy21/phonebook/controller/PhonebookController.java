package org.comstudy21.phonebook.controller;

import static org.comstudy21.phonebook.R.*;

import org.comstudy21.phonebook.command.Command;
import org.comstudy21.phonebook.model.PhonebookDto;

public class PhonebookController {
	
	public void service() {
		if(request.get("menuKey") == null) {
			viewer.play(MENU);
		}
		
		String menuKey = (String)request.get("menuKey");
		Command cmd = cmdMap.get(menuKey);
		if(INPUT.equals(menuKey)) {
			viewer.play(INPUT); // 입력 맞치고 돌아옴
			cmd.action(request);
		} else if(OUTPUT.equals(menuKey)) {
			viewer.play(cmd.action(request));
		} else {
			viewer.play(cmd.action(request));
		}
		
		// input이면 cmd를 다시 실행 하고 menu로 간다.
		
		request.put("menuKey", null);
		System.out.println("-------------------------");
		service();
	}
	
}
