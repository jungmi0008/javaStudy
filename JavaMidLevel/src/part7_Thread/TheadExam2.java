package part7_Thread;

public class TheadExam2 {

	public static void main(String[] args) {
		 MyThread2 r1 = new MyThread2("*");
         MyThread2 r2 = new MyThread2("-");
         
       //Runnable에는 start라는 메소드가 없고 run()메소드만 있다
       //그래서 Thread객체를 생성해야한다.
         Thread t1 = new Thread(r1);
         Thread t2 = new Thread(r2);

         t1.start();
         t2.start();
         System.out.print("!!!!!");  
	}
}
//Runnable을 쓰는 이유
//자바는 단일상속만 지원한다. 그래서 이미 다른 것을 상속했을 경우에 쓰레드를 또 상속할 수 없기 때문에 
//인터페이스인 Runnable을 사용한다.