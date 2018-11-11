package General.concepts.concurrency.phaser.parties_3;

import java.util.concurrent.Phaser;

public class Worker_multiParty extends Thread {

	Phaser currentPhase; // this phase
	String name; // worker name

	public Worker_multiParty(Phaser deliveryOrder, String name) {
		this.currentPhase = deliveryOrder;
		this.setName(name);
		start();
	}

	@Override
	public void run() {

		// for three food items that we want to prepare
		for (int i = 1; i <= ProcessOrder_multiParty.FOOD_ITEMS; i++) {

			System.out.println("\t" + getName() + " doing his work for order no. " + i);

			try {
				Thread.sleep(3000); // simulate time for preparing the food item
			} catch (InterruptedException ie) {
				/* ignore exception */
				ie.printStackTrace();
			}
			
			// still off items to prepare, wait for other threads to reach this point and
			// then advance.
			System.out.println("\t" + getName() + " <arrived> for order no. " + i + " <awaiting advance>");
			currentPhase.arriveAndAwaitAdvance();

		}

	}

}
