package org.comstudy21.day22_layoutManager;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Panel;

import org.comstudy21.day22.MyFrame2;

public class Day22Ex07 extends MyFrame2{
	public static final int MAX = 12;
	
	private Panel centerPan = new Panel(new GridLayout(4,3));
	private Button[] arr = new Button[MAX];

	private Panel eastPan = new Panel(new GridLayout(4,1));
	private Button btn01 = new Button("			+			");
	private Button btn02 = new Button("-");
	private Button btn03 = new Button("C");
	private Button btn04 = new Button("=");

	
	{
		for (int i = 1; i < 10; i++) {
			arr[i-1] = new Button(""+i);
		}
		arr[9] = new Button("*");
		arr[10] = new Button("0");
		arr[11] = new Button("#");
	}
	public Day22Ex07(){
		super(300,400);
		init();
	}
	public void init(){
		setLayout(new BorderLayout());
		for (int i = 0; i < arr.length; i++) {
			centerPan.add(arr[i]);
		}
		add(centerPan,"Center");
		add(eastPan, "East");
		eastPan.add(btn01);
		eastPan.add(btn02);
		eastPan.add(btn03);
		eastPan.add(btn04);
	}
	public static void main(String[] args) {
		new Day22Ex07().setVisible(true);
	}
}
