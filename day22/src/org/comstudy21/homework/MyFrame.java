package org.comstudy21.homework;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MyFrame extends Frame{
	public MyFrame() {
		this.setTitle("°è»ê±â");
		this.setSize(240, 335);
		this.setLocation(200, 200);
		
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){	
				dispose();								
				System.exit(0);							
			}
		});
	}
	

	public static void main(String[] args) {
		new MyFrame().setVisible(true);
	}
}
