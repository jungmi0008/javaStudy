package Interface;

public class LedExam {

	public static void main(String[] args) {
		TV tv = new LedTV();	//인터페이스인 TV도 참조변수타입이 될 수 있다. 
		tv.changeChannel(8);	//TV가 가지고 있는 기능들만 사용할 수 있다.
		tv.changeVolume(38);
		tv.turnOff();
		tv.turnOn();
		
		//예를 들어 평면TV 등 다양한 종류의 tv클래스들을 만들고 인터페이스를 공유할 수 있다.
	}

}
