package Exception;

public class BizService {

	public void bizMethod(int i)throws BizException{
	    System.out.println("비지니스 로직이 시작합니다.");
	    if(i < 0){
	        throw new BizException("매개변수 i는 0이상이어야 합니다.");	//msg에 해당
	    }
	    System.out.println("비지니스 로직이 종료됩니다.");
	}
}