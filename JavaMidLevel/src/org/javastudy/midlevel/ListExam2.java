package org.javastudy.midlevel;

import java.util.ArrayList;
import java.util.List;

public class ListExam2 {
	//�Ű������� arr1�� arr2 �迭�� ��ġ�� addArray ������ ���
	public List<String> addArray(String[]arr1, String[]arr2){
        List<String> list = new ArrayList<String>();
        //arr1��ü�� �迭�̱� ������ StringŸ���� str �ȿ� �ϳ��� �ִ´�.
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
		
		//list2ó�� ������ �������� ����� �� �� �ִ�.
		List<String> list2 = listExam.addArray(arr1,arr2);
		for (int i = 0; i < list2.size(); i++) {
			System.out.print(list2.get(i)+" ");
		}
	}
}
