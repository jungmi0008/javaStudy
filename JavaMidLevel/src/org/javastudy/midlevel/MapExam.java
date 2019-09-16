package org.javastudy.midlevel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExam {

	public static void main(String[] args) {
		//Map<key,value>
		//key는 중복될 수 없다.
		Map<String, String>map = new HashMap<>();
		map.put("001", "kim");
		map.put("002", "lee");
		map.put("003", "shoi");
		
		map.put("001", "kang");	//중복된 값을 넣어보자.
		
		System.out.println(map.size());	//3이 나온다.
		
		System.out.println(map.get("001"));	//나중에 들어온 값이 나오게 된다.
		System.out.println(map.get("002"));	//get은 벨류값을 불러오는 방법.
		
		//value값은 get()으로 간단하게 꺼낼 수 있지만
		//key값의 경우는 Set에 넣어준다음에 iterator로 꺼내줘야 한다.
		
		//keySet은 키 값만 모두 꺼내서 넣어주는 것.
		Set<String> keys = map.keySet();
		
		//Set에 값을 넣었으므로 iterator로 값을 꺼내준다.
		Iterator<String> iter = keys.iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			String value = map.get(key);
			System.out.println(key+":"+value);
			
		}
	}

}
