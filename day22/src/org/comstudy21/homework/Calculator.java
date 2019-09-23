package org.comstudy21.homework;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

public class Calculator extends MyFrame{
	
	private Label lable = new Label("0", Label.RIGHT);

	private Panel centerPan = new Panel(new GridLayout(5,4));
	Button[] centerBtn = null;
	Button[] eastBtn = null;
	Button[] southBtn = null;
	
	String[] centerBtnStr = {
	"MC", "MR", "MS", "M+",  
	"←", "CE", "C", "±", 
	"7", "8", "9", "/",  
	"4", "5", "6", "*",  
	"1", "2", "3", "-", 
	};
	
	private Panel eastPan = new Panel(new GridLayout(5,1));
	String[] eastBtnStr = {
			"M-","√", "%","1/x","=",
	};
	
	private Panel southPan = new Panel(new GridLayout(1,1));
	String[] southBtnStr = {
			"0",  ".", "+"
	};
	
	public Calculator() {
		init();
	}
	
	public void init() {
		
		setLayout(new GridLayout(5,4,5,5));
		centerBtn = new Button[centerBtnStr.length];
		for(int i=0; i<centerBtnStr.length; i++) {
			centerBtn[i] = new Button(centerBtnStr[i]);
			centerPan.add(centerBtn[i]);
		}
		
		setLayout(new GridLayout(1,3,5,5));
		southBtn = new Button[southBtnStr.length];
		for(int i=0; i<southBtnStr.length; i++) {
			southBtn[i] = new Button(southBtnStr[i]);
			if(i==0){
//				layout(southBtn,);버튼 크기
			}
			southPan.add(southBtn[i]);
		}
		
		setLayout(new GridLayout(5,1,5,5));
		eastBtn = new Button[eastBtnStr.length];
		for(int i=0; i<eastBtnStr.length; i++) {
			eastBtn[i] = new Button(eastBtnStr[i]);
			eastPan.add(eastBtn[i]);
		}
		
		
		
		setLayout(new BorderLayout());
		add(centerPan,"Center");
		add(southPan, "South");
		add(eastPan, "East");
	}
	
	public static void main(String[] args) {
		new Calculator().setVisible(true);
	}

}
