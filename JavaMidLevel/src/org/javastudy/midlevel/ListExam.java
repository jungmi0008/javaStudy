package org.javastudy.midlevel;

import java.util.ArrayList;
import java.util.List;
//list는 중복이 있을 수 있고 순서가 있다.
//배열과 다르게 사이즈가 정해져있지 않는다.
public class ListExam {

	public static void main(String[] args) {
		//마찬가지로 List는 인터페이스이므로 메소드를 구현하는 ArrayList같은 것이 필요.
		List<String> list = new ArrayList<>();
		list.add("kim");
		list.add("kang");
		list.add("kim");
		
		System.out.println(list.size());	// 결과는 3이다. 중복이 가능하다는 소리
		
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);	//get을 이용해 값을 꺼내온다.
			System.out.println(str);
		}
	}

}
