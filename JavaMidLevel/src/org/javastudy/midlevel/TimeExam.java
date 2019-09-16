package org.javastudy.midlevel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

//Date �� �Ѱ����� ����.
//�׷��� Joda-Time�� ���̺귯���� �����ϱ⵵ �ϰ� JDK8���� ���ο� API�� �����ȴ�.
public class TimeExam {

	public static void main(String[] args) {
		LocalDateTime timePoint = LocalDateTime.now();	//����ð� ��¥�� �ð� ���
		System.out.println("���� ��¥�� �ð�: "+timePoint);
		
		//get�޼ҵ带 �̿��ϴ� ���
		//��¥�� �ð��� ��� ������ �ִ� timePoint���� �ʿ信 �°� ������ �ٲپ� ���
		LocalDate theDate = timePoint.toLocalDate();
		System.out.println("��¥�� ���: "+theDate);	//���糯¥
		
		System.out.println("���� ���� ��� : "+timePoint.getMonthValue()+"��");	//int Ÿ������ ���
		System.out.println("���� ���� ����� ���: "+timePoint.getMonth());	//����� �� ���
	
		//��ü�� ���� �� of�� ����Ѵ�. new�� ���� �ʴ´�.
		LocalDate ld1 = LocalDate.of(2012, Month.DECEMBER, 12);	//���� �Է��� �ð�
		System.out.println("���� �Է��� ��¥: "+ld1);
		
		LocalTime lt1 = LocalTime.of(17,18);	//int������
		System.out.println("���� �Է��� �ð�: "+lt1);
		LocalTime lt2 = LocalTime.parse("10:15:30");	//���ڿ���
		System.out.println("���ڿ��� �Է��� �ð�: "+lt2);					
	}

}
