package part7_Thread;
//join�޼ҵ�� �����尡 ���� ������ ���θ޼ҵ尡 ��ٸ��� �ϴ� �޼ҵ�
public class JoinExam {
	public static void main(String[] args) {
        MyThread5 thread = new MyThread5();
        // Thread ���� 
        thread.start(); 
        System.out.println("Thread�� ����ɶ����� ��ٸ��ϴ�.");
        try {
            // �ش� �����尡 ���⶧���� ����
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread�� ����Ǿ����ϴ�."); 
    }   
}
