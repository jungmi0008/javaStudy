package org.comstudy21.day19;

//extends Object�� �����Ǿ��ִ�.
class Point {
	int x;
	int y;
	
	public Point(){
		
	}
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		//���� �� �� �ʵ峢�� ���ϰ� �Ѵ�.
		if(obj instanceof Point){
			Point pt = (Point)obj;
			if(pt.x == x && pt.y == y){
				return true;
			}
		}
		return false;
	}
}
public class Day19Ex01UtillPackage {
	public static void main(String[] args) {
		Point pt1 = new Point(10,20);
		Point pt2 = new Point(10,20);
		System.out.println(pt1);
		System.out.println(pt2);
		
		System.out.println(pt1 == pt2);			//false
		System.out.println(pt1.equals(pt2));	//false �������� ���ϱ� ������ false�� ���´�.
		
		
	}
}
