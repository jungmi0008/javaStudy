package org.javastudy.midlevel;

import java.util.ArrayList;
import java.util.List;

public class ListExam2 {
	//매개변수인 arr1과 arr2 배열을 합치는 addArray 생성자 블록
	public List<String> addArray(String[]arr1, String[]arr2){
        List<String> list = new ArrayList<String>();
        //arr1자체가 배열이기 때문에 String타입인 str 안에 하나씩 넣는다.
        for(String str : arr1){
            list.add(str);    
        }
        
        for(String str : arr2){
           list.add(str);
        }
        
        return list;
    }
	public static void main(String[] args) {
		ListExam2 listExam = new ListExam2();
		String[] arr1 = {"a", "b"};
		String[] arr2 = {"c", "d","e"};
		
		//list2처럼 변수를 만들어줘야 출력을 할 수 있다.
		List<String> list2 = listExam.addArray(arr1,arr2);
		for (int i = 0; i < list2.size(); i++) {
			System.out.print(list2.get(i)+" ");
		}
	}
}
