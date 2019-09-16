package part7_Thread;
/*
 * 
 */
public class ThreadExam {
	public static void main(String[] args) {
		MyThread1 t1 = new MyThread1("*");	//각자가 가지는 랜덤한 속도로 출력되기 때문에 콘솔에 랜덤하게 찍힌다.
		MyThread1 t2 = new MyThread1("-");
		
		t1.start();
		t2.start();
//		쓰레드가 시작할 때는  start()가 있어야한다. run()으로 호출하는 것이 아니다.
		
		System.out.println("메인쓰레드가 끝남");
	}
}
//메인은 종료가 되어버렸지만 다른 쓰레드는 계속 동작한다.
//쓰레드들을 끝내는 명령이 필요하다.
