package org.comstudy21.day23.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day23Ex05 {
	
	public static void test01(String[] args) throws IOException {
		//���ڿ� �Է¹ޱ�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Reader��� Ŭ���� �ȿ� BufferedReaderŬ������ InputStreamReaderŬ������ �ִ�. 
		//read��� �޼ҵ尡 BufferedReaderŬ���� �ȿ� �ְ�.
		//InputStreamReader���� InputStream in�� �޴� �����ڰ� �־� System.in�� �ް� �ȴ�.
		String name = null;
		String address = null;
		
		System.out.println("�����Է�>>");
		name = br.readLine();
		System.out.println("�ּ��Է�>>");
		address = br.readLine();
		
		System.out.printf("����: %s\n",name);
		System.out.printf("�ּ�: %s\n",address);
	}
	
	public static void test02(String[] args) throws IOException{
		//������ �Է¹ޱ�		
		System.out.println("Input >>");
		int ch = 0;
		int num = 0;
		while((ch = System.in.read())!= '\n'){	//���� �������� �޴´�. �� �ڸ����� �޴´�.
			if(ch>='0' && ch<='9'){
			num = num*10;
			num = num + ch - '0';
			}
//			System.out.println(num);
		}
		System.out.println("num =>"+num);
	}
	public static void main(String[] args) throws Exception {
		//byteŸ���� ���ڿ��� �ٲٰ� �ٽ� ���������� ��ȯ
		byte[] by = new byte[256];
		
		System.out.println("Input>>>");
		System.in.read(by);
		
		String str = new String(by).trim();
//		System.out.println(str);
		System.out.println("Number =>"+ new Integer(str));
	}
}
