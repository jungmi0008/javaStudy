package part7_Thread;

public class ThreadB extends Thread{
	int total;
    @Override
    public void run(){
        synchronized(this){
            for(int i=0; i<5 ; i++){
                System.out.println(i + "를 더합니다.");
                total += i;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            notify();	//정지되었던 메인쓰레드를 재개한다.
            			//자기자신을 재개하게 할거였으면 this를 썼을 거다.
        }//end of synchronized
    }//end of run
}
