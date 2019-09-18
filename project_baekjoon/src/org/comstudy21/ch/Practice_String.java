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
		//���� 11654�� �ƽ�Ű�ڵ�
		String input = scan.next();		//���ڿ��� �ް�
		int output = input.charAt(0);	//���ڷ� �ڸ��� int���� �ִ´�.
		System.out.println(output);
		/*
		 * 	charAt()�Լ��� ���ڿ��� ���� �ϳ������� �߶��ش�.
		 	System.out.println(input.charAt(0));
			��� ���� �ȴٸ� �Էµ� ���ڿ� �߿��� 0��° ���ڰ� ��µȴ�.
			
			���ĺ�, ���ڸ� ��� �ޱ� ���ؼ� input�� String���� �����ϰ�
			input�� ����� �װͿ� charAt(0)�� ���� �ִ´ٸ� �ƽ�Ű�ڵ尪�� ��µǰ� �ȴ�.
		 */
	}
	public static void baekjoon11720(String[] args) {
		//���� 11720�� ������ ��
		int N;
		do{
			N = scan.nextInt();
		}while(N>100 || N<1);
		
		String str = null;
		str = scan.next();
		if(str.length()==N){		//�Է¹��� N���� str�� ���̰� �ٸ���  error
			int total = 0;
			for (int i = 0; i < N; i++) {
				total += (str.charAt(i)-'0');
			}
			System.out.println(total);
		}else{
			System.out.println("error");
		}
		/*
		StringŸ���� intŸ������ �ٲ㼭 ����ϴ� ����� �ƴ϶�
		���� ���ڵ��� charŸ������ �ٲٰ� �ƽ�Ű �ڵ带 �̿��ؼ� ���� ���ߴ�.
		�ƽ�Ű�ڵ�� ���������̴ϱ�!
		
		0�� ASCII�� �Ʒ� ������� ���� �� �ִ�.
		char zero = '0';		//0�� ���ڷ� �Է��ϰ�
		int result  = zero;		//intŸ������ �ٲ��ְ� ����ϸ� 0�� �ƽ�Ű�ڵ尡 ���´�.
		System.out.println(result);
		��� ����� 48�̴�.
		
		���� Integer.parseInt()���� ���� ä��
		���ڸ� intŸ�� ������ �ְ� �׳� ����ϸ� ASC���·� ������ �ȴ�.
		
		Integer.toString(); int�� String����
		Integer.parseInt(); String�� int��
		*/
	}
	public static void baekjoon1890(String[] args) {
		//���� 10809�� ���ĺ� ã��
		//a�� �ƽ�Ű�ڵ��  97�̰� z�� 122     
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
			 System.out.println("����");
		}
	}
	public static void baekjoon2675(String[] args) {
		//���� 2675�� ���ڿ� �ݺ�
		// �̰� ��Ÿ�� ���� �ȳ���
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
	 * �̰͵� ��Ÿ�� ����
	 * BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = 0;
		try {
			T = Integer.parseInt(reader.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    StringBuilder builder = new StringBuilder();	//append�� ���� ����.
	    for(int i=0 ; i<T ; i++){
            StringTokenizer tokenizer = null;
			try {
				tokenizer = new StringTokenizer(reader.readLine());	//�������� �о���̰�
			} catch (Exception e) {
				e.printStackTrace();
			}
			
            int R = Integer.parseInt(tokenizer.nextToken());	//���ںκ��� integer�� �ް�
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
		//1157�� �ܾ����
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

