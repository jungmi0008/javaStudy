package bingo;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Bingo extends JFrame {
	final	int	SIZE = 5; //빙고판의 크기
	JButton[] btnArr = null;
	String[] birds = { //버튼에 넣을 글자들을 배열로 만든다.
			"참새", "두루미", "황새",   "비둘기", "까오기",
			"까치", "까마귀", "앵무새", "꾀꼬리", "고니",
			"거위", "독수리", "콘돌",   "봉황",   "공작",
			"오리", "타조",   "부엉이", "올빼미", "뱁새",
			"꿩",   "닭",     "구관조", "잉꼬",   "매"
	};
	
	Bingo() {
		this("빙고 게임");
	}
	
	Bingo(String title) {
		super(title);
		setLayout(new GridLayout(SIZE, SIZE)); //빙고판을 구성하기 위해서 GRID를 사용
		MyEventHandler handler = new MyEventHandler();
		addWindowListener(handler);
		
		btnArr = new JButton[SIZE*SIZE];
		
		//Frame에 버튼을 추가한다.
		for(int i = 0; i < SIZE*SIZE; i++) {
			btnArr[i] = new JButton(birds[i]); //배열 birds의 값을 버튼의 이름으로 한다.
			btnArr[i].addActionListener(handler);
			add(btnArr[i]); //버튼을 Frame에 추가한다.
		}
		setBounds(500, 200, 500, 500);
		setVisible(true);
	}

	class MyEventHandler extends WindowAdapter implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			JButton btn = (JButton)ae.getSource();
			//눌려진 버튼의 글자를 콘솔에 출력한다.
			System.out.println(btn.getText());
			//백그라운드를 밝은 회색으로 변경한다.
			btn.setBackground(Color.LIGHT_GRAY);
		}
		//Frame의 우측상단에 있는 x버튼(닫기버튼)을 누르면 프로그램을 종료한다.
		public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);
			e.getWindow().dispose();
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		Bingo win = new Bingo("빙고 게임");
	}

}
















