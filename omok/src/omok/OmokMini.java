package omok;

import java.awt.*;
import java.awt.event.*;

public class OmokMini extends Frame implements MouseListener {

	final	int	LINE_NUM	= 9; 	//오목판의 줄 수
	final	int	LINE_WIDTH	= 50;	//오목판의 줄 간격
	final	int	BOARD_SIZE	= LINE_WIDTH * (LINE_NUM - 1);//오목판의 크기
	final	int	STONE_SIZE	= (int)(LINE_WIDTH * 0.8);	//돌의 크기
	
	final	int	X0;	//오목판의 시작위치 x좌표
	final	int	Y0;	//오목판의 시작위치 y좌표
	
	final	int	FRAME_WIDTH;	//프레임의 폭
	final	int	FRAME_HEIGHT;	//프레임의 높이
	
	Image		img		= null;
	Graphics	gImg	= null;
	
	public OmokMini(String title) {
		super(title);
		
		//Event Handler를 등록한다.
		addMouseListener(this);
		
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		
		setVisible(true);	//Frame을 화면에 보이게 한다.
		Insets insets = getInsets(); //화면에 보이기 전에는 Insets의 값을 얻을 수 있다.
		
		//오목판이 그려질 위치(LEFT, TOP)의 좌표 X0, Y0를 지정한다.
		X0 = insets.left + LINE_WIDTH;
		Y0 = insets.top  + LINE_WIDTH;
		
		//Frame의 크기를 계산한다.
		FRAME_WIDTH  = BOARD_SIZE + LINE_WIDTH*2 + insets.left + insets.right;
		FRAME_HEIGHT = BOARD_SIZE + LINE_WIDTH*2 + insets.top  + insets.bottom;
		
		//Frame을 화면의 (300, 200)의 위치에 계산된 크기로 보이게 한다.
		setBounds(300, 200, FRAME_WIDTH, FRAME_HEIGHT);
		
		img  = createImage(FRAME_WIDTH, FRAME_HEIGHT);
		gImg = img.getGraphics();
		
		setResizable(false); //Frame의 크기를 변경하지 못하게 한다.
		drawBoard(gImg);
	}
	
	public void drawBoard(Graphics g) {
		//가로와 세로로 각각 9개의 선을 그리자.
		for(int i = 0; i < LINE_NUM; i++) {
			g.drawLine(X0, Y0+i*LINE_WIDTH, X0+BOARD_SIZE, Y0+i*LINE_WIDTH);
			g.drawLine(X0+i*LINE_WIDTH, Y0, X0+i*LINE_WIDTH, Y0+BOARD_SIZE);
		}
	}
	
	public void paint(Graphics g) {
		if(img == null) return;
		g.drawImage(img, 0, 0, this); //가상화면에 그려진 그림을 Frame에 복사한다.
	}
	
	//마우스를 클릭하였을 경우, 그 위치에 바둑돌을 그린다.
	public void mousePressed(MouseEvent e) {
		int	x = e.getX();	//마우스 포인터의 x좌표
		int	y = e.getY();	//마우스 포인터의 y좌표
		
		/*
		 1. x와 y의 값이 오목판의 바깥으로 벗어난 곳이면 돌을 그리지 않는다.
		 2. x와 y의 값을 클릭한 곳에서 가장 가까운 교차점으로 변경한다.(반올림을 이용)
		 3. x와 y의 값에서 돌의 크기(STONE_SIZE)의 절반을 빼야 클릭한 곳에 돌이 그려진다.
		 4. 눌러진 버튼이 마우스의 왼쪽버튼이면 (x,y)의 위치에 검은 돌을 그리고,
		    눌러진 버튼이 마우스의 오른쪽버튼이면 (x,y)의 위치에 흰 돌을 그린다.
		    (흰 돌을 그릴 때 검은 색 테두리도 같이 그린다.)
		 5. repaint()를 호출한다.
		 */
		//1. x와 y의 값이 오목판의 바깥으로 벗어난 곳이면 돌을 그리지 않는다.
		if(x < X0 - LINE_WIDTH/2 || x > X0 + (LINE_NUM-1)*LINE_WIDTH+LINE_WIDTH/2)
			return;
		if(y < Y0 - LINE_WIDTH/2 || y > Y0 + (LINE_NUM-1)*LINE_WIDTH+LINE_WIDTH/2)
			return;

		//2. x와 y의 값을 클릭한 곳에서 가장 가까운 교차점으로 변경한다.(반올림을 이용)
		x = (x - X0 + LINE_WIDTH/2)/LINE_WIDTH * LINE_WIDTH + X0;
		y = (y - Y0 + LINE_WIDTH/2)/LINE_WIDTH * LINE_WIDTH + Y0;
		
		//3. x와 y의 값에서 돌의 크기(STONE_SIZE)의 절반을 빼야 클릭한 곳에 돌이 그려진다.
		x -= STONE_SIZE / 2;
		y -= STONE_SIZE / 2;
		
		//4. 눌러진 버튼이 마우스의 왼쪽버튼이면 (x,y)의 위치에 검은 돌을 그리고,
		//   눌러진 버튼이 마우스의 오른쪽버튼이면 (x,y)의 위치에 흰 돌을 그린다.
		//   (흰 돌을 그릴 때 검은 색 테두리도 같이 그린다.)
		if(e.getModifiersEx() == MouseEvent.BUTTON1_DOWN_MASK) {
			gImg.setColor(Color.BLACK);
			gImg.fillOval(x, y, STONE_SIZE, STONE_SIZE);
		} else if(e.getModifiersEx() == MouseEvent.BUTTON3_DOWN_MASK) {
			gImg.setColor(Color.WHITE);
			gImg.fillOval(x, y, STONE_SIZE, STONE_SIZE);
			//흰색돌의 테투리를 검정색으로 그린다.
			gImg.setColor(Color.BLACK);
			gImg.drawOval(x, y, STONE_SIZE, STONE_SIZE);
		}
		
		//5. repaint()를 호출한다.
		repaint();
		
	}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e)  {}
	public void mouseReleased(MouseEvent e) {}
	
	public static void main(String[] args) {
		new OmokMini("미니오목");
	}

}














