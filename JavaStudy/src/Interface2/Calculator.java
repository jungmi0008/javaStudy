package Interface2;
//�ڹ�8���� default�޼ҵ�� static�޼ҵ带 ������ �� �ִ�.
public interface Calculator {
	public int plus(int i, int j);
	public int multiple(int i, int j);
	
	//���� �������̽��� �߻�Ŭ������ ������ ������ �������̽� ������ �޼ҵ带 ������ �� ����.
	//�׷��� default�� ������ �� �ִ�.
	default int exec(int i, int j){
		return i+j;
	}
	public static int exec2(int i , int j){
		return i*j;
	}
}
