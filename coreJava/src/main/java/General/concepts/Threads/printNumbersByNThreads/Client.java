package General.concepts.Threads.printNumbersByNThreads;

/**
 * 
 * This thread program initial number (to start with) and number of players 
 * in that will take part in printing the numbers one by one.
 * 
 * @author cnayak
 *
 */
public class Client {
	public static void main(String[] args) {
		NumberManager num = new NumberManager(1, 5);
		
		Thread T1 = new Thread(new PrinterThread(1, num));
		Thread T2 = new Thread(new PrinterThread(2, num));
		Thread T3 = new Thread(new PrinterThread(3, num));
		Thread T4 = new Thread(new PrinterThread(4, num));
		Thread T5 = new Thread(new PrinterThread(5, num));
		
		T1.start();
		T2.start();
		T3.start();
		T4.start();
		T5.start();
	}

}
