package org.comstudy21.day19;

import java.util.*;

class Point1{
	int x;
	int y;
	
	public Point1() {
	}

	public Point1(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public boolean equals(Object obj) {
		Point1 pt = null;
		if(obj instanceof Point1){
			pt = (Point1)obj;
			if (pt.x==x && pt.y==y) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "[" + x + "," + y + "]";
	}
	
}
	
public class Day19Ex06ArrayList {
	public static void main(String[] args) {
		ArrayList<Point1> list = new ArrayList<>();
		list.add(new Point1(1,1));
		list.add(new Point1(6,6));
		list.add(new Point1(5,5));
		list.add(new Point1(9,9));
		list.add(new Point1(3,3));
		list.add(new Point1(4,4));
		list.add(new Point1(7,7));
		list.add(new Point1(8,8));
		list.add(new Point1(2,2));
		
		
		Collections.sort(list,new Comparator<Point1>(){
			@Override
			public int compare(Point1 o1, Point1 o2) {	//Comparator�� ���� compare�� ������
				if(o1.x > o2.x){
					return -1;
				}else if (o1.y > o2.y) {
					return -1;
				}
					return 0;
			};
		});
		System.out.println(list);
	}
	
	public static void test3(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(7);
		list.add(2);
		list.add(4);
		list.add(3);
		list.add(6);
		list.add(8);
		list.add(1);
		list.add(9);
		
		//��������
		Collections.sort(list);
		System.out.println(list);
		
		//��������
		Collections.sort(list,new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {	//Comparator�� ���� compare�� ������
				if(o1<o2){
					return -1;
				}else if (o1>o2) {
					return -1;
				}
					return 0;
			};
		});
		System.out.println(list);
	}
	
	public static void test2(String[] args) {
		ArrayList<Point1> list = new ArrayList<>();
		list.add(new Point1(10,12));
		list.add(new Point1(20,22));
		list.add(new Point1(30,32));
		list.add(new Point1(40,42));
		list.add(new Point1(50,52));
		
		Point1 pt = new Point1(30,32);	//�̰Ͱ� ������ ���� ���� ���� �ε����� ã�´�.
		System.out.println(list.indexOf(pt));
	}
	
	public static void test(String[] args) {
		ArrayList<String> list = new ArrayList<>();
			list.add("���");
			list.add("�ٳ���");
			list.add("��");
			list.add("����");
			list.add("�ٳ���");
//		System.out.println(list.size());	//5
//		System.out.println(list);	//���� ����� ������ �̷������� �׳� ����Ʈ �ϸ� �ȵȴ�. Iterator�� toArray�� �ٲٴ� ���� ����.
		
		list.set(4, "����");	//�ٳ����� ���� �ȴ�.
		list.set(3, "����");	//���Ⱑ ������ �ȴ�.
		list.remove(3);		//������ ������� ���� �����ڸ��� ��������.
		
		if (list.indexOf("����") == -1) {
			System.out.println("���� ����.");
		}else{
			System.out.println(list.indexOf("����"));	//3 
		}
			
		String[] arr = new String[list.size()];
		list.toArray(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr["+i+"] "+arr[i]);
		}
	}
}
