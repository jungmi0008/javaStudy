package org.javastudy.midlevel;

import java.util.Calendar;

//Date�� �ٸ��� �������� ������ �ִ�.
public class CalendarExam {

	public static void main(String[] args) {
		//Calendar�� �߻�Ŭ�����̱� ������ new�� �����ڸ� ���� �� ����. �� �ν��Ͻ�ȭ �� �� ����.
		//�׷��� getInstance()�� ����ؾ� �Ѵ�.
		//Calendar�� �ڱ� �ڽ��� ������ �� ����. Calendar�� ���� �ڽ� Ŭ������ ���� ���ϵȴ�.
		//Calendar���Դ� Gregorian Calendar��� �ڽ� Ŭ������ �ִµ�
		//���� �����δ�  Gregorian�� �ν��Ͻ�ȭ �Ǿ� ���ϵǴ� ���̴�.
		//�̷��� ������ ������ ���Ŀ� ���ο� ������ Ķ������ ����� �� �ִ� ���ɼ� �����̴�.
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR)+"��");	//����� �������� ���̱� ������ Calendar. �̶�� ����.
		System.out.println(cal.get(Calendar.MONTH)+1+"��");	//���� 0~11�̶� 1 ��������Ѵ�.
		System.out.println(cal.get(Calendar.DATE)+"��");
		
		System.out.println(cal.get(Calendar.HOUR_OF_DAY)+"��");	//24�÷� ����
		System.out.println(cal.get(Calendar.HOUR)+"��");			//12�÷� ����
	
		cal.add(Calendar.HOUR, -5);	//5�ð� ��
		System.out.println(cal.get(Calendar.HOUR)+"��");
		
		cal.add(Calendar.DATE, 100);	//100�� ��
		System.out.print(cal.get(Calendar.YEAR)+"�� ");
		System.out.print(cal.get(Calendar.MONTH)+1+"�� ");
		System.out.print(cal.get(Calendar.DATE)+"�� ");
	}

}
