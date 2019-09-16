package org.javastudy.midlevel;
//제네릭
public class BoxExam {

	public static void main(String[] args) {
//		Box box = new Box();
//		box.setObj(new Object());
//		Object obj = box.getObj();
//		
//		box에 문자열을 넉고 싶은 경우
//		box.setObj("hello");				//넣을 때는 모든 객체를 넣을 수 있다.
//		String str = (String)box.getObj();	//하지만 다시 꺼내올 때에는 Object타입이어야 한다. 형변환 필요
//		System.out.println(str);
//		
//		box.setObj(1);
//		int value = (int)box.getObj();
//		System.out.println(value);
		
		//어떤 Object든 받을 수 있다.
		Box<Object> box = new Box<>();
		box.setObj(new Object());
		Object obj = box.getObj();
		
		//문자열만 받는다.
		Box<String> box2 = new Box<>();
		box2.setObj("hello");
		box2.getObj();
		
		//정수형만 받는다.
		Box<Integer> box3 = new Box<>();
		box3.setObj(1);
		box3.getObj();
	}
}
