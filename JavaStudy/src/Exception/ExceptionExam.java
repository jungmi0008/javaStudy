package Exception;
//Exception and throws

public class ExceptionExam {

//	public static void test01(String[] args) {
//		int i  = 10;
//		int j  = 0;
//		try{
//            int k = i / j;
//            System.out.println(k);
//        }catch(ArithmeticException e){
//            System.out.println("0���� ���� �� �����ϴ�. : " + e.toString());
//        }finally {
//            System.out.println("������ �߻��ϵ� ���ϵ� ������ ����Ǵ� ����Դϴ�.");
//        }
//	}
	public static void main(String[] args) {
		int i = 10;
        int j = 0;
        try{
            int k = divide(i, j);
            System.out.println(k);
        } catch(ArithmeticException e){
            System.out.println(e.toString());
        }

    }
	//divide�Լ����� ���ܸ� ó���ϴ� ���� �ƴ϶� ȣ���� ���ο��� ó���ϰ� �Ѵ�.
	//������ ,�� ���ٿ��� �������� ������ throws�� �� �ִ�.
    public static int divide(int i, int j) throws ArithmeticException{
        int k = i / j;
        return k;
    }
}
