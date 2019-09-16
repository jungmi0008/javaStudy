package org.javastudy.midlevel;

import java.text.SimpleDateFormat;
import java.util.Date;

//DateŬ������ java.util�� �ִ�.
//Date�� ������ ���� �ٸ��� �����Ǿ� ���� �ʴ�.
//�̷� �Ѱ����� �غ��ϱ� ���ؼ� ���� ���� calendarŬ������.

public class DateExam {

	public static void main(String[] args) {
		Date date = new Date();	//���׸��� �ƴ϶� �⺻�����ڷ� �����.
		System.out.println(date.toString());
		//KST�� �ѱ� ǥ�ؽð��̶�� ��
		
		//���� ���ϴ� �������� ����غ� �� �ִ�.
		SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd' at 'hh:mm:ss a zzz");
		System.out.println(ft.format(date));	//format�� �̿��ؼ� ���� �����´�.
		
		//����ð��� long������ �������� ���
		System.out.println(date.getTime());
		
		//�� �ٸ� ������� ����ð��� long���� �������� ���
		long today = System.currentTimeMillis();
		System.out.println(today);
		
		//�ڵ� ���̿� �ɸ� �ð��� ���� ���� �ִ�.
		System.out.println(today-date.getTime());
	}

}
