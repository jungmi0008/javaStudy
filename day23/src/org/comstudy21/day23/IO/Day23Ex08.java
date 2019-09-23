package org.comstudy21.day23.IO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day23Ex08 {
	public static void main(String[] args) throws IOException {
		int i = 0;
		File file = new File("sample.txt");
		FileReader fr = null;
		FileWriter fw = null;
		InputStreamReader isr = null;
		
		//키보드에서 입력을 받고 쓴다.
		isr = new InputStreamReader(System.in);
		fw = new FileWriter(file,true);
		
		while((i = isr.read())!=-1){
			fw.write(i);
		}
		
		fw.flush();	//입력받은 버퍼를 파일에 내보낸다.
		
		//읽는다.
		fr = new FileReader(file);
		
		while((i = fr.read())!=-1){
			System.out.println((char)i);
		}
		
		if(isr != null) isr.close();
		if(fr != null) fr.close();
		if(fw != null) fw.close();
	}
}
