package org.comstudy21.day22;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame5 extends Frame{
	public MyFrame5() {
		this("no-title", 0, 0, 480, 240);
	}
	public MyFrame5(int w, int h) {
		this("no-title", 0, 0, w, h);
	}

	public MyFrame5(String title, int x, int y, int w, int h) {
		setTitle(title);
		if(x==0 && y==0){
			//화면의 정 가운데 오게 한다.
			Dimension sc = Toolkit.getDefaultToolkit().getScreenSize();
			x = (int)(sc.getWidth()/2-w/2);
			y = (int)(sc.getHeight()/2-h/2);
		}
		setBounds(x, y, w, h);
		
		//addWindowListener는 Window에 있는 메소드로 WindowListener타입을 받는다.
		addWindowListener(new WindowAdapter(){
//			abstract class WindowAdapter는 
//		         인터페이스 WindowListener, WindowStateListener, WindowFocusListener을 구현한다.
			@Override
			public void windowClosing(WindowEvent e){	//WindowEvent타입을 쓰는 메소드 windowClosing를 오버라이딩
				dispose();								//WindowListener인터페이스에 있는 메소드다.
				System.exit(0);							//dispose()는 window의 메소드로  프로그램을 종료하는 것이 아니라, 현재 frame만 종료시킨다.
			}
		});
	}
	public static void main(String[] args) {
		new MyFrame5().setVisible(true);
	}
}

//WindowListener의 windowClosing을 오버라이드 하고자 하는데
//WindowListener를 구현하는 추상클래스 WindowAdapter를 통해서 windowClosing를 오버라이딩한다.
//이때, 
