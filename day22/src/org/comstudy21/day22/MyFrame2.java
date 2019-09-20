package org.comstudy21.day22;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyFrame2 extends Frame implements WindowListener{
	public MyFrame2(){
		this("no-title", 10, 10, 600, 400);
	}
	public MyFrame2(int w, int h){
		this("no-title", 10, 10, w, h);
	}

	public MyFrame2(String title, int x, int y, int w, int h) {
		setTitle(title);
		setBounds(x, y, w, h);
		
		addWindowListener(this);	//이벤트 리스너 등록
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {	//창 닫게 하기
		dispose();
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}
	
	public static void main(String[] args) {
		new MyFrame2().setVisible(true);
	}

}
