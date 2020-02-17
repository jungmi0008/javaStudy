package chatting;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class Id extends JFrame implements ActionListener {
	static JTextField tf = new JTextField(8);
	JButton btn = new JButton("입력");
	
	WriteThread wt;
	ClientFrame cf;
	
	public Id() {}
	public Id(WriteThread wt, ClientFrame cf) {
		super("아이디");
		this.wt	= wt;
		this.cf	= cf;
		
		setLayout(new FlowLayout());
		add(new JLabel("아이디"));
		add(tf);
		add(btn);
		
		btn.addActionListener(this);
		setBounds(300, 300, 250, 100);
		setVisible(true);
	} // End - public Id(WriteThread wt, ClientFrame cf)
	
	public void actionPerformed(ActionEvent e) {
		wt.sendMsg();
		cf.isFirst = false;
		cf.setVisible(true);
		this.dispose();
	} // End - public void actionPerformed(ActionEvent e)
	
	static public String getId() {
		return tf.getText();
	}
	
} // End - class Id extends JFrame implements ActionListener
public class ClientFrame extends JFrame implements ActionListener {
	JTextArea	txtA		= new JTextArea();
	JTextField	txtF		= new JTextField(15);
	JButton		btnTransfer	= new JButton("전송");
	JButton		btnExit		= new JButton("닫기");
	boolean		isFirst		= true;
	JPanel		p1			= new JPanel();
	Socket		socket;
	WriteThread	wt;
	
	public ClientFrame(Socket socket) {
		super("대화 나누기");
		this.socket = socket;
		wt = new WriteThread(this);
		new Id(wt, this);
		
		txtA.setFont(new Font("굴림", Font.ITALIC+Font.BOLD, 24));
		txtA.setBackground(Color.YELLOW); 
		add("Center", txtA);
		
		p1.add(txtF);
		p1.add(btnTransfer);
		p1.add(btnExit);
		add("South", p1);
		
		//메세지를 전송하는 클래스를 생성
		btnTransfer.addActionListener(this);
		btnExit.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 300, 500, 500);
		setVisible(false);
	} // End - public ClientFrame(Socket socket)
	
	public void actionPerformed(ActionEvent e) {
		String id = Id.getId();
		if(e.getSource() == btnTransfer) { //전송버튼이 눌렸을 경우
			//메시지가 없이 전송버튼을 눌렀을 경우
			if(txtF.getText().equals("") ) {
				return;
			}
			//내가 입력한 글자를 내 화면에 출력한다.
			txtA.append("["+id+"] " + txtF.getText()+"\n");
			//입력한 내용을 전송한다.
			wt.sendMsg();
			//전송이 끝나면 입력창에 있는 글자들을 지운다.
			txtF.setText("");
		} else { //닫기버튼을 눌렀을 경우
			this.dispose();
		}
	} // End - public void actionPerformed(ActionEvent e)
	
} // End - public class ClientFrame extends JFrame implements ActionListener






















