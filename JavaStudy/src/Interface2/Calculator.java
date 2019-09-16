package Interface2;
//자바8부터 default메소드와 static메소드를 구현할 수 있다.
public interface Calculator {
	public int plus(int i, int j);
	public int multiple(int i, int j);
	
	//원래 인터페이스는 추상클래스만 가지기 때문에 인터페이스 내에서 메소드를 구현할 수 없다.
	//그러나 default는 구현할 수 있다.
	default int exec(int i, int j){
		return i+j;
	}
	public static int exec2(int i , int j){
		return i*j;
	}
}
