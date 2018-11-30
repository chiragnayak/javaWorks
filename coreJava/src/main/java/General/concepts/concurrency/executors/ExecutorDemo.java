package General.concepts.concurrency.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {

	public static void main(String[] args) {
		/*
		 * Executors.newSingleThreadExecutor()
		 * 
		 * Creates an Executor that uses a single worker thread operating off an
		 * unbounded queue.
		 * 
		 * (Note however that if this single thread terminates due to a failure
		 * during execution prior to shutdown, a new one will take its place if
		 * needed to execute subsequent tasks.)
		 * 
		 * Tasks are guaranteed to execute sequentially, and no more than one
		 * task will be active at any given time. Unlike the otherwise
		 * equivalent newFixedThreadPool(1) the returned executor is guaranteed
		 * not to be reconfigurable to use additional threads.
		 * 
		 * Returns:the newly created single-threaded Executor
		 * 
		 */
		ExecutorService executorObj = Executors.newSingleThreadExecutor();

		executorObj.execute(new Runnable() { //annonymus inner class

			@Override
			public void run() {
				int x = 0;
				while (++x < 10) {
					System.out.println("Chirag's Executor : tik tic " + x);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});

		executorObj.execute(() -> System.out.println("Using lamdas"));

		System.out.println("Shutdown " + executorObj.isShutdown());
		System.out.println("Terminated " + executorObj.isTerminated());

		if (executorObj != null) {

			/*
			 * shutdown process for a thread executor involves first rejecting
			 * any new tasks submitted to the thread executor while continuing
			 * to execute any previously submitted tasks.
			 * 
			 * shutdown() does not actually stop any tasks that have already
			 * been submitted to the thread executor.
			 */
			executorObj.shutdown();

			System.out.println("Shutdown after SD " + executorObj.isShutdown());
			System.out.println("Terminated after SD " + executorObj.isTerminated());

		}

		/*
		 * //no compilation error if adding tasks after shutdown,
		 * java.util.concurrent.RejectedExecutionException is thrown
		 * executorObj.execute(() -> System.out.println("After Shutdown !"))
		 * 
		 * 
		 * shutdownNow() : 
		 * 
		 * Attempts to stop all running tasks and discards any
		 * that have not been started yet. Note that shutdownNow() attempts to
		 * stop all running tasks.
		 * 
		 * Lastly, shutdownNow() returns a List<Runnable> of tasks that were
		 * submitted to the thread executor but that were never started. *
		 * 
		 */;

	}

}
