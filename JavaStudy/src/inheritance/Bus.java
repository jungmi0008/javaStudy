package inheritance;
//�ڽ� Ŭ����
public class Bus extends Car{
	//BusŬ������ ���� ���鶧 �����ϴ� â���� ��ӹ��� �θ� Ŭ������ ���� �� �ִ�.
	public Bus(){
		//�⺻  ������
		//super();		//�θ��� �����ڸ� �ǹ�.�̰� ���� Car�� �⺻�����ڸ� ���� �ʿ䰡 ����.
		super("�ҹ���");	//�Ű����� �ִ� ���
	}
	public Bus(String name){
		super(name);
	}
	public void ppangppang(){
		System.out.println("ppangppang");
	}
}
	