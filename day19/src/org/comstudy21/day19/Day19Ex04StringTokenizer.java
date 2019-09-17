package org.comstudy21.day19;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Day19Ex04StringTokenizer {
	public static void main(String[] args) {
		String str = "01|홍길동|서울시 은평구 응암동|010-1111-1111";	//문자로 구분을 지어주었다.
		StringTokenizer st = new StringTokenizer(str,"|");
		
		ArrayList<String> list = new ArrayList<>();
		
		while(st.hasMoreTokens()){
//			System.out.println(st.nextToken());
			list.add(st.nextToken());
		}
		
		String titles[] = {"번호","성명","주소","전화"};
		for (int i = 0; i < list.size(); i++) {
			System.out.println(titles[i]+":"+list.get(i));
		}
		
//		for(String s : list){
//			System.out.println(s);
//		}
	}
}
