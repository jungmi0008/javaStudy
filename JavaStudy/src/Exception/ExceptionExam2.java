package Exception;
class ExamExam{
    public static void main(String[]args){
        ExceptionExam2 ex = new ExceptionExam2();
        int[] array = new int[10];
		try {
			ex.get50thItem(array);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.toString());
		}
        
    }
}
public class ExceptionExam2 {
	public int get50thItem(int []array) throws ArrayIndexOutOfBoundsException{
        return  array[49];
    }
}
