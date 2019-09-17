package org.comstudy21.day19;

import java.util.*;
public class Day19Ex05Set {
	static Random rand = new Random();
	
	public static void test(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("���");
		set.add("�ٳ���");
		set.add("������");
		set.add("����");
		set.add("�ٳ���");
		
		System.out.println(set.size());
		
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
		String[] arr = new String[set.size()];
		set.toArray(arr);	//Set�� �ִ� �Ÿ� array�� �����.
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	public static void main(String[] args) {
		//�ζǹ�ȣ ������
		//Set�� �������̽� HashSet�� Ŭ����
		HashSet<Integer> lotto = new HashSet<>();
		do{
			lotto.add(1+rand.nextInt(45));
		}while((lotto.size())<6);
		
		//�̷��� �ص� ����� �Ǳ�� �Ѵ�.
		System.out.println(lotto);
//		
//		Integer[] arr = new Integer[lotto.size()];
//		lotto.toArray(arr);
//		System.out.println(Arrays.toString(arr));
	}
}
