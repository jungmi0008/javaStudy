package part5_IO;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
//다양한 타입의 출력
//자바 IO의 메소드를 사용하면 close();로 닫아주어야한다.
//하지만 예외가 생기지 않는 경우에는 자동으로 닫아줄 수 있는데 try-with-resources가 그에 해당한다.

public class ByteIOExam3 {
//data.txt에 값을 넣는다. 이를 읽어오는 클래스는 ByteIOExam4
//값을 읽어오는 read는 Input계열 값을 써넣는 write는 Output계열 
	
	public static void main(String[] args) {
		try (
			//io 객체 선언
			DataOutputStream out = new  DataOutputStream(new FileOutputStream("data.txt"));
			){
			//io 객체 사용
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
//다양한 타입을 불러들일 수 있는 객체.
//DataOutputStream이라는 클래스는 OutputStream을 매개변수로 받는 생성자를 가지고 있다.

//DataOutputStream(OutputStream outputStream){ }
//DataOutputStream(new FileOutputStream()); 
//즉 OutputStream의 자손이라면 무엇이든지 받아 들인다는 소리.
//OutputStream은 장식 대상의 클래스고  DataOutputStream은 장식하는 클래스다.
//장식하는 클래스는 다양한 메소드를 가진다.

//java.io.OutputStream
//		java.io.FilterOutputStream
//				java.io.DataOutputStream

//java.io.OutputStream
//			java.io.FileOutputStream

//원래는 문자형인데 데이터 타입으로 했기때문에 읽어낼때도 데이터 타입으로 읽도록 만들어야 data.txt에 제대로 된 값을 불러올 수 있다.