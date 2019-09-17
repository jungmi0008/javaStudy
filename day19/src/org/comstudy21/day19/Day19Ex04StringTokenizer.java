package org.comstudy21.day19;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Day19Ex04StringTokenizer {
	public static void main(String[] args) {
		String str = "01|ȫ�浿|����� ���� ���ϵ�|010-1111-1111";	//���ڷ� ������ �����־���.
		StringTokenizer st = new StringTokenizer(str,"|");
		
		ArrayList<String> list = new ArrayList<>();
		
		while(st.hasMoreTokens()){
//			System.out.println(st.nextToken());
			list.add(st.nextToken());
		}
		
		String titles[] = {"��ȣ","����","�ּ�","��ȭ"};
		for (int i = 0; i < list.size(); i++) {
			System.out.println(titles[i]+":"+list.get(i));
		}
		
//		for(String s : list){
//			System.out.println(s);
//		}
	}
}
