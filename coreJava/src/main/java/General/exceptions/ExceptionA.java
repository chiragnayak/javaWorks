package General.exceptions;

public class ExceptionA extends Exception{
	
	public ExceptionA(String message) {
		super(message);
	}
	
	public ExceptionA(String message, Throwable cause) {
		super(message, cause);
	}

}
