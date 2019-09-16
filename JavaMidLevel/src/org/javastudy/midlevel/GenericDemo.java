package org.javastudy.midlevel;

class StrudentInfo{
	public int grade;
	//������ ���
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
//Object Ÿ���� info�� ����� �Ǹ� ��Ÿ�ӿ����� ����Ƿ� ���׸��� ����ؾ��Ѵ�.

class Person<T>{
	public T info;
	Person(T info){
		this.info = info;
	}
}
public class GenericDemo {
	public static void main(String[] args) {
		//EmployeeInfoŸ������ ���������Ƿ� info Ÿ���� EmployeeInfo��.
		Person<EmployeeInfo> p1 = new Person<EmployeeInfo>(new EmployeeInfo(1));
		EmployeeInfo ei1 = p1.info;
		System.out.println(ei1.rank);
		
		Person<String> p2 = new Person<String>("����");
		String ei2 = p2.info;
		//System.out.println(ei2.rank); ����
	}
}
