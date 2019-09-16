package org.comstudy21.ch;

	public class baekjoon4673 {
	//백준 4673번 셀프넘버
	static int d(int n) {		//n이라는 생성자를 가지고 셀프넘버를 생성하는 함수를 내가 만든다.
		int result = n;			
			
		while(n>0){				//n을 줄여나간다는 발상이 필요.
			result += n%10;
			n /= 10;
		}
		return result;		//이 숫자가 d(n)이 된다. 
	}
	public static void main(String[] args) {
		int[] arr = new int [10001];
				
		for (int i = 0; i < arr.length; i++) {
			int result = d(i);		//result값을 구하기 위해서 d(n)함수를 이용할 수 있다.
			if(result<10001) {
				arr[result] = 1;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == 0) {
				System.out.println(i);
			}
		}
	}
	/*
	public class baekjoon4673 {
		static void d(int n) {
			int result = 0;
			int[] arr = new int [10000];
			
			while(result<10000) {
				result = n+(n%10)+(n/10);	// 이렇게 공식을 세우면 3자리 수에서 막힌다.
				arr[result+1] = 1;			// 아직도 나머지를 이용하는 부분에서 이해도가 부족하다.
				n++;
			}
			for (int i = 0; i < arr.length; i++) {
				if(arr[i]!=1) {
				System.out.println(arr[i]);
				}
			}
		}
		
		public static void main(String[] args) {
			int n = 0;
			d(n);
			
		}
	}
	*/
	}

