package org.comstudy21.day23;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.comstudy21.myframe.MyFrame;

//우리가 만든 클래스 ButtonActionListener
//외부에 클래스를 다로 선언하고 Day23Ex01의 변수들을 가져다 쓴다.
class ButtonActionListener implements ActionListener{
	private Day23Ex01AWT owner;
	
	public ButtonActionListener() {}
	public ButtonActionListener(Day23Ex01AWT owner) {
		this.owner = owner;
	}
	
	//액션을 감지하고 그에 대한 반응을 하게 한다.
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof Button){
			Button btn = (Button)e.getSource();
			if(btn==owner.btn1){
				System.out.println("1번 버튼을 눌렀다.");
				owner.label.setText("[결과] : 1번 버튼을 눌렀다.");	//창에 직접 보이게 한다.
			}else if(btn==owner.btn2){
				System.out.println("2번 버튼을 눌렀다.");
				owner.label.setText("[결과] : 2번 버튼을 눌렀다.");	
			}else{
				System.out.println("알 수 없는 버튼을 눌렀다.");
				owner.label.setText("[결과] : 알 수 없는 버튼을 눌렀다.");
			}
		}
	}
}
	
public class Day23Ex01AWT extends MyFrame{
	public Label label = new Label("[결과] : 아무 버튼도 누르지 않았다.");
	private Panel centerPanel = new Panel(new FlowLayout());
	private Panel southPanel = new Panel(new FlowLayout());
	public Button btn1 = new Button("버튼1");
	public Button btn2 = new Button("버튼2");
	
	public Day23Ex01AWT() {
		super(300,100);
		
		init();
		start();
	}
	
	
	//이벤트 리스너를 등록하는 함수
	private void start(){
		ActionListener l = new ButtonActionListener(this);
		btn1.addActionListener(l);
		btn2.addActionListener(l);
	}
	
	//화면 레이아웃을 설정하는 함수
	private void init(){
		centerPanel.add(label);
		southPanel.add(btn1);
		southPanel.add(btn2);
		
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(southPanel, BorderLayout.SOUTH);
	}
	public static void main(String[] args) {
		
		new Day23Ex01AWT().setVisible(true);
	
	}
}
