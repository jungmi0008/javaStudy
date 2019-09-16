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
				//��ǻ�Ͱ� �ʹ� ������ �߰� �����ؼ� �����Ͻ� ���� �����ϱ� ����
				}else if(i<8){
					synchronized (this) {
						this.wait();	//i�� 6�̻���ʹ� ��� ���߰� �ߴ�.
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
