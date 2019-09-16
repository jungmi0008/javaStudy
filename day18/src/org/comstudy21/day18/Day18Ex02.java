package org.comstudy21.day18;
class MyThread extends Thread {
	@Override
	public void run() {
		int i=0;
		while(i<100) {
			try {
				Thread.sleep(30); // 0.03초 마다 일시 정지
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("MyThread -> " + i++);
		}
	}
}

public class Day18Ex02 {
	public static void main(String[] args) {
		Thread t = new MyThread();
		t.start();
		
		int i=0;
		while(i<100) {
			try {
				Thread.sleep(30); // 0.03초 마다 일시 정지
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("main -> " + i++);
		}

	}
}
