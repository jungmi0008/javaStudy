package org.comstudy21.ch;

import java.util.Scanner;

public class baekjoon2447 {
	//���� 2447�� �����-10
	//���� ���� �𸣰���
	//N�� 3�� ���� ���� �⺻�� �����ϰ� �װ� �ϳ��� *�̶�� �����ؼ� �� ���Ͽ� �ְ� ������ �װ� �ȵ�
	//�����11 �����ϱ�
	//�������� ������� �Ϸ��� �ߴµ�...
	
	static Scanner scan = new Scanner(System.in);
	static void mkStar(int N){
		
		for (int i = 0; i < N; i++) {
			if(i < 1){
				for (int j = 0; j < N; j++) {
					System.out.print("*");
				}
				System.out.println();
			}else if(i<2){
				for (int j = 0; j < N; j++) {
					System.out.print(j<1?"*":(j<2?" ":"*"));
				}
				System.out.println();
			}else{
				for (int j = 0; j < N; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}
	public static void main(String[] args) {
		
		int N = scan.nextInt();
		
		mkStar(N);
		
	
	}
	/*
	int end = N/3;
	for (int i = 0; i < N; i++) {
		if(i < end){
			for (int j = 0; j < N; j++) {
				System.out.print("*");
			}
			System.out.println();
		}else if(i<2*end){
			for (int j = 0; j < N; j++) {
				System.out.print(j<end?"*":(j<2*end?" ":"*"));
			}
			System.out.println();
		}else{
			for (int j = 0; j < N; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	*/
}
