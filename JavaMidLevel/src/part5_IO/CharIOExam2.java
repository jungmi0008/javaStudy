package part5_IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CharIOExam2 {
	//파일을 읽어오는 경우
	//ByteIOExam1과 비교해서 보기
	public static void main(String[] args) {
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			br = new BufferedReader(new FileReader("src/part5_IO/CharIOExam5.java"));
			pw = new PrintWriter(new FileWriter("test.txt"));
			
			String line = null;
			while((line = br.readLine())!= null){	//String이니까 null로 리턴
				pw.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pw.close();
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
