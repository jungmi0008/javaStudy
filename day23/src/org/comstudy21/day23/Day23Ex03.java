package org.comstudy21.day23;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import org.comstudy21.myframe.MyFrame;
//���� ��, ���� ũ�� ���� �����Ѵ�.
public class Day23Ex03 extends MyFrame{
	public Day23Ex03(){
		
	}
	
	@Override
	public void paint(Graphics g) {
		//�ڵ� ȣ�� �Ǵ� �Լ��̴�.
		System.out.println("paint �Լ� ȣ��");
		setBackground(Color.darkGray);
		g.setColor(Color.ORANGE);
		Font font = new Font("�ü�ü", Font.ITALIC, 48);
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
