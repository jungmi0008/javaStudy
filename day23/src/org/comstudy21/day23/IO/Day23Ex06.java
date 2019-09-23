package org.comstudy21.day23.IO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Day23Ex06 {
	
	public static void test01(String[] args) {
		int data = 0;
		InputStream myln = System.in;
		OutputStream myOut = System.out;
		System.out.println("데이터를 입력하세요. 끝내려면 [Ctrl]+Z를 누르세요");
		try {
			while((data=myln.read())!=-1){
				myOut.write(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
