package org.comstudy21.day22_layoutManager;

import java.awt.Button;
import java.awt.FlowLayout;

import org.comstudy21.day22.MyFrame2;
//��ư�����
public class Day22Ex03 extends MyFrame2{
	//FlowLayout ����
	//Ŭ���� ����ʵ�� �����Ѵ�.
	private Button btn01 = new Button("btn01");
	private Button btn02 = new Button("btn02");
	private Button btn03 = new Button("btn03");
	private Button btn04 = new Button("btn04");
	private Button btn05 = new Button("btn05");
	
	public Day22Ex03() {
		start();
	}
	public void start() {
		this.setLayout(new FlowLayout());
		this.add(btn01);
		this.add(btn02);
		this.add(btn03);
		this.add(btn04);
		this.add(btn05);
	}
	
	public static void main(String[] args) {
		new Day22Ex03().setVisible(true);
	}
}
