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
	//Ŭ������ ���� ���ο� �����ؼ� WindowAdapter�� �����Ѵ�.
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
