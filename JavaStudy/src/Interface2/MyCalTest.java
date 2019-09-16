package Interface2;

public class MyCalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator cal = new MyCal();
		cal.plus(3,4);
		cal.multiple(3, 4);
		
		//default
		int c = cal.exec(5, 6);
		System.out.println(c);
		
		//static
		int c1 = Calculator.exec2(3,4);
		System.out.println(c1);
		//cal.exec2(3,4); 이런식으로 호출할 수 없다.
	}
}
//인터페이스가 변경되면 그 인터페이스를 구현하는 모든 클래스들이 수정되어야한다.
//그래서 변경 가능성이 있는 것은 인터페이스 내에서 구현이 가능하다.
