package part7_Thread;

public class ThreadA {
	public static void main(String[] args){
        // �տ��� ���� ������ B�� ���� �����ڸ� ���� �� start 
        // �ش� �����尡 ����Ǹ�, �ش� ������� run�޼ҵ� �ȿ��� �ڽ��� ����͸� ���� ȹ��
        ThreadB b = new ThreadB();
        b.start();

        // TheardB�� �ش��ϴ� b�� ���Ͽ� ����ȭ ���� ����
        // ���� main�����尡 �Ʒ��� ����� ���� Thread���� ���� ����Ǿ��ٸ� wait�� �ϰ� �Ǹ鼭 ����͸� ���� ���� ���       
        synchronized(b){
            try{
                // b.wait()�޼ҵ带 ȣ��.
                // ���ξ������ ����
                // ThreadB�� 5�� ���� ���� �� notify�� ȣ���ϰ� �Ǹ� wait���� ���
                System.out.println("b�� �Ϸ�ɶ����� ��ٸ��ϴ�.");
                b.wait();	//run�� ������ �ǹ��ϴ� ���� �ƴϴ�.
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            //��� �� ����� ���
            System.out.println("Total is: " + b.total);
        }
    }
}
