package General.concepts.concurrency.Semaphores.other.printEvenOdds;

import java.util.concurrent.Semaphore;

public class oddNums implements Runnable {

	int num = 1;

	Semaphore semaphore;

	public oddNums(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	@Override
	public void run() {

		while (true) {
			try {
				
				if(PrintEvenOdds.whosNext.equalsIgnoreCase("odd")) {
					
					semaphore.acquire();

					System.out.println(num);
					num+=2;

					semaphore.release();
					
					PrintEvenOdds.whosNext = "even";
					
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
