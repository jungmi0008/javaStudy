package chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

//-------------------------------------------------------------------------------------
//클라이언트로 부터 전송된 문자열을 받아서 다른 클라이언트에게 문자열을 보내주는 클래스
// class EchoThread extends Thread
//-------------------------------------------------------------------------------------
class EchoThread extends Thread {
	Socket	socket;
	Vector<Socket> vec;
	
	//-------------------------------------------------------------------------------------
	public EchoThread(Socket socket, Vector<Socket> vec) {
		this.socket = socket;
		this.vec    = vec;
	} // End - public EchoThread(Socket socket, Vector<Socket> vec)
	//-------------------------------------------------------------------------------------
	public void run() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			String str = null;
			while(true) {
				//클라이언트로 부터 문자열 받기
				str = br.readLine();
				//상대가 접속을 끊으면 break;
				if(str == null) {
					//벡터에서 접속을 종료한 상대방을 제거한다.
					vec.remove(socket);
					break;
				}
				//메세지가 있으면 연결된 소켓들을 통해서 다른 클라이언트에게 문자열을 보낸다.
				sendMsg(str);
			}
		} catch(IOException ie) {
			System.out.println(ie.getMessage());
		} finally {
			try {
				if(br     != null) br.close();
				if(socket != null) socket.close();
			} catch(IOException ie) {
				System.out.println(ie.getMessage());
			}
		}
	} // End - public void run()
	//-------------------------------------------------------------------------------------
	//전송받은 문자열을 다른 클라이언트들에게 보내주는 메서드
	public void sendMsg(String str) {
		try {
			for(Socket socket:vec) {
				//for문을 사용하되 현재의 socket이 데이터를 보낸 클라인언트인 경우를
				//제외하고 나머지 socket들에게 데이터를 보내준다.
				if(socket != this.socket) {
					PrintWriter pw =
						new PrintWriter(socket.getOutputStream(), true);
					pw.println(str);
					pw.flush();
					//단, 여기서 얻어온 소켓들은 남의 것들이기 때문에 여기서 닫으면 안된다.
				}
			}
		} catch(IOException ie) {
			System.out.println(ie.getMessage());
		}
	} // End - public void sendMsg(String str)
}

//-------------------------------------------------------------------------------------
// public class MultiChatServer {
//-------------------------------------------------------------------------------------
public class MultiChatServer {

	public static void main(String[] args) {
		ServerSocket	server	= null;
		Socket			socket	= null;
		//클라이언트와 연결된 소켓들을 배열처럼 저장할 벡터 객체를 생성한다.
		Vector<Socket> vec = new Vector<Socket>();
		
		try {
			server = new ServerSocket(3000);
			while(true) {
				System.out.println("접속 대기중......");
				socket = server.accept();
				//클라이언트와 연결된 소켓을 벡터에 담든다.
				vec.add(socket);
				//쓰레드를 구동한다.
				new EchoThread(socket, vec).start();
			}
		} catch(IOException ie) {
			System.out.println(ie.getMessage());
		}
	}

}














