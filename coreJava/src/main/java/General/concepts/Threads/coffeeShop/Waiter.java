package General.concepts.Threads.coffeeShop;

public class Waiter implements Runnable {

	public void getCoffee() {
		synchronized (Locker.lock) {
			if (CoffeeMachine.coffeeMade == null) {
				try {
					// wait till the CoffeeMachine says (notifies) that
					// coffee is ready
					System.out.println("Waiter: Will get orders till coffee machine notifies me ");
					Locker.lock.wait();
				} catch (InterruptedException ie) {
					// its okay to ignore this exception
					// since we're not using thread interrupt mechanism
					ie.printStackTrace();
				}
			}
			System.out.println("Waiter: Delivering " + CoffeeMachine.coffeeMade);
			CoffeeMachine.coffeeMade = null;
			// ask (notify) the coffee machine to prepare the next coffee
			Locker.lock.notifyAll();
			System.out.println("Waiter: Notifying coffee machine to make another one");
		}
	}

	public void run() {
		// keep going till the user presses ctrl-C and terminates the program
		while (true) {
			getCoffee();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
