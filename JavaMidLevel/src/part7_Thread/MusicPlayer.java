package part7_Thread;

public class MusicPlayer extends Thread {
	int type;
	MusicBox musicBox;

	// 생성자로 부터 musicBox와 정수를 하나 받아들여서 필드를 초기화
	public MusicPlayer(int type, MusicBox musicBox) {
		this.type = type;
		this.musicBox = musicBox;
	}

	// type이 무엇이냐에 따라서 musicBox가 가지고 있는 메소드가 다르게 호출
	public void run() {
		switch (type) {
		case 1:
			musicBox.playMusicA();
			break;
		case 2:
			musicBox.playMusicB();
			break;
		case 3:
			musicBox.playMusicC();
			break;
		}
	}
}
