package General.concepts.concurrency.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService exService = Executors.newSingleThreadExecutor();
		
		
		/*
		 * Callable - interface
		 * 
		 * 
		 * 
		 * */
		Future <Integer> valueInFuture = exService.submit(new Callable<Integer>() {
			
			@Override
			public Integer call() throws Exception {
				
				int x = 0;
				while (x++<10) {
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
		 * futureObj.isDone()
		 * ====================
		 * 
		 * Returns true if this task completed. Completion may be due to normal
		 * termination, an exception, or cancellation -- in all of these cases,
		 * this method will return true.
		 * 
		 */
		System.out.print("Waiting.");
		while(!valueInFuture.isDone()){
			
			System.out.print(".");
			Thread.sleep(500);
		}
		
		/*
		 * Waits if necessary for the computation to complete, and then
		 * retrieves its result.
		 */
		System.out.println(valueInFuture.get());
	}

}
