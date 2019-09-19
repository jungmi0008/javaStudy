package org.comstudy21.phonebook.controller;

import static org.comstudy21.phonebook.R.*;	//static������� �������� ������ import�� �� static�̶�� ����Ѵ�.
import org.comstudy21.phonebook.command.Command;

public class PhonebookController {
	
	public void service() {
		if(request.get("menuKey") == null) {
			viewer.play(MENU);
		}
		
		String menuKey = (String)request.get("menuKey");	//Menu���� put�� menuStr[no]�� �޾ƿ´�.
		Command cmd = cmdMap.get(menuKey);	//�̸� cmdMap���� �����´�.
		if(INPUT.equals(menuKey)) {			//�޴�Ű�� �ش��ϴ� play�� �����Ѵ�.
			viewer.play(INPUT);		//�Է��� �޴´�.
			cmd.action(request);	//���� ���� insert�Ѵ�.
		} else if(OUTPUT.equals(menuKey)) {	
			viewer.play(cmd.action(request));	//selectAll �ϰ�  ����Ѵ�.
		} else {
			viewer.play(cmd.action(request));
		}
		
		// input�̸� cmd�� �ٽ� ���� �ϰ� menu�� ����.
		
		request.put("menuKey", null);	//���½�Ű�� ���񽺸� �θ���.
		System.out.println("-------------------------");
		service();
	}
	
}
