package General.concepts.concurrency.Semaphores.other.printEvenOddsII;

public class PrintNum implements Runnable {

	int num;

	static boolean ready = false;

	static Object lock = new Object();

	//to control odd is printed first
	//to control/ensure which thread actually prints next and must have the lock
	static volatile String whosNext = "odd"; //only static (without vlatile) also works

	public PrintNum(int num) {
		this.num = num;
	}

	@Override
	public void run() {

		while (true) {

			if (num % 2 == 0) {

				printEven();

			} else {

				printOdd();
			}

		}

	}

	private void printOdd() {

		synchronized (lock) {

			if (whosNext.equalsIgnoreCase("even")) {
				//meaning lock is acquired but not my trn as even os to be printed 
				lock.notifyAll();

			} else {

				System.out.println(Thread.currentThread().getName() + " -> " + num);

				num += 2;

				whosNext = "even";

				/*
				 * we don't need wait, else the thread will stop to execute further, as both
				 * thread will keep on waiting. Solution to this will be to use timed wait. This
				 * will ensure that thread is coming out of wait state and is competing for lock
				 * as usual.
				 * 
				 * Overall, in this design, we don't need wait (timed) as such, because we have 
				 * condition to give up the lock.
				 * 
				 * if (whosNext.equalsIgnoreCase("even")) {
				 * 
				 * 	lock.notifyAll();
				 * 
				 * }
				 * 
				 * 
				 */
				try {
					lock.wait(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	private void printEven() {

		synchronized (lock) {

			if (whosNext.equalsIgnoreCase("odd")) {
				//meaning lock is acquired but not my trn as odd os to be printed 
				lock.notifyAll();

			} else {

				System.out.println(Thread.currentThread().getName() + " -> " + num);

				num += 2;

				whosNext = "odd";

				// try {
				// lock.wait(100);
				// } catch (InterruptedException e) {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
				// }
			}

		}

	}

}
