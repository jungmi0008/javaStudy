package org.comstudy21.ch;

	public class baekjoon4673 {
	//���� 4673�� �����ѹ�
	static int d(int n) {		//n�̶�� �����ڸ� ������ �����ѹ��� �����ϴ� �Լ��� ���� �����.
		int result = n;			
			
		while(n>0){				//n�� �ٿ������ٴ� �߻��� �ʿ�.
			result += n%10;
			n /= 10;
		}
		return result;		//�� ���ڰ� d(n)�� �ȴ�. 
	}
	public static void main(String[] args) {
		int[] arr = new int [10001];
				
		for (int i = 0; i < arr.length; i++) {
			int result = d(i);		//result���� ���ϱ� ���ؼ� d(n)�Լ��� �̿��� �� �ִ�.
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
				result = n+(n%10)+(n/10);	// �̷��� ������ ����� 3�ڸ� ������ ������.
				arr[result+1] = 1;			// ������ �������� �̿��ϴ� �κп��� ���ص��� �����ϴ�.
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

