package General.concepts.concurrency.phaser.parties_1;

import java.util.concurrent.Phaser;

public class ProcessOrder {

	public static void main(String[] args) {

		// the Phaser is the synchronizer to make food items one-by-one,
		// and deliver it before moving to the next item
		// 3 food items to deliver
		Phaser deliveryOrder = new Phaser(1); //1 for current thread, workers are registered inside their constructor.
		//single party 
		// parties : the number of parties required to advance to the next phase

		Worker chef = new Worker(deliveryOrder, "Chef");
		Worker helper = new Worker(deliveryOrder, "Helper");
		Worker attendent = new Worker(deliveryOrder, "Attendent");

		for (int i = 1; i <= 3; i++) {
			// Prepare, mix and deliver this food item
			deliveryOrder.arriveAndAwaitAdvance();
			System.out.println("Deliver food item no. " + i);
		}
		// work completed for this delivery order, so deregister
		deliveryOrder.arriveAndDeregister();
		System.out.println("Delivery order completed... give it to the customer");
	}

}
