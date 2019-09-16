package part5_IO;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;

public class ByteIOExam4_1 {
	//data.txt�� ���� �а� sum�� ���Ѵ�.
	//�ϴ� ByteIOExam3Ŭ�������� int���� �ְ� �����ؾ� ����� �����Ѵ�.
	public static int read3() {
		int sum = 0;
		try(
			DataInputStream ex = new DataInputStream(new FileInputStream("data.txt"));
			){
//			int arr[] = new int[3];
//	        for(int i = 0; i<3; i++){	//data.txt�� �� ���� �������� �ִ��� �˶��� ��ȿ
//	            arr[i] = ex.readInt();
//	            sum += arr[i];
			int readData;	//***�ٸ� �������� �̰� -1�� ������ ������ �𸣰���
			while((readData = ex.readInt())!= -1)	//EOF�� �Ǹ� read�� -1�� ��ȯ�ϹǷ�
			{
				sum += readData;
	        }
			ex.close();
		}catch(Exception e){
//			e.printStackTrace();
		}
		return sum;
	}
	public static void main(String[] args) {
		int result = read3();
		System.out.println(result);
	}
}
