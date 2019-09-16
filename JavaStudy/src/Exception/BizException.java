package Exception;
//사용자 정의 Exception
//클래스의 이름만 봐도 어떤 오류가 발생했는지 알게하기 위한 목적으로 만들어졌다.
//checked exception은 오류를 꼭 처리를 해야하는 예외
//Runtime Exception은 오류를 꼭 처리를 해야할 필요가 없다.

public class BizException extends RuntimeException{
	//오류발생시 메세지를 담는 생성자
	public BizException(String msg) {
		super(msg);	//부모클래스에 이미 해당 기능을 하는 생성자가 있기때문에 super를 쓴다.ㄴ
	}
	//실제 발생할 Exception을 담는 생성자
	public BizException(Exception ex) {
		super(ex);
	}
}