package General.concepts.concurrency.Semaphores.other.printEvenOdds;

import java.util.concurrent.Semaphore;

public class PrintEvenOdds {
	
	//if you won't make it volatile, execution will abruptly stop after sometime (reason to be found) 
	public static volatile String whosNext = "even";

	public static Semaphore semaphore = new Semaphore(1);

	public static void main(String[] args) {
		
		Thread teven = new Thread(new evenNums(semaphore));
		Thread todd = new Thread(new oddNums(semaphore));
		
		teven.start();
		todd.start();
	}

}
