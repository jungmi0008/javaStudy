package org.comstudy21.day23.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day23Ex05 {
	
	public static void test01(String[] args) throws IOException {
		//문자열 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Reader라는 클래스 안에 BufferedReader클래스와 InputStreamReader클래스가 있다. 
		//read라는 메소드가 BufferedReader클래스 안에 있고.
		//InputStreamReader에는 InputStream in을 받는 생성자가 있어 System.in을 받게 된다.
		String name = null;
		String address = null;
		
		System.out.println("성명입력>>");
		name = br.readLine();
		System.out.println("주소입력>>");
		address = br.readLine();
		
		System.out.printf("성명: %s\n",name);
		System.out.printf("주소: %s\n",address);
	}
	
	public static void test02(String[] args) throws IOException{
		//정수형 입력받기		
		System.out.println("Input >>");
		int ch = 0;
		int num = 0;
		while((ch = System.in.read())!= '\n'){	//엔터 전까지를 받는다. 한 자리수씩 받는다.
			if(ch>='0' && ch<='9'){
			num = num*10;
			num = num + ch - '0';
			}
//			System.out.println(num);
		}
		System.out.println("num =>"+num);
	}
	public static void main(String[] args) throws Exception {
		//byte타입을 문자열로 바꾸고 다시 정수형으로 변환
		byte[] by = new byte[256];
		
		System.out.println("Input>>>");
		System.in.read(by);
		
		String str = new String(by).trim();
//		System.out.println(str);
		System.out.println("Number =>"+ new Integer(str));
	}
}
