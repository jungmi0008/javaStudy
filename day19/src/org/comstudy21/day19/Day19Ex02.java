package org.comstudy21.day19;

public class Day19Ex02 {
	public static void test01(String[] args) {	
		String str1 = "Hello world";
		String str2 = "Hello world";
		String str3 = new String("Hello world");
		String str4 = new String("Hello world");
		
		System.out.println(str1==str2);	//true
		System.out.println(str2==str3);	//false
		System.out.println(str3==str4);	//false
		
		//문자열 비교는 equals를 써야한다.
		System.out.println(str3.equals(str4));	//true
	}
	
	public static void test02(String[] args) {
		String str1 = "Hello world";
		
		int i = str1.indexOf('o');
		System.out.println(i);	//4번지에 있다고 나옴
		
		i = str1.lastIndexOf('o');
		System.out.println(i);	//7번지에 있다고 나옴
	}
	
	public static void test03(String[] args) {
		String str1 = "Hello world";
		
		str1.replace("world", "java");
		System.out.println(str1);	//바뀌어있지 않는다.
		
		str1 = str1.replace("world", "java");
		System.out.println(str1);	//다시 str1에 넣어주어야 바뀐다.
	}
	
	public static void test04(String[] args) {
		String str1 = "Hello java world";
		
		int beginIndex = str1.indexOf("java");
		System.out.println(beginIndex);	//6번지에 있다고 나온다.
		
		str1 = str1.substring(0,beginIndex)+str1.substring(beginIndex+("java ".length()));
		System.out.println(str1);
	}
	
	public static void test05(String[] args) {
		String path = "/hello/world/";
		String uri1 = "/hello/world/profile.do";
		String uri2 = "/hello/world/gallery.do";
		String uri3 = "/hello/world/photo.do";
		
		int i = uri1.lastIndexOf(".do");
		uri1 = uri1.substring(path.length(),i);
		
		uri2 = uri2.substring(path.length(),uri2.length()-3);
		
		uri3 = uri3.substring((path.lastIndexOf('/')+1),uri3.lastIndexOf('.'));
		
		System.out.println(uri1);
		System.out.println(uri2);
		System.out.println(uri3);
	}
	
	public static void main(String[] args) {
		String str1 = "Hello World";
		String str2 = "hello world";
		
		System.out.println(str1.toLowerCase());
		System.out.println(str1.toUpperCase());
		
		System.out.println(str1.equals(str2));
		System.out.println(str1.equalsIgnoreCase(str2));
		
		System.out.println(str2.charAt(6));
		
		String str3 = " Hello ";
		
		System.out.println("Hello".equals(str3.trim()));	//trim으로 공백을 지워준다. 사이드에 있는 공백만 제거하고 문자 사이의 공백은 제거되지 않는다.
		
		String value = String.valueOf(5000);	//5000을 String으로 바꿔준다. 사용빈도가 높지않다.
		String value2 = 5000+"";				//이렇게 쓸 수도 있다.
		System.out.println(value);
	}
}
