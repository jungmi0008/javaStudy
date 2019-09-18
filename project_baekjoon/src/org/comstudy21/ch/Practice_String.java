package org.comstudy21.ch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Practice_String {
	static Scanner scan = new Scanner (System.in);
	
	public static void baekjoon11654(String[] args) {
		//백준 11654번 아스키코드
		String input = scan.next();		//문자열로 받고
		int output = input.charAt(0);	//문자로 자르고 int형에 넣는다.
		System.out.println(output);
		/*
		 * 	charAt()함수는 문자열을 문자 하나씩으로 잘라준다.
		 	System.out.println(input.charAt(0));
			라고 쓰게 된다면 입력된 문자열 중에서 0번째 문자가 출력된다.
			
			알파벳, 숫자를 모두 받기 위해서 input을 String으로 설정하고
			input을 만들고 그것에 charAt(0)한 값을 넣는다면 아스키코드값이 출력되게 된다.
		 */
	}
	public static void baekjoon11720(String[] args) {
		//백준 11720번 숫자의 합
		int N;
		do{
			N = scan.nextInt();
		}while(N>100 || N<1);
		
		String str = null;
		str = scan.next();
		if(str.length()==N){		//입력받은 N값과 str의 길이가 다르면  error
			int total = 0;
			for (int i = 0; i < N; i++) {
				total += (str.charAt(i)-'0');
			}
			System.out.println(total);
		}else{
			System.out.println("error");
		}
		/*
		String타입을 int타입으로 바꿔서 계산하는 방법이 아니라
		받은 숫자들을 char타입으로 바꾸고 아스키 코드를 이용해서 값을 구했다.
		아스키코드는 오름차순이니까!
		
		0의 ASCII는 아래 방법으로 구할 수 있다.
		char zero = '0';		//0을 문자로 입력하고
		int result  = zero;		//int타입으로 바꿔주고 출력하면 0의 아스키코드가 나온다.
		System.out.println(result);
		출력 결과는 48이다.
		
		따로 Integer.parseInt()하지 않은 채로
		문자를 int타입 변수에 넣고 그냥 출력하면 ASC형태로 나오게 된다.
		
		Integer.toString(); int를 String으로
		Integer.parseInt(); String을 int로
		*/
	}
	public static void baekjoon1890(String[] args) {
		//백준 10809번 알파벳 찾기
		//a의 아스키코드는  97이고 z는 122     
		String S = scan.next();
		if(S.length()>0&&S.length()<101){
		      int[] arr1 = new int[S.length()];
		      int[] arr2 = new int[26];
		      for (int i = 0; i < arr2.length; i++) {
		         arr2[i] = -1;
		      }
		      for (int i = 0; i < arr1.length; i++) {
		         arr1[i] = S.charAt(i);
		         int num = arr1[i]-97;
		         if(arr2[num]== -1){
		        	 arr2[num] = i;
		         }
		      }
		      System.out.println(Arrays.toString(arr2));
		 }else{
			 System.out.println("오류");
		}
	}
	public static void baekjoon2675(String[] args) {
		//백준 2675번 문자열 반복
		// 이건 런타임 에러 안나옴
		int T = scan.nextInt();
		for (int i = 0; i < T; i++) {
			int R = scan.nextInt();
			String X = scan.next();
			char[] chr = X.toCharArray();
			String Ret="";
			//StringBuffer Ret = new StringBuffer();
			for (int j = 0; j < chr.length; j++) {
				for (int k = 0; k < R; k++) {
					//Ret.append(Character.toString(chr[j]));
					Ret+=Character.toString(chr[j]);
				}
			}
			System.out.println(Ret);
		}
	}
		
		/*
		 * int T = scan.nextInt();
		for (int i = 0; i < T; i++) {
			int R = scan.nextInt();
			String S = scan.next();
			
			String[] arr1 = new String[S.length()];
			String P ="";
			for (int l = 0; l < arr1.length; l++) {
				arr1[l] = S.substring(l,l+1);
				for (int k = 0; k < R; k++) {
//					P += arr1[l];
					P = P.concat(arr1[l]);
				}
			}
			System.out.print(P);
		}
	}
		 */		
	/*
	 * 이것도 런타임 에러
	 * BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = 0;
		try {
			T = Integer.parseInt(reader.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    StringBuilder builder = new StringBuilder();	//append를 쓰기 위함.
	    for(int i=0 ; i<T ; i++){
            StringTokenizer tokenizer = null;
			try {
				tokenizer = new StringTokenizer(reader.readLine());	//라인으로 읽어들이고
			} catch (Exception e) {
				e.printStackTrace();
			}
			
            int R = Integer.parseInt(tokenizer.nextToken());	//숫자부분은 integer로 받고
            String str = tokenizer.nextToken();
            
            for(int j=0 ; j<str.length() ; j++){
                for(int k=0 ; k<R ; k++){
                    builder.append(str.charAt(j));
                }
            }
            builder.append("\n");
        }
        System.out.println(builder);
        try {
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	 */
	public static void main(String[] args) {
		//1157번 단어공부
		String str = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strToken = null;
		ArrayList<Character> list = new ArrayList<>();
		int[] arr = new int[list.size()];
		try {
			String upperStr = (reader.readLine()).toUpperCase();
			int cnt = 0;
			for (int i = 0; i < upperStr.length(); i++) {
				list.add(upperStr.charAt(i));	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(list);
	}
}

