package Interface2;

public class MyCal implements Calculator {

	@Override
	public int plus(int i, int j) {
		// TODO Auto-generated method stub
		return i+j;
	}

	@Override
	public int multiple(int i, int j) {
		// TODO Auto-generated method stub
		return i*j;
	}
	//default������ �������̵��� �����ϴ�.
	public int exec(int i, int j){
		return i*j;
	}
	//static�� �������̵��� �ȵȴ�.
	public int exec2(int i , int j){
		return i+j;
	}
}
