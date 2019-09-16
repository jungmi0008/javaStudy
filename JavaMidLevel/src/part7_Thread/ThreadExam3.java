package part7_Thread;
//Thread�� ������ü
//run���� ������ �޼ҵ尡 ���ÿ� ȣ����� �ʰ� �Ѱ��� ������Ű�� �ٸ��� �ϳ��� �����ϵ��� �� �� �ִ�.
//synchronized�� �ٰ� �Ǹ� �� �޼ҵ尡 ������ �Ϸ�Ǹ� �� ���� �޼ҵ尡 �����ϰ� �ȴ�.
//�̿� ���� ������ wait�� notify�� �� �� �ִ�.
//synchronized�� ������ �ִ� �޼ҵ��� �޸� �׷��� ������ �ȴ�.

public class ThreadExam3 {
    public static void main(String[] args) {
        // MusicBox �ν��Ͻ�
        MusicBox box = new MusicBox();

        MusicPlayer kim = new MusicPlayer(1, box);
        MusicPlayer lee = new MusicPlayer(2, box);
        MusicPlayer kang = new MusicPlayer(3, box);

        // MusicPlayer�����带 �����մϴ�. 
        kim.start();
        lee.start();
        kang.start();      
        
        System.out.println("main ����");
    }   
}