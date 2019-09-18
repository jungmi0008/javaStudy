package org.comstudy21.phonebook.view;

import static org.comstudy21.phonebook.R.*;

public class Viewer {
	
	public void play(String key) {
		View view = viewMap.get(key);
		if(view == null) {
			System.out.println("View가 존재 하지 않습니다!");
			return;
		}
		view.show(request);
	}
	
}
