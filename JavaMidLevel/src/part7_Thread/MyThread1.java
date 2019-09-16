package part7_Thread;
public class MyThread1 extends Thread{
	String str;
	public MyThread1(String str) {
		this.str = str;
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(str);
			try {
				if(i<6){
				Thread.sleep((int)Math.random()*1000);
				//컴퓨터가 너무 빠르니 중간 쉬게해서 컴파일시 보기 좋게하기 위함
				}else if(i<8){
					synchronized (this) {
						this.wait();	//i가 6이상부터는 잠시 멈추게 했다.
					}
				}else{
					synchronized (this) {
						this.notify();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
	}
}
