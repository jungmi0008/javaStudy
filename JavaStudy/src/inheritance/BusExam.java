package inheritance;

public class BusExam {

	public static void main(String[] args) {
		//Bus Ŭ������ Car�� ��ӹ����鼭 �Ʒ��� ���� �۵��Ѵ�.
		Bus bus1 = new Bus();
		bus1.ppangppang();
		bus1.run();
		
		Bus bus2 = new Bus("������");
		bus2.run();
		
		//�׷��� BusŬ���� �ȿ� run()�� �������� �ұ��ϰ� ȣ���� �� �ִ�.
		Car car1 = new Car();
		car1.run();
		//car.ppangppang();	�θ�Ŭ�������� �ڽ�Ŭ������ �޼ҵ带 �� �� �� ����. ����� �ʵ嵵 ��������
		
		//***Ŭ���� ����ȯ***
		//�θ� �ڽ�Ŭ������ �޼ҵ带 ���� ���� ��� �̿��Ѵ�.
		//1��
		Car car2 = new Bus();	//�θ�Ÿ������ �����ڸ� ������� ������
		car2.run();				//�θ�Ŭ������ �ִ� �޼ҵ常 ����� �� �ִ�.
		//c.ppnagppang();
		
		//2��
		//Bus c2 = new Car();//�ڽ�Ÿ������ �����ڸ� ���� ���� ����.
		
		//3��
		//�׷��� ppangppang�޼ҵ带 ���� �ʹٸ�
		Car car3 = new Bus();
		Bus b = (Bus)car3;	//�θ�Ÿ���� �����ڸ� �ڽ�Ÿ������ ����ȯ ���ش�.
//		�̷��� �� �� �ִ�.
//		Car car3 = new Bus();
//		((Bus)car3).ppangppang();
		b.run();
		b.ppangppang();
		
		//instanceof�� true false�� �ǹ��Ѵ�.
		//car4�� ��ü�� Bus�ΰ��� ���� ����
		Car car4 = new Bus();
		System.out.println(car4 instanceof Bus);
	}
}
