package org.comstudy21.day23.IO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Day23Ex06 {
	
	public static void test01(String[] args) {
		int data = 0;
		InputStream myln = System.in;
		OutputStream myOut = System.out;
		System.out.println("�����͸� �Է��ϼ���. �������� [Ctrl]+Z�� ��������");
		try {
			while((data=myln.read())!=-1){
				myOut.write(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
