package org.comstudy21.day22_layoutManager;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

import org.comstudy21.day22.MyFrame2;

public class Day22Ex08 extends MyFrame2{
	private Panel northPan = new Panel(new GridLayout(1,1));
	private Label lable = new Label("버튼을 누르세요", Label.CENTER);
	
	private Panel southPan = new Panel(new GridLayout(1,2));
	private Panel southPan1 = new Panel(new GridLayout(1,4));
	private Button btn01 = new Button("Play");
	private Button btn02 = new Button("Stop");
	private Button btn03 = new Button("Pause");
//	private Button extra = new Button();	
	
	private Panel southPan2 = new Panel(new GridLayout(2,1));
	private Button btn04 = new Button("Back");
	private Button btn05 = new Button("Blank");
	
	
	public Day22Ex08() {
		super(300,400);
		init();
	}
	public void init(){
		setLayout(new BorderLayout());
		add(northPan,"Center");
		northPan.add(lable);
		
		add(southPan,"South");
		southPan.add(southPan1,"West");
		southPan1.add(btn01);
		southPan1.add(btn02);
		southPan1.add(btn03);
		southPan.add(southPan2,"East");
		southPan2.add(btn04);
		southPan2.add(btn05);
	}
	
	public static void main(String[] args) {
		new Day22Ex08().setVisible(true);
	}
}
