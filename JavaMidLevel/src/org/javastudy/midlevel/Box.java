package org.javastudy.midlevel;

//public class Box {
//	private Object obj;
//	
//	public void setObj(Object obj) {
//		this.obj = obj;
//	}
//	
//	public Object getObj() {
//		return obj;
//	}
//}

//제네릭 사용한 경우
public class Box<E> {
	private E obj;
	
	public void setObj(E obj) {
		this.obj = obj;
	}
	
	public E getObj() {
		return obj;
	}
}
//Box가 가상 클래스 E를 사용하겠다는 의미
//가상의 타입으로 선언하고, 사용시에는 구체적인 타입을 설정함으로써 
//다양한 타입의 클래스를 이용하는 클래스를 만들 수 있다.
