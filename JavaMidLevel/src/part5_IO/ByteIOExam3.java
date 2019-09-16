package part5_IO;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
//�پ��� Ÿ���� ���
//�ڹ� IO�� �޼ҵ带 ����ϸ� close();�� �ݾ��־���Ѵ�.
//������ ���ܰ� ������ �ʴ� ��쿡�� �ڵ����� �ݾ��� �� �ִµ� try-with-resources�� �׿� �ش��Ѵ�.

public class ByteIOExam3 {
//data.txt�� ���� �ִ´�. �̸� �о���� Ŭ������ ByteIOExam4
//���� �о���� read�� Input�迭 ���� ��ִ� write�� Output�迭 
	
	public static void main(String[] args) {
		try (
			//io ��ü ����
			DataOutputStream out = new  DataOutputStream(new FileOutputStream("data.txt"));
			){
			//io ��ü ���
			out.writeInt(100);	//4byte
//			out.writeInt(10);
//			out.writeInt(1);
			out.writeBoolean(true);	//1byte
			out.writeDouble(50.5);	//8byte
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
//++ DataOutputStream ++
//�پ��� Ÿ���� �ҷ����� �� �ִ� ��ü.
//DataOutputStream�̶�� Ŭ������ OutputStream�� �Ű������� �޴� �����ڸ� ������ �ִ�.

//DataOutputStream(OutputStream outputStream){ }
//DataOutputStream(new FileOutputStream()); 
//�� OutputStream�� �ڼ��̶�� �����̵��� �޾� ���δٴ� �Ҹ�.
//OutputStream�� ��� ����� Ŭ������  DataOutputStream�� ����ϴ� Ŭ������.
//����ϴ� Ŭ������ �پ��� �޼ҵ带 ������.

//java.io.OutputStream
//		java.io.FilterOutputStream
//				java.io.DataOutputStream

//java.io.OutputStream
//			java.io.FileOutputStream

//������ �������ε� ������ Ÿ������ �߱⶧���� �о���� ������ Ÿ������ �е��� ������ data.txt�� ����� �� ���� �ҷ��� �� �ִ�.