package General.customExceptions;

public class TestCustomException {
	
	public static void main(String[] args) throws Exception {
		
		try {
			booMethod();
		}catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	
	public static void fooMethod() throws ExceptionA {
		
		try {
			throw new ExceptionC("Exception C");
		}catch (ExceptionC e) {
			throw new ExceptionB(e.getMessage(), e);
		}
	}
	
	public static void booMethod() throws Exception {
		
		try {
			fooMethod();
		}catch (ExceptionC c) {
			throw new ExceptionB(c.getMessage(), c);
		}catch (ExceptionB b) {
			throw new ExceptionA(b.getMessage(), b);
		}catch (ExceptionA a) {
			throw new Exception(a.getMessage(), a);
		}catch (Exception e) {
			throw new Exception(e.getMessage(), e);
		}
	}

}

/*
 * 
 * OUTPUT
 * 
 * General.customExceptions.ExceptionA: Exception C
	at General.customExceptions.TestCustomException.booMethod(TestCustomException.java:32)
	at General.customExceptions.TestCustomException.main(TestCustomException.java:8)
Caused by: General.customExceptions.ExceptionB: Exception C
	at General.customExceptions.TestCustomException.fooMethod(TestCustomException.java:19)
	at General.customExceptions.TestCustomException.booMethod(TestCustomException.java:26)
	... 1 more
Caused by: General.customExceptions.ExceptionC: Exception C
	at General.customExceptions.TestCustomException.fooMethod(TestCustomException.java:17)
	... 2 more

 * 
 * */
 