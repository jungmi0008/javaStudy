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
//            System.out.println("0으로 나눌 수 없습니다. : " + e.toString());
//        }finally {
//            System.out.println("오류가 발생하든 안하든 무조건 실행되는 블록입니다.");
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
	//divide함수에서 예외를 처리하는 것이 아니라 호출한 메인에서 처리하게 한다.
	//오류는 ,로 덧붙여서 여러개의 오류를 throws할 수 있다.
    public static int divide(int i, int j) throws ArithmeticException{
        int k = i / j;
        return k;
    }
}
