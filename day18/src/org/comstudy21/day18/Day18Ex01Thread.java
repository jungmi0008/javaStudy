package org.comstudy21.day18;
//사용자가 지정하는 예외
//Exception클래스를 상속받아 직접 예외를 만든다.
class MyException extends Exception{
	public MyException(){
		super("MyEcxeption 발생!");
	}
}
public class Day18Ex01Thread {
	static void ExceptionManager() throws MyException{
		throw new MyException();
//		try {
//			throw new MyException();
//		} catch (MyException e) {
//			System.out.println(e.getMessage());
//		}
	}
	public static void main(String[] args) {
		
	}
}
