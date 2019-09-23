package org.comstudy21.day23;

import java.awt.Graphics;
import java.awt.Image;

import org.comstudy21.myframe.MyFrame;

public class Day23Ex04 extends MyFrame{
	Image image;
	public Day23Ex04() {
		// TODO Auto-generated constructor stub
		image = getToolkit().getImage("제목 없음.png");
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(image, 50, 50, 300, 300, this);
	}
	public static void main(String[] args) {
		new Day23Ex04().setVisible(true);
	}
}
