package org.comstudy21.day23.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Day23Ex07 {
	static String file = "C:\\Users\\stu\\workspace\\output.txt";
	static String file2 = "C:\\Users\\stu\\workspace\\output2.txt";
	
	public static void main(String[] args) throws IOException {
		int data = 0;
		OutputStream myOut = System.out;
		InputStream myIn = System.in;
		FileOutputStream fos = null;
		FileInputStream fis = null;
		
			fos = new FileOutputStream(file);
			
			System.out.println("내용을 입력하세요");
			while((data = myIn.read())!=-1){
				fos.write(data);
			}
			
			fos.close();
			
			fis = new FileInputStream(file);
			fos = new FileOutputStream(file2);
			while((data = fis.read())!=-1){
				myOut.write(data);
			}
			fis.close();
			fos.close();
	}
	
	public static void test02(String[] args) throws IOException {
		int data = 0;
		FileInputStream fis = null;
		OutputStream myOut = System.out;
		
		fis = new FileInputStream(file);
		
		while((data = fis.read())!= -1){
			myOut.write(data);
		}
		
		fis.close();
		System.out.println("완료");
	}
	
	//파일을 만들어서 입력하는 방법
	public static void test01(String[] args) throws IOException{
		int data = 0;
		InputStream myIn = System.in;
		FileOutputStream fos = null;
		
		fos = new FileOutputStream(file);
		while((data = myIn.read())!=-1){
			fos.write(data);
		}
		
		fos.close();
		System.out.println("완료");
	}
	
}
