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
			//ȭ���� �� ��� ���� �Ѵ�.
			Dimension sc = Toolkit.getDefaultToolkit().getScreenSize();
			x = (int)(sc.getWidth()/2-w/2);
			y = (int)(sc.getHeight()/2-h/2);
		}
		setBounds(x, y, w, h);
		
		//addWindowListener�� Window�� �ִ� �޼ҵ�� WindowListenerŸ���� �޴´�.
		addWindowListener(new WindowAdapter(){
//			abstract class WindowAdapter�� 
//		         �������̽� WindowListener, WindowStateListener, WindowFocusListener�� �����Ѵ�.
			@Override
			public void windowClosing(WindowEvent e){	//WindowEventŸ���� ���� �޼ҵ� windowClosing�� �������̵�
				dispose();								//WindowListener�������̽��� �ִ� �޼ҵ��.
				System.exit(0);							//dispose()�� window�� �޼ҵ��  ���α׷��� �����ϴ� ���� �ƴ϶�, ���� frame�� �����Ų��.
			}
		});
	}
	public static void main(String[] args) {
		new MyFrame5().setVisible(true);
	}
}

//WindowListener�� windowClosing�� �������̵� �ϰ��� �ϴµ�
//WindowListener�� �����ϴ� �߻�Ŭ���� WindowAdapter�� ���ؼ� windowClosing�� �������̵��Ѵ�.
//�̶�, 
