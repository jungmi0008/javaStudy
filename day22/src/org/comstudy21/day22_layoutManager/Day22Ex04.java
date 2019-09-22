package org.comstudy21.day22_layoutManager;

import java.awt.Button;
import java.awt.FlowLayout;

import org.comstudy21.day22.MyFrame2;
//버튼 100개 만들기
public class Day22Ex04 extends MyFrame2{
	//FlowLayout에 Button
	public static final int MAX = 100;
	Button[] btnArr = new Button[MAX];	//Button타입으로 어레이를 만들기!
	{
		for (int i = 0; i < MAX; i++) {
			btnArr[i] = new Button(i<10?("btn0"+i):("btn"+i));
		}
	}
	
	public Day22Ex04() {
		init();
	}
	public void init(){
		setLayout(new FlowLayout());	//메소드 public void setLayout(LayoutManager mgr)
		for (int i = 0; i < MAX; i++) {
			this.add(btnArr[i]);
		}
	}
	public static void main(String[] args) {
		new Day22Ex04().setVisible(true);
	}
}
