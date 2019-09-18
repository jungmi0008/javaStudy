package org.comstudy21.day20;

import java.util.*;

public class Day20Ex01Hashtable {
	public static void main(String[] args) {
		//�ؽ����̺��� ������ ���� ������ ����� ������� ������ �ʴ´�.
		//���� ����Ʈ�� �Է��� �ϰ� �� ���� Collection.sort�ؾ��Ѵ�.
		Hashtable<String, String> map = new Hashtable();
		map.put("ȫ�浿", "010-1111-1111");
		map.put("��浿", "010-2222-2222");
		map.put("�̱浿", "010-3333-3333");
		map.put("�ڱ浿", "010-4444-4444");
		map.put("��浿", "010-5555-5555");
		
		System.out.println(map.size());
		
		//Enumeration interface generates a series of elements, one at a time. Successive calls to the nextElement 
		Enumeration<String> keys = map.keys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			System.out.println(key+":"+map.get(key));
			
			
		}
	}
}
