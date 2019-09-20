package org.comstudy21.day22;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame3 extends Frame{
	public MyFrame3(){
		this("no-title", 10, 10, 600, 400);
	}

	public MyFrame3(String title, int x, int y, int w, int h) {
		setTitle(title);
		setBounds(x, y, w, h);
		
		//내부클래스WindowAdapterImpl를 선언하고 WindowAdapter를 통해서 windowClosing을 구현할 수 있다.
		//adapter는 클래스이기 때문에 MyFrame2와 같이 이미 상속받은 경우에는 쓸 수 없다.
		class WindowAdapterImpl extends WindowAdapter{
			@Override
			public void windowClosing(WindowEvent e){
				dispose();
				System.exit(0);
			}
		}
		addWindowListener(new WindowAdapterImpl());
	}
	
	public static void main(String[] args) {
		new MyFrame3().setVisible(true);
	}
}
