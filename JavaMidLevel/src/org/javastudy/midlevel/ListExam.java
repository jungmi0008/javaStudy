package org.javastudy.midlevel;

import java.util.ArrayList;
import java.util.List;
//list�� �ߺ��� ���� �� �ְ� ������ �ִ�.
//�迭�� �ٸ��� ����� ���������� �ʴ´�.
public class ListExam {

	public static void main(String[] args) {
		//���������� List�� �������̽��̹Ƿ� �޼ҵ带 �����ϴ� ArrayList���� ���� �ʿ�.
		List<String> list = new ArrayList<>();
		list.add("kim");
		list.add("kang");
		list.add("kim");
		
		System.out.println(list.size());	// ����� 3�̴�. �ߺ��� �����ϴٴ� �Ҹ�
		
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);	//get�� �̿��� ���� �����´�.
			System.out.println(str);
		}
	}

}
