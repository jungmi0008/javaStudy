package org.comstudy21.phonebook.view;

import org.comstudy21.phonebook.R;
import org.comstudy21.phonebook.model.DTO;

public class Modify implements View {
	R r = resource;
	@Override
	public void show() {
		System.out.println("::: Modify :::");
		// 수정 할 이름 검색(Search 에서 처리 가능)
		// 검색을 이용해서 Dao에서 검색할 수 있도록 R에 저장한다.(Search 에서 처리)
		// ----------- 검색 결과를 사용 가능
		// 검색 결과 목록 출력
		// 몇번째를 수정 할지 idx 선택한다.
		// 새 데이터 입력 받아서 R에 저장한다.
		if(r.dtoList == null) {
			System.out.println("수정 할 내용이 없습니다!");
			return;
		}
		for(int i=0; i<r.dtoList.length; i++) {
			System.out.println(r.dtoList[i]);
		}
		// 수정 할 idx를 입력 받는다.
		int sIdx = r.dtoList[0].getIdx();
		if(r.dtoList.length > 1) {
			System.out.print("수정 할 IDX 입력 >>> ");
			sIdx = r.scan.nextInt();
		}
		r.dto2 = new DTO();
		System.out.print("새 이름 입력>>> ");
		r.dto2.setName(r.scan.next());
		System.out.print("새 전화번호 입력>>> ");
		r.dto2.setPhone(r.scan.next());
		r.dto2.setIdx(sIdx);
	}

}
