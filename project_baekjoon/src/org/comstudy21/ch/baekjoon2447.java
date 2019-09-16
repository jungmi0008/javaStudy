package org.comstudy21.ch;

import java.util.Scanner;

public class baekjoon2447 {
	//백준 2447번 별찍기-10
	//정답 봐도 모르겠음
	//N이 3일 때를 가장 기본을 생각하고 그걸 하나의 *이라고 간주해서 그 패턴에 넣고 싶은데 그게 안됨
	//별찍기11 참고하기
	//분할정복 방법으로 하려고 했는데...
	
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
