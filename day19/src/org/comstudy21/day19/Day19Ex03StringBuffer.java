package org.comstudy21.day19;

public class Day19Ex03StringBuffer {

	public static void tset01(String[] args) {
		//String은 편리하지만 메모리의 소모가 많다.
		StringBuffer sb = new StringBuffer("Hello");	//오토박싱이 안된다. 
		System.out.println(sb.hashCode());
		sb.append(" java");	//StringBugger는 +나 =연산자를 쓸 수 없다.
		sb.append(" world");
		System.out.println(sb);
		
		sb.replace(sb.indexOf("java"), sb.indexOf("java")+"java".length(), "Python");
		System.out.println(sb);
		
		System.out.println(sb.hashCode());	//변화가 없다. 아무리 수정해도 객체는 같다.
		
		sb.reverse();
		System.out.println(sb);
		
	}
	
	public static void test02(String[] args) {
		String str1 = "Hello";
		System.out.println(str1.hashCode());
		
		str1 += "java";
		System.out.println(str1.hashCode());	//hashCode가 다르다. 서로 다른 객체를 사용한다.
	}
}
