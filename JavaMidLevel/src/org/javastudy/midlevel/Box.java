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

//���׸� ����� ���
public class Box<E> {
	private E obj;
	
	public void setObj(E obj) {
		this.obj = obj;
	}
	
	public E getObj() {
		return obj;
	}
}
//Box�� ���� Ŭ���� E�� ����ϰڴٴ� �ǹ�
//������ Ÿ������ �����ϰ�, ���ÿ��� ��ü���� Ÿ���� ���������ν� 
//�پ��� Ÿ���� Ŭ������ �̿��ϴ� Ŭ������ ���� �� �ִ�.
