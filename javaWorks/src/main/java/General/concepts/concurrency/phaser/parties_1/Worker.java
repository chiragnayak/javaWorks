package General.concepts.concurrency.phaser.parties_1;

import java.util.concurrent.Phaser;

public class Worker extends Thread {

	Phaser currentPhase; // this phase
	String name; // worker name

	public Worker(Phaser deliveryOrder, String name) {
		this.currentPhase = deliveryOrder;
		deliveryOrder.register();
		this.setName(name);
		start();
	}

	@Override
	public void run() {

		// for three food items that we want to prepare
		for (int i = 1; i <= 3; i++) {

			System.out.println("\t" + getName() + " doing his work for order no. " + i);

			// case where only three worker threads are there.
			if (i == 3) {
				// this was the last food item Item we can de-register from Phaser
				currentPhase.arriveAndDeregister();
			} else {
				// still off items to prepare, wait for other threads to reach this point and
				// then advance.
				System.out.println("\t" + getName() + " <arrived> for order no. " + i+" <awaiting advance>");
				currentPhase.arriveAndAwaitAdvance();
			}

			try {
				Thread.sleep(3000); // simulate time for preparing the food item
			} catch (InterruptedException ie) {
				/* ignore exception */
				ie.printStackTrace();
			}
		}

	}

}
