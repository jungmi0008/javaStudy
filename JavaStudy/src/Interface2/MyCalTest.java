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
		//cal.exec2(3,4); �̷������� ȣ���� �� ����.
	}
}
//�������̽��� ����Ǹ� �� �������̽��� �����ϴ� ��� Ŭ�������� �����Ǿ���Ѵ�.
//�׷��� ���� ���ɼ��� �ִ� ���� �������̽� ������ ������ �����ϴ�.
