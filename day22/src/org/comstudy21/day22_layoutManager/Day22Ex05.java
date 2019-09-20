package org.comstudy21.day22_layoutManager;

import java.awt.BorderLayout;
import java.awt.Button;

import org.comstudy21.day22.MyFrame2;

public class Day22Ex05 extends MyFrame2{
	
	private Button btn01 = new Button("btn01");
	private Button btn02 = new Button("btn02");
	private Button btn03 = new Button("btn03");
	private Button btn04 = new Button("btn04");
	private Button btn05 = new Button("btn05");

	public Day22Ex05() {
		init();
	}
	private void init(){
		setLayout(new BorderLayout());
		add(btn01, BorderLayout.NORTH);
		add(btn02, "South");	//SOUTH로 써주면 적용되지 않는다. 규정이니 외우기!
		add(btn03, BorderLayout.WEST);
		add(btn04, BorderLayout.EAST);
		add(btn05, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		new Day22Ex05().setVisible(true);
	}
}
