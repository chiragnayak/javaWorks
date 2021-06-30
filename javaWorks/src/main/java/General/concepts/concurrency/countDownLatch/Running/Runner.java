package General.concepts.concurrency.countDownLatch.Running;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

public class Runner implements Runnable {
	
	CountDownLatch latch;
	String name;
	
	public Runner(CountDownLatch latch, String name) {
		this.latch=latch;
		this.name=name;
		System.out.println(name+" is ready on start line !");
	}

	@Override
	public void run() {
		
		try {
			System.out.println(name+" await() called");
			latch.await();
			
			System.out.println(name+" is running !! >>> ");
			
			Thread.sleep(ThreadLocalRandom.current().nextInt(3000));
			
			System.out.println(name+" has FINISHED +++ ");
			
			
			
		}catch(InterruptedException e) {
			
		}
		
	}
	
	

}
