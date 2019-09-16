package org.javastudy.midlevel;

import java.text.SimpleDateFormat;
import java.util.Date;

//Date클래스는 java.util에 있다.
//Date는 지역에 따라 다르게 설정되어 있지 않다.
//이런 한계점을 극복하기 위해서 생긴 것이 calendar클래스다.

public class DateExam {

	public static void main(String[] args) {
		Date date = new Date();	//제네릭이 아니라 기본생성자로 만든다.
		System.out.println(date.toString());
		//KST는 한국 표준시간이라는 뜻
		
		//내가 원하는 형식으로 출력해볼 수 있다.
		SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd' at 'hh:mm:ss a zzz");
		System.out.println(ft.format(date));	//format을 이용해서 값을 가져온다.
		
		//현재시간은 long값으로 가져오는 경우
		System.out.println(date.getTime());
		
		//또 다른 방법으로 현재시간은 long값을 가져오는 경우
		long today = System.currentTimeMillis();
		System.out.println(today);
		
		//코드 사이에 걸린 시간을 구할 수도 있다.
		System.out.println(today-date.getTime());
	}

}
