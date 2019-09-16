package org.comstudy21.phonebook;

import java.util.Scanner;

import org.comstudy21.phonebook.controller.*;
import org.comstudy21.phonebook.model.*;
import org.comstudy21.phonebook.view.*;

public class R {
	public static final String[] menuArr = {"INPUT","OUTPUT","SEARCH","MODIFY","DELETE","END"};
	
	public static final Viewer viewer = new Viewer();
	public static final Input input = new Input();
	public static final Output output = new Output();
	public static final Menu menu = new Menu();
	public static final End end = new End();
	public static final Search search = new Search();
	public static final Modify modify = new Modify();
	public static final Delete delete = new Delete();
	
	public static final Controller controller = new Controller();
	
	public static final DAO dao = new DAO();
	
	public static final View[] viewArr = {menu, input, output, search, modify, delete, end};
	
	public static int menuNo = 0;
	public static DTO[] dtoList = null;
	public static DTO dto = null;
	public static DTO dto2 = null;
	
	public static final Scanner scan = new Scanner(System.in);
	
}
