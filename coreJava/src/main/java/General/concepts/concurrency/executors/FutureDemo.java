package General.concepts.concurrency.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService exService = Executors.newSingleThreadExecutor();

		/*
		 * Callable - interface
		 * 
		 * Returns Future object :
		 * 
		 * Future represents the lifecycle of a task and provides methods to
		 * test whether the task has completed or been cancelled, retrieve its
		 * result, and cancel the task.
		 * 
		 */
		Future<Integer> valueInFuture = exService.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {

				int x = 0;
				while (x++ < 10) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				return x;

			};
		});

		/*
		 * futureObj.isDone() ====================
		 * 
		 * Returns true if this task completed. Completion may be due to normal
		 * termination, an exception, or cancellation -- in all of these cases,
		 * this method will return true.
		 * 
		 */
		System.out.print("Waiting.");
		while (!valueInFuture.isDone()) {

			System.out.print(".");
			Thread.sleep(500);
		}

		/*
		 * Waits if necessary for the computation to complete, and then
		 * retrieves its result.
		 */
		System.out.println(valueInFuture.get());

		exService.shutdown();

		/*
		 * ways to create a Future to describe a task.
		 * 
		 * -> The submit methods in ExecutorService all return a Future, so that
		 * you can submit a Runnable or a Callable to an executor and get back a
		 * Future that can be used to retrieve the result or cancel the task.
		 * 
		 *  -> Explicitly instantiate a FutureTask for a given Runnable
		 * or Callable. (Because FutureTask implements Runnable, it can be
		 * submitted to an Executor for execution or executed directly by
		 * calling its run method.)
		 * 
		 */
		
		FutureTask<String> futureTask01 = new FutureTask<String>(new Callable<String>() {

			@Override
			public String call() throws Exception {

				for(int x = 0; x <= 10; x++) {
					Thread.sleep(1000);
					System.out.print(".");
				}
				return "Future Result returned from callable!";
			}
		});
	
		futureTask01.run();
		
		System.out.println(futureTask01.get()); //Waits if necessary for the computation to complete, and thenretrieves its result.
	}

}
