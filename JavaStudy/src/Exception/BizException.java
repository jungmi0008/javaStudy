package Exception;
//����� ���� Exception
//Ŭ������ �̸��� ���� � ������ �߻��ߴ��� �˰��ϱ� ���� �������� ���������.
//checked exception�� ������ �� ó���� �ؾ��ϴ� ����
//Runtime Exception�� ������ �� ó���� �ؾ��� �ʿ䰡 ����.

public class BizException extends RuntimeException{
	//�����߻��� �޼����� ��� ������
	public BizException(String msg) {
		super(msg);	//�θ�Ŭ������ �̹� �ش� ����� �ϴ� �����ڰ� �ֱ⶧���� super�� ����.��
	}
	//���� �߻��� Exception�� ��� ������
	public BizException(Exception ex) {
		super(ex);
	}
}