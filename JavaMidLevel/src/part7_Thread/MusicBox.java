package part7_Thread;
//run안에 있는 여러 메소드를 정의하는 클래스
public class MusicBox {
	 //신나는 음악!!! 이란 메시지가 1초이하로 쉬면서 10번 반복출력
    public synchronized void playMusicA(){
        for(int i = 0; i < 10; i ++){
            System.out.println("신나는 음악!!!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } // for        
    } //playMusicA

    //슬픈 음악!!!이란 메시지가 1초이하로 쉬면서 10번 반복출력
    public void playMusicB(){		//synchronized가 없으면 위의 메소드들과 달리 그래도 실행이 된다.
        for(int i = 0; i < 10; i ++){
            System.out.println("슬픈 음악!!!");
            try {
                Thread.sleep((int)(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } // for        
    } //playMusicB
    //카페 음악!!! 이란 메시지가 1초이하로 쉬면서 10번 반복출력
    public void playMusicC(){				//메소드 전체에 synchronized하면 너무 길어져서 다음 메소드가 나오는 시간이 길어진다.	
        for(int i = 0; i < 10; i ++){		//필요한 부분만 동기화블록으로 감쌀 수 있다.
        	synchronized (this) {
        		System.out.println("카페 음악!!!");	//한줄만 감싸져 있기 때문에 한번만 먼저 나오고 결국 다시 락을 뺏기게 된다.
			}
            try {
                Thread.sleep((int)(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } // for        
    } //playMusicC  
}
