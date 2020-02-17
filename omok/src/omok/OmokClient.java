package omok;

import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.JList;

//--------------------------------------------------------------------------
//오목판을 구현하는 클래스
//--------------------------------------------------------------------------
class OmokBoard extends Canvas {
	//흑돌과 백돌을 나타내는 상수
	public	static final int BLACK = 1, WHITE = -1;
	private	int[][]	map;			//오목판 배열
	private	int		size;			//격자의 가로 또는 세로 개수.(15개로 지정한다)
	private	int		cell;			//격자의 크기(pixel)
	private	String	info  = "게임 중지";	//게임의 진행상황을 나타내는 문자열
	private	int		color = BLACK;	//사용자의 돌 색깔
	
	//true 이면 사용자가 돌을 놓을 수 있는 상태를 의미하고,
	//false이면 사용자가 돌을 놓을 수 없는 상태를 의미한다.
	private	boolean	enable	= false;
	
	private	boolean	running = false;	//게임이 진행 중인가를 나타내는 변수
	private	PrintWriter	writer;			//상대편에게 메시지를 전달하기 위한 스트림
	private	Graphics gboard, gbuff;		//캔버스와 버퍼를 위한 그래픽스 객체
	private	Image	buff;				//더블 버퍼링을 위한 버퍼
	
	//--------------------------------------------------------------------------
	// 오목판의 생성자(s=15, c=15)
	//--------------------------------------------------------------------------
	OmokBoard(int s, int c) {
		this.size	= s;
		this.cell	= c;
		
		map = new int[size+2][]; //맵의 크기를 정한다.
		for(int i = 0; i < map.length; i++) {
			map[i] = new int[size+2];
		}
		//오목판의 배경색을 지정한다.
		setBackground(new Color(206, 167, 61));
		//오목판의 크기를 계산한다.
		//setSize(size * (cell+1) + size, size * (cell + 1) + size);
		//돌의 크기를 cell의 크기만하게 그리기 때문에 여유를 주기위해서 cell+1을 사용했다.
		setSize(size * (cell+1) + size, size * (cell + 1) + size);

		//--------------------------------------------------------------------------
		// 오목판의 마우스 이벤트 처리
		//--------------------------------------------------------------------------
		addMouseListener(new MouseAdapter() {
			//마우스를 누르면
			public void mousePressed(MouseEvent me) {
				if(!enable)
					return; //사용자가 마우스를 누를 수 없는 상태이면 빠져 나온다.
				
				//마우스의 좌표를 map의 좌표로 계산한다.
				int x = (int)Math.round(me.getX() / (double)cell);
				int y = (int)Math.round(me.getY() / (double)cell);
				//int x = (int)Math.round(me.getX() / cell);
				//int y = (int)Math.round(me.getY() / cell);
				System.out.println(me.getX() + ", " + me.getY() + " 돌의 좌표: (" + x + ", " + y + ")");
				
				//돌이 놓일 수 있는 좌표가 아니면 빠져 나온다.
				if(x == 0 || y == 0 || x == size + 1 || y == size +1)
					return;
				
				//해당 좌표에 다른 돌이 놓여져 있으면 빠져 나온다.
				if(map[x][y] == BLACK || map[x][y] == WHITE)
					return;
				
				//상대편에게 놓은 돌의 좌표를 전송한다.
				writer.println("[STONE]" + x + " " + y);
				
				map[x][y] = color;
				
				//--------------------------------------------------------------------------
				// java.awt.Point
				// 1. Point클래스는 좌표 사의 어떤 위치를 나타내는데 사용한다.
				// 2. 각종 프레임이나 다른 컴포넌트의 위치를 설정할 때 사용한다.
				// 3. x와 y좌표값을 저장하기 위한 멤버변수를 가지고 있다.
				//--------------------------------------------------------------------------
				//이겼는지 검사한다.
				if(check(new Point(x, y), color)) {
					info = "이겼습니다.";
					writer.println("[WIN]");
				} else {
					info = "상대방이 두기를 기다립니다.";
				}
				//오목판을 그린다.
				repaint();
				
				//사용자가 돌을 둘 수없는 상태로 만든다.
				//상대편이 두면 enable이 true가 되어 사용자가 둘 수 있게 된다.
				enable = false;
			}
		});
	} // End - OmokBoard(int s, int c)

	//--------------------------------------------------------------------------
	// 게임의 진행 상태를 반환한다.
	//--------------------------------------------------------------------------
	public boolean isRunning() {
		return running;
	}
	
	//--------------------------------------------------------------------------
	// 게임을 시작한다.
	//--------------------------------------------------------------------------
	public void startGame(String col) {
		running = true;
		if(col.equals("BLACK")) {
			//흑돌이 선택되었으면
			enable = true;
			color  = BLACK;
			info   = "게임 시작. 돌을 두세요.";
		} else {
			//흰돌이 선택되었으면
			enable = false;
			color  = WHITE;
			info   = "게임 시작. 상대가 돌을 둘 차례입니다.";
		}
	}
	//--------------------------------------------------------------------------
	// 게임을 멈춘다
	//--------------------------------------------------------------------------
	public void stopGame() {
		reset();	//오목판을 초기화한다.
		writer.println("[STOPGAME]"); //상대방에게 메시지를 보낸다.
		enable	= false;
		running	= false;
	}
	//--------------------------------------------------------------------------
	// 상대편의 돌을 내 화면에 그린다.
	//--------------------------------------------------------------------------
	public void putOpponent(int x, int y) {
		//map정보에 추가한다.
		map[x][y] = -color;
		info = "상대가 돌을 두었습니다. 돌을 두세요.";
		repaint();
	}
	//--------------------------------------------------------------------------
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	//--------------------------------------------------------------------------
	public void setWriter(PrintWriter writer) {
		this.writer = writer;
	}
	//--------------------------------------------------------------------------
	// AWT 쓰레드는 다음과 같은 경우 paint()를 자동호출해서 화면을 갱신한다.
	// 1.처음 화면에 나타날 때
	// 2.다른 화면에 가려져 있던 부분이 다시 화면에 나타날 때
	// 3.아이콘화 되어 있다가 원래 크기로 화면에 나타날 때
	//
	// 화면이 강제적으로 다시 그려지게 하려면 repaint()를 호출하면 된다.
	// 화면갱신을 요청받으면 AWT쓰레드는 update()를 호출하고,
	// update()는 화면을 지운 후에 paint()를 호출한다.
	//
	// repaint() : AWT쓰레드에게 화면을 갱신할 것을 요청한다.
	//             AWT쓰레드는 0.1초마다 확인을 해서 요청이 있으면 
	//             update(Graphice g)를 호출한다.
	// update(Graphics g) : 화면을 지우고 paint(Graphics g)를 호출한다.
	// repaint() => update(Graphics g) => paint(Graphics g)
	//--------------------------------------------------------------------------
	
	//--------------------------------------------------------------------------
	// repaint를 호출하면 자동으로 호출된다.
	//--------------------------------------------------------------------------
	public void update(Graphics g) {
		paint(g); //paint를 호출한다.
	}
	//--------------------------------------------------------------------------
	// 화면을 그린다.
	//--------------------------------------------------------------------------
	public void paint(Graphics g) {
		if(gbuff == null) {
			//버퍼가 없으면 버퍼를 만든다.
			buff = createImage(getWidth(), getHeight());
			gbuff = buff.getGraphics();
		}
		drawBoard(g); //오목판을 그린다.
	}
	//--------------------------------------------------------------------------
	// 오목판을 초기화 한다.
	//--------------------------------------------------------------------------
	public void reset() {
		//맵의 정보를 모두 지운다.
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				map[i][j] = 0;
			}
		}
		info = "게임 중지";
		repaint();
	}
	//--------------------------------------------------------------------------
	// 오목판에 선을 긋는다.
	//--------------------------------------------------------------------------
	private void drawLine() {
		gbuff.setColor(Color.black);
		for(int i = 1; i <= size; i++) {
			gbuff.drawLine(cell, i * cell, cell * size, i * cell); //가로 줄
			gbuff.drawLine(i * cell, cell, i * cell, cell * size); //세로 줄
		}
	}
	//--------------------------------------------------------------------------
	// 흑 돌을 (x, y)에 그린다.
	//--------------------------------------------------------------------------
	private void drawBlack(int x, int y) {
		////Graphics2D gbuff = (Graphics2D)this.gbuff;
		gbuff.setColor(Color.black);
		gbuff.fillOval(x*cell-cell/2, y*cell-cell/2, cell, cell);
		//검은 돌의 테두리를 흰색으로 그린다.
		gbuff.setColor(Color.white);
		gbuff.drawOval(x*cell-cell/2, y*cell-cell/2, cell, cell);
	}
	//--------------------------------------------------------------------------
	// 흰 돌을 (x, y)에 그린다.
	//--------------------------------------------------------------------------
	private void drawWhite(int x, int y) {
		gbuff.setColor(Color.white);
		gbuff.fillOval(x*cell-cell/2, y*cell-cell/2, cell, cell);
	}
	//--------------------------------------------------------------------------
	// map 에 놓여진 돌들을 모두 그린다.
	//--------------------------------------------------------------------------
	private void drawStones() {
		for(int x = 1; x <= size; x++) {
			for(int y = 1; y <= size; y++) {
				if(map[x][y] == BLACK)
					drawBlack(x, y);
				else if(map[x][y] == WHITE)
					drawWhite(x, y);
			}
		}
	}
	//--------------------------------------------------------------------------
	// 오목판을 그린다.
	//--------------------------------------------------------------------------
	synchronized private void drawBoard(Graphics g) {
		//버퍼에 먼저 그리고 버퍼의 이미지를 오목판에 그린다.
		gbuff.clearRect(0, 0, getWidth(), getHeight());
		drawLine();
		drawStones();
		gbuff.setColor(Color.red);
		gbuff.drawString(info, 20, 15);
		g.drawImage(buff, 0, 0, this);
	}
	//--------------------------------------------------------------------------
	// 지금 둔 돌 주위로 연속해서 같은 색깔의 돌이 4개면 오목이 성립된다.
	// 4가지 방향에 대해서 검사를 해야한다.
	//--------------------------------------------------------------------------
	private boolean check(Point p, int col) {
		
		if(count(p,  1,  0, col) + count(p,-1, 0, col) == 4) //가로우측 + 가로좌측
			return true;
		if(count(p,  0,  1, col) + count(p, 0,-1, col) == 4) //세로하단 + 세로상단
			return true;
		if(count(p, -1, -1, col) + count(p, 1, 1, col) == 4) //＼
			return true;
		if(count(p,  1, -1, col) + count(p,-1, 1, col) == 4) //／
			return true;
		return false;
	}
	//--------------------------------------------------------------------------
	// 지금 둔 돌 주위로 연속해서 같은 색깔의 돌의 갯수를 반환한다.
	// dx, dy의 값이 양수와 음수로 구분하는 것은 검사방향을 의미한다.
	// (dx,dy)의 값이 (1,0)이면 y좌표는 고정되고 x축만 검사하게 된다.
	// (dx,dy)의 값이 (0,1)이면 x좌펴는 고정되고 y축만 검사하게 된다.
	// dx값이 1이면 우측방향으로 검사하고, -1이면 좌측방향으로 검사를 한다.
	// dy값이 1이면 아래방향으로 감사하고, -1이면 위쪽방향으로 감사를 한다.
	//--------------------------------------------------------------------------
	
	//--------------------------------------------------------------------------
	// map[x][y]에 사용되는 x, y는 row와 column을 의미하는 것이 아니라,
	// 돌이 놓여지는 위치 x, y를 의미한다.
	//--------------------------------------------------------------------------
	private int count(Point p, int dx, int dy, int col) {
		//for문의 초기화부분을 for문 바깥에 선언한 것은 i의 계산된 결과를
		//리턴할 때 사용하기 위해서
		int i = 0;
		for( ; map[p.x + (i+1) * dx][p.y + (i+1) * dy] == col; i++)
			;
		return i;
	}
		
} // End - class OmokBoard extends Canvas

//-----------------------------------------------------------------------------
//public class OmokClient extends JFrame implements Runnable, ActionListener
//-----------------------------------------------------------------------------
public class OmokClient extends JFrame implements Runnable, ActionListener {
	//private TextArea 	msgView = new TextArea("", 1, 1, 1);	// 메시지를 보여주는 영역
	private JTextArea  msgView = new JTextArea("", 1, 1); 		// 메시지를 보여주는 영역
	private JTextField sendBox = new JTextField(""); 			// 보낼 메시지를 적는 상자
	private JTextField nameBox = new JTextField(); 				// 사용자 이름 상자
	private JTextField roomBox = new JTextField("0"); 			// 방 번호 상자

	// 방에 접속한 인원의 수를 보여주는 레이블
	private JLabel pInfo = new JLabel("대기실:  명");

	//private JList pList = new JList(); 					// 사용자 명단을 보여주는 리스트
	private java.awt.List pList = new java.awt.List(); 		// 사용자 명단을 보여주는 리스트
	private JButton startButton = new JButton("대국 시작"); // 대국 시작 버튼
	private JButton stopButton  = new JButton("기권"); 		// 기권 버튼
	private JButton enterButton = new JButton("입장하기"); 	// 입장하기 버튼
	private JButton exitButton  = new JButton("대기실로"); 	// 대기실로 버튼

	// 각종 정보를 보여주는 레이블
	//private Label infoView = new Label("<JAVA>", 1);
	private JLabel infoView = new JLabel("<JAVA>");

	//private OmokBoard board = new OmokBoard(15, 30); // 오목판 객체
	private OmokBoard board = new OmokBoard(15, 30); // 오목판 객체
	private BufferedReader reader; // 입력 스트림
	private PrintWriter writer; // 출력 스트림
	private Socket socket; // 소켓
	private int roomNumber = -1; // 방 번호
	private String userName = null; // 사용자 이름

	//-----------------------------------------------------------------------------
	// 생성자
	//-----------------------------------------------------------------------------
	public OmokClient(String title) { 
		super(title);
		setLayout(null); // 레이아웃을 사용하지 않는다.

		// 각종 컴포넌트를 생성하고 배치한다.
		msgView.setEditable(false);
		infoView.setBounds(10, 30, 480, 30);
		infoView.setBackground(new Color(200, 200, 255));
		board.setLocation(10, 70);
		add(infoView);
		infoView.setHorizontalAlignment(JLabel.CENTER); //add후에 사용해야 한다.
		
		add(board);
		JPanel p = new JPanel();
		p.setBackground(new Color(200, 255, 255));
		p.setLayout(new GridLayout(3, 3));
		p.add(new JLabel("이     름:", 2));
		p.add(nameBox);
		p.add(new JLabel("방 번호:", 2));
		p.add(roomBox);
		p.add(enterButton);
		p.add(exitButton);
		enterButton.setEnabled(false);
		p.setBounds(500, 30, 250, 70);

		JPanel p2 = new JPanel();
		p2.setBackground(new Color(255, 255, 100));
		p2.setLayout(new BorderLayout());
		JPanel p2_1 = new JPanel();
		p2_1.add(startButton);
		p2_1.add(stopButton);
		p2.add(pInfo, "North");
		p2.add(pList, "Center");
		p2.add(p2_1, "South");
		startButton.setEnabled(false);
		stopButton.setEnabled(false);
		p2.setBounds(500, 110, 250, 180);

		Panel p3 = new Panel();
		p3.setLayout(new BorderLayout());
		p3.add(msgView, "Center");
		p3.add(sendBox, "South");
		p3.setBounds(500, 300, 250, 250);

		add(p);
		add(p2);
		add(p3);

		// 이벤트 리스너를 등록한다.
		sendBox.addActionListener(this);
		enterButton.addActionListener(this);
		exitButton.addActionListener(this);
		startButton.addActionListener(this);
		stopButton.addActionListener(this);

		// 윈도우 닫기 처리
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}

	//-----------------------------------------------------------------------------
	// 컴포넌트들의 액션 이벤트 처리
	//-----------------------------------------------------------------------------
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == sendBox) { // 메시지 입력 상자이면
			String msg = sendBox.getText();
			if (msg.length() == 0)
				return;
			if (msg.length() >= 30)
				msg = msg.substring(0, 30);
			try {
				writer.println("[MSG]" + msg);
				sendBox.setText("");
			} catch (Exception ie) {
			}
		}

		else if (ae.getSource() == enterButton) { // 입장하기 버튼이면
			try {

				if (Integer.parseInt(roomBox.getText()) < 1) {
					infoView.setText("방번호가 잘못되었습니다. 1이상");
					return;
				}
				writer.println("[ROOM]" + Integer.parseInt(roomBox.getText()));
				msgView.setText("");
			} catch (Exception ie) {
				infoView.setText("입력하신 사항에 오류가 았습니다.");
			}
		}

		else if (ae.getSource() == exitButton) { // 대기실로 버튼이면
			try {
				goToWaitRoom();
				startButton.setEnabled(false);
				stopButton.setEnabled(false);
			} catch (Exception e) {
			}
		}

		else if (ae.getSource() == startButton) { // 대국 시작 버튼이면
			try {
				writer.println("[START]");
				infoView.setText("상대의 결정을 기다립니다.");
				startButton.setEnabled(false);
			} catch (Exception e) {
			}
		}

		else if (ae.getSource() == stopButton) { // 기권 버튼이면
			try {
				writer.println("[DROPGAME]");
				endGame("기권하였습니다.");
			} catch (Exception e) {
			}
		}
	}

	//-----------------------------------------------------------------------------
	// 대기실로 버튼을 누르면 호출된다.
	//-----------------------------------------------------------------------------
	void goToWaitRoom() { 
		if (userName == null) {
			String name = nameBox.getText().trim();
			if (name.length() <= 2 || name.length() > 10) {
				infoView.setText("Name Fault. 3~10");
				nameBox.requestFocus();
				return;
			}
			
			userName = name;
			
			/******************
			//dev.re.kr/87
			Charset euckrCharset	= Charset.forName("euc-kr");
			ByteBuffer byteBuffer 	= euckrCharset.encode(name);
			byte[] euckrStringBuffer = new byte[byteBuffer.remaining()];
			System.out.println("aaaa=>"+byteBuffer.get(euckrStringBuffer));
			*****************/
			
			//userName = name;
			//writer.println("[NAME]" + userName);
			writer.println("[NAME]" + userName);
			//nameBox.setText(byteBuffer.get(euckrStringBuffer));
			nameBox.setText(userName);
			nameBox.setEditable(false);
		}
		msgView.setText("");
		writer.println("[ROOM]0");
		infoView.setText("대기실에 입장하셨습니다.");
		roomBox.setText("0");
		enterButton.setEnabled(true);
		exitButton.setEnabled(false);
	}

	//-----------------------------------------------------------------------------
	// public void run()
	//-----------------------------------------------------------------------------
	public void run() {
		String msg; // 서버로부터의 메시지
		try {
			while ((msg = reader.readLine()) != null) {

				if (msg.startsWith("[STONE]")) { // 상대편이 놓은 돌의 좌표
					String temp = msg.substring(7);
					int x = Integer.parseInt(temp.substring(0,
							temp.indexOf(" ")));
					int y = Integer
							.parseInt(temp.substring(temp.indexOf(" ") + 1));
					board.putOpponent(x, y); // 상대편의 돌을 그린다.
					board.setEnable(true); // 사용자가 돌을 놓을 수 있도록 한다.
				}

				else if (msg.startsWith("[ROOM]")) { // 방에 입장
					if (!msg.equals("[ROOM]0")) { // 대기실이 아닌 방이면
						enterButton.setEnabled(false);
						exitButton.setEnabled(true);
						infoView.setText(msg.substring(6) + "번 방에 입장하셨습니다.");
					} else
						infoView.setText("대기실에 입장하셨습니다.");

					roomNumber = Integer.parseInt(msg.substring(6)); // 방 번호 지정

					if (board.isRunning()) { // 게임이 진행중인 상태이면
						board.stopGame(); // 게임을 중지시킨다.
					}
				}

				else if (msg.startsWith("[FULL]")) { // 방이 찬 상태이면
					infoView.setText("방이 차서 입장할 수 없습니다.");
				}

				else if (msg.startsWith("[PLAYERS]")) { // 방에 있는 사용자 명단
					nameList(msg.substring(9));
				}

				else if (msg.startsWith("[ENTER]")) { // 손님 입장
					pList.add(msg.substring(7));
					playersInfo();
					msgView.append("[" + msg.substring(7) + "]님이 입장하였습니다.\n");
				} else if (msg.startsWith("[EXIT]")) { // 손님 퇴장
					pList.remove(msg.substring(6)); // 리스트에서 제거
					playersInfo(); // 인원수를 다시 계산하여 보여준다.
					msgView.append("[" + msg.substring(6)
							+ "]님이 다른 방으로 입장하였습니다.\n");
					if (roomNumber != 0)
						endGame("상대가 나갔습니다.");
				}

				else if (msg.startsWith("[DISCONNECT]")) { // 손님 접속 종료
					pList.remove(msg.substring(12));
					playersInfo();
					msgView.append("[" + msg.substring(12) + "]님이 접속을 끊었습니다.\n");
					if (roomNumber != 0)
						endGame("상대가 나갔습니다.");
				}

				else if (msg.startsWith("[COLOR]")) { // 돌의 색을 부여받는다.
					String color = msg.substring(7);
					board.startGame(color); // 게임을 시작한다.
					if (color.equals("BLACK"))
						infoView.setText("흑돌을 잡았습니다.");
					else
						infoView.setText("백돌을 잡았습니다.");
					stopButton.setEnabled(true); // 기권 버튼 활성화
				}

				else if (msg.startsWith("[DROPGAME]")) // 상대가 기권하면
					endGame("상대가 기권하였습니다.");

				else if (msg.startsWith("[WIN]")) // 이겼으면
					endGame("이겼습니다.");

				else if (msg.startsWith("[LOSE]")) // 졌으면
					endGame("졌습니다.");

				// 약속된 메시지가 아니면 메시지 영역에 보여준다.
				else
					msgView.append(msg + "\n");
			}
		} catch (IOException ie) {
			msgView.append(ie + "\n");
		}
		msgView.append("접속이 끊겼습니다.");
	}

	//-----------------------------------------------------------------------------
	// 게임의 종료시키는 메소드
	//-----------------------------------------------------------------------------
	private void endGame(String msg) { 
		infoView.setText(msg);
		startButton.setEnabled(false);
		stopButton.setEnabled(false);

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		} // 2초간 대기

		if (board.isRunning())
			board.stopGame();
		if (pList.getItemCount() == 2)
			startButton.setEnabled(true);
	}

	//-----------------------------------------------------------------------------
	// 방에 있는 접속자의 수를 보여준다.
	//-----------------------------------------------------------------------------
	private void playersInfo() { 
		int count = pList.getItemCount();
		if (roomNumber == 0)
			pInfo.setText("대기실: " + count + "명");
		else
			pInfo.setText(roomNumber + " 번 방: " + count + "명");

		// 대국 시작 버튼의 활성화 상태를 점검한다.
		if (count == 2 && roomNumber != 0)
			startButton.setEnabled(true);
		else
			startButton.setEnabled(false);
	}

	//-----------------------------------------------------------------------------
	// 사용자 리스트에서 사용자들을 추출하여 pList에 추가한다.
	//-----------------------------------------------------------------------------
	private void nameList(String msg) {
		pList.removeAll();
		StringTokenizer st = new StringTokenizer(msg, "\t");
		while (st.hasMoreElements())
			pList.add(st.nextToken());
		playersInfo();
	}

	//-----------------------------------------------------------------------------
	// 연결
	//-----------------------------------------------------------------------------
	private void connect() { 
		try {
			msgView.append("서버에 연결을 요청합니다.\n");
			socket = new Socket("127.0.0.1", 7777);
			msgView.append("---연결 성공--.\n");
			msgView.append("이름을 입력하고 대기실로 입장하세요.\n");
			reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(), true);
			new Thread(this).start();
			board.setWriter(writer);
		} catch (Exception e) {
			msgView.append(e + "\n\n연결 실패..\n");
		}
	}

	//-----------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------
	public static void main(String[] args) {
		OmokClient client = new OmokClient("오목 게임");
		client.setSize(780, 660);
		client.setVisible(true);
		client.connect();
	}
}