package Exception;

public class BizService {

	public void bizMethod(int i)throws BizException{
	    System.out.println("�����Ͻ� ������ �����մϴ�.");
	    if(i < 0){
	        throw new BizException("�Ű����� i�� 0�̻��̾�� �մϴ�.");	//msg�� �ش�
	    }
	    System.out.println("�����Ͻ� ������ ����˴ϴ�.");
	}
}