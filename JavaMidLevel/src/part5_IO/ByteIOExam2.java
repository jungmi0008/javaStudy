package part5_IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteIOExam2 {

	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();	//����ð��� longŸ������ ��ȯ�Ѵ�.
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("src/part5_IO/ByteIOExam1.java");		
			fos = new FileOutputStream("byte.txt");		
			
			int readCount = -1;
			byte[] buffer = new byte[512];	//�ִ� 512byte�� �о���̰� �Ѵ�.
			while((readCount = fis.read(buffer))!= -1) {
				fos.write(buffer,0,readCount);	
			}								//1byte�� ���� ������ �ξ� ����ð��� ª������.
			
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
//1byte�� �д´ٰ� �ص� 512byte�� �о���� ���� 1byte�� �����ϰ� ������ 511�� ������.
//�̸� �ݺ��ϴٺ��� �ѹ��� 512byte�� �а����شٸ� �ӵ��� ������ ������ �������� �ȴ�.


