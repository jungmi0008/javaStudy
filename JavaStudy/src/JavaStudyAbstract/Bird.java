package JavaStudyAbstract;

public abstract class Bird {
	public abstract void sing();
	//메소드를 작성할 때 어떻게 구현할지 구체적인 계획이 없을 때 억지로 구현하지 않는다.
	//그 대신 abstract라는 것으로 남겨둔다.
	//추상 메소드가 만들어진 이상 해당 메소드를 가진 클래스는 추상 클래스가 된다.
	public void fly(){
		System.out.println("날다");
	}
}
