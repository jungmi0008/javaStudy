package org.comstudy21.myframe;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame{
	public MyFrame() {
		this("MyFrame", 0, 0, 640, 480);
	}
	public MyFrame(int width, int height) {
		this("MyFrame", 0, 0, width, height);
	}

	public MyFrame(String title, int x, int y, int width, int height) {
		setTitle(title);
		setSize(width, height);
		
		//중간에 위치하게 한다.
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		x = (int)(screen.getWidth()/2-getWidth()/2);
		y = (int)(screen.getHeight()/2-getHeight()/2);
		
		setLocation(x, y);
		
		//종료기능 추가
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e){
				dispose();
				System.exit(0);
			}
		});
	}
}
