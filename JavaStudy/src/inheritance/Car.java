package inheritance;
//부모클래스
public class Car {
	public Car(){
		//기본 생성자
		//super을 썼기 때문에 생략이 가능하다.
	}
	public Car(String name){
		//매개변수를 받는 생성자 블록
		System.out.println(name+"을 받아들이는 생성자입니다.");
	}
	public void run(){
		System.out.println("run");
	}
}

