package org.comstudy21.day22;

import java.awt.Frame;

public class MyFrame extends Frame{
	public MyFrame() {
		this("MyFrame", 50, 50, 640, 480);
	}
	public MyFrame(int w, int h) {
		this("no-title", 0, 0, w, h);
	}
	
	public MyFrame(String title, int x, int y, int w, int h) {
		setTitle(title);
		setSize(w, h);
		setLocation(x, y);
	}
}
