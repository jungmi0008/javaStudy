package org.javastudy.midlevel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

//Date 등 한계점이 많다.
//그래서 Joda-Time등 라이브러리를 제공하기도 하고 JDK8부터 새로운 API가 제공된다.
public class TimeExam {

	public static void main(String[] args) {
		LocalDateTime timePoint = LocalDateTime.now();	//현재시간 날짜와 시간 모두
		System.out.println("현재 날짜와 시간: "+timePoint);
		
		//get메소드를 이용하는 방법
		//날짜와 시간을 모두 가지고 있는 timePoint에서 필요에 맞게 형식을 바꾸어 출력
		LocalDate theDate = timePoint.toLocalDate();
		System.out.println("날짜만 출력: "+theDate);	//현재날짜
		
		System.out.println("현재 월만 출력 : "+timePoint.getMonthValue()+"월");	//int 타입으로 출력
		System.out.println("현재 월만 영어로 출력: "+timePoint.getMonth());	//영어로 월 출력
	
		//객체를 만들 때 of를 써야한다. new를 쓰지 않는다.
		LocalDate ld1 = LocalDate.of(2012, Month.DECEMBER, 12);	//직접 입력한 시간
		System.out.println("직접 입력한 날짜: "+ld1);
		
		LocalTime lt1 = LocalTime.of(17,18);	//int형으로
		System.out.println("직접 입력한 시간: "+lt1);
		LocalTime lt2 = LocalTime.parse("10:15:30");	//문자열로
		System.out.println("문자열로 입력한 시간: "+lt2);					
	}

}
