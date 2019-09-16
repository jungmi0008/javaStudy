package org.comstudy21.phonebook.model;

public class DAO {
	// 임의로 만들어진 부분
	// 이 부분은 나중에 DB를 배우고 나서 DB에 저장 되는 부분입니다.
	private static final int MAX = 100;
	private DTO[] list = new DTO[MAX];
	private static int squence = 0; // idx가 된다.
	private int top = 0;
	{
		list[top++] = new DTO(squence++, "KIM","010-1111-1111");
		list[top++] = new DTO(squence++, "LEE","010-2222-2222");
		list[top++] = new DTO(squence++, "PARK","010-3333-3333");
		list[top++] = new DTO(squence++, "KANG","010-4444-4444");
	}
	
	
	public void insert(DTO dto) {
		System.out.println("### insert ...");
		if(top >= list.length) {
			System.out.println("### 더이상 입력 할수 없습니다!!");
			return;
		}
		dto.setIdx(squence++);
		list[top++] = dto;
	}
	
	public DTO[] selectAll() {
		if(top <= 0) {
			System.out.println("### 저장 된 데이터가 없습니다!!");
			return null;
		}
		DTO[] dtoList = new DTO[top];
		for(int i=0; i<dtoList.length; i++) {
			dtoList[i] = new DTO();
			dtoList[i].setIdx(list[i].getIdx());
			dtoList[i].setName(list[i].getName());
			dtoList[i].setPhone(list[i].getPhone());
		}
		return dtoList;
	}

	public DTO[] select(DTO dto) {
		DTO[] list1 = new DTO[top];
		int cnt=0;
		System.out.println("### dto.getName() => " + dto.getName());
		for(int i=0;i<top; i++) {
			if((dto.getName()).equals(list[i].getName()) ) {
				list1[cnt] = new DTO();
				list1[cnt].setIdx(list[i].getIdx());
				list1[cnt].setName(list[i].getName());
				list1[cnt].setPhone(list[i].getPhone());
				cnt++;
			}
		}
		if(cnt == 0) {
			System.out.println("### 검색 내용이 없습니다!");
			return null;
		}
		DTO[] list2 = new DTO[cnt];
		for(int i=0; i<cnt; i++) {
			list2[i] = list1[i];
		}
		return list2;
	}

	public void update(DTO dto2) {
		for(int i=0; i<top; i++) {
			if((dto2.getIdx()) == list[i].getIdx()) {
				list[i] = dto2;
				return;
			}
		}
		System.out.println("### 수정 할 내용이 없습니다!");
	}

	public void delete(DTO dto) {
		for(int i=0; i<top; i++) {
			if((dto.getIdx()) == list[i].getIdx()) {
				for(int j=i; j<top-1; j++) {
					list[j]=list[j+1];
				}
				top--;
				return;
			}
		}
		System.out.println("### 삭제 할 내용이 없습니다!");
	}
	
	
	
	
	
}
