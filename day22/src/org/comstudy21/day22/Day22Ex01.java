package org.comstudy21.day22;

import java.awt.Frame;
/*
 * Frame클래스 객체를 만들어서 쓸 수도 있고 
 * Frame을 상속받아서 사용할 수도 있다.
 */
public class Day22Ex01 extends Frame{
	
	public Day22Ex01() {
		this.setTitle("JAVA GUI Programming");
		this.setSize(640, 480);
		this.setLocation(200, 200);
	}
	public static void main(String[] args) {
//		Frame frame = new Frame();
//		frame.setTitle("위대한 자바");
//		frame.setBounds(100, 100, 640, 480);
//		frame.setVisible(true);
		
		new Day22Ex01().setVisible(true);
		
	}
}
