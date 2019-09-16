package part5_IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * IO�� Byte�� Char�� ������.
 * 4���� �߻�Ŭ����(InputStream,OutputStreamReader,Reader,Writer)�� �޾Ƶ��̴� �����ڰ� �ִٸ�, �پ��� ����¹���� �����ϴ� Ŭ�����Դϴ�.
 * 4���� Ŭ������ �޾Ƶ��̴� �����ڰ� ���ٸ�, ���κ��� �Է¹��� ������, ��� ���������� ��Ÿ���� Ŭ�����Դϴ�.
 * ���κ���, ��𿡶�� ����� ������ �� �ִ� IOŬ�������� �ִ�. �̷� Ŭ������ ��Ĵ�� Ŭ������� �Ѵ�.
 * pintln(),readLine()�� ���� �پ��� ������� �Է��ϰ�, ����ϴ� ����� �����ϴ� ����ϴ� Ŭ������ �ִ�.
 * 
 * IO�� ���ڷ����� �������� ��������� ������ ����̶�� ���� ����.
 */
public class ByteIOExam1 {
//	���Ϸ� ���� 1byte�� �о�鿩 ���Ͽ� 1byte�� �����ϴ� ���α׷�
//	byte���� 1byte, int���� 4byte
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		
		//FileInptStream ���Ϸκ��� ��ü�� �о���δ�.
		FileInputStream fis = null;
		//FileInptStream ������ ����ϴ� ��ü�� ������ �Ѵ�.
		FileOutputStream fos = null;
		
		try {
			//�츮�� �� Ŭ������ �ִ� ��� ������ byte.txt�� ����� �װ��� �־��� ���̴�.
			fis = new FileInputStream("src/part5_IO/ByteIOExam1.java");		//���ϰ�θ� �� �־��ش�.
			fos = new FileOutputStream("byte.txt");		//��θ� ���� ������ �ش� ��Ű�� �Ʒ��� ������ �����.
			
			//�о���� ���� ������ؼ� ������ ����
			int readData = -1;
			//�о���� �����͸� readData�� ��´�.  �׸��� �� ���� -1(EOF�� �� ���ϵǴ� ��)�� �Ǹ� �ݺ����� ������ �Ѵ�.
			while((readData = fis.read())!= -1) {
				fos.write(readData);
			}
		
		} catch (FileNotFoundException e) {		//������ ���� ��쿡 ����� ���� ó��
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
	}
}
//FileInputStream��  read()�޼ҵ�� 1byte�� ���� �� �ִ�.
//���� �����ϴ� ����  �������̴�. ������ 4byte�� ������ byte���ٰ� �о���� 1byte�� �����Ѵ�.
//�о���� ���� �ִٸ� �׻� ����� ����������  ���̻� �о���� ���� ������ -1�� �����Ѵ�.

//++ read()�� ���� Ÿ���� int�� ���� ++
//Stream�� EOF�� �� -1�� �����ϴµ�, byte������ -1�� ��ȿ�ϱ� ������ EOF���� ����� ��Ÿ���� ���Ѵ�. 
//*��ǻ�ÿ���, ���� ��(End of File, EOF)�� ������ �ҽ��κ��� �� �̻� ���� �� �ִ� �����Ͱ� ������ ��Ÿ����.

//read()�� �߻�޼ҵ��� ������  InputStream�� ��� ����Ŭ���������� �����͸� ������ �����̴�.

