package Interface;

public class LedExam {

	public static void main(String[] args) {
		TV tv = new LedTV();	//�������̽��� TV�� ��������Ÿ���� �� �� �ִ�. 
		tv.changeChannel(8);	//TV�� ������ �ִ� ��ɵ鸸 ����� �� �ִ�.
		tv.changeVolume(38);
		tv.turnOff();
		tv.turnOn();
		
		//���� ��� ���TV �� �پ��� ������ tvŬ�������� ����� �������̽��� ������ �� �ִ�.
	}

}
