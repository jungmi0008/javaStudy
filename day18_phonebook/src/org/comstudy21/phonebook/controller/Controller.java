package org.comstudy21.phonebook.controller;

import static org.comstudy21.phonebook.R.*;

import java.util.Arrays;

import org.comstudy21.phonebook.model.*;
import org.comstudy21.phonebook.view.*;

public class Controller {
	
	public void service() {
		
		View view = viewArr[menuNo];
		viewer.setView(view);
		
		//input
		if(menuNo == 1) {
			viewer.display();
			dao.insert(dto);
		
		//output
		} else if(menuNo == 2) {
			DTO[] list = dao.selectAll();
			dtoList = list;
			viewer.display();
			
		//Search
		}else if(menuNo == 3) {
			viewer.display();
			dtoList = DAO.select(search.dto);
			System.out.println(Arrays.toString(dtoList));
			
		//Modify
		}else if(menuNo == 4) {
			viewer.display();
			dtoList = DAO.select(modify.dto);
			dto = DAO.convert(dtoList);
			dto = (DTO) DAO.modify(dto);
			DAO.update(dto);
		//Delete
		}else if(menuNo == 5) {
			viewer.display();
			if(delete.i==1) {
				dtoList = DAO.select(delete.dto);
				dto = DAO.convert(dtoList);
				DAO.delete(dto);
			} else {
				System.out.println("취소를 선택 하였습니다.");
			}
			
		//End
		} else {
			viewer.display();
		}
		
		//
		service();
		
	}
	
}
