package org.comstudy21.day23.IO;

import java.io.File;
import java.io.IOException;

public class Day23Ex09 {
	public static void main(String[] args) throws IOException {
		String dir = "C:\\Users\\stu\\workspace";
		String path = "testFile.txt";
		
		File file = new File(path);
		if(file.exists()){	//파일 존재 확인
			System.out.println("파일이 존재합니다.");
			if(file.delete()){	//파일 지우기
				System.out.println("파일이 제거되었습니다.");
			}
		}else{
			System.out.println("파일이 없다");
			if(file.createNewFile())	//파일 만들기
				System.out.println("새파일이 생겼습니다");
			}
		
		File directory = new File(dir);
		if(directory.isDirectory()){
			System.out.println("디렉토리입니다.");
			String[] fileList = directory.list();
			for (String filename : fileList) {
				System.out.println(filename);
			}
		}
	}
	
	
}
