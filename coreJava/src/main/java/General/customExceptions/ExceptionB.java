package General.customExceptions;

public class ExceptionB extends ExceptionA {
	
	public ExceptionB(String message) {
		super(message);
	}
	
	public ExceptionB(String message, Throwable cause) {
		super(message, cause);
	}

}
