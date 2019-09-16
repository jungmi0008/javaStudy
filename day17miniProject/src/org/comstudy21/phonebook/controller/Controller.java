package org.comstudy21.phonebook.controller;

import static org.comstudy21.phonebook.R.*;

import org.comstudy21.phonebook.model.*;
import org.comstudy21.phonebook.view.*;

public class Controller {
	
	public void service() {
		
		View view = viewArr[menuNo];
		viewer.setView(view);
		boolean flag = true;
		if(menuNo == 1) {
			viewer.display();
			// 입력 후 dao 호출
			dao.insert(dto);
		} else if(menuNo == 2) {
			DTO[] list = dao.selectAll();
			dtoList = list;
			// dao 호출 후 출력
			viewer.display();
		}else if(menuNo == 3) {
			viewer.display(); // 검색어를 R에 저장하고 돌아옴
			// Dao에서 검색 해서 목록 가져온다
			// 결과를 뿌려준다.
			DTO[] list = dao.select(dto);
			dtoList = list;
			// 검색 목록을 출력한다.
			viewer.setView(viewArr[2]);
			viewer.display();			
		}else if(menuNo == 4) {
			// modify를 호출 하기 전에 데이터를 검색한다.
			preSearch();
			
			viewer.setView(view);
			viewer.display();
			// 새 데이터를 Dao에 전달한다.
			dao.update(dto2);
		}else if(menuNo == 5) {
			preSearch();
			
			viewer.setView(view);
			viewer.display();
			// 입력 받은 idx정보를 이용해서 dao에서 해당 데이터 삭제
			dao.delete(dto);
		} else {
			//메뉴 호출
			viewer.display();
			flag = false;
		}
		System.out.println();
		// 메뉴 선택 외의 케이스에서 실행
		if(flag) {
			menuNo = 0;
		}
		
		service();
	} // end of service
	
	// 수정, 삭제 전 검색 기능
	private void preSearch() {
		viewer.setView(search);
		viewer.display();
		// dao에서 검색한다.
		DTO[] list = dao.select(dto);
		dtoList = list;
	}
	
}
