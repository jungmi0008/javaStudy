package org.comstudy21.day18;
//������ 30�϶� ������ ���߰� 60�϶� �ٽ� ���� ������ ��� ���ư�
class MyThread2 extends Thread {
	// run�޼ҵ� ������
	@Override
	public void run() {
		int i = 0;
		while(i<100) {
			try {
				Thread.sleep(100);
				if(i== 10) {
					synchronized (this) { // ���ü� ���� ������(�񵿱�->����)
						//this.wait(1000);
						this.wait();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("run() => "+ this.getName() + " : " + i);
			i++;
		}
	}
}

public class Day18Ex03 {
	public static void main(String[] args) {
		//������ ��ü ���� �� ����
		Thread t = new MyThread2();
		t.start();
		
		int i = 0;
		while(i<100) {
			try {
				Thread.sleep(100);
				if(i == 30) {
					synchronized (t) {
						t.notify(); // ��?
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//System.out.println("main => " + Thread.currentThread().getName());
			i++;
		}
	}
}
