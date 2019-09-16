package org.comstudy21.day18;
//메인이 30일때 쓰레드 멈추고 60일때 다시 시작 메인은 계속 돌아감
class MyThread2 extends Thread {
	// run메소드 재정의
	@Override
	public void run() {
		int i = 0;
		while(i<100) {
			try {
				Thread.sleep(100);
				if(i== 10) {
					synchronized (this) { // 동시성 오류 방지용(비동기->동기)
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
		//쓰래드 객체 생성 및 실행
		Thread t = new MyThread2();
		t.start();
		
		int i = 0;
		while(i<100) {
			try {
				Thread.sleep(100);
				if(i == 30) {
					synchronized (t) {
						t.notify(); // 왜?
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
