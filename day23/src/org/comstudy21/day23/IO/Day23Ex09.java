package org.comstudy21.day23.IO;

import java.io.File;
import java.io.IOException;

public class Day23Ex09 {
	public static void main(String[] args) throws IOException {
		String dir = "C:\\Users\\stu\\workspace";
		String path = "testFile.txt";
		
		File file = new File(path);
		if(file.exists()){	//���� ���� Ȯ��
			System.out.println("������ �����մϴ�.");
			if(file.delete()){	//���� �����
				System.out.println("������ ���ŵǾ����ϴ�.");
			}
		}else{
			System.out.println("������ ����");
			if(file.createNewFile())	//���� �����
				System.out.println("�������� ������ϴ�");
			}
		
		File directory = new File(dir);
		if(directory.isDirectory()){
			System.out.println("���丮�Դϴ�.");
			String[] fileList = directory.list();
			for (String filename : fileList) {
				System.out.println(filename);
			}
		}
	}
	
	
}
