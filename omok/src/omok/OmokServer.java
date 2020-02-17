package omok;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Vector;

//--------------------------------------------------------------------------
// public class OmokServer
//--------------------------------------------------------------------------
public class OmokServer {
	private	ServerSocket	server;
	private	BManager		bMan	= new BManager(); //메시지 관리자
	private	Random			rnd		= new Random();   //흑과 백을 임의로 정하기 위한 변수
	
	public OmokServer() {}
	
	//--------------------------------------------------------------------------
	// 서버를 실행한다.
	//--------------------------------------------------------------------------
	void startServer() {
		try {
			server = new ServerSocket(7777);
			System.out.println("서버소켓이 생성되었습니다.");
			
			while(true) {
				//클라이언트와 연결된 소켓을 가져온다.
				Socket socket = server.accept();
				
				//쓰레드를 만들고 실행시킨다.
				Omok_Thread ot = new Omok_Thread(socket);
				ot.start();
				
				//bMan에 쓰레드를 추가한다.
				bMan.add(ot);
				
				System.out.println("접속자 수 : " + bMan.size());
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	} // End - void startServer()

	//--------------------------------------------------------------------------
	// 클라이언트와 통신하는 쓰레드 클래스
	//--------------------------------------------------------------------------
	class Omok_Thread extends Thread 
	{
		private	int		roomNumber	= -1;	//방번호
		private	String	userName	= null;	//사용자 이름
		private	Socket	socket;				//소켓
		
		//게임 준비 여부. true면 게임을 시작할 준비가 되었다는 의미로 사용한다.
		private	boolean	ready		= false;
		
		private	BufferedReader	reader;		//입력 스트림
		private	PrintWriter		writer;		//출력 스트림
		
		//매개변수가 있는 생성자
		Omok_Thread(Socket socket) {
			this.socket = socket;
		}
		
		//소켓을 반환한다.
		Socket getSocket() {
			return socket;
		}
		
		//방번호를 반환한다.
		int getRoomNumber() {
			return roomNumber;
		}
		
		//사용자의 이름을 반환한다.
		String getUserName() {
			return userName;
		}
		
		//게임의 준비상태를 반환한다.
		boolean isReady() {
			return ready;
		}
		
		//--------------------------------------------------------------------------
		// 쓰레드가 시작되는 메서드
		//--------------------------------------------------------------------------
		public void run() {
			try {
				reader = new BufferedReader(new InputStreamReader(
								socket.getInputStream()));
				writer = new PrintWriter(socket.getOutputStream(), true);
				
				//클라이언트의 메시지를 담을 변수
				String msg;
				
				while((msg = reader.readLine()) != null) {
					//메시지의 헤더부분[???]에 따라 처리를 다르게 한다.
					//String startsWith()
					//자바 문자열 startsWith() 메서드는 문자열이 주어진 문자열을 가지고
					//시작하는 확인한다.
					//만약에 주어진 문자열을 가지고 시작한다면 true를 반환하고,
					//아니면 false를 반환한다.
					
					//msg가 "[NAME]"으로 시작되는 메시지이면
					if(msg.startsWith("[NAME]")) {
						//substring() 에 하나의 인자값을 넣으면 해당하는 인덱스부터
						//   뒤의 모든 글자를 리턴하고,
						//substring(2, 4)
						//두개의 인자값을 넣으면 첫번째 인자값부터 두번째 인자값-1의
						//  값을 리턴한다.
						userName = msg.substring(6);
					} else if(msg.startsWith("[ROOM]")) {
						int roomNum = Integer.parseInt(msg.substring(6));
						
						//방이 찬 상태가 아니라면
						if(!bMan.isFull(roomNum)) {
							//현재 방의 다른 사용자에게 사용자의 퇴장을 알려준다.
							if(roomNumber != -1)
								bMan.sendToOthers(this, "[EXIT]" + userName);
							
							//사용자의 새로운 방번호를 지정한다.
							roomNumber = roomNum;
							
							//사용자에게 메시지를 그대로 전송하여 입장할 수 있음을 알려준다.
							writer.println(msg);
							
							//사용자에게 새 방에 있는 사용자 이름 리스트를 전송한다.
							writer.println(bMan.getNameInRoom(roomNumber));
							
							//새방에 있는 다른 사용자에게 사용자의 입장을 알려준다.
							bMan.sendToOthers(this, "[ENTER]" + userName);
							
						} else {
							//방에 인원이 가득 찬 상태라면
							//사용자에게 방이 찼음을 알려준다.
							writer.println("[FULL]"); 
						}
					} else if(roomNumber >= 1 && msg.startsWith("[STONE]")) {
						//[STONE] 메시지를 상대편에게 전송한다.
						bMan.sendToOthers(this, msg);
					} else if(msg.startsWith("[MSG]")) {
						//[MSG] 대화 메시지를 방에 전송한다.
						bMan.sendToRoom(roomNumber, "[" + userName + "]: "
													+ msg.substring(5));
					} else if(msg.startsWith("[START]")) {
						//[START] 게임시작 메시지를 받으면
						ready = true; //게임을 시작할 준비상태로 만든다.
						
						//상대방도 게임을 시작할 준비가 되었으면
						if(bMan.isReady(roomNumber)) {
							//흑과 백을 정하고 사용자와 상대편에게 전송한다.
							//Random 클래스의 nextInt() 메소드에 파라미터를 입력하지 않으면
							//int형의 표현범위(-2147483648 ~ 2147483647)의 모든 영역에서
							//랜덤한 숫자가 나온다.
							//int형 파라미터를 입력하면, 0에서 부터 입력한 파라미터값 미만의
							//랜덤한 정수가 나온다.
							//예)nextInt(10) => 0 ~ 9사이의 랜덤한 숫자가 출력된다.
							int a = rnd.nextInt(2);
							if(a == 0) {
								writer.println("[COLOR]BLACK");
								bMan.sendToOthers(this, "[COLOR]WHITE");
							} else {
								writer.println("[COLOR]WHITE");
								bMan.sendToOthers(this, "[COLOR]BLACK");
							}
						}
					} else if(msg.startsWith("[STOPGAME]")) {
						//사용자가 게임을 중지하는 메시지를 보내오면
						ready = false;
					} else if(msg.startsWith("[DROPGAME]")) {
						//사용자가 게임을 기권하는 메시지를 보내오면
						ready = false;
						//상대편에게 사용자의 기권을 알려준다.
						bMan.sendToOthers(this, "[DROPGAME]");
					} else if(msg.startsWith("[WIN]")) {
						//사용자가 이겼다는 메시지를 보내오면
						ready = false;
						//사용자에게 이겼다는 메시지를 보내준다.
						writer.println("[WIN]");
						//상대편에게는 졌다는 메시지를 보내준다.
						bMan.sendToOthers(this, "[LOSE]");
					}
					/*
					} else if(msg.startsWith("[LOSE]")) {
						//이부분을 만들까요? 말까요?
						//대국중인 어느 한명으로부터 [WIN]메시지가 보내져오기 때문에
						//굳이 [LOSE] 부분을 만들지 않아도 된다.
					}
					*/
				} // End - while()
			} catch(Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					bMan.remove(this);
					if(reader != null)	reader.close();
					if(writer != null)	writer.close();
					if(socket != null)	socket.close();
					reader 	= null;
					writer 	= null;
					socket	= null;
					System.out.println(userName + "님이 접속을 끊었습니다.");
					System.out.println("접속자 수 : " + bMan.size());
					//사용자가 접속을 끊었다는 메시지를 같은 방에 알려준다.
					bMan.sendToRoom(roomNumber, "[DISCONNECT]" + userName);
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
			} // End - try
		} // End - public void run()
	} // End - class Omok_Thread extends Thread
	
	//--------------------------------------------------------------------------
	// 메시지를 전달하는 클래스
	//--------------------------------------------------------------------------
	class BManager extends Vector {
		BManager() {}
		
		//--------------------------------------------------------------------------
		// 쓰레드를 추가한다.
		//--------------------------------------------------------------------------
		void add(Omok_Thread ot) {
			super.add(ot);
		}
		//--------------------------------------------------------------------------
		// 쓰레드를 제거한다.
		//--------------------------------------------------------------------------
		void remove(Omok_Thread ot) {
			super.remove(ot);
		}
		//--------------------------------------------------------------------------
		// i번째 쓰레드를 반환한다.
		//--------------------------------------------------------------------------
		Omok_Thread getOT(int i) {
			return (Omok_Thread) elementAt(i);
		}
		//--------------------------------------------------------------------------
		// i번째 소켓을 반환한다.
		//--------------------------------------------------------------------------
		Socket getSocket(int i) {
			return getOT(i).getSocket();
		}
		//--------------------------------------------------------------------------
		// i번째 쓰레드와 연결된 클라이언트에게 메시지를 전송한다.
		//--------------------------------------------------------------------------
		void sendTo(int i, String msg) {
			try {
				PrintWriter pw = new PrintWriter(
						getSocket(i).getOutputStream(), true);
				pw.println(msg);
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		//--------------------------------------------------------------------------
		// i번째 쓰레드의 방 번호를 반환한다.
		//--------------------------------------------------------------------------
		int getRoomNumber(int i) {
			return getOT(i).getRoomNumber();
		}
		//--------------------------------------------------------------------------
		// 방이 찼는지 알아본다.
		//--------------------------------------------------------------------------
		synchronized boolean isFull(int roomNum) {
			if(roomNum == 0) //방번호가 0은 대기실을 의미한다.
				return false; //대기실은 정원이 없다.
			//다른 방은 2명이 넘게 입장할 수가 없다.
			int count = 0;
			for(int i = 0; i < size(); i++) {
				if(roomNum == getRoomNumber(i))
					count++;
			}
			if(count >= 2) return true;
			return false;
		}
		//--------------------------------------------------------------------------
		// roomNum 방에 메시지를 전송한다.
		//--------------------------------------------------------------------------
		void sendToRoom(int roomNum, String msg) {
			for(int i = 0; i < size(); i++) {
				if(roomNum == getRoomNumber(i)) {
					sendTo(i, msg);
				}
			}
		}
		//--------------------------------------------------------------------------
		// ot와 같은 방에 있는 다른 사용자에게 메시지를 전송한다.
		//--------------------------------------------------------------------------
		void sendToOthers(Omok_Thread ot, String msg) {
			for(int i = 0; i < size(); i++) {
				if(getRoomNumber(i) == ot.getRoomNumber() && getOT(i) != ot) {
					sendTo(i, msg);
				}
			}
		}
		//--------------------------------------------------------------------------
		// 게임을 시작할 준비가 되었는가를 반환한다.
		// 두 명의 사용자가 모두 준비된 상태이면 true를 반환한다.
		//--------------------------------------------------------------------------
		synchronized boolean isReady(int roomNum) {
			int count = 0;
			for(int i = 0; i < size(); i++) {
				if(roomNum == getRoomNumber(i) && getOT(i).isReady()) {
					count++;
				}
			}
			if(count == 2)	return true;
			return false;
		}
		//--------------------------------------------------------------------------
		// roomNum방에 있는 사용자들의 이름을 반환한다.
		//--------------------------------------------------------------------------
		String getNameInRoom(int roomNum) {
			StringBuffer sb = new StringBuffer("[PLAYERS]");
			for(int i = 0; i < size(); i++) {
				if(roomNum == getRoomNumber(i)) {
					sb.append(getOT(i).getUserName() + "\t");
				}
			}
			return sb.toString();
		}
	} // End - class BManager extends Vector
	
	//--------------------------------------------------------------------------
	// public static void main(String[] args)
	//--------------------------------------------------------------------------
	public static void main(String[] args) {
		OmokServer server = new OmokServer();
		server.startServer();
	}

} // End - public class OmokServer























