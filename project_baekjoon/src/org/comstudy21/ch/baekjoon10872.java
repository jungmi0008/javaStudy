package org.comstudy21.ch;

import java.util.Scanner;

public class baekjoon10872 {
	//���� 10872�� ���丮��
	static Scanner scan = new Scanner(System.in);
	static void factorial(int N){
		int result = 1;
		while (N>0) {
			result = result*N;
			N--;
		}
		System.out.println(result);
	}
	public static void main(String[] args) {
		int N;
		do{
			N = scan.nextInt();
		}while(N>12 || N<0);
		
		factorial(N);
	}

}
