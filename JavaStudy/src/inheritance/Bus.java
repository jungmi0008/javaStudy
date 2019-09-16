package inheritance;
//자식 클래스
public class Bus extends Car{
	//Bus클래스를 따로 만들때 설정하는 창에서 상속받을 부모 클래스를 정할 수 있다.
	public Bus(){
		//기본  생성자
		//super();		//부모의 생성자를 의미.이걸 쓰면 Car의 기본생성자를 써줄 필요가 없다.
		super("소방차");	//매개변수 있는 경우
	}
	public Bus(String name){
		super(name);
	}
	public void ppangppang(){
		System.out.println("ppangppang");
	}
}
	