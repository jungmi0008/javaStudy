package org.comstudy21.ch;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Practice_Array {
	static Scanner scan = new Scanner (System.in);
	
	public static void baekjoon10818(String[] args) {
		//���� 10818��
		//N���� ������ �־�����. �̶�, �ּڰ��� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

		int N = 0;                //N���� �ʱ�ȭ�ؾ��Ѵ�.
		N = scan.nextInt();       //N���� �ް� ���� ����� ���̸� ���Ѵ�. 
		int [] array = new int[N];
		
		for(int i=0; i<array.length; i++){
			int num = scan.nextInt();
			array[i] = num;
		}
		
		int max = array[0];
		int min = array[0];
		
		for(int j=0; j<array.length; j++){
			if(array[j]>max){
				max = array[j];
			}
			if(array[j]<min){
				min = array[j];
			}
		}
		System.out.println(max);
		System.out.println(min);
			
	}
		/* if���� �̿��Ͽ� ������ ���� �ʿ����
		 * ������ ���� max min���� �����Ͽ� ���߿� �ݺ����� ��ġ�鼭 �ٲ� �� �ֵ��� �Ѵ�.
		 * �迭�̱� ������ �ݺ����� �̿��ؼ� �ִ� �ּҸ� ã�� �� �ִ�.
		 * 
		 * min max ����
		 *  System.out.println(min(12,2));��ȣ ���� �� �� �ּҸ� �����´�.
		 *  array�δ� �ȵ�
		 * 
		 * Arrays.sort(array);�� �ϸ� �迭��ü�� ������ �ȴ�.
		 * 
		 * int min = Integer.MIN_VALUE;
		 * int max = Integer.MAX_VALUE;�� �̿��� ���
		 */
	public static void baekjoon2562(String[] args) {
		//2562��
		//9���� ���� �ٸ� �ڿ����� �־��� ��, �̵� �� �ִ��� ã�� �� �ִ��� �� ��° �������� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
		//���� ���, ���� �ٸ� 9���� �ڿ��� 3, 29, 38, 12, 57, 74, 40, 85, 61�� �־�����,
		//�̵� �� �ִ��� 85�̰�, �� ���� 8��° ���̴�.
		
		Random rand = new Random();
		
		int [] num = new int[99];
		
		for(int i=0; i<9; i++){
			num[i] = 1+Math.abs((int)(Math.random()*99));
			for(int j =0; j<i; j++){
				if(num[i]==num[j]){
					i--;
					break;
				}
			}
		}
		for(int i=0; i<9; i++){				//�ߺ��Ǵ� ���� ������ �ٽ� ����� ���� �������� ������ ����.
			System.out.print(num[i]+" ");	//�׷��� for���� ���� �������Ѵ�.
		}
		System.out.println();
		
		int max = num[0];
		int min = num[0];
		
		for (int i = 0; i < 9; i++) {
			if (max<num[i]) {
				max = num[i];
			}
			if (min>num[i]) {
				min = num[i];
			}
		}
		System.out.println("�ִ�: "+max);
		System.out.println("�ּ�: "+min);
		
	}
	/*
	 * �ߺ��� ���� ������ ����� ���
	 *  for������ �������� ���ϴ� ������ŭ �̾Ƴ���.
	 *  �� for���ȿ� for���� �ѹ� �� �θ鼭 �� ���� ���� �������� ������ �ٽ� ���鵵�� �ϴ� ������ �����.
	 *  ���� ��� i=3�̶�� �� ���� ������� ��� num[0],num[1],num[2]��� ���ϴ� ���̴�.
	 *  ���� ���� ���� ������, i=2���� ���ư��� �ٽ� ������ �����. �ߺ��� ���� �Ҵ緮�� N���� num[i]�� ���� ������ ��� �ݺ��ǰ� �ȴ�.
	 * 
	 */
	public static void baekjoon2920(String[] args) {                
	      //���� 2920��
	      //������ ������ �־����� ��, �̰��� ascending����, descending����, �ƴϸ� mixed���� �Ǻ��ϴ� ���α׷��� �ۼ��Ͻÿ�.
		  Scanner scan = new Scanner(System.in);
		  
		  int [] cord = new int[8];
	      for (int i = 0; i <cord.length; i++) {
	         cord[i] = scan.nextInt();
	      }
	      scan.close(); 
	      
	      String result = "";
	      for (int i = 0; i < cord.length-1; i++) {		//i��7�� �Ǵ� ���������� �־ cord.length���� 1�� �����Ѵ�.
	         if(cord[i]== cord[i+1]-1){
	           result = "ascending";
	         }else if(cord[i]==cord[i+1]+1){
	           result = "descending";
	         }else{
	           result = "mixed";
	           break;						
	           //break ���� ������ if ���� while, for, switch, do while �� �������� ���� ����� �� 1���� Ż���Ѵ�.
	           //������� 1 3 2 4 �̷������� �� �� break�� ���� ���� ��쿡�� 1���� 3�� �Ѿ�鼭 mixed�� ������ ������ 
	           //break�� for���� �հ� ������ �ʰ� �ٽ� for���� ���鼭 3������ 2�̱� ������ descending�� ������ �ȴ�.
	           //���ϴ� ���� �����ϸ� for���� ���������� ���ؼ� break�� ����ؾ��Ѵ�. 
	         }
	      }
	      System.out.println(result);
	}
	public static void baekjoon2577(String[] args) {
		 //���� 2577
		 //���� ��� A = 150, B = 266, C = 427 �̶�� 
		 //A �� B �� C = 150 �� 266 �� 427 = 17037300 
		   
	      int A = scan.nextInt();
	      int B = scan.nextInt();
	      int C = scan.nextInt();
	      scan.close();
	      
	      int num = A*B*C;
	      System.out.println("num : "+num);
	      int [] arr = new int [10];
	      //num%10���� ������ 10���� �۱� ����
	      //������ ���� �ε����� �̿��Ѵ�.
	      //�ƹ��͵� ���� �ʾ��� �� arr�� [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]�� ���´�.
	      
	      while(num>0) {
	         arr[num%10]++;		//num%10�� 1�� ������ 1 �÷��ش�.
	         num /= 10;			//�� ���� 10���� ����� �� ���� �ڸ����� �˻��ϰ� �ȴ�.
	         					//arr[i]=num%10;�� i++;���� �ϴ°� �ƴϴ�.
	      }
	      System.out.println(Arrays.toString(arr));
	      //
	      
	      for(int i=0; i<arr.length; i++){
	            System.out.println(arr[i]);
	         }

	      
	      /*  
	       * ���� �ƿ� ��� �ڸ����� �ϳ��ϳ� �迭�� �������� �߰�
	       * ���� ���� �˰����� �̿��� �� ����.    
	      int A = scan.nextInt();
	      int B = scan.nextInt();
	      int C = scan.nextInt();
	      scan.close();
	      
	      int num = A*B*C;
	      int i = 0;
	      
	      while(num>0) {      //num==0�̶�� ���ǽĿ� ���°� �ƴ϶�, num�� 0���� �۾����� �ٷ� ���� i ���� ã�°� ����Ʈ.
	           num = num/10;
	           i++;
	      }
	      System.out.println("num�� "+i+"�ڸ���");
	      num += A*B*C;      //num���� 0�� �����ϱ� �ٽ� �������.
	      
	      int [] arr = new int [i];
	      int j = 0;
	      
	      while(i>=1) {
	           int NUM = num/(int)(Math.pow(10,i-1));   //Math.pow(a,b)�� a^b�̴�. double�̹Ƿ� int�� ����ȯ
	           System.out.println(NUM);
	           arr[j] = NUM;
	           num = num - (NUM*(int)(Math.pow(10,i-1)));
	           i--;
	           j++;
	      }
	      
	      System.out.println(Arrays.toString(arr));
	      
	      int k = 0;
	      
	      while(true){
	               if(arr[k]==0){
	                  System.out.println("arr["+k+"]="+arr[k]);   
	               }
	               k++;
	      }
	      */
	}
	public static void baekjoon3052(String[] args) {
		/*
		 * 3052��
		 *  39
			40
			41
			42
			43
			44
			82
			83
			84
			85
		 */
		//�������� 0~41���� ���� �� �ִ�.
		int[] arr = new int[42];		
		int cnt = 0;
		
		for (int i = 0; i < arr.length; i++) {
			int num = scan.nextInt();
			arr[num%42]++;
		}
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i]==arr[j]){
					cnt++;		//�ߺ��Ǵ� ���ڸ� ã�Ƴ� Ƚ��
				}		
			}
		}
		System.out.println(cnt);	//10���� �迭 ���� �߿��� �ߺ��ȴ� ��츦 ���ָ� �ȴ�.
		/*
		int[] arr = new int[10];
		int[] rest = new int[10];
		int cnt = 0;
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
			rest[i] = arr[i]%42;
			System.out.println(rest[i]);
		}
		for (int i = 0; i < rest.length-1; i++) {
			for (int j = i+1; j < rest.length; j++) {
				if(rest[i]==rest[j]){
					cnt++;		//�ߺ��Ǵ� ���ڸ� ã�Ƴ� Ƚ��
				}		
			}
		System.out.println(cnt);	
		}
		System.out.println(10-cnt);	//10���� �迭 ���� �߿��� �ߺ��ȴ� ��츦 ���ָ� �ȴ�.
		*/
		/*
		int[] arr = new int[10];
		int[] rest = new int[10];
		int cnt = 0;
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
			rest[i] = arr[i]%42;
		}
		//lotto test05ó�� ���� ���
		int[] rest2 = new int[42];		//�������� 0~41�����̹Ƿ�
		for (int i = 0; i < rest.length; i++) {
			for (int j = i+1; j < rest.length; j++) {
				if(rest[i]!=rest[j]){
					int idx = rest[i];
					int idx2 = rest[j];
					while(rest2[idx]!=1){
						rest2[idx] = 1;
						rest2[idx2] = 1;
					}
				}		
			}
		}
		for (int i = 0; i < rest2.length; i++){
			if(rest2[i]==1){
				cnt++;
			}
		}
		System.out.println(cnt);
		*/
	}
	public static void baekjoon1546(String[] args) {
		//6�ܰ� 1546�� ���
		int N = scan.nextInt();
		int score[] = new int[N];
		int M = score[0];
		
		for (int i = 0; i < N; i++) {
			score[i] = scan.nextInt();
			if(score[i]>M) {
				M = score[i];
			}
		}
		double avg = 0,  total = 0;
		for (int i = 0; i < score.length; i++) {
			total += ((double)score[i]/M)*100; //intŸ���� �� �����ϱ� double�� �ٲ�����Ѵ�.
		}
		avg = total/N;
		System.out.printf("%.2f",avg);		//�Ҽ��� �� ° �ڸ�����
	}
	public static void baekjoon8958(String[] args) {
		//���� 8958 OX����
		int N = scan.nextInt();
		int[] num = new int[N];
		
		for (int i = 0; i < N; i++) {
			String str;
			do{
				str = scan.next();
			}while(str.length()>=80 || str.length()<=0);
			
			int cnt=0;
			
			for (int j = 0; j < num.length; j++) {
				if(str.charAt(i) == 'O') {
					cnt++;
					num[i]+=cnt;
				}else if(str.charAt(i) == 'X'){		// .charAt()���� ���ڿ��� �ϳ��� ���ڷ� �ڸ� �� �ִ�.
					cnt=0;		//X�� ������ �������� cnt�� 0���� �����Ѵ�.
				}
			}
		}
		
		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i]);
		}
		/*
		String str;
		do{
			str = scan.next();
		}while(str.length()>=80 || str.length()<=0);
		
		int[] num = new int[str.length()];
		
		int cnt=0;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'O') {
					num[i]=1;
				}else if(str.charAt(i) == 'X'){
					num[i]=0;
				}
		}
		
		int total = 0;
		for (int i = 1; i < num.length; i++) {
			if(num[i]!=0 && num[i-1]>0) {
				num[i] = num[i-1]+1;
			}
		}
		for (int i = 0; i < num.length; i++) {
			total += num[i];
		}
		System.out.println(total);
		*/
	}	
	public static void baekjoon4344(String[] args) {
		//���� 4344�� ����� �Ѱ���
		
		int C = scan.nextInt();
		
		for (int j = 0; j < C; j++) {
			int N = scan.nextInt();
			int [] score = new int [N];
			
			for (int i = 0; i < N; i++) {
				do {
					score[i] = scan.nextInt();
				}while(score[i]<0 || score[i]>100);
			}
			System.out.println(Arrays.toString(score));
			
			int total = 0;
			int avg =0;
			for (int i = 0; i < N; i++) {
				total += score[i];
				avg = total/N;
			}
			
			int cnt = 0;
			for (int i = 0; i < score.length; i++) {
				if(score[i]>avg) {
					cnt++;
				}
			}
			System.out.println();
			double rate =((double)cnt/N)*100;
			System.out.printf("%.3f",rate);
			System.out.print("%");				
		}
		
	}
}
