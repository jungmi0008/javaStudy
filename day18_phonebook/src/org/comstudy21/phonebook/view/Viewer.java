package org.comstudy21.phonebook.view;

import static org.comstudy21.phonebook.R.*;

public class Viewer {
	
	private View view;
	
	public void setView(View view) {
		this.view = view;
	}

	public void display() {
		view.show();
	}
}

//display()를 View에서 만들면 되지 않을까 싶지만 Controller에서 display를 부를려면
//View의 인스턴스가 필요한데 View는 인터페이스로 인스턴스를 만들 수 없다.
//R에서 public static final View view = new View(); 오류가 난다.
//그래서 클래스인 Viewer를 만들어주고 그곳에서 View타입의 view인스턴스 멤버를 만든다.
