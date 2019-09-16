package org.comstudy21.phonebook.view;

import static org.comstudy21.phonebook.R.*;

public class Viewer {
	
	private View view;
	
	public void setView(View view) {
		this.view = view;
	}

	public void display() {
		view.show();
		//controller.service();
	}
	
}
