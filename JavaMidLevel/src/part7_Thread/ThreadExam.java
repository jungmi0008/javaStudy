package part7_Thread;
/*
 * 
 */
public class ThreadExam {
	public static void main(String[] args) {
		MyThread1 t1 = new MyThread1("*");	//���ڰ� ������ ������ �ӵ��� ��µǱ� ������ �ֿܼ� �����ϰ� ������.
		MyThread1 t2 = new MyThread1("-");
		
		t1.start();
		t2.start();
//		�����尡 ������ ����  start()�� �־���Ѵ�. run()���� ȣ���ϴ� ���� �ƴϴ�.
		
		System.out.println("���ξ����尡 ����");
	}
}
//������ ���ᰡ �Ǿ�������� �ٸ� ������� ��� �����Ѵ�.
//��������� ������ ����� �ʿ��ϴ�.
