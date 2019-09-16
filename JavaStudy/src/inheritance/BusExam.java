package inheritance;

public class BusExam {

	public static void main(String[] args) {
		//Bus 클래스가 Car를 상속받으면서 아래와 같이 작동한다.
		Bus bus1 = new Bus();
		bus1.ppangppang();
		bus1.run();
		
		Bus bus2 = new Bus("경찰차");
		bus2.run();
		
		//그래서 Bus클래스 안에 run()이 없음에도 불구하고 호출할 수 있다.
		Car car1 = new Car();
		car1.run();
		//car.ppangppang();	부모클래스에서 자식클래스의 메소드를 쓸 수 는 없다. 선언된 필드도 마찬가지
		
		//***클래스 형변환***
		//부모가 자식클래스의 메소드를 쓰고 싶은 경우 이용한다.
		//1번
		Car car2 = new Bus();	//부모타입으로 생성자를 만들수는 있지만
		car2.run();				//부모클래스에 있는 메소드만 사용할 수 있다.
		//c.ppnagppang();
		
		//2번
		//Bus c2 = new Car();//자식타입으로 생성자를 만들 수는 없다.
		
		//3번
		//그래도 ppangppang메소드를 쓰고 싶다면
		Car car3 = new Bus();
		Bus b = (Bus)car3;	//부모타입의 생성자를 자식타입으로 형변환 해준다.
//		이렇게 쓸 수 있다.
//		Car car3 = new Bus();
//		((Bus)car3).ppangppang();
		b.run();
		b.ppangppang();
		
		//instanceof는 true false를 의미한다.
		//car4의 실체는 Bus인가를 묻는 질문
		Car car4 = new Bus();
		System.out.println(car4 instanceof Bus);
	}
}
