package org.comstudy21.day23;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import org.comstudy21.myframe.MyFrame;
//글자 색, 글자 크기 등을 조절한다.
public class Day23Ex03 extends MyFrame{
	public Day23Ex03(){
		
	}
	
	@Override
	public void paint(Graphics g) {
		//자동 호출 되는 함수이다.
		System.out.println("paint 함수 호출");
		setBackground(Color.darkGray);
		g.setColor(Color.ORANGE);
		Font font = new Font("궁서체", Font.ITALIC, 48);
		g.setFont(font);
		g.drawString("Hello java world", 50, 100);
		
		g.drawRect(50, 200, 150, 150);
		g.setColor(Color.RED);
		g.fillRect(50, 200, 150, 150);
	}
	
	public static void main(String[] args) {
		new Day23Ex03().setVisible(true);
	}
}
