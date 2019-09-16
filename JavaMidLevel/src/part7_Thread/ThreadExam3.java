package part7_Thread;
//Thread와 공유객체
//run안의 세개의 메소드가 동시에 호출되지 않게 한개를 정지시키고 다른것 하나는 수행하도록 할 수 있다.
//synchronized가 붙게 되면 한 메소드가 실행이 완료되면 그 다음 메소드가 실행하게 된다.
//이에 대한 조절은 wait과 notify로 할 수 있다.
//synchronized가 없으면 있는 메소드들과 달리 그래도 실행이 된다.

public class ThreadExam3 {
    public static void main(String[] args) {
        // MusicBox 인스턴스
        MusicBox box = new MusicBox();

        MusicPlayer kim = new MusicPlayer(1, box);
        MusicPlayer lee = new MusicPlayer(2, box);
        MusicPlayer kang = new MusicPlayer(3, box);

        // MusicPlayer쓰레드를 실행합니다. 
        kim.start();
        lee.start();
        kang.start();      
        
        System.out.println("main 종료");
    }   
}