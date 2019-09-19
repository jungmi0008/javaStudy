package org.comstudy21.phonebook.view;

import static org.comstudy21.phonebook.R.*;

public class Viewer {
	
	public void play(String key) {
		View view = viewMap.get(key);
		//viewMap에서 String값을 가져온다는 소리고
		//viewMap에서 String값이 첫번째 인자로 키값이다. 
		//**get(Object key)하는 것은 value값을 불러온다.**
		// 즉, View view = new Input();해준것과 같다.
		if(view == null) {
			System.out.println("View가 존재 하지 않습니다!");
			return;
		}
		//우리는 R에서 static 초기화를 통해서 viewMap과 cmdMap에 key값을 모두 넣었다.
		view.show(request);
	}
}
