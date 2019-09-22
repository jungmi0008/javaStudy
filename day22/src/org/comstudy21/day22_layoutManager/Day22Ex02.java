package org.comstudy21.day22_layoutManager;

import java.awt.Button;

import org.comstudy21.day22.MyFrame2;
//버튼이 움직이게 만들기(쓰레드 사용)
public class Day22Ex02 extends MyFrame2 implements Runnable{
	Button btn = new Button("오늘은 회식");
	private int x = 0;
	
	public Day22Ex02(){
		
	}

	public Day22Ex02(int w, int h){
		super(w, h);
		setTitle("배치관리자 연습");
		
		setLayout(null);	//null값으로 두어야 아래에서 위치를 조절할 수 있다.
		
		btn.setBounds(x,120,100,25);
		this.add(btn);
		
		Thread thread = new Thread(this);
		thread.start();
	}
	
	@Override
		public void run() {
			int speed = 10;
			for(;;){	//계속 움직이게 한다.
				try{
					Thread.sleep(28);
					x+=speed;	//speed만큼 더한 위치에 
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
