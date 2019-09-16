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

//display()�� View���� ����� ���� ������ ������ Controller���� display�� �θ�����
//View�� �ν��Ͻ��� �ʿ��ѵ� View�� �������̽��� �ν��Ͻ��� ���� �� ����.
//R���� public static final View view = new View(); ������ ����.
//�׷��� Ŭ������ Viewer�� ������ְ� �װ����� ViewŸ���� view�ν��Ͻ� ����� �����.
