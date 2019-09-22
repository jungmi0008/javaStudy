package org.comstudy21.day22_layoutManager;

import java.awt.Button;
import java.awt.FlowLayout;

import org.comstudy21.day22.MyFrame2;
//��ư 100�� �����
public class Day22Ex04 extends MyFrame2{
	//FlowLayout�� Button
	public static final int MAX = 100;
	Button[] btnArr = new Button[MAX];	//ButtonŸ������ ��̸� �����!
	{
		for (int i = 0; i < MAX; i++) {
			btnArr[i] = new Button(i<10?("btn0"+i):("btn"+i));
		}
	}
	
	public Day22Ex04() {
		init();
	}
	public void init(){
		setLayout(new FlowLayout());	//�޼ҵ� public void setLayout(LayoutManager mgr)
		for (int i = 0; i < MAX; i++) {
			this.add(btnArr[i]);
		}
	}
	public static void main(String[] args) {
		new Day22Ex04().setVisible(true);
	}
}
