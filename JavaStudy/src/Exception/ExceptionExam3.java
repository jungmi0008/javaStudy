package Exception;

public class ExceptionExam3 {

	public static void main(String[] args) {
		int i = 10;
        int j = 0;
        try{
            int k = divide(i, j);
            System.out.println(k);
        }catch(IllegalArgumentException e){
            System.out.println("0���� ������ �ȵ˴ϴ�.");
        }         
    }

    public static int divide(int i, int j)throws IllegalArgumentException{
        if(j == 0){
        	//j==0�� �Ǵ� ������ ���ܰ� �߻��ϰ� ������ִ� ��
        	throw new IllegalArgumentException();
        	// �Ʒ�ó�� ���ָ� 0�� �����ϸ鼭 ����� 0�� ���´�. �ƿ� ������ �ȵǾ� �ϴµ�!
//        	System.out.println("0���� ���� �� �����.");
//        	return 0;
        	
        }
        int k = i / j;
        return k;
    }
}
