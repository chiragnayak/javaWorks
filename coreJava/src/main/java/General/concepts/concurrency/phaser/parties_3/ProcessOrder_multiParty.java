package General.concepts.concurrency.phaser.parties_3;

import java.util.concurrent.Phaser;

public class ProcessOrder_multiParty {

	public static int FOOD_ITEMS = 3;
	
	public static void main(String[] args) {

		// the Phaser is the synchronizer to make food items one-by-one,
		// and deliver it before moving to the next item
		// 3 food items to deliver
		Phaser deliveryOrder = new Phaser(4); // 1 for current thread + 3 worker threads
		// 3 parties 
		// parties : the number of parties required to advance to the next phase

		Worker_multiParty chef = new Worker_multiParty(deliveryOrder, "Chef");
		Worker_multiParty helper = new Worker_multiParty(deliveryOrder, "Helper");
		Worker_multiParty attendent = new Worker_multiParty(deliveryOrder, "Attendent");

		//iterate over number of food items
		for (int i = 1; i <= ProcessOrder_multiParty.FOOD_ITEMS; i++) {
			// Prepare, mix and deliver this food item
			deliveryOrder.arriveAndAwaitAdvance();
			System.out.println("Deliver food item no. " + i);
		}
		// work completed for this delivery order, so deregister
		deliveryOrder.arriveAndDeregister();
		System.out.println("Delivery order completed... give it to the customer");
	}

}
