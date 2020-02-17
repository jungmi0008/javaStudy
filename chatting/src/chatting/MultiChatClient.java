package chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

//----------------------------------------------------------------------------
//키보드로 전송문자열을 입력받아서 서버로 전송하는 쓰레드
//----------------------------------------------------------------------------
class WriteThread {
	Socket		socket;
	ClientFrame	cf;
	String		str;
	String		id;
	
	public WriteThread(ClientFrame cf) {
		this.cf			= cf;
		this.socket		= cf.socket;
	} // End - public WriteThread(ClientFrame cf)
	
	public void sendMsg() {
		//키보드로부터 읽어오기 위한 스트림객체를 생성한다.
		BufferedReader br =
			new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = null;
		
		try {
			//서버로 문자열을 전송하기 위한 스트림객체를 생성한다.
			pw = new PrintWriter(socket.getOutputStream(), true);
			
			//첫번째 데이터는 id이다. 상대방에게 id와 함께 내 ip주소를 전송한다.
			if(cf.isFirst == true) {
				InetAddress iaddr = socket.getLocalAddress();
				String ip = iaddr.getHostAddress();
				getId();
				str = "[" + id +"] 님 로그인 (" + ip + ")";
				System.out.println("ip:" + ip + "   id:" + id);
			} else {
				str = "[" + id + "] " + cf.txtF.getText();
			}
			//입력받은 문자열을 서버로 보낸다.
			pw.println(str);
		} catch(IOException ie) {
			System.out.println(ie.getMessage());
		} finally {
			try {
				if(br != null) br.close();
			} catch(IOException ie) {
				System.out.println(ie.getMessage());
			}
		}
	} // End - public void sendMsg()
	
	public void getId() {
		id = Id.getId();
	} // End - public void getId()
	
} // End - class WriteThread

//----------------------------------------------------------------------------
//서버가 보내온 문자열을 전송받는 쓰레드
//----------------------------------------------------------------------------
class ReadThread extends Thread {
	Socket socket;
	ClientFrame cf;
	
	public ReadThread(Socket socket, ClientFrame cf) {
		this.cf		= cf;
		this.socket	= socket;
	}
	
	public void run() {
		BufferedReader br = null;
		try {
			//서버로부터 전송된 문자열을 읽어오기 위한 스트림객체를 생성
			br = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			while(true) {
				//소켓으로부터 문자열을 읽어온다.
				String str = br.readLine();
				if(str == null) { //접속이 끊어진 경우
					System.out.println("접속이 끊어졌습니다.");
					break;
				}
				//전송받은 문자열을 화면에 출력한다.
				cf.txtA.append(str + "\n");
				System.out.println("[server] " + str);
			}
		} catch(IOException ie) {
			System.out.println(ie.getMessage());
		} finally {
			try {
				if(br     != null) br.close();
				if(socket != null) socket.close();
			} catch(IOException ie) {}
		}
	}
} // End - class ReadThread extends Thread


//----------------------------------------------------------------------------
public class MultiChatClient {

	public static void main(String[] args) {
		Socket	socket = null;
		ClientFrame		cf;
		
		try {
			socket = new Socket("127.0.0.1", 3000); // 127.0.0.1 == localhost
			System.out.println("연결 성공....");
			//연결이 성공하면 클라이언트 화면을 보여준다.
			cf = new ClientFrame(socket);
			//수신을 하기위해서 쓰레드를 구동시킨다.
			new ReadThread(socket, cf).start();
		} catch(IOException ie) {
			System.out.println(ie.getMessage());
		}
	}

}








