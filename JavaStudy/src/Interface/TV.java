package Interface;
//�߻�Ŭ������ ������ ���
public interface TV {
	//�������̽����� ������ ������ ��� ����̱� ������ ���߿� ������ �� �ٲ� �� ����.
	//���߿� �ٲ� ���ɼ��� �ִٸ� �����ϴ� Ŭ�������� ������ �����ؾ��Ѵ�.
	//�Ʒ��� ������� static final�� �����Ǿ��ִ�.
	public int MIN_VOULUME = 0;
	public int MAX_VOULUME = 100;
	
	//�Ʒ��� �޼ҵ�� �߻�޼ҵ�� abstract�� �����Ǿ��ִ�.
	public void turnOn();
	public void turnOff();
	public void changeVolume(int volume);
	public void changeChannel(int channel);
}
