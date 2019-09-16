package org.comstudy21.ch;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Practice_Array {
	static Scanner scan = new Scanner (System.in);
	
	public static void baekjoon10818(String[] args) {
		//백준 10818번
		//N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.

		int N = 0;                //N값을 초기화해야한다.
		N = scan.nextInt();       //N값을 받고 나서 어레이의 길이를 정한다. 
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
		/* if문을 이용하여 일일히 비교할 필요없이
		 * 임의의 값을 max min으로 설정하여 나중에 반복문을 거치면서 바꿀 수 있도록 한다.
		 * 배열이기 때문에 반복문을 이용해서 최대 최소를 찾을 수 있다.
		 * 
		 * min max 사용법
		 *  System.out.println(min(12,2));괄호 안의 수 중 최소를 내놓는다.
		 *  array로는 안됨
		 * 
		 * Arrays.sort(array);를 하면 배열자체가 정렬이 된다.
		 * 
		 * int min = Integer.MIN_VALUE;
		 * int max = Integer.MAX_VALUE;를 이용한 방법
		 */
	public static void baekjoon2562(String[] args) {
		//2562번
		//9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 번째 수인지를 구하는 프로그램을 작성하시오.
		//예를 들어, 서로 다른 9개의 자연수 3, 29, 38, 12, 57, 74, 40, 85, 61이 주어지면,
		//이들 중 최댓값은 85이고, 이 값은 8번째 수이다.
		
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
		for(int i=0; i<9; i++){				//중복되는 값이 있으면 다시 만들다 보니 같은것을 여러번 찍어낸다.
			System.out.print(num[i]+" ");	//그래서 for문을 따로 만들어야한다.
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
		System.out.println("최대: "+max);
		System.out.println("최소: "+min);
		
	}
	/*
	 * 중복값 없는 랜덤을 만드는 방법
	 *  for문으로 랜덤값을 원하는 갯수만큼 뽑아낸다.
	 *  그 for문안에 for문을 한번 더 두면서 그 전에 만든 랜덤값과 같으면 다시 만들도록 하는 로직을 만든다.
	 *  예를 들어 i=3이라면 그 전에 만들어진 모든 num[0],num[1],num[2]들과 비교하는 것이다.
	 *  만약 같은 것이 있으면, i=2으로 돌아가서 다시 난수를 만든다. 중복이 없고 할당량인 N개의 num[i]가 나올 때까지 계속 반복되게 된다.
	 * 
	 */
	public static void baekjoon2920(String[] args) {                
	      //백준 2920번
	      //연주한 순서가 주어졌을 때, 이것이 ascending인지, descending인지, 아니면 mixed인지 판별하는 프로그램을 작성하시오.
		  Scanner scan = new Scanner(System.in);
		  
		  int [] cord = new int[8];
	      for (int i = 0; i <cord.length; i++) {
	         cord[i] = scan.nextInt();
	      }
	      scan.close(); 
	      
	      String result = "";
	      for (int i = 0; i < cord.length-1; i++) {		//i가7이 되는 순간까지만 있어서 cord.length에서 1을 빼야한다.
	         if(cord[i]== cord[i+1]-1){
	           result = "ascending";
	         }else if(cord[i]==cord[i+1]+1){
	           result = "descending";
	         }else{
	           result = "mixed";
	           break;						
	           //break 문은 무조건 if 밖의 while, for, switch, do while 을 기준으로 가장 가까운 것 1개를 탈출한다.
	           //예를들어 1 3 2 4 이런식으로 될 때 break를 쓰지 않은 경우에는 1에서 3을 넘어가면서 mixed가 찍히게 되지만 
	           //break로 for문을 뚫고 나오지 않고 다시 for문을 돌면서 3다음은 2이기 때문에 descending이 찍히게 된다.
	           //원하는 값에 도달하면 for문을 빠져나가기 위해서 break를 사용해야한다. 
	         }
	      }
	      System.out.println(result);
	}
	public static void baekjoon2577(String[] args) {
		 //백준 2577
		 //예를 들어 A = 150, B = 266, C = 427 이라면 
		 //A × B × C = 150 × 266 × 427 = 17037300 
		   
	      int A = scan.nextInt();
	      int B = scan.nextInt();
	      int C = scan.nextInt();
	      scan.close();
	      
	      int num = A*B*C;
	      System.out.println("num : "+num);
	      int [] arr = new int [10];
	      //num%10값은 무조건 10보다 작기 때문
	      //나머지 값을 인덱스로 이용한다.
	      //아무것도 넣지 않았을 때 arr는 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]인 상태다.
	      
	      while(num>0) {
	         arr[num%10]++;		//num%10가 1번 나오면 1 올려준다.
	         num /= 10;			//그 다음 10으로 나누어서 그 다음 자릿수를 검사하게 된다.
	         					//arr[i]=num%10;과 i++;으로 하는게 아니다.
	      }
	      System.out.println(Arrays.toString(arr));
	      //
	      
	      for(int i=0; i<arr.length; i++){
	            System.out.println(arr[i]);
	         }

	      
	      /*  
	       * 나는 아예 모든 자리수를 하나하나 배열에 넣으려고 했고
	       * 위의 경우는 알고리즘을 이용한 것 같다.    
	      int A = scan.nextInt();
	      int B = scan.nextInt();
	      int C = scan.nextInt();
	      scan.close();
	      
	      int num = A*B*C;
	      int i = 0;
	      
	      while(num>0) {      //num==0이라고 조건식에 쓰는게 아니라, num이 0보다 작아지기 바로 전의 i 값을 찾는게 포인트.
	           num = num/10;
	           i++;
	      }
	      System.out.println("num은 "+i+"자리수");
	      num += A*B*C;      //num값이 0이 됐으니까 다시 원래대로.
	      
	      int [] arr = new int [i];
	      int j = 0;
	      
	      while(i>=1) {
	           int NUM = num/(int)(Math.pow(10,i-1));   //Math.pow(a,b)는 a^b이다. double이므로 int로 형변환
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
		 * 3052번
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
		//나머지는 0~41까지 나올 수 있다.
		int[] arr = new int[42];		
		int cnt = 0;
		
		for (int i = 0; i < arr.length; i++) {
			int num = scan.nextInt();
			arr[num%42]++;
		}
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i]==arr[j]){
					cnt++;		//중복되는 숫자를 찾아낸 횟수
				}		
			}
		}
		System.out.println(cnt);	//10개의 배열 원소 중에서 중복된는 경우를 빼주면 된다.
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
					cnt++;		//중복되는 숫자를 찾아낸 횟수
				}		
			}
		System.out.println(cnt);	
		}
		System.out.println(10-cnt);	//10개의 배열 원소 중에서 중복된는 경우를 빼주면 된다.
		*/
		/*
		int[] arr = new int[10];
		int[] rest = new int[10];
		int cnt = 0;
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
			rest[i] = arr[i]%42;
		}
		//lotto test05처럼 만든 방식
		int[] rest2 = new int[42];		//나머지는 0~41까지이므로
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
		//6단계 1546번 평균
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
			total += ((double)score[i]/M)*100; //int타입이 더 작으니까 double로 바꿔줘야한다.
		}
		avg = total/N;
		System.out.printf("%.2f",avg);		//소수점 둘 째 자리까지
	}
	public static void baekjoon8958(String[] args) {
		//백준 8958 OX퀴즈
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
				}else if(str.charAt(i) == 'X'){		// .charAt()으로 문자열을 하나의 문자로 자를 수 있다.
					cnt=0;		//X를 만나는 지점에서 cnt를 0으로 리셋한다.
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
		//백준 4344번 평균은 넘겠지
		
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
