package part5_IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CharIOExam2_1 {

	public static void main(String[] args) {
		PrintWriter pw  = null;
		String str = "�ȳ��ϼ���. PrintWriter�Դϴ�.";
        try{
        	pw = new PrintWriter(new FileWriter("test2.txt"));
        	pw.println(str);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            pw.close();
        }
	        
	}

}
