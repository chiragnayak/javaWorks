package General.concepts.Threads.coffeeShop;

public class CoffeeMachine implements Runnable {

	public static String coffeeMade = null;

	private static int coffeeNumber = 1;

	public void makeCoffee() {

		// synchronised block
		synchronized (Locker.lock) {

			// if coffee ready
			if (coffeeMade != null) {

				System.out.println(
						"Coffee machine: Coffee Ready !! Waiting for waiter notification to deliver : "+coffeeMade);

				try {

					Locker.lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			coffeeMade = "Coffee No. " + coffeeNumber++;
			System.out.println("Coffee machine says: Made " + coffeeMade);
			// once coffee is ready, notify the waiter to pick it up
			Locker.lock.notifyAll();
			System.out.println("Coffee machine: Notifying waiter to pick the coffee ");
		}

	}

	public void run() {
		//keep making coffee
		while (true) {
			makeCoffee();
			try {
				System.out.println("Coffee machine: Making another coffee now");
				// simulate the time taken to make a coffee by calling sleep method
				Thread.sleep(5000);
			} catch (InterruptedException ie) {
				// its okay to ignore this exception
				// since we're not using thread interrupt mechanism
				ie.printStackTrace();
			}
		}
	}

}
