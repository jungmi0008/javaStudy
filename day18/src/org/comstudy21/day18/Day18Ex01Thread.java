package org.comstudy21.day18;
//����ڰ� �����ϴ� ����
//ExceptionŬ������ ��ӹ޾� ���� ���ܸ� �����.
class MyException extends Exception{
	public MyException(){
		super("MyEcxeption �߻�!");
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
