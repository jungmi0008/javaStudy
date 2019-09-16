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
//스트림의 의미
//자바에서는 파일이나 콘솔의 입출력을 직접 다루지 않고, 스트림(stream)이라는 흐름을 통해 다룹니다.
//스트림(stream)이란 실제의 입력이나 출력이 표현된 데이터의 이상화된 흐름을 의미합니다. 
//즉, 스트림은 운영체제에 의해 생성되는 가상의 연결 고리를 의미하며, 중간 매개자 역할을 합니다.
