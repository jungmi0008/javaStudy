package org.javastudy.midlevel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExam {

	public static void main(String[] args) {
		//Map<key,value>
		//key�� �ߺ��� �� ����.
		Map<String, String>map = new HashMap<>();
		map.put("001", "kim");
		map.put("002", "lee");
		map.put("003", "shoi");
		
		map.put("001", "kang");	//�ߺ��� ���� �־��.
		
		System.out.println(map.size());	//3�� ���´�.
		
		System.out.println(map.get("001"));	//���߿� ���� ���� ������ �ȴ�.
		System.out.println(map.get("002"));	//get�� �������� �ҷ����� ���.
		
		//value���� get()���� �����ϰ� ���� �� ������
		//key���� ���� Set�� �־��ش����� iterator�� ������� �Ѵ�.
		
		//keySet�� Ű ���� ��� ������ �־��ִ� ��.
		Set<String> keys = map.keySet();
		
		//Set�� ���� �־����Ƿ� iterator�� ���� �����ش�.
		Iterator<String> iter = keys.iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			String value = map.get(key);
			System.out.println(key+":"+value);
			
		}
	}

}
