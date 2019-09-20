package org.comstudy21.day22_layoutManager;

import java.awt.Button;
import java.awt.GridLayout;

import org.comstudy21.day22.MyFrame2;

public class Day22Ex06 extends MyFrame2{
	private Button btn01 = new Button("btn01");
	private Button btn02 = new Button("btn02");
	private Button btn03 = new Button("btn03");
	private Button btn04 = new Button("btn04");
	private Button btn05 = new Button("btn05");
	private Button btn06 = new Button("btn06");
	
	public Day22Ex06() {
		init();
	}
	public void init(){
		setLayout(new GridLayout(2,3,5,5));	//2행, 3열, 가로 간격, 세로 간격
		add(btn01);
		add(btn02);
		add(btn03);
		add(btn04);
		add(btn05);
		add(btn06);
	}
	
	public static void main(String[] args) {
		new Day22Ex06().setVisible(true);
	}
}
