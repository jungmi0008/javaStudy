package org.comstudy21.day22;

import java.awt.Frame;
/*
 * FrameŬ���� ��ü�� ���� �� ���� �ְ� 
 * Frame�� ��ӹ޾Ƽ� ����� ���� �ִ�.
 */
public class Day22Ex01 extends Frame{
	
	public Day22Ex01() {
		this.setTitle("JAVA GUI Programming");
		this.setSize(640, 480);
		this.setLocation(200, 200);
	}
	public static void main(String[] args) {
//		Frame frame = new Frame();
//		frame.setTitle("������ �ڹ�");
//		frame.setBounds(100, 100, 640, 480);
//		frame.setVisible(true);
		
		new Day22Ex01().setVisible(true);
		
	}
}
