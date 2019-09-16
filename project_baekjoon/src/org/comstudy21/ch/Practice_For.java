package org.comstudy21.ch;

import java.util.Random;
import java.util.Scanner;

public class Practice_For {
	static final Scanner scan = new Scanner(System.in);
	
	public static void 구구단(String[] args) {
		System.out.println("정수 입력");
		int num = scan.nextInt();
		
		
		for (int i = 1; i < 10; i++) {
			System.out.println(num + "*" + i +" = "+(num * i));
		}

	}
	public static void 합01(String[] args) {
		//15552번 문제 bufferedread 이용하여 빠른 계산도 가능하다.
		System.out.println("정수 입력");
		int limit = scan.nextInt();
		
		for (int i = 1; i < limit; i++) { //입력한 제한 안에서 입력하는 두 정수를 더해서 나옴
			int A = scan.nextInt();
			int B = scan.nextInt();
			System.out.println(A+B);
		}
}
	public static void 합02(String[] args) {
		System.out.println("N입력>");
		int N = scan.nextInt();
		int total = 0;
		
		for (int i = 1; i <= N; i++) {
			total= total +i;
		}
		System.out.println(total);
	}
	public static void 기찍N(String[] args) {
		System.out.print("정수 입력>");
		int N = scan.nextInt();
		
		for (int i = 0; i < N; i++) {
			System.out.println(N-i);
		}
	}
	public static void baekjoon1110(String[] args) {
		//백준 1110번
		//0보다 크거나 같고,99보다 작거나 같은 정수가 주어질 때 다음과 같은 연산을 할 수 있다.
		//먼저 주어진 수가 10보다 작다면 앞에 0을 붙여 두 자리 수로 만들고,각 자리의 숫자를 더한다.
		//그 다음,주어진 수의 가장 오른쪽 자리 수와 앞에서 구한 합의 가장 오른쪽 자리 수를 이어 붙이면 새로운 수를 만들 수 있다.
		//이를 반복하여 처음 입력한 수와 같아지려면 몇번을 하는가?
		
		System.out.println("두자리 정수를 입력하세요");
		int num = scan.nextInt();
		
		int cnt = 1;
		int chk = num;    //반복문을 거치고 나서 원래 입력한 수에 도달하는지 보기 위해
		
		while(true){	  //몇번이나 돌리게 될지 모르기 때문에 while(true)(무한루프)를 이용할 수 있다.
			int first = num%10;//1의 자리
			int second = num/10;//10의 자리
			num = first*10+(first+second)%10;
			
			if(num==chk) //if문이 없으면 무한루프가 된다. if문을 만족시키면 while이 중단된다.
				break;
			else
				cnt++;
			
		}//end of while
		System.out.println(cnt);		
	}	//flag를 이용할 수도 있다.
	
}


