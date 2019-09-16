package part5_IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * IO는 Byte와 Char로 나뉜다.
 * 4가지 추상클래스(InputStream,OutputStreamReader,Reader,Writer)를 받아들이는 생성자가 있다면, 다양한 입출력방법을 제공하는 클래스입니다.
 * 4가지 클래스를 받아들이는 생성자가 없다면, 어디로부터 입력받을 것인지, 어디에 쓸것인지를 나타내는 클래스입니다.
 * 어디로부터, 어디에라는 대상을 지정할 수 있는 IO클래스들이 있다. 이런 클래스를 장식대상 클래스라고 한다.
 * pintln(),readLine()과 같이 다양한 방식으로 입력하고, 출력하는 기능을 제공하는 장식하는 클래스가 있다.
 * 
 * IO는 데코레이터 패턴으로 만들어졌기 때문에 장식이라는 말을 쓴다.
 */
public class ByteIOExam1 {
//	파일로 부터 1byte씩 읽어들여 파일에 1byte씩 저장하는 프로그램
//	byte형은 1byte, int형은 4byte
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		
		//FileInptStream 파일로부터 객체를 읽어들인다.
		FileInputStream fis = null;
		//FileInptStream 파일을 사용하는 객체의 역할을 한다.
		FileOutputStream fos = null;
		
		try {
			//우리는 이 클래스에 있는 모든 내용을 byte.txt를 만들고 그곳에 넣어줄 것이다.
			fis = new FileInputStream("src/part5_IO/ByteIOExam1.java");		//파일경로를 써 넣어준다.
			fos = new FileOutputStream("byte.txt");		//경로를 쓰지 않으면 해당 패키지 아래에 파일이 생긴다.
			
			//읽어들인 값을 담기위해서 변수를 선언
			int readData = -1;
			//읽어들인 데이터를 readData에 담는다.  그리고 그 값이 -1(EOF일 때 리턴되는 값)이 되면 반복문이 끝나게 한다.
			while((readData = fis.read())!= -1) {
				fos.write(readData);
			}
		
		} catch (FileNotFoundException e) {		//파일이 없을 경우에 생기는 예외 처리
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
//FileInputStream의  read()메소드는 1byte씩 읽을 수 있다.
//또한 리턴하는 값이  정수형이다. 정수의 4byte중 마지막 byte에다가 읽어들인 1byte를 저장한다.
//읽어들일 값이 있다면 항상 양수를 리턴하지만  더이상 읽어들일 것이 없을때 -1을 리턴한다.

//++ read()의 리턴 타입이 int인 이유 ++
//Stream은 EOF일 때 -1을 리턴하는데, byte에서는 -1이 유효하기 때문에 EOF임을 제대로 나타내지 못한다. 
//*컴퓨팅에서, 파일 끝(End of File, EOF)는 데이터 소스로부터 더 이상 읽을 수 있는 데이터가 없음을 나타낸다.

//read()는 추상메소드인 이유는  InputStream의 어느 서브클래스에서도 데이터를 얻어오기 위함이다.

