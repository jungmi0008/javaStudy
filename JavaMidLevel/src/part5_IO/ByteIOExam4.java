package part5_IO;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class ByteIOExam4 {

	public static void main(String[] args) {
		try(
			DataInputStream in = new DataInputStream(new FileInputStream("data.txt"));
			){
			int i = in.readInt();
			boolean b = in.readBoolean();
			double d = in.readDouble();
			
			System.out.println(i);
			System.out.println(b);
			System.out.println(d);
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
//��Ʈ���� �ǹ�
//�ڹٿ����� �����̳� �ܼ��� ������� ���� �ٷ��� �ʰ�, ��Ʈ��(stream)�̶�� �帧�� ���� �ٷ�ϴ�.
//��Ʈ��(stream)�̶� ������ �Է��̳� ����� ǥ���� �������� �̻�ȭ�� �帧�� �ǹ��մϴ�. 
//��, ��Ʈ���� �ü���� ���� �����Ǵ� ������ ���� ���� �ǹ��ϸ�, �߰� �Ű��� ������ �մϴ�.
