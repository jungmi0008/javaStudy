package part7_Thread;

public class TheadExam2 {

	public static void main(String[] args) {
		 MyThread2 r1 = new MyThread2("*");
         MyThread2 r2 = new MyThread2("-");
         
       //Runnable���� start��� �޼ҵ尡 ���� run()�޼ҵ常 �ִ�
       //�׷��� Thread��ü�� �����ؾ��Ѵ�.
         Thread t1 = new Thread(r1);
         Thread t2 = new Thread(r2);

         t1.start();
         t2.start();
         System.out.print("!!!!!");  
	}
}
//Runnable�� ���� ����
//�ڹٴ� ���ϻ�Ӹ� �����Ѵ�. �׷��� �̹� �ٸ� ���� ������� ��쿡 �����带 �� ����� �� ���� ������ 
//�������̽��� Runnable�� ����Ѵ�.