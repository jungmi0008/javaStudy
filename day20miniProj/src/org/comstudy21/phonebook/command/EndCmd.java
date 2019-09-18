package org.comstudy21.phonebook.command;

import java.util.HashMap;

public class EndCmd implements Command {

	@Override
	public String action(HashMap<String, Object> request) {
		System.out.println("### EndCmd ###");
		
		return END;
	}

}
