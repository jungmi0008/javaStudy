package org.comstudy21.day19;

public class Day19Ex03StringBuffer {

	public static void tset01(String[] args) {
		//String�� �������� �޸��� �Ҹ� ����.
		StringBuffer sb = new StringBuffer("Hello");	//����ڽ��� �ȵȴ�. 
		System.out.println(sb.hashCode());
		sb.append(" java");	//StringBugger�� +�� =�����ڸ� �� �� ����.
		sb.append(" world");
		System.out.println(sb);
		
		sb.replace(sb.indexOf("java"), sb.indexOf("java")+"java".length(), "Python");
		System.out.println(sb);
		
		System.out.println(sb.hashCode());	//��ȭ�� ����. �ƹ��� �����ص� ��ü�� ����.
		
		sb.reverse();
		System.out.println(sb);
		
	}
	
	public static void test02(String[] args) {
		String str1 = "Hello";
		System.out.println(str1.hashCode());
		
		str1 += "java";
		System.out.println(str1.hashCode());	//hashCode�� �ٸ���. ���� �ٸ� ��ü�� ����Ѵ�.
	}
}
