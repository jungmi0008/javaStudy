package JavaStudyAbstract;

public class Duck extends Bird {

	@Override
	public void sing() {
		System.out.println("꽥꽥");
		//부모클래스에서 구현하지 못했던 sing메소드를 오버라이드 해서
		//자식클래스에서 구현한다.

	}

}
