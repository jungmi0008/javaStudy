package org.comstudy21.phonebook.view;

import org.comstudy21.phonebook.R;
import org.comstudy21.phonebook.model.DTO;

public class Search implements View {
	R r = resource;
	
	@Override
	public void show() {
		System.out.println("::: Search :::");
		// 검색어를 입력 받는다.
		// 검색어를 Controller에서 쓸수 있도록 R에 저장
		System.out.print("검색 할 이름 입력>>> ");
		String sName = r.scan.next();
		
		r.dto = new DTO(0, sName, null);
	}
}
