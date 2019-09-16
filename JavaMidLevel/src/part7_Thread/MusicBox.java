package part7_Thread;
//run�ȿ� �ִ� ���� �޼ҵ带 �����ϴ� Ŭ����
public class MusicBox {
	 //�ų��� ����!!! �̶� �޽����� 1�����Ϸ� ���鼭 10�� �ݺ����
    public synchronized void playMusicA(){
        for(int i = 0; i < 10; i ++){
            System.out.println("�ų��� ����!!!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } // for        
    } //playMusicA

    //���� ����!!!�̶� �޽����� 1�����Ϸ� ���鼭 10�� �ݺ����
    public void playMusicB(){		//synchronized�� ������ ���� �޼ҵ��� �޸� �׷��� ������ �ȴ�.
        for(int i = 0; i < 10; i ++){
            System.out.println("���� ����!!!");
            try {
                Thread.sleep((int)(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } // for        
    } //playMusicB
    //ī�� ����!!! �̶� �޽����� 1�����Ϸ� ���鼭 10�� �ݺ����
    public void playMusicC(){				//�޼ҵ� ��ü�� synchronized�ϸ� �ʹ� ������� ���� �޼ҵ尡 ������ �ð��� �������.	
        for(int i = 0; i < 10; i ++){		//�ʿ��� �κи� ����ȭ������� ���� �� �ִ�.
        	synchronized (this) {
        		System.out.println("ī�� ����!!!");	//���ٸ� ������ �ֱ� ������ �ѹ��� ���� ������ �ᱹ �ٽ� ���� ����� �ȴ�.
			}
            try {
                Thread.sleep((int)(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } // for        
    } //playMusicC  
}
