package org.comstudy21.day19;

//extends Object가 생략되어있다.
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
		//깊은 비교 즉 필드끼리 비교하게 한다.
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
		System.out.println(pt1.equals(pt2));	//false 참조값만 비교하기 때문에 false가 나온다.
		
		
	}
}
