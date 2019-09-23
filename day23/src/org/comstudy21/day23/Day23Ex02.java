package org.comstudy21.day23;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Day23Ex02 extends Frame{
	public Day23Ex02() {
		setSize(300, 200);
		setVisible(true);
		addWindowListener(new ExitHandler());
	}
	//클래스를 따로 내부에 선언해서 WindowAdapter를 설계한다.
	class ExitHandler extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new Day23Ex02();
	}
}
