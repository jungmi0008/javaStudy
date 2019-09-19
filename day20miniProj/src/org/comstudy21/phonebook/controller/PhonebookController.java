package org.comstudy21.phonebook.controller;

import static org.comstudy21.phonebook.R.*;	//static멤버들을 가져오기 때문에 import할 때 static이라고 써야한다.
import org.comstudy21.phonebook.command.Command;

public class PhonebookController {
	
	public void service() {
		if(request.get("menuKey") == null) {
			viewer.play(MENU);
		}
		
		String menuKey = (String)request.get("menuKey");	//Menu에서 put한 menuStr[no]을 받아온다.
		Command cmd = cmdMap.get(menuKey);	//이를 cmdMap에서 가져온다.
		if(INPUT.equals(menuKey)) {			//메뉴키에 해당하는 play를 실행한다.
			viewer.play(INPUT);		//입력을 받는다.
			cmd.action(request);	//받은 것을 insert한다.
		} else if(OUTPUT.equals(menuKey)) {	
			viewer.play(cmd.action(request));	//selectAll 하고  출력한다.
		} else {
			viewer.play(cmd.action(request));
		}
		
		// input이면 cmd를 다시 실행 하고 menu로 간다.
		
		request.put("menuKey", null);	//리셋시키고 서비스를 부른다.
		System.out.println("-------------------------");
		service();
	}
	
}
