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
		
		//����Ŭ����WindowAdapterImpl�� �����ϰ� WindowAdapter�� ���ؼ� windowClosing�� ������ �� �ִ�.
		//adapter�� Ŭ�����̱� ������ MyFrame2�� ���� �̹� ��ӹ��� ��쿡�� �� �� ����.
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
