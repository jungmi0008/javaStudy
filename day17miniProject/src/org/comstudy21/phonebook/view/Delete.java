package org.comstudy21.phonebook.view;

import org.comstudy21.phonebook.R;
import org.comstudy21.phonebook.model.DTO;

public class Delete implements View {
	R r = resource;
	@Override
	public void show() {
		System.out.println("::: Delete :::");
		// 삭제 할 데이터 검색 (search 기능 활용)
		// 삭제 할 데이터를 화면에 보여준다.
		// 어떤것을 삭제할지 idx를 입력받는다.
		// --> Dao에서 삭제 처리
		if(r.dtoList == null) {
			System.out.println("삭제 할 내용이 없습니다!");
			return;
		}
		for(int i=0; i<r.dtoList.length; i++) {
			System.out.println(r.dtoList[i]);
		}
		System.out.print("삭제 할 데이터의 idx입력 >>> ");
		r.dto = new DTO(r.scan.nextInt(), null, null);
	}
}
