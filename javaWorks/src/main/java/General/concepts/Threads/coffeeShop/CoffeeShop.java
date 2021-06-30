package General.concepts.Threads.coffeeShop;

/**
 * coffee shop. ===========
 * 
 * A waiter is using a coffee machine in a coffee shop and delivering coffee to
 * customers.
 * 
 * The coffee machine in this coffee shop is an antique machine: it makes one
 * cup of coffee at a time, and it takes five to ten minutes time to make a cup.
 * 
 * The waiter does not have to be idle while waiting for the coffee machine to
 * complete making coffee; he can go to customers in the meantime to deliver the
 * coffee prepared earlier.
 * 
 * This example is a little contrived, though: assume that coffee machine keeps
 * making the coffee and waiter keeps delivering it.
 * 
 * @author cnayak
 *
 */
public class CoffeeShop {

	public static void main(String[] s) {
		CoffeeMachine coffeeMachine = new CoffeeMachine();
		Waiter waiter = new Waiter();
		
		Thread tCoffeeMachine = new Thread(coffeeMachine);
		Thread tWaiter = new Thread(waiter);
		tCoffeeMachine.start();
		tWaiter.start();
	}

}
