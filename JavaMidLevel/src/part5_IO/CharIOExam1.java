package part5_IO;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

//	char단위 입출력 클래스는 클래스 이름이 Reader나 Writer로 끝난다.

//	BufferedReader - 한줄씩 입력 받기위한 클래스

//	System.in - 키보드에서의 입력을 의미 (InputStream 타입이다.)
//	BufferedReader 클래스의 생성자는 InputStream을 입력받는 생성자가 없다. Reader타입이다.
//	따라서 System.in은 BufferedReader의 생성자에 바로 들어갈 수 없으므로 InputStreamReader 클래스를 이용해야함.
//	InputStreamReader은 System.in을 Reader타입으로 변환해준다.
//	InputStreamReader는 Reader를 상속받고 InputStreamReader를 생성자로 받기 때문이다.

public class CharIOExam1 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Byte타입 입출력과 비교
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