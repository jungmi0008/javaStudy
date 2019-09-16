package Interface;
//추상클래스와 모양새가 비슷
public interface TV {
	//인터페이스에서 정의한 변수는 모두 상수이기 때문에 나중에 구현할 때 바꿀 수 없다.
	//나중에 바뀔 가능성이 있다면 구현하는 클래스에서 변수를 선언해야한다.
	//아래의 상수에는 static final이 생략되어있다.
	public int MIN_VOULUME = 0;
	public int MAX_VOULUME = 100;
	
	//아래의 메소드는 추상메소드로 abstract가 생략되어있다.
	public void turnOn();
	public void turnOff();
	public void changeVolume(int volume);
	public void changeChannel(int channel);
}
