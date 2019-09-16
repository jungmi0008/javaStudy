package org.javastudy.midlevel;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class setExam {
//set은 중복과 순서가 없다.
	
	public static void main(String[] args) {
		//set은 인터페이스이므로 HashSet으로 구현할 수 있다.
		//아래의 경우는 제너릭으로 문자열만 받게 했다.
		//데이터를 저장하기 위해 add을 사용한다.
		//add는 boolean값으로 저장된다.
		Set<String> set1 = new HashSet<>();
		boolean flag1 = set1.add("kang");
		boolean flag2 = set1.add("kim");
		boolean flag3 = set1.add("kang");
		
		//set 자료구조의 크기를 알아볼 때 size를 이용한다.
		System.out.println(set1.size());
		System.out.println(flag1);
		System.out.println(flag2);
		System.out.println(flag3);	//false는 중복이 되었다는 의미가 된다.
		
		//set에 있는 값을 하나씩 꺼내보기 위해 iterator을 쓴다.
		//hasNext는 꺼낼 내용이 있다면 true를 리턴한다.
		//즉 true일 때 값을 출력해내는 while문을 아래에 구현했다.
		//next()는 자료를 하나씩 꺼내는 함수다.
		Iterator<String> iter = set1.iterator();
		while(iter.hasNext()) {
			String str = iter.next();
			System.out.println(str);
		}
		
		Set<String> set2 = new HashSet<>();
		set2.add("a");
		set2.add("b");
		set2.add("c");
		
		//for-each구문을 이용해서 출력할 수 있다. 
		for (String str : set2) {
			System.out.println(str);
		}
	}
}
