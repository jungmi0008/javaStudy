package org.comstudy21.homework;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

public class Calculator extends MyFrame{
	
	private Label lable = new Label("0", Label.RIGHT);
	
	private Panel centerPan = new Panel(new GridLayout(1,1));
	Button[] button = null;
	String[] centerBtnStr = {
	"MC", "MR", "MS", "M+",  
	"¡ç", "CE", "C", "¡¾", 
	"7", "8", "9", "/",  
	"4", "5", "6", "*",  
	"1", "2", "3", "-", 
	};
	
	String[] eastBtnStr = {
			"M-","¡î", "%","1/x","=",
	};
	
	String[] southBtnStr = {
			"0",  ".", "+"
	};
	
	public Calculator() {
		init();
	}
	
	public void init() {
		setLayout(new BorderLayout());
		add(centerPan,"Center");
		
		setLayout(new GridLayout(5,4,5,5));
		button = new Button[centerBtnStr.length];
		for(int i=0; i<centerBtnStr.length; i++) {
			button[i] = new Button(centerBtnStr[i]);
			add(button[i]);
		}
	}
	
	public static void main(String[] args) {
		new Calculator().setVisible(true);
	}

}
