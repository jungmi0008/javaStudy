package org.comstudy21.day23;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.comstudy21.myframe.MyFrame;

//�츮�� ���� Ŭ���� ButtonActionListener
//�ܺο� Ŭ������ �ٷ� �����ϰ� Day23Ex01�� �������� ������ ����.
class ButtonActionListener implements ActionListener{
	private Day23Ex01AWT owner;
	
	public ButtonActionListener() {}
	public ButtonActionListener(Day23Ex01AWT owner) {
		this.owner = owner;
	}
	
	//�׼��� �����ϰ� �׿� ���� ������ �ϰ� �Ѵ�.
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof Button){
			Button btn = (Button)e.getSource();
			if(btn==owner.btn1){
				System.out.println("1�� ��ư�� ������.");
				owner.label.setText("[���] : 1�� ��ư�� ������.");	//â�� ���� ���̰� �Ѵ�.
			}else if(btn==owner.btn2){
				System.out.println("2�� ��ư�� ������.");
				owner.label.setText("[���] : 2�� ��ư�� ������.");	
			}else{
				System.out.println("�� �� ���� ��ư�� ������.");
				owner.label.setText("[���] : �� �� ���� ��ư�� ������.");
			}
		}
	}
}
	
public class Day23Ex01AWT extends MyFrame{
	public Label label = new Label("[���] : �ƹ� ��ư�� ������ �ʾҴ�.");
	private Panel centerPanel = new Panel(new FlowLayout());
	private Panel southPanel = new Panel(new FlowLayout());
	public Button btn1 = new Button("��ư1");
	public Button btn2 = new Button("��ư2");
	
	public Day23Ex01AWT() {
		super(300,100);
		
		init();
		start();
	}
	
	
	//�̺�Ʈ �����ʸ� ����ϴ� �Լ�
	private void start(){
		ActionListener l = new ButtonActionListener(this);
		btn1.addActionListener(l);
		btn2.addActionListener(l);
	}
	
	//ȭ�� ���̾ƿ��� �����ϴ� �Լ�
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
