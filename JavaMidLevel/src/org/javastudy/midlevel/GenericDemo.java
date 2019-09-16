package org.javastudy.midlevel;

class StrudentInfo{
	public int grade;
	//생성자 블록
	StrudentInfo(int grade){
		this.grade = grade;
	}
}
class EmployeeInfo{
	public int rank;
	public EmployeeInfo(int rank){
		this.rank = rank;
	}
}
//Object 타입의 info를 만들게 되면 런타임에러가 생기므로 제네릭을 사용해야한다.

class Person<T>{
	public T info;
	Person(T info){
		this.info = info;
	}
}
public class GenericDemo {
	public static void main(String[] args) {
		//EmployeeInfo타입으로 설정했으므로 info 타입이 EmployeeInfo다.
		Person<EmployeeInfo> p1 = new Person<EmployeeInfo>(new EmployeeInfo(1));
		EmployeeInfo ei1 = p1.info;
		System.out.println(ei1.rank);
		
		Person<String> p2 = new Person<String>("부장");
		String ei2 = p2.info;
		//System.out.println(ei2.rank); 오류
	}
}
