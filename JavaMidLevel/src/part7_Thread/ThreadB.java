package part7_Thread;

public class ThreadB extends Thread{
	int total;
    @Override
    public void run(){
        synchronized(this){
            for(int i=0; i<5 ; i++){
                System.out.println(i + "�� ���մϴ�.");
                total += i;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            notify();	//�����Ǿ��� ���ξ����带 �簳�Ѵ�.
            			//�ڱ��ڽ��� �簳�ϰ� �Ұſ����� this�� ���� �Ŵ�.
        }//end of synchronized
    }//end of run
}
