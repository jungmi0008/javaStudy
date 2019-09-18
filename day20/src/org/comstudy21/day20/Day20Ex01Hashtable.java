package org.comstudy21.day20;

import java.util.*;

public class Day20Ex01Hashtable {
	public static void main(String[] args) {
		//해쉬테이블은 순서가 없기 때문에 출력이 순서대로 나오지 않는다.
		//따로 리스트에 입력을 하고 그 다음 Collection.sort해야한다.
		Hashtable<String, String> map = new Hashtable();
		map.put("홍길동", "010-1111-1111");
		map.put("김길동", "010-2222-2222");
		map.put("이길동", "010-3333-3333");
		map.put("박길동", "010-4444-4444");
		map.put("김길동", "010-5555-5555");
		
		System.out.println(map.size());
		
		//Enumeration interface generates a series of elements, one at a time. Successive calls to the nextElement 
		Enumeration<String> keys = map.keys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			System.out.println(key+":"+map.get(key));
			
			
		}
	}
}
