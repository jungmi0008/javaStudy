package org.comstudy21.day18;
//������ 30�϶� ������ ���߰� 60�϶� �ٽ� ���� ������ ��� ���ư�
class MyThread2 extends Thread {
	// run�޼ҵ� ������
	@Override
	public void run() {
		int i = 0;
		while(i<100) {
			System.out.println("run() "+ this.getName() + " : " + i);
			i++;
			try {
				Thread.sleep(100);
				if(i== 30) {
					synchronized (this) { // ���ü� ���� ������(�񵿱�->����)
						//this.wait(1000);
						this.wait();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void threadNotify() {
		synchronized(this) {
			notify();
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
				if(i == 60) {
					//���⿡�� run�� �ٽ� �����ϰ� �ȴ�.
					((MyThread2) t).threadNotify();
//					synchronized (t) {
//						t.notify();
//					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("main " + Thread.currentThread().getName()+":"+i);
			i++;
		}
	}
}
