package org.javastudy.midlevel;
//���׸�
public class BoxExam {

	public static void main(String[] args) {
//		Box box = new Box();
//		box.setObj(new Object());
//		Object obj = box.getObj();
//		
//		box�� ���ڿ��� �˰� ���� ���
//		box.setObj("hello");				//���� ���� ��� ��ü�� ���� �� �ִ�.
//		String str = (String)box.getObj();	//������ �ٽ� ������ ������ ObjectŸ���̾�� �Ѵ�. ����ȯ �ʿ�
//		System.out.println(str);
//		
//		box.setObj(1);
//		int value = (int)box.getObj();
//		System.out.println(value);
		
		//� Object�� ���� �� �ִ�.
		Box<Object> box = new Box<>();
		box.setObj(new Object());
		Object obj = box.getObj();
		
		//���ڿ��� �޴´�.
		Box<String> box2 = new Box<>();
		box2.setObj("hello");
		box2.getObj();
		
		//�������� �޴´�.
		Box<Integer> box3 = new Box<>();
		box3.setObj(1);
		box3.getObj();
	}
}
