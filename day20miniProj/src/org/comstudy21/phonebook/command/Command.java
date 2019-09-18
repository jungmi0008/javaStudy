package org.comstudy21.phonebook.command;

import java.util.HashMap;

import org.comstudy21.phonebook.R;

public interface Command {
	String INPUT = R.INPUT;
	String OUTPUT = R.OUTPUT;
	String END = R.END;
	String MENU = R.MENU;
	
	String action(HashMap<String, Object> request);
	
}
