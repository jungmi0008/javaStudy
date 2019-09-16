package Exception;

public class ExceptionExam3 {

	public static void main(String[] args) {
		int i = 10;
        int j = 0;
        try{
            int k = divide(i, j);
            System.out.println(k);
        }catch(IllegalArgumentException e){
            System.out.println("0으로 나누면 안됩니다.");
        }         
    }

    public static int divide(int i, int j)throws IllegalArgumentException{
        if(j == 0){
        	//j==0이 되는 시점에 예외가 발생하게 만들어주는 것
        	throw new IllegalArgumentException();
        	// 아래처럼 해주면 0을 리턴하면서 결과가 0이 나온다. 아예 실행이 안되야 하는데!
//        	System.out.println("0으로 나눌 수 없어요.");
//        	return 0;
        	
        }
        int k = i / j;
        return k;
    }
}
