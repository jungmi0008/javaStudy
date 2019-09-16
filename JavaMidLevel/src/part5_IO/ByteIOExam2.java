package part5_IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteIOExam2 {

	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();	//현재시간을 long타입으로 반환한다.
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("src/part5_IO/ByteIOExam1.java");		
			fos = new FileOutputStream("byte.txt");		
			
			int readCount = -1;
			byte[] buffer = new byte[512];	//최대 512byte를 읽어들이게 한다.
			while((readCount = fis.read(buffer))!= -1) {
				fos.write(buffer,0,readCount);	
			}								//1byte씩 읽을 때보다 훨씬 수행시간이 짧아진다.
			
		} catch (FileNotFoundException e) {		
			e.printStackTrace();
		
		}finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
	}
}
//1byte를 읽는다고 해도 512byte를 읽어오고 그중 1byte를 전달하고 나머지 511을 버린다.
//이를 반복하다보니 한번에 512byte을 읽게해준다면 속도가 빨라져 성능이 좋아지게 된다.


