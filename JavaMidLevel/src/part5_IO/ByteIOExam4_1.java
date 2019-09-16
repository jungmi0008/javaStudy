package part5_IO;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;

public class ByteIOExam4_1 {
	//data.txt의 값을 읽고 sum에 더한다.
	//일단 ByteIOExam3클래스에서 int값만 넣고 실행해야 제대로 동작한다.
	public static int read3() {
		int sum = 0;
		try(
			DataInputStream ex = new DataInputStream(new FileInputStream("data.txt"));
			){
//			int arr[] = new int[3];
//	        for(int i = 0; i<3; i++){	//data.txt에 몇 개의 정수값이 있는지 알때는 유효
//	            arr[i] = ex.readInt();
//	            sum += arr[i];
			int readData;	//***다른 예제에서 이걸 -1로 지정한 이유를 모르겠음
			while((readData = ex.readInt())!= -1)	//EOF가 되면 read가 -1을 반환하므로
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
