package org.javastudy.midlevel;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class setExam {
//set�� �ߺ��� ������ ����.
	
	public static void main(String[] args) {
		//set�� �������̽��̹Ƿ� HashSet���� ������ �� �ִ�.
		//�Ʒ��� ���� ���ʸ����� ���ڿ��� �ް� �ߴ�.
		//�����͸� �����ϱ� ���� add�� ����Ѵ�.
		//add�� boolean������ ����ȴ�.
		Set<String> set1 = new HashSet<>();
		boolean flag1 = set1.add("kang");
		boolean flag2 = set1.add("kim");
		boolean flag3 = set1.add("kang");
		
		//set �ڷᱸ���� ũ�⸦ �˾ƺ� �� size�� �̿��Ѵ�.
		System.out.println(set1.size());
		System.out.println(flag1);
		System.out.println(flag2);
		System.out.println(flag3);	//false�� �ߺ��� �Ǿ��ٴ� �ǹ̰� �ȴ�.
		
		//set�� �ִ� ���� �ϳ��� �������� ���� iterator�� ����.
		//hasNext�� ���� ������ �ִٸ� true�� �����Ѵ�.
		//�� true�� �� ���� ����س��� while���� �Ʒ��� �����ߴ�.
		//next()�� �ڷḦ �ϳ��� ������ �Լ���.
		Iterator<String> iter = set1.iterator();
		while(iter.hasNext()) {
			String str = iter.next();
			System.out.println(str);
		}
		
		Set<String> set2 = new HashSet<>();
		set2.add("a");
		set2.add("b");
		set2.add("c");
		
		//for-each������ �̿��ؼ� ����� �� �ִ�. 
		for (String str : set2) {
			System.out.println(str);
		}
	}
}
