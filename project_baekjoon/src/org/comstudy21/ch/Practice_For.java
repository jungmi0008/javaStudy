package org.comstudy21.ch;

import java.util.Random;
import java.util.Scanner;

public class Practice_For {
	static final Scanner scan = new Scanner(System.in);
	
	public static void ������(String[] args) {
		System.out.println("���� �Է�");
		int num = scan.nextInt();
		
		
		for (int i = 1; i < 10; i++) {
			System.out.println(num + "*" + i +" = "+(num * i));
		}

	}
	public static void ��01(String[] args) {
		//15552�� ���� bufferedread �̿��Ͽ� ���� ��굵 �����ϴ�.
		System.out.println("���� �Է�");
		int limit = scan.nextInt();
		
		for (int i = 1; i < limit; i++) { //�Է��� ���� �ȿ��� �Է��ϴ� �� ������ ���ؼ� ����
			int A = scan.nextInt();
			int B = scan.nextInt();
			System.out.println(A+B);
		}
}
	public static void ��02(String[] args) {
		System.out.println("N�Է�>");
		int N = scan.nextInt();
		int total = 0;
		
		for (int i = 1; i <= N; i++) {
			total= total +i;
		}
		System.out.println(total);
	}
	public static void ����N(String[] args) {
		System.out.print("���� �Է�>");
		int N = scan.nextInt();
		
		for (int i = 0; i < N; i++) {
			System.out.println(N-i);
		}
	}
	public static void baekjoon1110(String[] args) {
		//���� 1110��
		//0���� ũ�ų� ����,99���� �۰ų� ���� ������ �־��� �� ������ ���� ������ �� �� �ִ�.
		//���� �־��� ���� 10���� �۴ٸ� �տ� 0�� �ٿ� �� �ڸ� ���� �����,�� �ڸ��� ���ڸ� ���Ѵ�.
		//�� ����,�־��� ���� ���� ������ �ڸ� ���� �տ��� ���� ���� ���� ������ �ڸ� ���� �̾� ���̸� ���ο� ���� ���� �� �ִ�.
		//�̸� �ݺ��Ͽ� ó�� �Է��� ���� ���������� ����� �ϴ°�?
		
		System.out.println("���ڸ� ������ �Է��ϼ���");
		int num = scan.nextInt();
		
		int cnt = 1;
		int chk = num;    //�ݺ����� ��ġ�� ���� ���� �Է��� ���� �����ϴ��� ���� ����
		
		while(true){	  //����̳� ������ ���� �𸣱� ������ while(true)(���ѷ���)�� �̿��� �� �ִ�.
			int first = num%10;//1�� �ڸ�
			int second = num/10;//10�� �ڸ�
			num = first*10+(first+second)%10;
			
			if(num==chk) //if���� ������ ���ѷ����� �ȴ�. if���� ������Ű�� while�� �ߴܵȴ�.
				break;
			else
				cnt++;
			
		}//end of while
		System.out.println(cnt);		
	}	//flag�� �̿��� ���� �ִ�.
	
}


