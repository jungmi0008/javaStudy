package org.comstudy21.phonebook.view;

import static org.comstudy21.phonebook.R.*;

public class Viewer {
	
	public void play(String key) {
		View view = viewMap.get(key);
		//viewMap���� String���� �����´ٴ� �Ҹ���
		//viewMap���� String���� ù��° ���ڷ� Ű���̴�. 
		//**get(Object key)�ϴ� ���� value���� �ҷ��´�.**
		// ��, View view = new Input();���ذͰ� ����.
		if(view == null) {
			System.out.println("View�� ���� ���� �ʽ��ϴ�!");
			return;
		}
		//�츮�� R���� static �ʱ�ȭ�� ���ؼ� viewMap�� cmdMap�� key���� ��� �־���.
		view.show(request);
	}
}
