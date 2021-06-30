package General.concepts.concurrency.Semaphores.other.printEvenOdds;

import java.util.concurrent.Semaphore;

public class evenNums implements Runnable{
	
	int num = 0;
	
	Semaphore semaphore;
	
	public evenNums(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	@Override
	public void run() {

		while (true) {
			try {
				
				if(PrintEvenOdds.whosNext.equalsIgnoreCase("even")) {
					
					semaphore.acquire();

					System.out.println(num);
					num+=2;

					semaphore.release();
					
					PrintEvenOdds.whosNext = "odd";
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
