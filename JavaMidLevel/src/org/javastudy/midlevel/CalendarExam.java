package org.javastudy.midlevel;

import java.util.Calendar;

//Date와 다르게 지역성을 가지고 있다.
public class CalendarExam {

	public static void main(String[] args) {
		//Calendar는 추상클래스이기 때문에 new로 생성자를 만들 수 없다. 즉 인스턴스화 할 수 없다.
		//그래서 getInstance()를 사용해야 한다.
		//Calendar는 자기 자신을 리턴할 수 없다. Calendar가 가진 자식 클래스가 같이 리턴된다.
		//Calendar에게는 Gregorian Calendar라는 자식 클래스가 있는데
		//따라서 실제로는  Gregorian이 인스턴스화 되어 리턴되는 것이다.
		//이렇게 구분한 이유는 이후에 새로운 형식으 캘린더를 사용할 수 있는 가능성 때문이다.
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR)+"년");	//상수를 꺼내오는 것이기 때문에 Calendar. 이라고 쓴다.
		System.out.println(cal.get(Calendar.MONTH)+1+"월");	//월이 0~11이라서 1 더해줘야한다.
		System.out.println(cal.get(Calendar.DATE)+"일");
		
		System.out.println(cal.get(Calendar.HOUR_OF_DAY)+"시");	//24시로 나옴
		System.out.println(cal.get(Calendar.HOUR)+"시");			//12시로 나옴
	
		cal.add(Calendar.HOUR, -5);	//5시간 전
		System.out.println(cal.get(Calendar.HOUR)+"시");
		
		cal.add(Calendar.DATE, 100);	//100일 뒤
		System.out.print(cal.get(Calendar.YEAR)+"년 ");
		System.out.print(cal.get(Calendar.MONTH)+1+"월 ");
		System.out.print(cal.get(Calendar.DATE)+"일 ");
	}

}
