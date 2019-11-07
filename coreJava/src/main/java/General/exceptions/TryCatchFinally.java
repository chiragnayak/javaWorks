package General.exceptions;

public class TryCatchFinally {
	
	public static void main(String[] args) {
		
		System.out.println(throwMeSomeException(null));
		
	}
	
	public static String throwMeSomeException (String x) {
		
		
		try {

			x.toCharArray();
			
			return "try"; 
			
		}catch ( Exception e) {
			
			return "catch";
		}finally {
			return "finally";	
		}
		
	}

}
