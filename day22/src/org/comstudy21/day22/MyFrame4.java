package org.comstudy21.day22;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame4 extends Frame{
	public MyFrame4(){
		this("no-title", 10, 10, 600, 400);
	}

	public MyFrame4(String title, int x, int y, int w, int h) {
		setTitle(title);
		setBounds(x, y, w, h);
		
		//MyFrame3을 익명클래스 형태로 오버라이드 한 경우
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				dispose();
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new MyFrame3().setVisible(true);
	}
}
