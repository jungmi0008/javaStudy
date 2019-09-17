package org.comstudy21.day19;

import java.util.*;
public class Day19Ex05Set {
	static Random rand = new Random();
	
	public static void test(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("사과");
		set.add("바나나");
		set.add("오렌지");
		set.add("딸기");
		set.add("바나나");
		
		System.out.println(set.size());
		
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
		String[] arr = new String[set.size()];
		set.toArray(arr);	//Set에 있는 거를 array로 만든다.
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	public static void main(String[] args) {
		//로또번호 생성기
		//Set은 인터페이스 HashSet은 클래스
		HashSet<Integer> lotto = new HashSet<>();
		do{
			lotto.add(1+rand.nextInt(45));
		}while((lotto.size())<6);
		
		//이렇게 해도 출력이 되기는 한다.
		System.out.println(lotto);
//		
//		Integer[] arr = new Integer[lotto.size()];
//		lotto.toArray(arr);
//		System.out.println(Arrays.toString(arr));
	}
}
