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
	//default였지만 오버라이딩이 가능하다.
	public int exec(int i, int j){
		return i*j;
	}
	//static은 오버라이딩이 안된다.
	public int exec2(int i , int j){
		return i+j;
	}
}
