package org.comstudy21.phonebook.view;

import java.util.HashMap;

public class End implements View {

	@Override
	public void show(HashMap<String, Object> request) {
		System.out.println("시스템 종료!!!");
		System.exit(0);
	}

}
