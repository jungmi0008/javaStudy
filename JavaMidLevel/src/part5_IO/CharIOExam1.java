package part5_IO;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

//	char���� ����� Ŭ������ Ŭ���� �̸��� Reader�� Writer�� ������.

//	BufferedReader - ���پ� �Է� �ޱ����� Ŭ����

//	System.in - Ű���忡���� �Է��� �ǹ� (InputStream Ÿ���̴�.)
//	BufferedReader Ŭ������ �����ڴ� InputStream�� �Է¹޴� �����ڰ� ����. ReaderŸ���̴�.
//	���� System.in�� BufferedReader�� �����ڿ� �ٷ� �� �� �����Ƿ� InputStreamReader Ŭ������ �̿��ؾ���.
//	InputStreamReader�� System.in�� ReaderŸ������ ��ȯ���ش�.
//	InputStreamReader�� Reader�� ��ӹް� InputStreamReader�� �����ڷ� �ޱ� �����̴�.

public class CharIOExam1 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		ByteŸ�� ����°� ��
//		DataOutputStream out = new  DataOutputStream(new FileOutputStream("data.txt"));
		String line = null;
		try {
			line = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(line);
	}

}