package bingo;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Bingo2 extends JFrame {
	final	int	SIZE = 5; //빙고판의 크기
	JButton[] btnArr = null;
	String[] birds = { //버튼에 넣을 글자들을 배열로 만든다.
			"참새", "두루미", "황새",   "비둘기", "까오기",
			"까치", "까마귀", "앵무새", "꾀꼬리", "고니",
			"거위", "독수리", "콘돌",   "봉황",   "공작",
			"오리", "타조",   "부엉이", "올빼미", "뱁새",
			"꿩",   "닭",     "구관조", "잉꼬",   "매"
	};
	
	//버튼위치에 숨겨져 있는 숫자를 담을 배열 변수
	int[] bingNum = new int[SIZE*SIZE];
	
	//완성된 라인의 수를 저장할 변수
	int bingoCount = 0;
	
	//빙고판 체크여부를 확인하기 위한 배열
	private boolean[][] btnOX = new boolean[SIZE][SIZE];
	
	//빙고판 상단에 메시지를 보여주기 위해서
	JLabel msgView = new JLabel("빙고");
	
	Bingo2() {
		this("빙고 게임");
	}
	
	Bingo2(String title) {
		super(title);
		setLayout(null); //레이아웃 매니저를 해제한다.
		
		JPanel p1 = new JPanel(); //메시지를 보여주는 영역
		JPanel p2 = new JPanel(); //버튼을 배치할 영역
		
		p1.setBackground(new Color(33, 99, 255));
		msgView.setFont(new Font("굴림", Font.ITALIC+Font.BOLD, 24));
		msgView.setForeground(Color.WHITE);
		
		//버튼이 올라갈 JPanel의 레이아웃을 그리드레이아웃으로 한다.
		p2.setLayout(new GridLayout(SIZE, SIZE));
		
		MyEventHandler handler = new MyEventHandler();
		addWindowListener(handler);
		
		//5x5=25개의 버튼을 담을 객체배열을 만든다.
		btnArr = new JButton[SIZE*SIZE];
		
		//버튼 위치에 숨겨져 있는 숫자를 만든다(bingNum)
		//단, 1~25까지의 숫자가 중복되게 만들면 않된다.
		for(int i = 0; i < SIZE*SIZE; i++) {
			bingNum[i] = (int)(Math.random() * (SIZE*SIZE) + 1);
			//맨처음에 뽑은 숫자는 비교할 필요가 없다.
			if(i > 0) {
				//현재 뽑은 숫자 전의 숫자들과 비교를 한다.
				for(int j = 0; j < i; j++) {
					if(bingNum[j] == bingNum[i]) {
						i--; //다시 숫자를 뽑을 수 있게 i값을 감소시킨다.
					}
				}
			}
		}
		
		//p2에 버튼을 추가한다.
		for(int i = 0; i < SIZE*SIZE; i++) {
			btnArr[i] = new JButton(birds[i]); //버튼을 만들 때 이름도 같이 넣어준다.
			btnArr[i].addActionListener(handler);
			p2.add(btnArr[i]); //만든 버튼을 JPanel에 부착한다.
		}
		//Frame에 컴포넌트들을 배치시킨다.
		p1.add(msgView);
		//p1.setSize(500, 40);
		p1.setBounds(0,  0, 500,  40);
		p2.setBounds(0, 40, 500, 500);
		
		add(p1);
		add(p2);
		
		setBounds(500, 200, 510, 580);
		setVisible(true);
	}
	
	class MyEventHandler extends WindowAdapter implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			JButton btn = (JButton)ae.getSource();
			
			for(int i = 0; i < SIZE*SIZE; i++) {
				if((JButton)btn == btnArr[i]) {
					System.out.println("Selected Button Number : " + i);
					btnArr[i].setFont(new Font("Arial", Font.BOLD, 28));
					btnArr[i].setText(String.valueOf(bingNum[i]));
					
					//현재 누른 버튼에 해당하는 btnOX를 true로 바꾼다.
					int cnt = 0;
					for(int x = 0; x < SIZE; x++) {
						for(int y = 0; y < SIZE; y++) {
							if(i == cnt) {
								btnOX[x][y] = true;
							}
							cnt++;
						}
					}
				}
			}
			btn.setBackground(Color.YELLOW); //선택한 버튼의 배경색을 변경한다.
			
			//빙고가 완성되었는지 검사한다.
			if(checkBingo() == true) {
				String str = null;
				str = "축하합니다. 5줄을 모두 맞추셨습니다.!!!";
				System.out.println(str);
				
				//빙고판 상단에다가 축하메시지를 보여준다.
				msgView.setText(str);
				JOptionPane.showMessageDialog(null, str, "Message", JOptionPane.ERROR_MESSAGE);
				//게임을 다시 시작할 수 있도록 한다.
				dispose();
				new Bingo2("빙고 게임");
			}
			//빙고판의 상태를 콘솔에 출력한다.
			displayOX();
		}
		
		//Frame의 우측 상단의 x버튼을 누르면 프로그램을 종료하게 한다.
		public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);
			e.getWindow().dispose();
			System.exit(0);
		}
		
		
	} // End - class MyEventHandler extends WindowAdapter implements ActionListener
	
	//콘솔에 OX를 출력한다.
	public void displayOX() { 
		//배열 btnOX를 콘솔화면에 출력한다. 
		//false => X, true => O 로 바꾸어서 출력하자.
		for(int i = 0; i < btnOX.length; i++) {
			for(int j = 0; j < btnOX[i].length; j++) {
				//if(btnOX[i][j] == false) System.out.print("X");
				//else if(btnOX[i][j] == true) System.out.print("O");
				System.out.print(btnOX[i][j] ? "O" : "X");
			}
			System.out.println();
		}
		System.out.println("현재 맞춘 줄의 개수 : " + bingoCount);
		System.out.println("------------------------------------------");
		msgView.setText("현재 맞춘 줄의 개수 : " + bingoCount);
	}
	
	//빙고가 완성되었는지 검사한다.
	boolean checkBingo() {
		this.bingoCount	= 0; //완성된 라인의 수
		int	garoCnt		= 0; //가로
		int	seroCnt		= 0; //세로
		int	crossCnt1	= 0; //대각선
		int	crossCnt2	= 0; //역대간선
		
		for(int i = 0; i < btnOX.length; i++) 
		{
			for(int j = 0; j < btnOX[i].length; j++) 
			{
				//가로검사 : 5개가 가로로 연속으로 되어있는 것은 green으로 배경색을 바꾼다.
				if(btnOX[i][j] == true) {
					garoCnt++; //O인 것의 개수를 누적시킨다.
					
					//2차원배열을 1차원배열의 형식으로 만들어서 비교한다.
					//begin과 end를 이용하여 만든다.
					if(garoCnt == SIZE) {
						int	begin	= i * SIZE;
						int	end		= begin + SIZE;
						for(int n = begin; n < end; n++) {
							btnArr[n].setBackground(Color.GREEN);
						}
					}
				}
				//세로검사 : 5개가 세로로 연속으로 되어있는 것은 green으로 배경색을 바꾼다.
				if(btnOX[j][i] == true) {
					seroCnt++; 
					if(seroCnt == SIZE) {
						//5씩 증가시켜서 색상을 변경시킨다.
						for(int n = i; n < btnArr.length; n = n + 5) {
							btnArr[n].setBackground(Color.GREEN);
						}
					}
				}
				//대각선 검사(↘)
				if(i == j && btnOX[i][j] == true) {
					crossCnt1++;
					if(crossCnt1 == SIZE) {
						//대각선(↘)으로 0부터 24까지 6씩 증가하여 색상을 변경한다.
						for(int n = 0; n < btnArr.length; n = n + 6) {
							btnArr[n].setBackground(Color.green);
						}
					}
				}
				//역대각선 검사(↙)
				//row가 증가할 때 column의 값이 4,3,2,1을 검사하면 된다.
				if(((btnOX.length-1)-i) == j && btnOX[i][j] == true) {
					crossCnt2++;
					if(crossCnt2 == SIZE) {
						for(int n = (btnArr.length - 4); n > 0; n--) {
							if(n % 4 == 0) {
								btnArr[n].setBackground(Color.green);
							}
						}
					}
				}
			} //row for문
			
			//한 줄에 대한 검사가 끝났으면 가로줄의 값이 5인지 확인한다.
			if(garoCnt == SIZE)
				bingoCount++;
			//한 줄에 대한 검사가 끝났으면 세로줄의 값이 5인지 확인한다.
			if(seroCnt == SIZE)
				bingoCount++;
			
			//검사에 사용된 변수를 초기화한다.
			garoCnt = 0;
			seroCnt = 0;
			
		} //column for문
		//대각선과 역대각슨은 1개씩 존재하므로 1번씩만 검사하면 된다.
		if(crossCnt1 == SIZE)
			bingoCount++;
		if(crossCnt2 == SIZE)
			bingoCount++;
		
		//System.out.println("맞춘 줄의 개 수 : " + bingoCount);
		return bingoCount >= SIZE;
	}
	
	public static void main(String[] args) {
		// 빙고판 밑에 임의의 숫자(1 ~ 25)를 생성하여 숨겨둔다.
		// 숫자를 클릭하면 가로,세로,사선의 4방향에 대해서
		// 연속하여 5개가 맞추어졌는지 검사한다.
		new Bingo2("빙고 게임");
	}

}







