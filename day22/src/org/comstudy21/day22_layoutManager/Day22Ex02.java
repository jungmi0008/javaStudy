package org.comstudy21.day22_layoutManager;

import java.awt.Button;

import org.comstudy21.day22.MyFrame2;

public class Day22Ex02 extends MyFrame2 implements Runnable{
	Button btn = new Button("오늘은 회식");
	private int x = 0;
	
	public Day22Ex02(){
		
	}

	public Day22Ex02(int w, int h){
		super(w, h);
		setTitle("배치관리자 연습");
		
		setLayout(null);
		
		btn.setBounds(x,120,100,25);
		this.add(btn);
		
		Thread thread = new Thread(this);
		thread.start();
	}
	
	@Override
		public void run() {
			int speed = 10;
			for(;;){
				try{
					Thread.sleep(28);
					x+=speed;
					int width = getWidth();
					if(x>=width-btn.getWidth()||x<=0){	//끝점에 도달하면
						speed = speed*(-1);
					}
					btn.setBounds(x, getHeight()-btn.getHeight()-10,100,22);
				}catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	
	public static void main(String[] args) {
		new Day22Ex02(640,480).setVisible(true);
	}
}
