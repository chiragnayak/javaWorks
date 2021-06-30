package General.designPatterns.creationalPattern.singleton;

public class Logger implements Cloneable{

	private static Logger instance;
	private static int count = 0;

	private Logger() {
		System.out.println("I am the new Logger Object # " + (++count));
	}
	
	/*
	 * To ensure that two intances cannot be created using clone()
	 * 
	 * */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return instance;
		
		//or 
		
		/*
		 * 
		 * throw new CloneNotSupportedException("This is Singleton Class Hacker !! UGh !!");
		 * 
		 * */
		
		
	}
	
	//no Override here. Just make sure the spelling is correct.
	/*
	 * To ensure that two instances are not created while de-serializing the class twice or more.
	 * */
	protected Object readResolve() {
		return instance;
	}
	
	public static Logger getInstance() {

		/*
		 * Not Thread safe
		 * 
		 * if(loggerInstance==null) {
		 * 
		 * loggerInstance = new Logger();
		 * 
		 * }
		 */

		/*
		 * Thread safe way #1 -> public static synchronized getInstance() {... }
		 * 
		 * issue : everytime some threda invokes getInstance() it has to wait irrespective of 
		 * the instance is null or not. Expensive when the instance is not null. 
		 * 
		 * hence, instead of making method synchronized we make a synchronized block after null check.
		 * See way #2
		 * 
		 */

		/*
		 * Thread safe way #2 -> double locking
		 *    
		 *    Also called -> Lazy Initialization
		 *    
		 *    other is called "Early Initialization" where ->
		 *    
		 *    Logger instance = new Logger() ; is done during declaration itself. And no other checks are required. 
		 */

		if (instance == null) { // if null

			synchronized (Logger.class) { // acquire lock

				if (instance == null) { //check again (to ensure it is still null)

					instance = new Logger(); //constructor call
				}

			}
		}

		return instance;
	}
	
	
	public void logInfoMessage(String someLog) {
		
		System.out.println("Info : "+someLog);
	}

}
