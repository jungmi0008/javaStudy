package org.comstudy21.phonebook;

import java.util.HashMap;
import java.util.Scanner;

import org.comstudy21.phonebook.command.*;
import org.comstudy21.phonebook.model.PhonebookDao;
import org.comstudy21.phonebook.view.*;

public class R {
	public static final Scanner scan = new Scanner(System.in);
	
	public static final String INPUT = "input";
	public static final String OUTPUT = "output";
	public static final String END = "end";
	public static final String MENU = "menu";
	
	public static final String menuStr[] = {
			MENU, INPUT, OUTPUT, END
	};
	
	public static final HashMap<String, View> viewMap = new HashMap<>();
	public static final HashMap<String, Command> cmdMap = new HashMap<>();
	public static final HashMap<String, Object> request = new HashMap<>();
	// static 초기화 영역
	static {
		viewMap.put(INPUT, new Input());
		viewMap.put(OUTPUT, new Output());
		viewMap.put(END, new End());
		viewMap.put(MENU, new Menu());
		
		cmdMap.put(INPUT, new InputCmd());
		cmdMap.put(OUTPUT, new OutputCmd());
		cmdMap.put(END, new EndCmd());
	}
	
	public static final Viewer viewer = new Viewer();
	
	public static final PhonebookDao dao = new PhonebookDao();
}
